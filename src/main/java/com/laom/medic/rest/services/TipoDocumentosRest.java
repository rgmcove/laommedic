/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.TipoDocumentos;
import com.laom.medic.jpa.sessions.TipoDocumentosFacade;
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
@Path("tipodocumentos")
public class TipoDocumentosRest {
    
    @EJB
    private TipoDocumentosFacade ejbTipoDocumentosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(TipoDocumentos tipoDocumentos) {
        ejbTipoDocumentosFacade.create(tipoDocumentos);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, TipoDocumentos tipoDocumentos) {
        ejbTipoDocumentosFacade.edit(tipoDocumentos);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbTipoDocumentosFacade.remove(ejbTipoDocumentosFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoDocumentos> findAll () {
        return ejbTipoDocumentosFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public TipoDocumentos findById(@PathParam("id") String id) {
        return ejbTipoDocumentosFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoDocumentos> findByNombre (@PathParam("query") String query) {
        return ejbTipoDocumentosFacade.findByNombre(query);
    }
    
}
