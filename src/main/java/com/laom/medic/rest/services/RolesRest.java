/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Roles;
import com.laom.medic.jpa.sessions.RolesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author rgmcove
 */
@Path("roles")
@Produces(MediaType.APPLICATION_JSON)
public class RolesRest {

    @EJB
    private RolesFacade ejbRolesFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> findAll() {
        return ejbRolesFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Roles findById(@PathParam("id") String id) {
        return ejbRolesFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> findByNombre (@PathParam("query") String query) {
        return ejbRolesFacade.findByNombre(query);
    }
}
