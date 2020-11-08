/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itt.ittol.inventarios;

import com.ittol.beans.DBHandler;
import java.util.List;

/**
 *
 * @author Erick
 */
public class InventariosValidations {
    querys query= new querys();
    
     public List ConsultIdProd() throws ClassNotFoundException{
        //DBHandler handler = new DBHandler();
        
        query.getConnection();
        List id = query.IDProd("SELECT id_prod FROM \"Productos\"");
        System.out.println("id_prod: "+id);
        return id;
    }
     
     public void InsertEntrada(String id_prod,String fecha_ent,int cantidad) throws ClassNotFoundException{
        query.getConnection();
        query.executeUpdate("INSERT INTO entradas(id_prod,fech_ent,cantidad) "+ "VALUES('"+id_prod+"','"+fecha_ent+"','"+cantidad+"')");
        List l=query.CantProd("SELECT stock FROM \"Productos\" WHERE id_prod ='"+id_prod+"'");
        int g=(int) l.get(0);
        int sum=cantidad+g;
        
       query.executeUpdate("UPDATE \"Productos\" SET stock='"+sum+"' WHERE id_prod='"+id_prod+"'");
       
        System.out.println("stock total: "+sum);
        
    }
     
     public void InsertSalida(String id_prod,String fecha_sal,int cantidad) throws ClassNotFoundException{
        int resta = 0;
        query.getConnection();
        query.executeUpdate("INSERT INTO salidas(id_prod,fecha_sal,cantidad) "+ "VALUES('"+id_prod+"','"+fecha_sal+"','"+cantidad+"')");
        List l=query.CantProd("SELECT stock FROM \"Productos\" WHERE id_prod ='"+id_prod+"'");
        int g=(int) l.get(0);
         if (g > 0) {
            resta=g-cantidad;
         }
        
        
       query.executeUpdate("UPDATE \"Productos\" SET stock='"+resta+"' WHERE id_prod='"+id_prod+"'");
       
        System.out.println("stock total: "+resta);
        
    }
     
    
     
     public static void main(String[] args) throws ClassNotFoundException {
        InventariosValidations obj = new InventariosValidations();
        //obj.InsertEntrada("hjg", "2020/10/12", 3);
        obj.InsertSalida("hjg", "2020/10/12", 3);
        //obj.stock("hjg");
       
    }
}
