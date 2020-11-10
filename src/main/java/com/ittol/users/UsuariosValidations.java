/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.users;

import com.ittol.almacen.Almacen;
import com.ittol.beans.DBHandler;
import java.util.List;

/**
 *
 * @author Erick
 */
public class UsuariosValidations {
    public void InsertUusario(String nombre, String ape_pat,String ape_mat,String usuario,String password,String tipo) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO usuarios(nombre,ape_pat,ape_mat,usuario,password,tipo) "+ "VALUES('"+nombre+"','"+ape_pat+"','"+ape_mat+"','"+usuario+"','"+password+"','"+tipo+"')");
    }
    
     public List ListUsers() throws ClassNotFoundException{
        List<Usuarios> listUser;
        DBHandler handler = new DBHandler();
        handler.getConnection();
        listUser = handler.UserList("SELECT * FROM usuarios");
        System.out.println("usuarios: "+listUser);
        return listUser;
    }
     
      public List UserGetId() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.IDUser("SELECT id_usuario FROM usuarios");
        System.out.println("Productoslist: "+lst);
        return lst;
    }  
     
    public List UserEditId(int id_usuario) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.UserList("SELECT * FROM usuarios WHERE id_usuario='"+id_usuario+"'");
        System.out.println("Productoslist: "+lst);
        return lst;
    }  
    
    public void Editar(int id_usuario,String nombre,String ape_pat,String ape_mat,String usuario,String password,String tipo) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("UPDATE usuarios SET nombre='"+nombre+"', ape_pat='"+ape_pat+"',ape_mat='"+ape_mat+"',usuario='"+usuario+"',password='"+password+"',tipo='"+tipo+"' WHERE id_usuario='"+id_usuario+"'");  
    }
     
     public static void main(String[] args) throws ClassNotFoundException {
        UsuariosValidations obj= new UsuariosValidations ();
         System.out.println("datos usuario"+ obj.UserEditId(1));
        
    }

}
