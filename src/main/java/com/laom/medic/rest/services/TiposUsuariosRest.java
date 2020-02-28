/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.TiposUsuarios;
import com.laom.medic.jpa.sessions.TiposUsuariosFacade;
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
@Path("tiposusuarios")
public class TiposUsuariosRest {
    
    @EJB
    private TiposUsuariosFacade ejbTiposUsuariosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TiposUsuarios tiposUsuarios) {
        ejbTiposUsuariosFacade.create(tiposUsuarios);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TiposUsuarios tiposUsuarios) {
        ejbTiposUsuariosFacade.edit(tiposUsuarios);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbTiposUsuariosFacade.remove(ejbTiposUsuariosFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TiposUsuarios> findAll () {
        return ejbTiposUsuariosFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TiposUsuarios findById(@PathParam("id") Integer id) {
        return ejbTiposUsuariosFacade.find(id);
    }
    
}
