/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import com.ittol.beans.LoginValidations;
import itt.ittol.inventarios.InventariosValidations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
            Pattern pat = Pattern.compile("^([0-9])*$");
            Matcher mat = pat.matcher(descripcion); 
            
            Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]{1,20}$");
            Matcher eat = cat.matcher(nombre);
            Matcher van = cat.matcher(descripcion);
            
            Pattern des = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú #]{1,20}$");
            Matcher dir = des.matcher(direccion);
            
           if (nombre.equals("")) {
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo nombre se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if(!eat.matches()){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo nombre no puede contener caracteres especiales o la longitud supera los 20 caracteres", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }
           else if(descripcion.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo descripcion se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if(!van.matches()){
                FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo descripcion no puede contener caracteres especiales o la longitud supera los 20 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
       }else if(direccion.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo direccion se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if(!dir.matches()){
                FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo direccion no puede contener caracteres especiales solamente (#) o la longitud supera los 20 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
       }else{
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Almacen registrado correctamente",null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
               
               new AlmacenValidations().InsertAlmacen(nombre, descripcion, direccion);
               nombre="";
               descripcion="";
               direccion="";
               //System.out.println(nombre + descripcion + direccion);
           }
           
            
    }  
       
       
       public List<Almacen> ConsultAlmacen() throws ClassNotFoundException{
       
        listAlmc= new AlmacenValidations().listaAlmacenes();
         
        
         /*for (int i = 0; i < listAlmc.size(); i++) {
              System.out.println("alm: "+listAlmc.get(i).getNombre());
         }*/
        
         return listAlmc;
         
    }   
       
       
       public String process() throws ClassNotFoundException {
        ConsultAlmacen();
        return "AlmacenList.xhtml";
       
        
    }
       
       
    
     public String process4() throws ClassNotFoundException {
               
            Pattern pat = Pattern.compile("^([0-9])*$");
            Matcher mat = pat.matcher(descripcion); 
            
            Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]{1,20}$");
            Matcher eat = cat.matcher(nombre);
            Matcher van = cat.matcher(descripcion);
            
            Pattern des = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú #]{1,20}$");
            Matcher dir = des.matcher(direccion);
            
           if (nombre.equals("")) {
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo nombre se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if(!eat.matches()){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo nombre no puede contener caracteres especiales o la longitud supera los 20 caracteres", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }
           else if(descripcion.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo descripcion se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if(!van.matches()){
                FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo descripcion no puede contener caracteres especiales o la longitud supera los 20 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
       }else if(direccion.equals("")){
               FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo direccion se encuentra vacio", null);
               FacesContext.getCurrentInstance().addMessage(null, fm);
           }else if(!dir.matches()){
                FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"El campo direccion no puede contener caracteres especiales solamente (#) o la longitud supera los 20 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
       }else{
                FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Almacen Editado correctamente",null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                new AlmacenValidations().Editar(id_alc,nombre,descripcion,direccion);
                nombre="";
                descripcion="";
                direccion="";
                //System.out.println("almacen editadi: "+id_alc);
                return"AlmacenList.xhtml";
       }
        return"AlmacenEdit.xhtml";
       
    }     
     
    public void Ealmacen() throws ClassNotFoundException {
       new AlmacenValidations().Editar(id_alc,nombre,descripcion,direccion);
       
    }

     public List<Almacen> EditAlmacen(int almacen) throws ClassNotFoundException{
       
         almacenEdit= new AlmacenValidations().AlmacenGetId(almacen);
            
         this.nombre= almacenEdit.get(0).getNombre();
         this.descripcion= almacenEdit.get(0).descripcion;
         this.direccion= almacenEdit.get(0).direccion;
        
         return  almacenEdit;
         
    }     
       
    public String getalmacen(int id) throws ClassNotFoundException {
        this.id_alc=id;
        System.out.println("almacen ob enido " + id);
        //int id_alm = Integer.parseInt(id);
        EditAlmacen(id);
        return "AlmacenEdit.xhtml";
    }
    
    public String almcenLink(){
     return "Almacen.xhtml";
    }

       public static void main(String[] args) throws ClassNotFoundException {
        /*Almacen obj = new Almacen();
        obj.ConsultAlmacen();*/
            
    }
   
      
}
