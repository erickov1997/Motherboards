/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.productos;

import com.ittol.beans.DBHandler;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class ProductosValidations {
     public void InsertProduct(String id_prod,String nombre,String tipo,String fam_proc,String mem_int,String tipo_meoria,double prec_uni,int almacen) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO public.\"Productos\"(id_prod, nombre, tipo, fam_proc, mem_int, tipo_meoria, prec_uni, almacen) "+ "VALUES('"+id_prod+"','"+nombre+"','"+tipo+"','"+fam_proc+"','"+mem_int+"','"+tipo_meoria+"','"+prec_uni+"','"+almacen+"')");
    }
     
     public List listaProductos() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.ProductosList("SELECT * FROM \"Productos\"");
        System.out.println("Productoslist: "+lst);
        return lst;
    } 
     
     public List ProductoEdit(String id_prod) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.ProductosList("SELECT * FROM \"Productos\" WHERE id_prod='"+id_prod+"'");
        System.out.println("Productoslist: "+lst);
        return lst;
    } 
     
    public void Editar(String id_prod,String nombre,String tipo,String fam_proc,String mem_int,String tipo_meoria,double prec_uni) throws ClassNotFoundException{
       DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("UPDATE \"Productos\" SET nombre='"+nombre+"', tipo='"+tipo+"',fam_proc='"+fam_proc+"',mem_int='"+mem_int+"',tipo_meoria='"+tipo_meoria+"',prec_uni='"+prec_uni+"' WHERE id_prod='"+id_prod+"'");  
    }
     public static void main(String[] args) {
         try {
             ProductosValidations obj= new ProductosValidations();
             obj.ProductoEdit("56fg");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ProductosValidations.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
