/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.FinalidadesConsultas;
import com.laom.medic.jpa.sessions.FinalidadesConsultasFacade;
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
@Path("finalidadesconsultas")
public class FinalidadesConsultasRest {
    
    @EJB
    private FinalidadesConsultasFacade ejbFinalidadesConsultasFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FinalidadesConsultas finalidadesConsultas) {
        ejbFinalidadesConsultasFacade.create(finalidadesConsultas);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, FinalidadesConsultas finalidadesConsultas) {
        ejbFinalidadesConsultasFacade.edit(finalidadesConsultas);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbFinalidadesConsultasFacade.remove(ejbFinalidadesConsultasFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FinalidadesConsultas> findAll () {
        return ejbFinalidadesConsultasFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FinalidadesConsultas findById(@PathParam("id") Integer id) {
        return ejbFinalidadesConsultasFacade.find(id);
    }
    
     @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FinalidadesConsultas> findByNombre(@PathParam("query") String query) {
        return ejbFinalidadesConsultasFacade.findByNombre(query);
    }
}
