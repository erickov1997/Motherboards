/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.productos;

import com.ittol.almacen.Almacen;
import com.ittol.almacen.AlmacenValidations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

@Named("appProduct")
@SessionScoped
public class Productos implements Serializable {
    private List<SelectItem> listAlmacenes;
    private List<SelectItem> listidAlmacenes;
    
    private String id_prod;
    private String nombre;
    private String tipo;
    private String fam_proc;
    private String mem_int;
    private String tipo_meoria;
    private String prec_uni;
    private String almacen;
    private int stock;
    private int vendidos;
    private List<Productos> listProductos;
    private List<Productos> productoEdit;

    public String getId_prod() {
        return id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFam_proc() {
        return fam_proc;
    }

    public void setFam_proc(String fam_proc) {
        this.fam_proc = fam_proc;
    }

    public String getMem_int() {
        return mem_int;
    }

    public void setMem_int(String mem_int) {
        this.mem_int = mem_int;
    }

    public String getTipo_meoria() {
        return tipo_meoria;
    }

    public void setTipo_meoria(String tipo_meoria) {
        this.tipo_meoria = tipo_meoria;
    }

    public String getPrec_uni() {
        return prec_uni;
    }

    public void setPrec_uni(String prec_uni) {
        this.prec_uni = prec_uni;
    }

    

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }
    
    

    public List<Productos> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Productos> listProductos) {
        this.listProductos = listProductos;
    }

    
     public List<SelectItem> getListAlmacen() throws ClassNotFoundException{
         this.listAlmacenes= new ArrayList<SelectItem>();
          
         List<Almacen> a= new AlmacenValidations().ConsultAlmacen();
         //listAlmacenes.clear();
        
         for (int i = 0; i < a.size(); i++) {
              SelectItem almcItem= new SelectItem(a.get(i));
              this.listAlmacenes.add(almcItem);
         }
        
         return listAlmacenes;
    }   
     
      public List<SelectItem> getListidAlmacen() throws ClassNotFoundException{
         this.listidAlmacenes= new ArrayList<SelectItem>();
          
         List<Almacen> b= new AlmacenValidations().ConsultIdAlmacen();
         //listAlmacenes.clear();
        
         for (int i = 0; i < b.size(); i++) {
              SelectItem almcidItem= new SelectItem(b.get(i));
              this.listidAlmacenes.add(almcidItem);
         }
        
         return listidAlmacenes;
    }   
        
        public void agrProducto() throws ClassNotFoundException {
            
            Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]*$");
            Matcher eat = cat.matcher(id_prod);
            Matcher nom = cat.matcher(nombre);
            
            Pattern p = Pattern.compile( "[0-9]");
            Matcher prec = p.matcher(prec_uni); 
            
            if (id_prod.equals("")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo codigo se encuentra vacio", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else if (!eat.matches()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo codigo solo pude conetener letras conformdas en el abecedario o numeros [0-9]", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else if (id_prod.length()!= 5) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo codigo debe contener 5 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else if(nombre.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacio", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (!nom.matches()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener caracteres especiales o la longitud supera los 20 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else if(nombre.length()>30){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener mas de 30 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (tipo.equals("---Tipo---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar un tipo", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (fam_proc.equals("---Familia de Procesador---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar Familia de Procesador", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (mem_int.equals("---Memoria Interna---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar Memoria Interna", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (tipo_meoria.equals("---Tipo de Memoria---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar Tipo de Memoria", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }
            else if (almacen.equals("---Almacen----")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar un Almacen", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }
            else if(prec_uni.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario se encuentra vacio", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }/*else if(!prec.matches()){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario solo puede contener numeros", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }*/else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto registrado correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                double precio = Double.parseDouble(prec_uni);
                int almc = Integer.parseInt(almacen);
                new ProductosValidations().InsertProduct(id_prod, nombre, tipo, fam_proc, mem_int, tipo_meoria, precio, almc);
            }


            
    }
        
    public void EProducto() throws ClassNotFoundException {
        Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]*$");
            Matcher nom = cat.matcher(nombre);
        if (nombre.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!nom.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener caracteres especiales o la longitud supera los 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (nombre.length() > 30) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener mas de 30 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(prec_uni.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario se encuentra vacio", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Editado correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            double precio = Double.parseDouble(prec_uni);
            new ProductosValidations().Editar(id_prod, nombre, tipo, fam_proc, mem_int, tipo_meoria, precio);
        }

        
        /* Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]*$");
            Matcher nom = cat.matcher(nombre);
            
            Pattern p = Pattern.compile( "[0-9]");
            Matcher prec = p.matcher(prec_uni); 
        
        
        if(nombre.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacio", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (!nom.matches()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener caracteres especiales o la longitud supera los 20 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else if(nombre.length()>30){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener mas de 30 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (tipo.equals("---Tipo---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar un tipo", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (fam_proc.equals("---Familia de Procesador---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar Familia de Procesador", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (mem_int.equals("---Memoria Interna---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar Memoria Interna", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (tipo_meoria.equals("---Tipo de Memoria---")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar Tipo de Memoria", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else{
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto editado correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                double precio = Double.parseDouble(prec_uni);             
                new ProductosValidations().Editar(id_prod,nombre,tipo,fam_proc,mem_int,tipo_meoria,precio);
            }
           
           */
            
    }    
        
       public List<Productos> ConsultProductos() throws ClassNotFoundException{
       
         listProductos= new ProductosValidations().listaProductos();   
         return  listProductos;
         
    }   
    public List<Productos> EditProducto() throws ClassNotFoundException{
       
          productoEdit= new ProductosValidations().ProductoEdit(id_prod);
            
         this.nombre= productoEdit.get(0).getNombre();
         this.tipo= productoEdit.get(0).tipo;
         this.fam_proc= productoEdit.get(0).fam_proc;
         this.mem_int= productoEdit.get(0).mem_int;
         this.tipo_meoria= productoEdit.get(0).tipo_meoria;
         this.prec_uni= productoEdit.get(0).prec_uni;
        
        System.out.println("nombre"+ this.nombre);
        System.out.println("precio"+ this.prec_uni);
        
         return  productoEdit;
         
    }     
       
       public String process3() throws ClassNotFoundException {
       EditProducto();
       return "EditarProducto.xhtml";
       
    } 
   
     public String process2() throws ClassNotFoundException {
         String id;
         id=listProductos.get(0).id_prod;
         
         System.out.println("id producto: "+id);
        //ConsultProductos();
        return "ProductosList.xhtml";
       
        
    } 
       
       
       public String process() throws ClassNotFoundException {
        ConsultProductos();
        return "ProductosList.xhtml";
       
        
    } 
       
       
    
}
