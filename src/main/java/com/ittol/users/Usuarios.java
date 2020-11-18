/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.users;


import com.ittol.almacen.AlmacenValidations;
import com.ittol.productos.Productos;
import com.ittol.productos.ProductosValidations;
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
@Named("appUser")
@SessionScoped
public class Usuarios implements Serializable{
    private String id;
    private String nombre;
    private String ape_pat;
    private String ape_mat;
    private String usuario;
    private String password;
    private String tipo;
    private List<SelectItem> listidUsers;
    private List<Usuarios> listUsers;
    private List<Usuarios> searchUser;

    public List<SelectItem> getListidUsers() {
        return listidUsers;
    }

    public void setListidUsers(List<SelectItem> listidUsers) {
        this.listidUsers = listidUsers;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public List<Usuarios> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Usuarios> listUsers) {
        this.listUsers = listUsers;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_pat() {
        return ape_pat;
    }

    public void setApe_pat(String ape_pat) {
        this.ape_pat = ape_pat;
    }

    public String getApe_mat() {
        return ape_mat;
    }

    public void setApe_mat(String ape_mat) {
        this.ape_mat = ape_mat;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void agrUser() throws ClassNotFoundException {
        //Pattern esp = Pattern.compile("^[a-zA-Z ñ á é í ó ú]{1,10}?\\s?[a-zA-Z ñ á é í ó ú]{1,10}$");
         Pattern esp = Pattern.compile("^[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-nñáéíóú]+$");
         Matcher enom = esp.matcher(nombre);
         Pattern apes = Pattern.compile("^[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-ñáéíóú]+$");
         Matcher pat = apes.matcher(ape_pat);
         Matcher mat = apes.matcher(ape_mat);
         Pattern user = Pattern.compile("^\\w+$");
         Matcher use = user.matcher(usuario);
         Pattern con = Pattern.compile("^[a-zA-Z0-9-nñáéíóú!¡#$%&{}=?¿\".+-]+$");
         Matcher pass = con.matcher(password);
         
         
        if (nombre.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }/*else if(!eat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener numeros o caracteres especiales o mas de 3 espacios", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }*/else if(!enom.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede ingresar mas de tres nombres y no se deben ingresar caracteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (ape_pat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido paterno se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!pat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido paterno y  no se deben ingresar carecteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (ape_mat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido materno se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!mat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido materno y  no se deben ingresar carecteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (usuario.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo usuario se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!use.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "no puede haber espacios en el campo usuario y solo puede contener letras del altabeto o numeros ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(usuario.length()>10){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo usuario no debe ser mayor a 10 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (password.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo password se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (!pass.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No debe haber espacios vacios en el campo password y solo se puede ingresar letras del alfabeto, numeros o los sig caracteres [áéíóú!¡#$%&{}=?¿\".+-]", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (password.length()>20) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El password no pude contener mas de 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (tipo.equals("tipo")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar el tipo de usuario", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario registrado correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            new UsuariosValidations().InsertUusario(nombre, ape_pat, ape_mat, usuario, password, tipo);
        }

           
    }  
    
     public List<Usuarios> ConsultUsers() throws ClassNotFoundException{
         listUsers= new UsuariosValidations().ListUsers();   
         return  listUsers;
         
    }   
     
    public String process() throws ClassNotFoundException {
        ConsultUsers();
        return "Consult_users.xhtml";
       
        
    }
    
    public List<SelectItem> getListidAlmacen() throws ClassNotFoundException{
         this.listidUsers= new ArrayList<SelectItem>();
          
         List<Usuarios> b= new UsuariosValidations().UserGetId();
         //listAlmacenes.clear();
        
         for (int i = 0; i < b.size(); i++) {
              SelectItem useridItem= new SelectItem(b.get(i));
              this.listidUsers.add(useridItem);
         }
        
         return listidUsers;
    } 
    
     public String editvista() throws ClassNotFoundException {
        getListidAlmacen();
        return "editUser.xhtml";
       
        
    }
     
    public List<Usuarios> getUser(String codigo) throws ClassNotFoundException{
       
         searchUser= new UsuariosValidations().UserEditId(Integer.parseInt(codigo));
            
         this.nombre= searchUser.get(0).getNombre();
         this.ape_pat= searchUser.get(0).ape_pat;
         this.ape_mat= searchUser.get(0).ape_mat;
         this.usuario= searchUser.get(0).usuario;
         this.password= searchUser.get(0).password;
         this.tipo= searchUser.get(0).tipo;
        
         return searchUser;
         
    }   
    
    /*public String searchuser() throws ClassNotFoundException {
       getUser();
       return "editUser.xhtml";
       
    } */ 
    
     public String edituser() throws ClassNotFoundException {
          Pattern esp = Pattern.compile("^[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-nñáéíóú]+$");
         Matcher enom = esp.matcher(nombre);
         Pattern apes = Pattern.compile("^[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-ñáéíóú]+$");
         Matcher pat = apes.matcher(ape_pat);
         Matcher mat = apes.matcher(ape_mat);
         Pattern user = Pattern.compile("^\\w+$");
         Matcher use = user.matcher(usuario);
         Pattern con = Pattern.compile("^[a-zA-Z0-9nñáéíóú!¡#$%&{}=?¿\".+-]+$");
         Matcher pass = con.matcher(password);
        if (nombre.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }/*else if(!eat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre no puede contener numeros o caracteres especiales o mas de 3 espacios", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }*/else if(!enom.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede ingresar mas de tres nombres y no se deben ingresar caracteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (ape_pat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido paterno se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!pat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido paterno y  no se deben ingresar carecteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (ape_mat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido materno se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!mat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido materno y  no se deben ingresar carecteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (usuario.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo usuario se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!use.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "no puede haber espacios en el campo usuario y solo puede contener letras del altabeto o numeros ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(usuario.length()>10){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo usuario no debe ser mayor a 10 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (password.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo password se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (!pass.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No debe haber espacios vacios en el campo password y solo se puede ingresar letras del alfabeto, numeros o los sig caracteres [áéíóú!¡#$%&{}=?¿\".+-]", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (password.length()>20) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El password no pude contener mas de 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (tipo.equals("tipo")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar el tipo de usuario", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else{ 
             FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario editado correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            new UsuariosValidations().Editar(Integer.parseInt(id), nombre, ape_pat, ape_mat, usuario, password, tipo);
            nombre="";
            ape_pat="";
            ape_mat="";
            usuario="";
            password="";
            tipo="tipo";
            return "Consult_users.xhtml";
        }
        
        return "editUser.xhtml";
        
     
       
    }   
    
     public String getuser(String id_user) throws ClassNotFoundException{
         this.id=id_user;
         getUser(id_user);
         return "editUser.xhtml";
     
     }  
}
