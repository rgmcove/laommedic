/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.TiposSangre;
import com.laom.medic.jpa.sessions.TiposSangreFacade;
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
@Path("tipossangre")
public class TiposSangreRest {
    
    @EJB
    private TiposSangreFacade ejbTiposSangreFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TiposSangre tiposSangre) {
        ejbTiposSangreFacade.create(tiposSangre);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TiposSangre tiposSangre) {
        ejbTiposSangreFacade.edit(tiposSangre);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbTiposSangreFacade.remove(ejbTiposSangreFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TiposSangre> findAll () {
        return ejbTiposSangreFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TiposSangre findById(@PathParam("id") Integer id) {
        return ejbTiposSangreFacade.find(id);
    }
    
}
