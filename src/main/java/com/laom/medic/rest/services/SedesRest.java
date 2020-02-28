/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Sedes;
import com.laom.medic.jpa.entities.Usuarios;
import com.laom.medic.jpa.sessions.SedesFacade;
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
@Path("sedes")
public class SedesRest {
    
    @EJB
    private SedesFacade ejbSedesFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sedes sedes) {
        ejbSedesFacade.create(sedes);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Sedes sedes) {
        ejbSedesFacade.edit(sedes);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbSedesFacade.remove(ejbSedesFacade.find(id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sedes> findAll() {
        return ejbSedesFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sedes findById(@PathParam("id") Integer id) {
        return ejbSedesFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sedes> findByNombre (@PathParam("query") String query) {
        return ejbSedesFacade.findByNombre(query);
    }
    
    @GET
    @Path("usuarios/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sedes> findByIdUsuario (@PathParam("idUsuario") Integer idUsuario) {
        return ejbSedesFacade.findByIdUsuario(new Usuarios(idUsuario));
    }
    
}
