/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Escolaridades;
import com.laom.medic.jpa.sessions.EscolaridadesFacade;
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
@Path("escolaridades")
public class EscolaridadesRest {
    
   @EJB
    private EscolaridadesFacade ejbEscolaridadesFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Escolaridades escolaridades) {
        ejbEscolaridadesFacade.create(escolaridades);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Escolaridades escolaridades) {
        ejbEscolaridadesFacade.edit(escolaridades);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbEscolaridadesFacade.remove(ejbEscolaridadesFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Escolaridades> findAll () {
        return ejbEscolaridadesFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Escolaridades findById(@PathParam("id") Integer id) {
        return ejbEscolaridadesFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Escolaridades> findByNombre (@PathParam("query") String query) {
        return ejbEscolaridadesFacade.findByNombre(query);
    }
    
}
