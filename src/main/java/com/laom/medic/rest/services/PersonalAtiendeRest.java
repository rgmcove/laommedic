/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.PersonalAtiende;
import com.laom.medic.jpa.sessions.PersonalAtiendeFacade;
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
@Path("personalatiende")
public class PersonalAtiendeRest {
    
    @EJB
    private PersonalAtiendeFacade ejbPersonalAtiendeFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PersonalAtiende personalAtiende) {
        ejbPersonalAtiendeFacade.create(personalAtiende);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, PersonalAtiende personalAtiende) {
        ejbPersonalAtiendeFacade.edit(personalAtiende);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbPersonalAtiendeFacade.remove(ejbPersonalAtiendeFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PersonalAtiende> findAll () {
        return ejbPersonalAtiendeFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PersonalAtiende findById(@PathParam("id") Integer id) {
        return ejbPersonalAtiendeFacade.find(id);
    }
    
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonalAtiende> findByNombre (@PathParam("query") String query) {
        return ejbPersonalAtiendeFacade.findByNombre(query);
    }
    
}
