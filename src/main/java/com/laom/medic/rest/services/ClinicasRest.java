/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laom.medic.jpa.entities.Clinicas;
import com.laom.medic.jpa.sessions.ClinicasFacade;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author neney
 */
@Path("clinicas")
@Produces(MediaType.APPLICATION_JSON)
public class ClinicasRest {
    
    @EJB
    private ClinicasFacade ejbClinicasFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Clinicas clinicas) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        if (ejbClinicasFacade.findByEmailClinica(clinicas.getEmail()) == null) {
            if (ejbClinicasFacade.findByNit(clinicas.getNitClinica()) != null) {
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(gson.toJson("El Nit ya fue registrado"))
                        .build();
            }
            ejbClinicasFacade.create(clinicas);//Crea el usuario en la base de datos
            return Response.ok()
                    .entity(gson.toJson("La Clinica fue creada exitosamente"))
                    .build();
        } else {
            //Retornar error si no cumple con la validación del email
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity(gson.toJson("El email ya esta registrado, ingresa uno diferente"))
                    .build();
        }
        
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Clinicas clinicas) {
        ejbClinicasFacade.edit(clinicas);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbClinicasFacade.remove(ejbClinicasFacade.find(id));
    }
    
    @GET
    public List<Clinicas> findAll() {
        return ejbClinicasFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    public Clinicas findById(@PathParam("id") Integer id) {
        return ejbClinicasFacade.find(id);
    }
    
    @GET
    @Path("nombre/{query}")
    public List<Clinicas> findByNombre (@PathParam("query") String query) {
        return ejbClinicasFacade.findByNombre(query);
    }
}
