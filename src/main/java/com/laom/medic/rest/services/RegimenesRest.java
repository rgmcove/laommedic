/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Regimenes;
import com.laom.medic.jpa.sessions.RegimenesFacade;
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
@Path("regimenes")
public class RegimenesRest {
    
    @EJB
    private RegimenesFacade ejbRegimenesFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Regimenes regimenes) {
        ejbRegimenesFacade.create(regimenes);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Regimenes regimenes) {
        ejbRegimenesFacade.edit(regimenes);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbRegimenesFacade.remove(ejbRegimenesFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Regimenes> findAll () {
        return ejbRegimenesFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Regimenes findById(@PathParam("id") String id) {
        return ejbRegimenesFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Regimenes> findByNombre (@PathParam("query") String query) {
        return ejbRegimenesFacade.findByNombre(query);
    }
}
