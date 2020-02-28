/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.FuerzasMusculares;
import com.laom.medic.jpa.sessions.FuerzasMuscularesFacade;
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
@Path("fuerzasmusculares")
public class FuerzasMuscularesRest {
    
    @EJB
    private FuerzasMuscularesFacade ejbFuerzasMuscularesFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FuerzasMusculares fuerzasMusculares) {
        ejbFuerzasMuscularesFacade.create(fuerzasMusculares);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, FuerzasMusculares fuerzasMusculares) {
        ejbFuerzasMuscularesFacade.edit(fuerzasMusculares);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbFuerzasMuscularesFacade.remove(ejbFuerzasMuscularesFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FuerzasMusculares> findAll () {
        return ejbFuerzasMuscularesFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FuerzasMusculares findById(@PathParam("id") String id) {
        return ejbFuerzasMuscularesFacade.find(id);
    }
    
     @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FuerzasMusculares> findByNombre(@PathParam("query") String query) {
        return ejbFuerzasMuscularesFacade.findByNombre(query);
    }
}
