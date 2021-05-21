/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.web.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Erick
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.ittol.almacen.service.PedidoWsFacadeREST.class);
        resources.add(com.ittol.web.service.AlmacenesFacadeREST.class);
        resources.add(com.ittol.web.service.EntradasFacadeREST.class);
        resources.add(com.ittol.web.service.PedidosFacadeREST.class);
        resources.add(com.ittol.web.service.ProductosFacadeREST.class);
        resources.add(com.ittol.web.service.SalidasFacadeREST.class);
        resources.add(com.ittol.web.service.UserRoleFacadeREST.class);
        resources.add(com.ittol.web.service.UsersFacadeREST.class);
        resources.add(com.ittol.web.service.UsuariosFacadeREST.class);
    }
    
}
