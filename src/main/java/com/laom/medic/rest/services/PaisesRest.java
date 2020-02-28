/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Paises;
import com.laom.medic.jpa.sessions.PaisesFacade;
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
@Path("paises")
public class PaisesRest {
    
    @EJB
    private PaisesFacade ejbPaisesFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Paises paises) {
        ejbPaisesFacade.create(paises);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Paises paises) {
        ejbPaisesFacade.edit(paises);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbPaisesFacade.remove(ejbPaisesFacade.find(id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paises> findAll () {
        return ejbPaisesFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Paises findById(@PathParam("id") String id) {
        return ejbPaisesFacade.find(id);
    }
    
}
