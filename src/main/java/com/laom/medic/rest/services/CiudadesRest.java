/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Ciudades;
import com.laom.medic.jpa.sessions.CiudadesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author APRENDIZ
 */
@Path("ciudades")
public class CiudadesRest {

    @EJB
    private CiudadesFacade ejbCiudadesFacade;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudades> findAll() {
        return ejbCiudadesFacade.findAll();
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudades> findByNombre(@PathParam("query") String query) {
        return ejbCiudadesFacade.findByNombre(query);
    }
    
}
