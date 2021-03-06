/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.TiposDeDiagnosticosPrincipales;
import com.laom.medic.jpa.sessions.TiposDeDiagnosticosPrincipalesFacade;
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
@Path("tiposdiagnosticos")
public class TiposDeDiagnosticosPrincipalesRest {
    
    @EJB
    private TiposDeDiagnosticosPrincipalesFacade ejbTiposDeDiagnosticosPrincipalesFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TiposDeDiagnosticosPrincipales tiposDeDiagnosticosPrincipales) {
        ejbTiposDeDiagnosticosPrincipalesFacade.create(tiposDeDiagnosticosPrincipales);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TiposDeDiagnosticosPrincipales tiposDeDiagnosticosPrincipales) {
        ejbTiposDeDiagnosticosPrincipalesFacade.edit(tiposDeDiagnosticosPrincipales);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbTiposDeDiagnosticosPrincipalesFacade.remove(ejbTiposDeDiagnosticosPrincipalesFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TiposDeDiagnosticosPrincipales> findAll () {
        return ejbTiposDeDiagnosticosPrincipalesFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TiposDeDiagnosticosPrincipales findById(@PathParam("id") Integer id) {
        return ejbTiposDeDiagnosticosPrincipalesFacade.find(id);
    }
    
     @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TiposDeDiagnosticosPrincipales> findByNombre(@PathParam("query") String query) {
        return ejbTiposDeDiagnosticosPrincipalesFacade.findByNombre(query);
    }
}
