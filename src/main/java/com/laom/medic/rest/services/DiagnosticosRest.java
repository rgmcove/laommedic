/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Diagnosticos;
import com.laom.medic.jpa.sessions.DiagnosticosFacade;
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
@Path("diagnosticos")
public class DiagnosticosRest {

    @EJB
    private DiagnosticosFacade ejbDiagnosticosFacade;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Diagnosticos diagnosticos) {
        ejbDiagnosticosFacade.create(diagnosticos);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Diagnosticos diagnosticos) {
        ejbDiagnosticosFacade.edit(diagnosticos);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbDiagnosticosFacade.remove(ejbDiagnosticosFacade.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Diagnosticos> findAll() {
        return ejbDiagnosticosFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Diagnosticos findById(@PathParam("id") Integer id) {
        return ejbDiagnosticosFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Diagnosticos> findByNombre(@PathParam("query") String query) {
        return ejbDiagnosticosFacade.findByNombre(query);
    }
}
