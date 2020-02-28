/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.PersonalTratante;
import com.laom.medic.jpa.sessions.PersonalTratanteFacade;
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
@Path("personaltratante")
public class PersonalTratanteRest {
    
    @EJB
    private PersonalTratanteFacade ejbPersonalTratanteFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PersonalTratante personalTratante) {
        ejbPersonalTratanteFacade.create(personalTratante);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, PersonalTratante personalTratante) {
        ejbPersonalTratanteFacade.edit(personalTratante);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbPersonalTratanteFacade.remove(ejbPersonalTratanteFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PersonalTratante> findAll () {
        return ejbPersonalTratanteFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PersonalTratante findById(@PathParam("id") Integer id) {
        return ejbPersonalTratanteFacade.find(id);
    }
    
}
