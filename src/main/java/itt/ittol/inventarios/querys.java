/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itt.ittol.inventarios;

import com.ittol.beans.DBHandler;
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
public class querys {
    public Connection conn;
    
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
    
    public void executeUpdate(String sqlStatement) {
       
        if (conn != null) {
            try {
                 Statement statement = conn.createStatement(); 
                 statement.executeUpdate(sqlStatement);
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
     public List IDProd(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getString("id_prod"));
                   
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
     
      public List CantProd(String sqlStatement) {
        List l = null;
        
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("stock"));
                   
                }
                
               
                
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
      
    public List Salidas(String sqlStatement) {
        List l = null;
        
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("cantidad"));
                   
                }
                
               
                
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
}
    

