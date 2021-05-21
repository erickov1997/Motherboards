/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Erick
 */

@Named("UserRoleList")
@SessionScoped
public class UserRoleList implements Serializable{
     private Integer idRole;
     private String usuario;
     private String userrole;
     private List< UserRoleList> listuser;
     private ArrayList<UserRoleList> pList = new ArrayList<UserRoleList>();
     
      String inline = "";

    public ArrayList<UserRoleList> getpList() {
        return pList;
    }

    public void setpList(ArrayList<UserRoleList> pList) {
        this.pList = pList;
    }

    public List<UserRoleList> getListuser() {
        return listuser;
    }

    public void setListuser(List<UserRoleList> listuser) {
        this.listuser = listuser;
    }

   
    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
    
    public String ejmploUsers(){
        return "UserRole.xhtml";
    }
      
    public String PeticionGet() throws IOException {
        String inline = "";
        try {
            URL url = new URL("http://localhost:8080/Motherboards/webresources/com.ittol.almacen.userroles");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode);

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                System.out.println("\nJSON Response in String format");
                System.out.println(inline);
                sc.close();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(java.util.function.Consumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(java.util.function.Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inline;
    }
    
    
     public ArrayList<UserRoleList> convertStringToDocument() throws ParserConfigurationException, SAXException, IOException, org.xml.sax.SAXException {
         String xmlCad = PeticionGet();
         UserRoleList almacenes = new UserRoleList();
         ArrayList<UserRoleList> pList = new ArrayList<UserRoleList>();
         org.w3c.dom.Document doc = DocumentBuilderFactory.newInstance()
                 .newDocumentBuilder()
                 .parse(new InputSource(new StringReader(xmlCad)));

         NodeList nodos = doc.getElementsByTagName("userRoles");

         for (int i = 0; i < nodos.getLength(); i++) {
             almacenes = new UserRoleList();
             Node nodo = nodos.item(i);
             if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                 Element e = (Element) nodo;
                 NodeList hijos = e.getChildNodes();

                 for (int j = 0; j < hijos.getLength(); j++) {
                     Node hijo = hijos.item(j);
                     if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                          if (hijo.getNodeName().toString() == "idRole") {
                             almacenes.setIdRole(Integer.parseInt(hijo.getTextContent()));
                         }
                         if (hijo.getNodeName().toString() == "userrole") {
                             almacenes.setUserrole(hijo.getTextContent());
                         }
                         if (hijo.getNodeName().toString() == "usuario") {
                             almacenes.setUsuario(hijo.getTextContent());
                         }
                     }
                 }
                 pList.add(almacenes);
             }
         }
         return pList;
    }
    
      
    
     
}
