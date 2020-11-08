/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.pedidos;

import com.ittol.beans.DBHandler;
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
        List l=handler.PrecioProd("SELECT prec_uni,stock FROM \"Productos\" WHERE id_prod ='"+id_prod+"'");
        double precio= (double) l.get(0);
        int  stock= (int) l.get(1);
        String status="";
        /*Calendar fecha = new GregorianCalendar();                                       
        String año =String.valueOf(fecha.get(Calendar.YEAR)) ;
        String mes =String.valueOf(fecha.get(Calendar.MONTH)) ;
        String dia =String.valueOf( fecha.get(Calendar.DAY_OF_MONTH));
        //String fechaS=año+"/"+mes+"/"+dia;
        String fechaS="2020/09/31";*/
         
        double total=cantidad*precio;
        
          if (cantidad>stock) {
              status="Sin productos suficintes";
          }else{
              status="Productos suficientes";
          }
        handler.executeInsert("INSERT INTO pedidos(id_prod, cantidad, total, status, fecha) "+ "VALUES('"+id_prod+"','"+cantidad+"','"+total+"','"+status+"','"+fecha+"')");
    }
      
    public List listaPedidos() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.PedidoList("SELECT * FROM pedidos");
        System.out.println("Pedidoslist: "+lst);
        return lst;
    }   
    
    
}
