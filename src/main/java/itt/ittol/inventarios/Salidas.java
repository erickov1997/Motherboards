/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itt.ittol.inventarios;

import java.io.Serializable;
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
@Named("appSalidas")
@SessionScoped
public class Salidas implements Serializable {
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
    
      public String agrSalida() throws ClassNotFoundException {
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
           }
           else{
        int cantid= Integer.parseInt(cantidad);
       
        int stock=(int) new InventariosValidations().GetStockProd(id_prod).get(0);
        
          if (stock < cantid) {
              FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"No hay productos suficientes para realizar la salida de productos", null);
              FacesContext.getCurrentInstance().addMessage(null, fm);
              return "Salidas.xhtml";
          }else{
                 
               new InventariosValidations().InsertSalida(id_prod, fecha,cantid );
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Salida de productos registrada correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
               return "Salidas.xhtml";
          }
           
           }
        return "Salidas.xhtml";
    } 
     
}
