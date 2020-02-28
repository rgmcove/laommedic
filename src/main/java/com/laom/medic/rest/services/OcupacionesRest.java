/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Ocupaciones;
import com.laom.medic.jpa.sessions.OcupacionesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author neney
 */
@Path("ocupaciones")
@Produces(MediaType.APPLICATION_JSON)
public class OcupacionesRest {
    
    @EJB
    private OcupacionesFacade ejbOcupacionesFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Ocupaciones ocupaciones) {
        ejbOcupacionesFacade.create(ocupaciones);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Ocupaciones ocupaciones) {
        ejbOcupacionesFacade.edit(ocupaciones);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbOcupacionesFacade.remove(ejbOcupacionesFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ocupaciones> findAll() {
        return ejbOcupacionesFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Ocupaciones findById(@PathParam("id") String id) {
        return ejbOcupacionesFacade.find(id);
    }
    
}
