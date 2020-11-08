/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itt.ittol.inventarios;

import com.ittol.almacen.Almacen;
import com.ittol.almacen.AlmacenValidations;
import com.ittol.productos.Productos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Erick
 */

@Named("appInv")
@SessionScoped

public class Inventarios  implements Serializable{
    private List<SelectItem> listidProd;
    private String producto;

   
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public List<SelectItem> getListidProd() throws ClassNotFoundException{
         this.listidProd= new ArrayList<SelectItem>();
          
         List<Inventarios> b= new InventariosValidations().ConsultIdProd();
         //listAlmacenes.clear();
        
         for (int i = 0; i < b.size(); i++) {
              System.out.println(b.get(i));
              SelectItem prodidItem= new SelectItem(b.get(i));
              this.listidProd.add(prodidItem);
         }
        
         return listidProd;
    }   
    
    public String process() throws ClassNotFoundException {
        Productos producto= new Productos();
        producto.ConsultProductos();
       
        return "Invetario.xhtml";
       
        
    } 
        
    
    
    public static void main(String[] args) throws ClassNotFoundException {
        
    }
   
}




