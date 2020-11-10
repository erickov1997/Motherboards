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
import javax.enterprise.context.SessionScoped;
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
        new UsuariosValidations().InsertUusario(nombre, ape_pat, ape_mat, usuario, password, tipo);
           
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
     
    public List<Usuarios> getUser() throws ClassNotFoundException{
       
          searchUser= new UsuariosValidations().UserEditId(Integer.parseInt(id));
            
         this.nombre= searchUser.get(0).getNombre();
         this.ape_pat= searchUser.get(0).ape_pat;
         this.ape_mat= searchUser.get(0).ape_mat;
         this.usuario= searchUser.get(0).usuario;
         this.password= searchUser.get(0).password;
         this.tipo= searchUser.get(0).tipo;
        
         return searchUser;
         
    }   
    
    public String searchuser() throws ClassNotFoundException {
       getUser();
       return "editUser.xhtml";
       
    }  
    
     public void edituser() throws ClassNotFoundException {
      new UsuariosValidations().Editar(Integer.parseInt(id), nombre, ape_pat, ape_mat, usuario, password, tipo);
       
    }   
    
    
}
