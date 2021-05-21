/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import com.ittol.almacen.AlmacenValidations;
import com.ittol.users.Usuarios;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Erick
 */
@Named("appLogin")
@SessionScoped
public class Login implements Serializable {
   
    
    private String username;
    private String password;
    private String errorMessage;
    private int errorsCounter;
    
    
    
    public String login() {
        
        System.out.println("metodo login: "+userLogin());
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            new Usuarios().setPersona(getUsername());
            System.out.println("USERNAME:" + getUsername() + "PASSWORD:" + getPassword());
            request.login(getUsername(), getPassword());
        } catch (ServletException ex) {
            if (ex.getMessage().contains("Login failed")) {
                setErrorMessage("login.failed");            
            }
            FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o contraseña incorrectos", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            logout();
            return "index.xhtml";
        }
        Principal user = request.getUserPrincipal();
        /*setPersons(new PersonsJpaController(emf).findPersons(username));
        context.getExternalContext().getSessionMap().put("persons", persons);*/
        if (request.isUserInRole("ADMINS")) {
            return "/secured/admin/user/agr_user.xhtml";
        } else {
            return "/secured/user/Productos/Productos.xhtml";
        }
    }
    
      public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            externalContext.invalidateSession();
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }

        setErrorMessage("");
        setErrorsCounter(0);
        return "/index.xhtml?faces-redirect=true";
    }
      
     public String userLogin(){
         return this.username;
     } 
     
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorsCounter() {
        return errorsCounter;
    }

    public void setErrorsCounter(int errorsCounter) {
        this.errorsCounter = errorsCounter;
    }
    
    
     /* public static void main(String[] args) throws ClassNotFoundException {
       Login obj= new Login();
       obj.process();
       
    }*/

}
