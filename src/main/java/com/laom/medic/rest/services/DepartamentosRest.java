/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Departamentos;
import com.laom.medic.jpa.sessions.DepartamentosFacade;
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
@Path("departamentos")
public class DepartamentosRest {
    
    @EJB
    private DepartamentosFacade ejbDepartamentosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Departamentos departamentos) {
        ejbDepartamentosFacade.create(departamentos);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Departamentos departamentos) {
        ejbDepartamentosFacade.edit(departamentos);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbDepartamentosFacade.remove(ejbDepartamentosFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Departamentos> findAll () {
        return ejbDepartamentosFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Departamentos findById(@PathParam("id") Integer id) {
        return ejbDepartamentosFacade.find(id);
    }
    
}
