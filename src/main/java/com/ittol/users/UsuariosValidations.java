/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.users;

import com.ittol.almacen.Almacen;
import com.ittol.beans.DBHandler;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class UsuariosValidations {
    public void InsertUsuario(String nombre, String ape_pat,String ape_mat,String usuario,String password,String rol) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO users(nombre,ape_pat,ape_mat,usuario,password,rol) "+
                "VALUES('"+nombre+"','"+ape_pat+"','"+ape_mat+"','"+usuario+"','"+password+"','"+rol+"')");
    }
    
    public void Insertrol(String usuario,String rol) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO user_role(usuario,userrole) "+ "VALUES('"+usuario+"','"+rol+"')");
    }
    
     public List ListUsers() throws ClassNotFoundException{
        List<Usuarios> listUser;
        DBHandler handler = new DBHandler();
        handler.getConnection();
        listUser = handler.UserList("SELECT * FROM users");
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
        List lst = handler.UserList("SELECT * FROM users WHERE id_user='"+id_usuario+"'");
        System.out.println("Productoslist: "+lst);
        return lst;
    }  
    
    public void Editar(int id_usuario,String nombre,String ape_pat,String ape_mat,String usuario,String tipo) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("UPDATE users SET nombre='"+nombre+"', ape_pat='"+ape_pat+"',ape_mat='"+ape_mat+"',usuario='"+usuario+"',rol='"+tipo+"' WHERE id_user='"+id_usuario+"'");  
        handler.executeInsert("UPDATE user_role SET usuario='"+usuario+"',userrole='"+tipo+"' WHERE id_role='"+id_usuario+"'");  

    }
     
    public void DeleteUser(String id_user){
    DBHandler handler= new DBHandler();
        try {
            handler.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosValidations.class.getName()).log(Level.SEVERE, null, ex);
        }
    handler.executeInsert("DELETE FROM users WHERE id_user='"+id_user+"'");
     handler.executeInsert("DELETE FROM user_role WHERE id_role='"+id_user+"'");
    }
    
    
     public String GetNameUser(String usuario) throws ClassNotFoundException{
        DBHandler handler = new DBHandler(); 
        handler.getConnection();
        List user=handler.getUser("SELECT usuario FROM users WHERE usuario ='" + usuario + "'");      
         if (user.size() == 0) {
             return "";
         } else {
             String getuser = (String) user.get(0);
             System.out.println("usuario: " + getuser);
             return getuser;
         }

    } 
    /* public static void main(String[] args) throws ClassNotFoundException {
        UsuariosValidations obj= new UsuariosValidations ();
        obj.GetNameUser("usuario1d");
        
    }*/

}
