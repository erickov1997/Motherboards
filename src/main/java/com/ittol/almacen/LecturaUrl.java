/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jdk.internal.org.xml.sax.SAXException;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;




import org.json.JSONException;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

/**
 *
 * @author Erick
 */
public class LecturaUrl {
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
    
    

      public ArrayList<UserRole> convertStringToDocument() throws ParserConfigurationException, SAXException, IOException, org.xml.sax.SAXException {
        String xmlCad=PeticionGet();
          UserRole almacenes = new UserRole();
        ArrayList<UserRole> pList = new ArrayList<UserRole>();
         org.w3c.dom.Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new InputSource(new StringReader(xmlCad)));

        NodeList nodos = doc.getElementsByTagName("userRoles");

        for (int i = 0; i < nodos.getLength(); i++) {
            almacenes = new UserRole();
            Node nodo = nodos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nodo;
                NodeList hijos = e.getChildNodes();

                for (int j = 0; j < hijos.getLength(); j++) {
                    Node hijo = hijos.item(j);
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
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
      
      /***************************************************************************************/
       public String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
        }
      
      /***************************************************************************************/
       
       public void ResPetGet(){
            String url2 = "http://localhost:8080/Motherboards/webresources/com.ittol.almacen.userroles";
		String respuesta = "";
		try {
			respuesta = peticionHttpGet(url2);
			System.out.println("La respuesta es:\n" + respuesta);
		} catch (Exception e) {
			// Manejar excepción
			e.printStackTrace();
		}
                System.out.println(new LecturaUrl().met(respuesta).size());
       
       }
      /*********************************************************************************************/ 
    public ArrayList<UserRole> met(String doct){
        UserRole almacenes = new UserRole();
        ArrayList<UserRole> pList = new ArrayList<UserRole>();
         try {
              
            //File archivoxml = new File("C:\\Users\\Erick\\Documents\\NetBeansProjects\\Motherboards\\src\\main\\webapp\\public\\xmlprueba.xml");
            File archivo = new File("C:\\Users\\Erick\\Documents\\NetBeansProjects\\Motherboards\\src\\main\\webapp\\public\\xmlprueba.xml");
            
          org.w3c.dom.Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new InputSource(new StringReader(doct)));
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
           // org.w3c.dom.Document document =  documentBuilder.parse(doc);
            
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
            NodeList listaEmpleados = document.getElementsByTagName("userRoles");
            for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {
                Node nodo = listaEmpleados.item(temp);
                System.out.println("Elemento:" + nodo.getNodeName());
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    //System.out.println("id: " + element.getAttribute("id"));
                     almacenes.setIdRole(Integer.parseInt(element.getElementsByTagName("idRole").item(0).getTextContent()));
                     almacenes.setUserrole(element.getElementsByTagName("idRole").item(0).getTextContent());
                     almacenes.setUsuario(element.getElementsByTagName("userrole").item(0).getTextContent());
                     pList.add(almacenes);
                     System.out.println(element.getElementsByTagName("idRole").item(0).getTextContent());
                     System.out.println(element.getElementsByTagName("userrole").item(0).getTextContent());
                    System.out.println(element.getElementsByTagName("usuario").item(0).getTextContent());
                   // System.out.println("password: " + element.getElementsByTagName("password").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        /*System.out.println("tamaño de la lista"+pList.size());
        for (int i = 0; i <pList.size(); i++) {
            System.out.println("userRole in position: "+pList.get(i));
        }*/
         return pList;
    }
    
   /*********************************************************************************************/ 

    
    public void PeticionPost(){
        String jsonInputString;
       
        String total="123.67";
         String status="nohay"+total;
        try {
            //String prod="hjh";
           // URL url = new URL("http://localhost:8080/Motherboards/webresources/com.ittol.almacen.userroles");
           // URL url = new URL(" http://f46e3ddabfec.ngrok.io/Motherboards/webresources/com.ittol.almacen.productos");
            // URL url = new URL(" http://f46e3ddabfec.ngrok.io/Motherboards/webresources/com.ittol.almacen.userroles");
            URL url = new URL(" http://f46e3ddabfec.ngrok.io/Motherboards/webresources/com.ittol.almacen.pedidows");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "*/*");
            con.setDoOutput(true);
            //jsonInputString = "{\"producto\":\"12347\",\"cantidad\":\"34\",\"total\":\"344\",\"fecha\":\"\",\"status\":\""+status+"\"}";
             jsonInputString = "{\"producto\":\"gf67u\",\"cantidad\":\"12\",\"total\":\"\",\"fecha\":\"gjhgj\",\"status\":\"\"}";
            // jsonInputString = "{\"userrole\":\"ADMINS\",\"usuario\":\"nuevo69\"}";
            //String json = "{\"userrole\":\"ADMINS\",\"usuario\":\"nuevo\"}";
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("xxx" + response.toString());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    
    }
   
   
    
    public static void main(String[] args) {
        
        new LecturaUrl().PeticionPost();
        
    }
}
