/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.AuditaUsuarios;
import com.laom.medic.jpa.sessions.AuditaUsuariosFacade;
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
 * @author adsi2
 */
@Path("auditausuarios")
public class AuditaUsuariosRest {
    
    @EJB
    private AuditaUsuariosFacade ejbAuditaUsuariosFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AuditaUsuarios auditaUsuarios) {
        ejbAuditaUsuariosFacade.create(auditaUsuarios);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, AuditaUsuarios auditaUsuarios) {
        ejbAuditaUsuariosFacade.edit(auditaUsuarios);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbAuditaUsuariosFacade.remove(ejbAuditaUsuariosFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AuditaUsuarios> findAll() {
        return ejbAuditaUsuariosFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AuditaUsuarios findById(@PathParam("id") Integer id) {
        return ejbAuditaUsuariosFacade.find(id);
    }
    
}
