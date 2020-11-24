/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import com.ittol.almacen.Almacen;
import com.ittol.pedidos.Pedidos;
import com.ittol.productos.Productos;
import com.ittol.users.Usuarios;
import itt.ittol.inventarios.Entradas;
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
                     l.add(rs.getString("tipo"));
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
     
     public  List UserList(String sqlStatement) {
        List u = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                u = new ArrayList();
                while (rs.next()) {
                     
                    Usuarios user = new Usuarios();
                    user.setId(String.valueOf(rs.getInt("id_usuario")) );
                    user.setNombre(rs.getString("nombre"));
                    user.setApe_pat(rs.getString("ape_pat"));
                    user.setApe_mat(rs.getString("ape_mat"));
                    user.setUsuario(rs.getString("usuario"));
                    user.setPassword(rs.getString("password"));
                    user.setTipo(rs.getString("tipo"));

                    u.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;
     }
     public List IDUser(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getString("id_usuario"));
                   
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
                     prod.setStatus(rs.getString("status"));
                     
                     
                    
                     l.add(prod);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
     
      public  List EntradasList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     Entradas ent = new Entradas();
                     ent.setId_ent(rs.getString("id_ent"));
                     ent.setId_prod(rs.getString("id_prod"));
                     ent.setFecha(rs.getString("fech_ent"));
                     ent.setCantidad(rs.getString("cantidad"));
                     
                     l.add(ent);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
      
      public  List SalidasList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     Entradas ent = new Entradas();
                     ent.setId_ent(rs.getString("id_sal"));
                     ent.setId_prod(rs.getString("id_prod"));
                     ent.setFecha(rs.getString("fecha_sal"));
                     ent.setCantidad(rs.getString("cantidad"));
                     
                     l.add(ent);
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
                     pedido.setCantidad(rs.getString("cantidad"));
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

      public List getUser(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getString("usuario"));
                   
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
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
