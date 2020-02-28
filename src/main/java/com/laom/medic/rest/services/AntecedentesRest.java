/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Antecedentes;
import com.laom.medic.jpa.sessions.AntecedentesFacade;
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
@Path("antecedentes")
public class AntecedentesRest {
    
    @EJB
    private AntecedentesFacade ejbAntecedentesFacade;
    
    @POST
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Antecedentes antecedentes) {
        ejbAntecedentesFacade.create(antecedentes);
    }
    
    @PUT
    //@RolesAllowed({"ADMIN", "FISIO"})
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Antecedentes antecedentes) {
        ejbAntecedentesFacade.edit(antecedentes);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbAntecedentesFacade.remove(ejbAntecedentesFacade.find(id));
    }
    
    @GET
    //@RolesAllowed({"ADMIN", "FISIO", "REC"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Antecedentes> findAll() {
        return ejbAntecedentesFacade.findAll();
    }
    
    @GET
    //@RolesAllowed({"ADMIN", "FISIO", "REC"})
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Antecedentes findById(@PathParam("id") Integer id) {
        return ejbAntecedentesFacade.find(id);
    }
    
}
