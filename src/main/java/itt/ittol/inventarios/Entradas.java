/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itt.ittol.inventarios;

import com.ittol.almacen.AlmacenValidations;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Named("appEntradas")
@SessionScoped
public class Entradas implements Serializable {
    private List<Entradas> ListEntradas;
    private String id_ent;
    private String id_prod;
    private String fecha;
    private String cantidad;

   

    
    public String getId_ent() {
        return id_ent;
    }

    public void setId_ent(String id_ent) {
        this.id_ent = id_ent;
    }

    public String getId_prod() {
        return id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public List<Entradas> getListEntradas() {
        return ListEntradas;
    }

    public void setListEntradas(List<Entradas> ListEntradas) {
        this.ListEntradas = ListEntradas;
    }

    
    
    
     public void agrEntrada() throws ClassNotFoundException {
         Calendar fech = new GregorianCalendar();
         String año = String.valueOf(fech.get(Calendar.YEAR));
         String mes = String.valueOf(fech.get(Calendar.MONTH) + 1);
         String dia = String.valueOf(fech.get(Calendar.DAY_OF_MONTH));
         String fechaS = año + "/" + mes + "/" + dia;
          Pattern pat = Pattern.compile("([0-9]){1,3}$");
            Matcher mat = pat.matcher(String.valueOf(cantidad));
          if(String.valueOf(cantidad).equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo cantidad se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }
           else if(!mat.matches()){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo cantidad solo puede contener numeros [0-9] y como un maximo de 3 digitos", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }/*else if(fecha.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo fecha se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }*/else{
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Entrada registrado correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
                int stock= Integer.parseInt(cantidad);
                new InventariosValidations().InsertEntrada(id_prod, fechaS, stock);
                 id_prod="";
                cantidad="";
                fecha="";
           }
        
       
            
    } 
     
     public List<Entradas> ConsultEntradas() throws ClassNotFoundException{
       
         ListEntradas= new InventariosValidations().listaEntradas();   
         return  ListEntradas;
         
    }   
     
    public String linkrentradas() throws ClassNotFoundException{
        ConsultEntradas();
        return "ListEntradas.xhtml";
    } 
    
     public static void main(String[] args) throws ClassNotFoundException {
        Entradas obj = new Entradas();
         System.out.println(obj.linkrentradas());
        
    }
    
    
}
