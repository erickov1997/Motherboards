/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.productos;

import com.ittol.beans.DBHandler;
import itt.ittol.inventarios.querys;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class ProductosValidations {
     public void InsertProduct(String id_prod,String nombre,String tipo,String fam_proc,String mem_int,String tipo_meoria,double prec_uni,int almacen,String status,String stock) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        int stock2=Integer.parseInt(stock);
       // handler.executeInsert("INSERT INTO public.\"Productos\"(id_prod, nombre, tipo, fam_proc, mem_int, tipo_meoria, prec_uni, almacen,stock,status) "+ "VALUES('"+id_prod+"','"+nombre+"','"+tipo+"','"+fam_proc+"','"+mem_int+"','"+tipo_meoria+"','"+prec_uni+"','"+almacen+"','"+stock2+"','"+status+"')");
        handler.executeInsert("INSERT INTO productos(id_prod, nombre, tipo, fam_proc, mem_int, tipo_meoria, prec_uni, almacen,stock,status) "+ "VALUES('"+id_prod+"','"+nombre+"','"+tipo+"','"+fam_proc+"','"+mem_int+"','"+tipo_meoria+"','"+prec_uni+"','"+almacen+"','"+stock2+"','"+status+"')");

    }
     
     public List listaProductos() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        //List lst = handler.ProductosList("SELECT * FROM \"Productos\"  ORDER BY cant_vent DESC");
        List lst = handler.ProductosList("SELECT * FROM productos  ORDER BY cant_vent DESC");

        System.out.println("Productoslist: "+lst);
        return lst;
    } 
     
     public List ProductoEdit(String id_prod) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
       // List lst = handler.ProductosList("SELECT * FROM \"Productos\" WHERE id_prod='"+id_prod+"'");
        List lst = handler.ProductosList("SELECT * FROM productos WHERE id_prod='"+id_prod+"'");

        System.out.println("Productoslist: "+lst);
        return lst;
    } 
     
    public void Editar(String id_prod,String nombre,String tipo,String fam_proc,String mem_int,String tipo_meoria,double prec_uni,String status) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
       // handler.executeInsert("UPDATE \"Productos\" SET nombre='"+nombre+"', tipo='"+tipo+"',fam_proc='"+fam_proc+"',mem_int='"+mem_int+"',tipo_meoria='"+tipo_meoria+"',prec_uni='"+prec_uni+"',status='"+status+"' WHERE id_prod='"+id_prod+"'"); 
        handler.executeInsert("UPDATE productos SET nombre='"+nombre+"', tipo='"+tipo+"',fam_proc='"+fam_proc+"',mem_int='"+mem_int+"',tipo_meoria='"+tipo_meoria+"',prec_uni='"+prec_uni+"',status='"+status+"' WHERE id_prod='"+id_prod+"'");  

    }
    
}