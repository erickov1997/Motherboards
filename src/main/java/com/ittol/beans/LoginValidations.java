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
        //List l = handler.executeQuery("SELECT * FROM usuarios where usuario='"+ usuario +"'");
        List l = handler.executeQuery("SELECT * FROM usuarios where usuario='"+ usuario +"' AND password='"+password+"'");
        /*System.out.println(handler.executeQuery("SELECT * FROM usuarios"));
        return nombre.equals("alejandro") && password.equals("medina");*/
        System.out.println("l: "+l);
        return !l.isEmpty();
    }
}
