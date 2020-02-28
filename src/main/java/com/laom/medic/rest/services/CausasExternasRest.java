/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.CausasExternas;
import com.laom.medic.jpa.sessions.CausasExternasFacade;
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
@Path("causasexternas")
@Produces(MediaType.APPLICATION_JSON)
public class CausasExternasRest {
    
    @EJB
    private CausasExternasFacade ejbCausasExternasFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(CausasExternas causasExternas) {
        ejbCausasExternasFacade.create(causasExternas);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, CausasExternas causasExternas) {
        ejbCausasExternasFacade.edit(causasExternas);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbCausasExternasFacade.remove(ejbCausasExternasFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CausasExternas> findAll() {
        return ejbCausasExternasFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CausasExternas findById(@PathParam("id") Integer id) {
        return ejbCausasExternasFacade.find(id);
    }
    
     @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CausasExternas> findByNombre(@PathParam("query") String query) {
        return ejbCausasExternasFacade.findByNombre(query);
    }
}
