/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itt.ittol.inventarios;

import com.ittol.beans.DBHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class InventariosValidations {
    querys query= new querys();
    DBHandler handler = new DBHandler();
     public List ConsultIdProd() throws ClassNotFoundException{
        //DBHandler handler = new DBHandler();
        String status="1";
        query.getConnection();
       // List id = query.IDProd("SELECT id_prod FROM \"Productos\" WHERE status='"+status+"'");
        List id = query.IDProd("SELECT id_prod FROM productos WHERE status='"+status+"'");

        System.out.println("id_prod: "+id);
        return id;
    }
     
     public String ConsultIdProd(String id_prod) throws ClassNotFoundException{
        //DBHandler handler = new DBHandler();
        
         query.getConnection();
         //List id = query.IDProd("SELECT id_prod FROM \"Productos\" WHERE id_prod ='" + id_prod + "'");
         List id = query.IDProd("SELECT id_prod FROM productos WHERE id_prod ='" + id_prod + "'");

         if (id.size() == 0) {
             return "";
         } else {
             String idprod = (String) id.get(0);
             System.out.println("id_prod: " + idprod);
             return idprod;
         }

    } 
     
     public void InsertEntrada(String id_prod,String fecha_ent,int cantidad) throws ClassNotFoundException{
       
       // handler.getConnection();
        query.getConnection();
        String status="Productos suficientes";
        query.executeUpdate("INSERT INTO entradas(id_prod,fech_ent,cantidad) "+ "VALUES('"+id_prod+"','"+fecha_ent+"','"+cantidad+"')");
       // List l=query.CantProd("SELECT stock FROM \"Productos\" WHERE id_prod ='"+id_prod+"'");
        List l=query.CantProd("SELECT stock FROM productos WHERE id_prod ='"+id_prod+"'");

        //List p=query.Pedido("SELECT cantidad FROM pedidos WHERE id_prod ='"+id_prod+"'");
           List p=query.Pedido2("SELECT id_pedido, cantidad FROM pedido_ws WHERE producto ='"+id_prod+"'");

        int g=(int) l.get(0);
        int sum=cantidad+g;
        
         /*for (int i = 0; i <p.size(); i++) {
             int pedido=Integer.parseInt((String) p.get(i));
             if (pedido < sum) {
                  query.executeUpdate("UPDATE pedidos SET status='"+status+"' WHERE id_prod='"+id_prod+"'");
             }
         }*/
         int v=0;
         while(v < p.size()){
          v+=1;
          int pedido=Integer.parseInt((String) p.get(v));
         if (pedido < sum) {
                  query.executeUpdate("UPDATE pedido_ws SET status='"+status+"' WHERE id_pedido='"+p.get(v-1)+"'");
             }
            v+=1;
      }
        
      // query.executeUpdate("UPDATE \"Productos\" SET stock='"+sum+"' WHERE id_prod='"+id_prod+"'");
        query.executeUpdate("UPDATE productos SET stock='"+sum+"' WHERE id_prod='"+id_prod+"'");

        System.out.println("stock total: "+sum);
        
    }
     
    public List GetStockProd(String id_prod) throws ClassNotFoundException{
         query.getConnection();
         //List l=query.CantProd("SELECT stock FROM \"Productos\" WHERE id_prod ='"+id_prod+"'");
         List l=query.CantProd("SELECT stock FROM productos WHERE id_prod ='"+id_prod+"'");

         return l;
    } 
    
     public void InsertSalida(String id_prod,String fecha_sal,int cantidad) throws ClassNotFoundException{
        int resta = 0;
        int vendidos=0;
          String status="Sin productos suficientes";
          String status2="Productos suficientes";
        query.getConnection();
        query.executeUpdate("INSERT INTO salidas(id_prod,fecha_sal,cantidad) "+ "VALUES('"+id_prod+"','"+fecha_sal+"','"+cantidad+"')");
        List p=query.Pedido2("SELECT id_pedido, cantidad FROM pedido_ws WHERE producto ='"+id_prod+"'");
       // List l=query.CantProd("SELECT stock FROM \"Productos\" WHERE id_prod ='"+id_prod+"'");
           List l=query.CantProd("SELECT stock FROM Productos WHERE id_prod ='"+id_prod+"'");

        List c=query.Salidas("SELECT cantidad  FROM salidas WHERE id_prod='"+id_prod+"'");
      //  System.out.println("vendidos: "+c.get(0));
        
         for (int i = 0; i < c.size(); i++) {
             vendidos+=(int) c.get(i);
         }
          
       
        int g=(int) l.get(0);
         if (g > 0) {
            resta=g-cantidad;
         }
        
       /*query.executeUpdate("UPDATE \"Productos\" SET stock='"+resta+"' WHERE id_prod='"+id_prod+"'");
       query.executeUpdate("UPDATE \"Productos\" SET cant_vent='"+vendidos+"' WHERE id_prod='"+id_prod+"'");*/
       query.executeUpdate("UPDATE productos SET stock='"+resta+"' WHERE id_prod='"+id_prod+"'");
       query.executeUpdate("UPDATE productos SET cant_vent='"+vendidos+"' WHERE id_prod='"+id_prod+"'");
      int v=0;
      while(v < p.size()){
          v+=1;
          int pedido=Integer.parseInt((String) p.get(v));
         if (pedido > resta) {
                  query.executeUpdate("UPDATE pedido_ws SET status='"+status+"' WHERE id_pedido='"+p.get(v-1)+"'");
             }
            v+=1;
      }
       
       
       // System.out.println("stock total: "+resta);
        
    }
     
     public List listaEntradas() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.EntradasList("SELECT * FROM entradas  ORDER BY fech_ent DESC");
        System.out.println("Entradaslist: "+lst);
        return lst;
    } 
     
    public List listaSalidas() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.SalidasList("SELECT * FROM salidas  ORDER BY fecha_sal DESC");
        System.out.println("Salidaslist: "+lst);
        return lst;
    }  
     
    public static void main(String[] args) throws ClassNotFoundException {
        InventariosValidations obj= new InventariosValidations();
        obj.InsertSalida("56fg", "12/09/2021", 12);
        /*String cad= obj.ConsultIdProd("dgcdf");
        String cad2="dgcdx";
       
        if ( cad.equals(cad2)) {
            System.out.println("iguales");
        }else{
            System.out.println("no son iguales");
        }*/
    }
 
     
}
