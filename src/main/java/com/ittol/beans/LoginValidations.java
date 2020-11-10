/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import java.util.List;

/**
 *
 * @author Erick
 */
public class LoginValidations {
   
     public boolean validate(String usuario, String password) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List l = handler.executeQuery("SELECT * FROM usuarios where usuario='"+ usuario +"' AND password='"+password+"'");
        
        return !l.isEmpty();
    }
     
    public String obtUser(String usuario, String password) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List l = handler.executeQuery("SELECT * FROM usuarios where usuario='"+ usuario +"' AND password='"+password+"'");
        String tipo=(String) l.get(2);
        System.out.println("tipo: "+tipo);
        return tipo;
    }
     
     public static void main(String[] args) throws ClassNotFoundException {
        LoginValidations obj= new LoginValidations();
        //obj.validate("usuario1", "m1eov");
        
         System.out.println(obj.obtUser("usuario1", "m1eov"));
    }
}
