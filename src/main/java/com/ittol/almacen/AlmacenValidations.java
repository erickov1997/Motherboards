/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import com.ittol.beans.DBHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class AlmacenValidations {
    Almacen almacen= new Almacen();
    
     public void InsertAlmacen(String nombre, String descripcion,String direccion) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO almacenes(nombre,descripcion,direccion) "+ "VALUES('"+nombre+"','"+descripcion+"','"+direccion+"')");
    }
     
     public List listaAlmacenes() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.AlmacenList("SELECT * FROM almacenes");
        //System.out.println("almacenlist: "+lst);
        return lst;
    }
     
     
      public List ConsultAlmacen() throws ClassNotFoundException{
        List<Almacen> listAlmc;
        DBHandler handler = new DBHandler();
        handler.getConnection();
        //List l = handler.AlmacenList("SELECT nombre FROM almacenes");
        listAlmc = handler.AlmacenList("SELECT nombre FROM almacenes");
        //System.out.println("l: "+listAlmc);
        return listAlmc;
    }

      
      public List ConsultIdAlmacen() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List id = handler.IDQuery("SELECT id_alc FROM almacenes");
        //System.out.println("id: "+id);
        return id;
    }
      
      
     public List AlmacenGetId(int id_alc) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.AlmacenEdit("SELECT * FROM almacenes WHERE id_alc='"+id_alc+"'");
        //System.out.println("Almacen list: "+lst);
        return lst;
    } 
     
    public void Editar(int id_alc,String nombre,String descripcion,String direccion) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("UPDATE almacenes SET nombre='"+nombre+"', descripcion='"+descripcion+"',direccion='"+direccion+"' WHERE id_alc='"+id_alc+"'");  
    } 
      
      
    public static void main(String[] args) {
        
        AlmacenValidations obj = new AlmacenValidations();
    }
    
     public void comprar() throws MalformedURLException, IOException{
     String url = "http://904d8d3ec873.ngrok.io/Motherboards/webresources/com.ittol.almacen.pedidos";
        String json = "{\"id_prod\":\"12347\",\"cantidad\":\"10\",\"fecha\":\"2021/01/25\",\"total\":\"10\"}";

        String charset = "UTF-8";
        URLConnection connection = new URL(url).openConnection();
        connection.setDoOutput(true); // Triggers POST.
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);

        try (OutputStream output = connection.getOutputStream()) {
            output.write(json.getBytes(charset));
        }

        InputStream response = connection.getInputStream();
         
     }
    
}


