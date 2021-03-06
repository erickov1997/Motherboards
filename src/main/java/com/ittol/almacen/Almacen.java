/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import com.ittol.beans.LoginValidations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Erick
 */

@Named("appAlmacen")
@SessionScoped
public class Almacen implements Serializable {
    private int id_alc;
    private String nombre;
    private String descripcion;
    private String direccion;
    private List<SelectItem> listAlmacenes;
    private List<Almacen> listAlmc;
    private List<Almacen> almacenEdit;

    public Almacen() {
//        try {
//            ConsultAlmacen();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_alc() {
        return id_alc;
    }

    public void setId_alc(int id_alc) {
        this.id_alc = id_alc;
    }

    public List<SelectItem> getListAlmacenes() {
        return listAlmacenes;
    }

    public void setListAlmacenes(List<SelectItem> listAlmacenes) {
        this.listAlmacenes = listAlmacenes;
    }

    public List<Almacen> getListAlmc() {
        return listAlmc;
    }

    public void setListAlmc(List<Almacen> listAlmc) {
        this.listAlmc = listAlmc;
    }

       public void agrAlmacen() throws ClassNotFoundException {
        new AlmacenValidations().InsertAlmacen(nombre, descripcion, direccion);
           System.out.println(nombre + descripcion + direccion);
            
    }  
       
       
       public List<Almacen> ConsultAlmacen() throws ClassNotFoundException{
       
        listAlmc= new AlmacenValidations().listaAlmacenes();
         
        
         for (int i = 0; i < listAlmc.size(); i++) {
              System.out.println("alm: "+listAlmc.get(i).getNombre());
         }
        
         return listAlmc;
         
    }   
       
       
       public String process() throws ClassNotFoundException {
        ConsultAlmacen();
        return "AlmacenList.xhtml";
       
        
    }
       
       
     public List<Almacen> EditAlmacen() throws ClassNotFoundException{
       
          almacenEdit= new AlmacenValidations().AlmacenGetId(id_alc);
            
         this.nombre= almacenEdit.get(0).getNombre();
         this.descripcion= almacenEdit.get(0).descripcion;
         this.direccion= almacenEdit.get(0).direccion;
        
         return  almacenEdit;
         
    }     
    
     public void process4() throws ClassNotFoundException {
      new AlmacenValidations().Editar(id_alc,nombre,descripcion,direccion);
       
    }     
     
    public void Ealmacen() throws ClassNotFoundException {
       new AlmacenValidations().Editar(id_alc,nombre,descripcion,direccion);
       
    }    
       public String process3() throws ClassNotFoundException {
       EditAlmacen();
       return "AlmacenEdit.xhtml";
       
    }   
      
       public static void main(String[] args) throws ClassNotFoundException {
        /*Almacen obj = new Almacen();
        obj.ConsultAlmacen();*/
            
    }
   
      
}
