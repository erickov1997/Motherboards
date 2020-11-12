/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.pedidos;

import com.ittol.productos.ProductosValidations;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
   private String cantidad;
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

   /* public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }*/

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
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
            Pattern pat = Pattern.compile("([0-9]){1,3}$");
            Matcher mat = pat.matcher(String.valueOf(cantidad));
          if(String.valueOf(cantidad).equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo cantidad se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }
           else if(!mat.matches()){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo cantidad solo puede contener numeros y como un maximo de 3 digitos", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if(fecha.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo fecha se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else{
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Pedido registrado correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
                 new PedidosValidations().InsertPedido(id_prod,Integer.parseInt(cantidad),fecha);
           }
          
           
            
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
