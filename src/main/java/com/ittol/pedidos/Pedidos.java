/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.pedidos;

import com.ittol.productos.ProductosValidations;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
         //fecha del sistema
         Calendar fech = new GregorianCalendar();
         String año = String.valueOf(fech.get(Calendar.YEAR));
         String mes = String.valueOf(fech.get(Calendar.MONTH) + 1);
         String dia = String.valueOf(fech.get(Calendar.DAY_OF_MONTH));
         String fechaS = año + "/" + mes + "/" + dia;
         //fecha ingresada por el usuario
          String anio=fecha.substring(0,4);
          String mesU=fecha.substring(5,7);
          String diaU=fecha.substring(8,10);
          int añoEnt= Integer.parseInt(anio) -Integer.parseInt(año);
         
         Pattern pat = Pattern.compile("([0-9]){1,3}$");
         Matcher mat = pat.matcher(String.valueOf(cantidad));
         if (String.valueOf(cantidad).equals("")) {
             FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo cantidad se encuentra vacio", null);
             FacesContext.getCurrentInstance().addMessage(null, fm);
         } else if (!mat.matches()) {
             FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo cantidad solo puede contener numeros [0-9] y como un maximo de 3 digitos", null);
             FacesContext.getCurrentInstance().addMessage(null, fm);
         }else if(fecha.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo fecha se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if (Integer.parseInt(anio)<Integer.parseInt(año)) {
             // System.out.println("El año y el mes no pude ser menor al año  y mes actual");           
               //System.out.println("El mes no pude ser menor al mes actual");
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El año no pude ser menor al año actual", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
               
              
          }else if (Integer.parseInt(anio)==Integer.parseInt(año) && Integer.parseInt(mesU)< Integer.parseInt(mes) ) {
             // System.out.println("El año y el mes no pude ser menor al año  y mes actual");           
               //System.out.println("El mes no pude ser menor al mes actual");
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El mes no pude ser menor al mes actual", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
               
              
          }else if(Integer.parseInt(anio)==Integer.parseInt(año)&& Integer.parseInt(mesU)== Integer.parseInt(mes)){
              if (Integer.parseInt(diaU)<= Integer.parseInt(dia)) {
                  //System.out.println("El dia no pude der menor al actual");
                  FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El dia no pude ser menor o igual al actual", null);
                  FacesContext.getCurrentInstance().addMessage(null, fm);
                  
              }else {
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Pedido registrado correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
                 new PedidosValidations().InsertPedido(id_prod,Integer.parseInt(cantidad),fechaS);
           }
          }else if(añoEnt>1){
              //System.out.println("Los pedidos solo pueden ralizarse a un maximo de un año");
              FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Los pedidos solo pueden ralizarse a un maximo de un año", null);
              FacesContext.getCurrentInstance().addMessage(null, fm);
          } else {
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Pedido registrado correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
                 new PedidosValidations().InsertPedido(id_prod,Integer.parseInt(cantidad),fechaS);
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
      public static void main(String[] args) {
        
    }
}
