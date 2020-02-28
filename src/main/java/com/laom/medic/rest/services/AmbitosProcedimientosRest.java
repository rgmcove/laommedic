/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.AmbitosProcedimientos;
import com.laom.medic.jpa.sessions.AmbitosProcedimientosFacade;
import java.util.List;
import javax.ws.rs.Path;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author neney
 */
@Path("ambitosprocedimientos")
public class AmbitosProcedimientosRest {
    
    @EJB
    private AmbitosProcedimientosFacade ejbAmbitosProcedimientosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AmbitosProcedimientos ambitosProcedimientos) {
        ejbAmbitosProcedimientosFacade.create(ambitosProcedimientos);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, AmbitosProcedimientos ambitosProcedimientos) {
        ejbAmbitosProcedimientosFacade.edit(ambitosProcedimientos);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbAmbitosProcedimientosFacade.remove(ejbAmbitosProcedimientosFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AmbitosProcedimientos> findAll() {
        return ejbAmbitosProcedimientosFacade.findAll();
    }
    
     @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AmbitosProcedimientos> findByNombre(@PathParam("query") String query) {
        return ejbAmbitosProcedimientosFacade.findByNombre(query);
    }
    
}
