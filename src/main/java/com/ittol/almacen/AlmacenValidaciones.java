/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Erick
 */
@FacesValidator("valmacen")
public class AlmacenValidaciones implements Validator {
   /* public void validar(FacesContext context,UIComponent toValidate,Object value){
        Almacen almacen= new Almacen();
        context = FacesContext.getCurrentInstance();
        String texto=(String)value;
        if (almacen.getNombre().equals("")) {
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(), message);
        }
    }*/
    

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //throw new UnsupportedOperationException("Not supported yet.");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        String ncampo = value.toString().trim();
        if (ncampo.length()==0) {
            throw new ValidatorException(new FacesMessage("campo vacio"));
        }else{
            String erTexto ="^[a-zA-Z]+$";
           // String erTexto ="/^\\d{2}([./-])\\d{2}\\1\\d{4}$/ ";
            //^[a-zA-Z0-9]+$ 
           
             
            boolean ok= Pattern.matches(erTexto,ncampo);
           
            
             if (!ok) {
                throw new ValidatorException(new FacesMessage("formato de fecha invalido "));
            }
        }
        
    }
}
