/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itt.ittol.inventarios;

import com.ittol.almacen.AlmacenValidations;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Erick
 */
@Named("appEntradas")
@SessionScoped
public class Entradas implements Serializable {
    
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
    
     public void agrEntrada() throws ClassNotFoundException {
        
        int stock= Integer.parseInt(cantidad);
        new InventariosValidations().InsertEntrada(id_prod, fecha, stock);
            
    } 
     
      public void agrSalida() throws ClassNotFoundException {
        
        int stock= Integer.parseInt(cantidad);
        new InventariosValidations().InsertSalida(id_prod, fecha, stock);
            
    } 
    
     public static void main(String[] args) throws ClassNotFoundException {
        Entradas obj = new Entradas();
        obj.agrEntrada();
    }
    
    
}
