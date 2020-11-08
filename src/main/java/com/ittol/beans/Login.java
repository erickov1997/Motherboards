/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import com.ittol.almacen.AlmacenValidations;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Erick
 */
@Named("appLogin")
@SessionScoped
public class Login implements Serializable {
    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String process() throws ClassNotFoundException {
        if (new LoginValidations().validate(usuario, password)) {
            return "Productos/Productos.xhtml";
        } else {
            FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o contraseña incorrectos", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "index.xhtml";
        }
    }
}
