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
   private String total;
   private String status;
   private String fecha;
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


    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
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
         
         
         Pattern pat = Pattern.compile("([0-9]){1,3}$");
         Matcher mat = pat.matcher(String.valueOf(cantidad));
         if (String.valueOf(cantidad).equals("")) {
             FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo cantidad se encuentra vacío", null);
             FacesContext.getCurrentInstance().addMessage(null, fm);
         } else if (!mat.matches()) {
             FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo cantidad solo puede contener números [0-9] y como un máximo de 3 dígitos", null);
             FacesContext.getCurrentInstance().addMessage(null, fm);
         }else if(fecha.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo fecha se encuentra vacío", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }
         else if (!fecha.equals("")) {
           String  anio = String.valueOf(fecha.substring(0, 4));
           String mesU = String.valueOf(fecha.substring(5, 7));
           String  diaU = String.valueOf(fecha.substring(8, 10));
           int  añoEnt = Integer.parseInt(anio) - Integer.parseInt(año);
          
           if (Integer.parseInt(anio) < Integer.parseInt(año)) {
            
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El año no pude ser menor al año actual", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
          }else if (Integer.parseInt(anio)==Integer.parseInt(año) && Integer.parseInt(mesU)< Integer.parseInt(mes) ) {
             
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El mes no pude ser menor al mes actual", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
          }else if(Integer.parseInt(anio)==Integer.parseInt(año)&& Integer.parseInt(mesU)== Integer.parseInt(mes)){
              if (Integer.parseInt(diaU)<= Integer.parseInt(dia)) {
                  //System.out.println("El dia no pude der menor al actual");
                  FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El día no pude ser menor o igual al actual", null);
                  FacesContext.getCurrentInstance().addMessage(null, fm);
                  
              }else {
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Pedido registrado correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
                 new PedidosValidations().InsertPedido(id_prod,Integer.parseInt(cantidad),fecha);
           }
          
          }else if(añoEnt>1){
              //System.out.println("Los pedidos solo pueden ralizarse a un maximo de un año");
              FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Los pedidos solo pueden realizarse a un máximo de un año", null);
              FacesContext.getCurrentInstance().addMessage(null, fm);
          }
           else if(añoEnt==1){
             FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Pedido registrado correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
                 new PedidosValidations().InsertPedido(id_prod,Integer.parseInt(cantidad),fecha);
          }
           
           
           
         } 
          
           
            
    }  
     
    /* public List<Pedidos> ConsultPedidos() throws ClassNotFoundException{
       
         return  listPedidos;
         
    } */  
    
      public String process() throws ClassNotFoundException {
        //ConsultPedidos();
        new PedidosValidations().listaPedidos();
        ConsultPedidos();
        return "Pedidos.xhtml";
       
        
    }
      
     public List<Pedidos> ConsultPedidos() throws ClassNotFoundException{
         listPedidos= new PedidosValidations().ConsultarPedidos();   
         return   listPedidos;      
    }    
      
      public static void main(String[] args) {
         /*String fecha="2020/12/03";
         String n=fecha.substring(5,6);
          System.out.println(n);
          String año="3";
           String anio=String.valueOf(fecha.substring(0,4));
          String mesU=String.valueOf(fecha.substring(5,7));
          String diaU=String.valueOf(fecha.substring(8,10));
          System.out.println(anio);
          System.out.println(diaU);
          System.out.println(mesU);
         int añoEnt= Integer.parseInt(anio) -Integer.parseInt(año);*/
    }
}
