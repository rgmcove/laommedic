/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.EntidadesAdministradoras;
import com.laom.medic.jpa.sessions.EntidadesAdministradorasFacade;
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
@Path("administradoras")
public class EntidadesAdministradorasRest {
    
    @EJB
    private EntidadesAdministradorasFacade ejbEntidadesAdministradorasFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EntidadesAdministradoras administradoras) {
        ejbEntidadesAdministradorasFacade.create(administradoras);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, EntidadesAdministradoras administradoras) {
        ejbEntidadesAdministradorasFacade.edit(administradoras);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbEntidadesAdministradorasFacade.remove(ejbEntidadesAdministradorasFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EntidadesAdministradoras> findAll() {
        return ejbEntidadesAdministradorasFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public EntidadesAdministradoras findById(@PathParam("id") String id) {
        return ejbEntidadesAdministradorasFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EntidadesAdministradoras> findByNombre(@PathParam("query") String query) {
        return ejbEntidadesAdministradorasFacade.findByNombre(query);
    }
}
