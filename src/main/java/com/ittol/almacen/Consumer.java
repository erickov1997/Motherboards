/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

//import static com.oracle.webservices.internal.api.EnvelopeStyle.Style.XML;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
   
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



/*import org.w3c.dom.Document;
import org.w3c.dom.Element;*/


import sun.net.www.http.HttpClient;

/**
 *
 * @author Erick
 */
public class Consumer {
    public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException, JAXBException, jdk.internal.org.xml.sax.SAXException {
       
       
          new LecturaUrl().ResPetGet();
           
	
}
	
    
   
                
               
    
    
    
    
    
    /*PETICION POST 2 */
               
           
                
                
       
        
      /* String inline = "";
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
             
                StringReader sr = new StringReader(inline);
                JAXBContext jaxbContext = JAXBContext.newInstance(UserRole.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                UserRole userRole = (UserRole) unmarshaller.unmarshal(sr);
                System.out.println(userRole.toString());

                //System.out.println("\nJSON Response in String format");
                System.out.println(inline);
                sc.close();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
         
         
        LecturaUrl obj= new  LecturaUrl();
        obj.met(inline);
        
        System.out.println("cantidad de usuarios: "+obj.met(inline).size());
       */
        // convertStringToDocument(inline);
         
         
  
        
    
   

    
    }
   
   
 


    
   

