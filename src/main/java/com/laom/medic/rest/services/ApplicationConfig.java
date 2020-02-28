/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author APRENDIZ
 */
@ApplicationPath("webresources")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("com.laom.medic.rest.services;com.laom.medic.rest.auth");
        register(RolesAllowedDynamicFeature.class);
    }
    
    
    
}
