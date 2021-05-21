/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.pedidos;

import com.ittol.almacen.PedidoWs;
import com.ittol.almacen.ProductPed;
import com.ittol.almacen.Productos;
import com.ittol.beans.DBHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class PedidosValidations {
    
      public void InsertPedido(String id_prod,int cantidad,String fecha) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        //List l=handler.PrecioProd("SELECT prec_uni,stock FROM \"Productos\" WHERE id_prod ='"+id_prod+"'");
        List l=handler.PrecioProd("SELECT prec_uni,stock FROM productos WHERE id_prod ='"+id_prod+"'");

          System.out.println("prec uni: "+l.get(0));
        double precio= (double) l.get(0);
        int  stock= (int) l.get(1);
        String status="";
        
        float total=(float) (cantidad*precio);
        
          if (cantidad>stock) {
              status="Sin productos suficientes";
          }else{
              status="Productos suficientes";
          }
        handler.executeInsert("INSERT INTO pedidos(id_prod, cantidad, total, status, fecha) "+ "VALUES('"+id_prod+"','"+cantidad+"','"+total+"','"+status+"','"+fecha+"')");
    }
      
    public void listaPedidos() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        String status="";
       
         List pList =  handler.GetPed("SELECT producto,cantidad FROM pedido_ws WHERE status =''");
         if (pList.size()==2) {
                String producto=String.valueOf(pList.get(0));
             int cantidad=Integer.parseInt((String) pList.get(1));

            List pProd =  handler.GetProdPed("SELECT id_prod,stock,prec_uni FROM productos WHERE id_prod ='"+producto+"'");
            int stock=Integer.parseInt((String) pProd.get(1));
            float prec_uni=Float.parseFloat((String) pProd.get(2));
            float total_ped=cantidad*prec_uni;
            String total=String.valueOf(total_ped);
            if (cantidad>stock) {
                status="No hay productos suficientes";   
            }
            if (stock>cantidad) {
                status="Productos suficientes"; 
            }
            handler.executeInsert("UPDATE pedido_ws SET total='"+total+"', status='"+status+"' WHERE status=''");  
        }else{
             System.out.println("no se hizo nada");}
    }
    
    public List ConsultarPedidos() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        //List lst = handler.ProductosList("SELECT * FROM \"Productos\"  ORDER BY cant_vent DESC");
        List lst = handler.PedidoList("SELECT * FROM pedido_ws  ORDER BY cantidad DESC");

        System.out.println("Pedidoslist: "+lst);
        return lst;
    } 
    

    public static void main(String[] args) throws ClassNotFoundException {
        new PedidosValidations().listaPedidos();
        
    }
    
    
}
