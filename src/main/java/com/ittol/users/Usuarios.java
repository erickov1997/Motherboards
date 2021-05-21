/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.users;


import com.ittol.almacen.AlmacenValidations;
import com.ittol.beans.Login;
import com.ittol.beans.Utilities;
import com.ittol.productos.Productos;
import com.ittol.productos.ProductosValidations;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
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
    private String persona;
    /*Login per= new Login();
    String persona=per.getUsername();*/

  
    

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

    public List<Usuarios> getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(List<Usuarios> searchUser) {
        this.searchUser = searchUser;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
    
    public String getUserLogin(){
        return "usuario login: " +new Login().getUsername();
    }
    
    public void agrUser() throws ClassNotFoundException, UnsupportedEncodingException {
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
         
         String nameuser=new UsuariosValidations().GetNameUser(usuario);;
         
             if (nombre.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (nombre.length() > 30) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo nombre no debe ser mayor a 30 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!enom.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede ingresar mas de tres nombres y solo se puede ingresar letras [a-zA-Z] o [ñ á é í ó ú]", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (ape_pat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido paterno se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(ape_pat.length()>20){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo apellido paterno no debe ser mayor a 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!pat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido paterno y  solo se puede ingresar letras [a-zA-Z] o [ñ á é í ó ú]", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (ape_mat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido materno se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(ape_mat.length()>20){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo apellido materno no debe ser mayor a 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!mat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido materno y  solo se puede ingresar letras [a-zA-Z] o [ñ á é í ó ú]", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (usuario.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo usuario se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!use.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No debe haber espacios en el campo usuario y  solo se puede ingresar letras [a-zA-Z] o números [0-9] ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(usuario.length()>10){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo usuario no debe ser mayor a 10 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (nameuser.equals(usuario)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario ya existe", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }  else if (password.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo contraseña se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (!pass.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No debe haber espacios vacíos en el campo contraseña y solo se puede ingresar letras [a-zA-Z], números [0-9] o los sig caracteres [áéíóú!¡#$%&{}=?¿\".+-]", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (password.length()>20) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña no pude contener mas de 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        else if (tipo.equals("tipo")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar el tipo de usuario", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario registrado correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
           // new UsuariosValidations().InsertUsuario(nombre, ape_pat, ape_mat, usuario, password);
           Utilities u = new Utilities();
           String passEncrypt=u.DigestSHA256(password);
             new UsuariosValidations().InsertUsuario(nombre, ape_pat,ape_mat, usuario, passEncrypt,tipo);
             new UsuariosValidations().Insertrol(usuario, tipo);
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
    
     public String edituser() throws ClassNotFoundException, UnsupportedEncodingException {
          Pattern esp = Pattern.compile("^[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-nñáéíóú]+$");
         Matcher enom = esp.matcher(nombre);
         Pattern apes = Pattern.compile("^[a-zA-Z-nñáéíóú]+\\s?[a-zA-Z-ñáéíóú]+$");
         Matcher pat = apes.matcher(ape_pat);
         Matcher mat = apes.matcher(ape_mat);
         Pattern user = Pattern.compile("^\\w+$");
         Matcher use = user.matcher(usuario);
         Pattern con = Pattern.compile("^[a-zA-Z0-9nñáéíóú!¡#$%&{}=?¿\".+-]+$");
         Matcher pass = con.matcher(password);
        
         System.out.println("puser2Login: "+new Login().userLogin());
         System.out.println("usuarioEdit: "+ this.usuario);
        
        if (nombre.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo nombre se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(nombre.length()>30){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo nombre no debe ser mayor a 30 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!enom.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede ingresar mas de tres nombres y no se deben ingresar caracteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (ape_pat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido paterno se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(ape_pat.length()>20){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo apellido paterno no debe ser mayor a 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!pat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido paterno y  no se deben ingresar carecteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (ape_mat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo apellido materno se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(ape_mat.length()>20){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo apellido materno no debe ser mayor a 20 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(!mat.matches()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se debe ingresar mas de un apellido materno y  no se deben ingresar carecteres que no pertenezcan al alfabeto", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (usuario.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo usuario se encuentra vacío", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!use.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "no puede haber espacios en el campo usuario y solo puede contener letras del altabeto o numeros ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(usuario.length()>10){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La longitud del campo usuario no debe ser mayor a 10 caracteres", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }/*else if (usuario.equals(per2)) {
            if (tipo.equals("USERS")) {
                 FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede cambiar tipo", null);
                 FacesContext.getCurrentInstance().addMessage(null, fm);
            } 
            if (tipo.equals("ADMINS")) {
                 FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede cambiar tipo", null);
                 FacesContext.getCurrentInstance().addMessage(null, fm);
            }
           
        }*/
        else if (tipo.equals("tipo")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar el tipo de usuario", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else{ 
             FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario editado correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            new UsuariosValidations().Editar(Integer.parseInt(id), nombre, ape_pat, ape_mat, usuario, tipo);
            nombre="";
            ape_pat="";
            ape_mat="";
            usuario="";
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
     public void deleteuser(String idUser){
         new UsuariosValidations().DeleteUser(idUser);
         FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado correctamente", null);
         FacesContext.getCurrentInstance().addMessage(null, fm);
        try {
            //return "Consult_users.xhtml";
            process();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     /* public void agrUserP(String nombre,String ape_pat,String ape_mat,String usuario,String password,String rol) throws ClassNotFoundException {   
            new UsuariosValidations().InsertUsuario(nombre, ape_pat,ape_mat, usuario, password);
            new UsuariosValidations().Insertrol(usuario, rol);
   
    }  */
     
     
      public static void main(String[] args) throws ClassNotFoundException, UnsupportedEncodingException {
        String nombre="Eva";
        String ape_pat="Valle";
        String ape_mat="Almazan";
        String usuario="eva";
        String password="1234";
        String rol="ADMINS";
        Utilities u = new Utilities();
        String passEncrypt=u.DigestSHA256(password);
        System.out.println("SHA-256: " + passEncrypt);
       // Usuarios obj= new Usuarios();
         new UsuariosValidations().InsertUsuario(nombre, ape_pat,ape_mat, usuario, passEncrypt,rol);
    }
}
