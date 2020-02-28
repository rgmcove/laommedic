/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.FinalidadesProcedimientos;
import com.laom.medic.jpa.sessions.FinalidadesProcedimientosFacade;
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
@Path("finalidadesprocedimientos")
public class FinalidadesProcedimientosRest {
    
    @EJB
    private FinalidadesProcedimientosFacade ejbFinalidadesProcedimientosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FinalidadesProcedimientos finalidadesProcedimientos) {
        ejbFinalidadesProcedimientosFacade.create(finalidadesProcedimientos);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, FinalidadesProcedimientos finalidadesProcedimientos) {
        ejbFinalidadesProcedimientosFacade.edit(finalidadesProcedimientos);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbFinalidadesProcedimientosFacade.remove(ejbFinalidadesProcedimientosFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FinalidadesProcedimientos> findAll () {
        return ejbFinalidadesProcedimientosFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FinalidadesProcedimientos findById(@PathParam("id") Integer id) {
        return ejbFinalidadesProcedimientosFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FinalidadesProcedimientos> findByNombre(@PathParam("query") String query) {
        return ejbFinalidadesProcedimientosFacade.findByNombre(query);
    }
}
