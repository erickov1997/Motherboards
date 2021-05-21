/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.productos;

import com.ittol.almacen.Almacen;
import com.ittol.almacen.AlmacenValidations;
import itt.ittol.inventarios.Inventarios;
import itt.ittol.inventarios.InventariosValidations;
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
    private String status;
   // private int stock;
    private String stock; 
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

    /*public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }*/

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    
    

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
            InventariosValidations prod=  new InventariosValidations();
          // Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]+$");
            Pattern cod = Pattern.compile("[a-zA-Z0-9]+$");
            Matcher eat = cod.matcher(id_prod);
            Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]*$");
            Matcher nom = cat.matcher(nombre);
            
            Pattern p = Pattern.compile( "^[1-9]\\d*(\\.\\d{1,2})$");
            Matcher prec = p.matcher(prec_uni); 
            
            Pattern pat = Pattern.compile("([0-9]){1,3}$");
            Matcher can = pat.matcher(String.valueOf(stock));
            
            String cprod=prod.ConsultIdProd(id_prod);
           
            if (id_prod.equals("")) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo código se encuentra vacío", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if(cprod.equals(id_prod)){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El código ya existe", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            
            } else if (!eat.matches()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo código solo pude contener letras [A-Z a-z] a excepcion de [ñ] y/o números [0-9] y sin espacios", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else if (id_prod.length()!= 5) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo código debe contener 5 caracteres", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } else if(nombre.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacío", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (!nom.matches()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre solo pude contener letras [A-Z a-z] o [á é í ó ú] y/o números [0-9] ", null);
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
            }else if(status.equals("---Status---")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar el status", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }
            else if(prec_uni.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario se encuentra vacío", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if(!prec.matches()){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario debe ser en formato decimal y con un maximo de dos decimales ejemplo: 12.0 , 122.12 ", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if(stock.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo stock se encuentra vacío", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if(!can.matches()){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo stock solo puede contener números [0-9] y como un máximo de 3 dígitos ", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto registrado correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                double precio = Double.parseDouble(prec_uni);
                int almc = Integer.parseInt(almacen);
                new ProductosValidations().InsertProduct(id_prod, nombre, tipo, fam_proc, mem_int, tipo_meoria, precio, almc,status,stock);
                id_prod="";
                nombre="";
                tipo="---Tipo---";
                fam_proc="---Familia de Procesador---";
                mem_int="---Memoria Interna---";
                tipo_meoria="---Tipo de Memoria---";
                almacen="---Almacen----";
                status="---Status---";
                prec_uni="";
                stock="";
            }


            
    }
        
    public String EProducto() throws ClassNotFoundException {
           InventariosValidations prod=  new InventariosValidations();
            Pattern cod = Pattern.compile("^[a-zA-Z0-9]+$");
            Matcher eat = cod.matcher(id_prod);
            Pattern cat = Pattern.compile("[a-zA-Z ñ 0-9 á é í ó ú]*$");
            Matcher nom = cat.matcher(nombre);
          
            //Pattern p = Pattern.compile( "^[1-9]\\d*(\\.\\d+)?$");
            Pattern p = Pattern.compile( "^[1-9]\\d*(\\.\\d{1,2})$");
            Matcher prec = p.matcher(prec_uni);
            Pattern d = Pattern.compile( "^([0-9])+[.]?([0-9]){1,2}?$");
            Matcher dec = p.matcher(prec_uni);
         
      if(nombre.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacio", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if (!nom.matches()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre solo pude contener letras conformadas del abecedario [A-Z a-z] o [á é í ó ú] o numeros [0-9] ", null);
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
            }else if(prec_uni.equals("")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario se encuentra vacio", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else if(!prec.matches()){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario debe ser en formato decimal y con un maximo de dos decimales ejemplo: 12.0 , 122.12", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }/*else if(!dec.matches()){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo precio unitario solo puede contener 2 decimales", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }*/else if(status.equals("---Status---")){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar el status", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Editado correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            double precio = Double.parseDouble(prec_uni);
            new ProductosValidations().Editar(id_prod, nombre, tipo, fam_proc, mem_int, tipo_meoria, precio, status);
                id_prod="";
                nombre="";
                tipo="---Tipo---";
                fam_proc="---Familia de Procesador---";
                mem_int="---Memoria Interna---";
                tipo_meoria="---Tipo de Memoria---";             
                prec_uni="";
                status="---Status---";
               
                ConsultProductos();
                return "ProductosList.xhtml";
        }
        return "EditarProducto.xhtml";

        
       
            
    }    
        
       public List<Productos> ConsultProductos() throws ClassNotFoundException{
       
         listProductos= new ProductosValidations().listaProductos();   
         return  listProductos;
         
    }   
    public List<Productos> EditProducto(String codigo) throws ClassNotFoundException{
       
          productoEdit= new ProductosValidations().ProductoEdit(codigo);
            
         this.nombre= productoEdit.get(0).getNombre();
         this.tipo= productoEdit.get(0).tipo;
         this.fam_proc= productoEdit.get(0).fam_proc;
         this.mem_int= productoEdit.get(0).mem_int;
         this.tipo_meoria= productoEdit.get(0).tipo_meoria;
         this.prec_uni= productoEdit.get(0).prec_uni;
         this.status=productoEdit.get(0).status;
        
       /* System.out.println("nombre"+ this.nombre);
        System.out.println("precio"+ this.prec_uni);*/
        
         return  productoEdit;
         
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
       
     public String getproduct(String id) throws ClassNotFoundException{
         this.id_prod=id;
         EditProducto(id);
         return "EditarProducto.xhtml";
     
     }  
       
    public String linkalmacen(){
        Almacen almacen= new Almacen();
        almacen.setNombre("");
        almacen.setDescripcion("");
        almacen.setDireccion("");
        return "/secured/user/Almacen/Almacen.xhtml";
    }   
    
    public String linkinventario() throws ClassNotFoundException{
    Inventarios inv= new Inventarios();
    inv.ConsultInventario();
    return "/secured/user/Inventarios/Inventario.xhtml";
    }
       
       
    
}
