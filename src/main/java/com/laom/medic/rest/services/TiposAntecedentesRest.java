/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.TiposAntecedentes;
import com.laom.medic.jpa.sessions.TiposAntecedentesFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
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
@Path("tiposantecedentes")
public class TiposAntecedentesRest {
    
    @EJB
    private TiposAntecedentesFacade ejbTiposAntecedentesFacade;
    
    @POST
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TiposAntecedentes tiposAntecedentes) {
        ejbTiposAntecedentesFacade.create(tiposAntecedentes);
    }
    
    @PUT
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TiposAntecedentes tiposAntecedentes) {
        ejbTiposAntecedentesFacade.edit(tiposAntecedentes);
    }
    
    @DELETE
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbTiposAntecedentesFacade.remove(ejbTiposAntecedentesFacade.find(id));
    }
    
    @GET
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TiposAntecedentes> findAll () {
        return ejbTiposAntecedentesFacade.findAll();
    }
    
    @GET
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TiposAntecedentes findById(@PathParam("id") Integer id) {
        return ejbTiposAntecedentesFacade.find(id);
    }
    
    @GET
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TiposAntecedentes> findByNombre (@PathParam("query") String query) {
        return ejbTiposAntecedentesFacade.findByNombre(query);
    }
    
}
