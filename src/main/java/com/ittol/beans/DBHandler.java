/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import com.ittol.almacen.Almacen;
import com.ittol.pedidos.Pedidos;
import com.ittol.productos.Productos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class DBHandler {
     public Connection conn;

    public DBHandler() {

    }

    public void getConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/motherboards", "postgres", "root");
            if (conn == null) {
                System.out.println("No connection obtained... Please check");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List executeQuery(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getString("usuario"));
                    l.add(rs.getString("password"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
     public  List AlmacenList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     //l.add(rs.getInt("id_alc"));
                     //l.add(rs.getString("nombre"));
                     //l.add(rs.getString("descripcion"));
                     //l.add(rs.getString("direccion"));
                     Almacen alm = new Almacen();
                     alm.setDescripcion(rs.getString("descripcion"));
                     alm.setDireccion(rs.getString("direccion"));
                     alm.setId_alc(Integer.parseInt(rs.getString("id_alc")));
                     alm.setNombre(rs.getString("nombre"));
                     l.add(alm);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
     
     public  List ProductosList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     Productos prod = new Productos();
                     prod.setId_prod(rs.getString("id_prod"));
                     prod.setNombre(rs.getString("nombre"));
                     prod.setTipo(rs.getString("tipo"));
                     prod.setFam_proc(rs.getString("fam_proc"));
                     prod.setMem_int(rs.getString("mem_int"));
                     prod.setTipo_meoria(rs.getString("tipo_meoria"));
                     prod.setPrec_uni(rs.getString("prec_uni"));
                     prod.setAlmacen(rs.getString("almacen"));
                     prod.setStock(rs.getInt("stock"));
                     prod.setVendidos(rs.getInt("cant_vent"));
                     
                    
                     l.add(prod);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
     
     public  List PedidoList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    
                     Pedidos pedido = new Pedidos();
                     pedido.setId_pedido(rs.getInt("id_pedido"));
                     pedido.setId_prod(rs.getString("id_prod"));
                     pedido.setCantidad(rs.getInt("cantidad"));
                     pedido.setTotal(rs.getDouble("total")); 
                     pedido.setStatus(rs.getString("status"));
                     pedido.setFecha(rs.getString("fecha"));
                     l.add(pedido);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
     
     
      public  List AlmacenEdit(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     Almacen alm = new Almacen();
                     alm.setId_alc(rs.getInt("id_alc"));
                     alm.setNombre(rs.getString("nombre"));
                     alm.setDescripcion(rs.getString("descripcion"));
                     alm.setDireccion(rs.getString("direccion"));
                     l.add(alm);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
     
     
     
     
     
      public List PrecioProd(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getDouble("prec_uni"));
                    l.add(rs.getInt("stock"));
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
     
     
     public List AlmacenQuery(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getString("nombre"));
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
     
     public List IDQuery(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("id_alc"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
     
     
    
     public void executeInsert(String sqlStatement) {
       
        if (conn != null) {
            try {
                 Statement statement = conn.createStatement(); 
                 statement.executeUpdate(sqlStatement);
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    
    /*public static void main(String[] args) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        System.out.println(handler.executeQuery("SELECT * FROM usuarios"));
        handler.closeConnection();
    }*/
    
}
