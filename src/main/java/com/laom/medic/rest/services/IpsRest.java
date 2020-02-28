/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Ips;
import com.laom.medic.jpa.sessions.IpsFacade;
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
@Path("ips")
public class IpsRest {
    
    @EJB
    private IpsFacade ejbIpsFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Ips ips) {
        ejbIpsFacade.create(ips);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Ips ips) {
        ejbIpsFacade.edit(ips);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbIpsFacade.remove(ejbIpsFacade.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ips> findAll() {
        return ejbIpsFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Ips findById(@PathParam("id") String id) {
        return ejbIpsFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ips> findByNombre(@PathParam("query") String query) {
        return ejbIpsFacade.findByNombre(query);
    }
    
}
