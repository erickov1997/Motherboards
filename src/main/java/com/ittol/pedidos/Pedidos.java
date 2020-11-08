/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.pedidos;

import com.ittol.productos.ProductosValidations;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Erick
 */
@Named("appPedido")
@SessionScoped
public class Pedidos implements Serializable{
   private int id_pedido;
   private String id_prod;
   private int cantidad;
   private double total;
   private String status;
   String fecha;
   private List<Pedidos> listPedidos;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

   
    public String getId_prod() {
        return id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Pedidos> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedidos> listPedidos) {
        this.listPedidos = listPedidos;
    }
   
    
   
     public void agrPedido() throws ClassNotFoundException {
          
             new PedidosValidations().InsertPedido(id_prod,cantidad,fecha);
            
    }  
     
     public List<Pedidos> ConsultPedidos() throws ClassNotFoundException{
       
         listPedidos= new PedidosValidations().listaPedidos();   
         return  listPedidos;
         
    }   
    
      public String process() throws ClassNotFoundException {
        ConsultPedidos();
        return "Pedidos.xhtml";
       
        
    } 
}
