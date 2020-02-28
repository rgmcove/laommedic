/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.TipoAfiliados;
import com.laom.medic.jpa.sessions.TipoAfiliadosFacade;
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
@Path("afiliados")
public class TipoAfiliadosRest {
    
    @EJB
    private TipoAfiliadosFacade ejbTipoAfiliadosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TipoAfiliados afiliados) {
        ejbTipoAfiliadosFacade.create(afiliados);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TipoAfiliados afiliados) {
        ejbTipoAfiliadosFacade.edit(afiliados);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbTipoAfiliadosFacade.remove(ejbTipoAfiliadosFacade.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TipoAfiliados> findAll() {
        return ejbTipoAfiliadosFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TipoAfiliados findById(@PathParam("id") Integer id) {
        return ejbTipoAfiliadosFacade.find(id);
    }
    
}
