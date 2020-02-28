/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Consultorios;
import com.laom.medic.jpa.sessions.ConsultoriosFacade;
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
 * @author adsi2
 */
@Path("consultorios")
@Produces(MediaType.APPLICATION_JSON)
public class ConsultoriosRest {
    
    @EJB
    private ConsultoriosFacade ejbConsultoriosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consultorios consultorios) {
        ejbConsultoriosFacade.create(consultorios);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Consultorios consultorios) {
        ejbConsultoriosFacade.edit(consultorios);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbConsultoriosFacade.remove(ejbConsultoriosFacade.find(id));
    }
    
    @GET
    public List<Consultorios> findAll() {
        return ejbConsultoriosFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    public Consultorios findById(@PathParam("id") Integer id) {
        return ejbConsultoriosFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    public List<Consultorios> findByNombre (@PathParam("query") String query) {
        return ejbConsultoriosFacade.findByNombre(query);
    }
}
