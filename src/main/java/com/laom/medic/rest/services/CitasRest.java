/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Citas;
import com.laom.medic.jpa.entities.Sedes;
import com.laom.medic.jpa.entities.Usuarios;
import com.laom.medic.jpa.sessions.CitasFacade;
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
@Path("citas")
public class CitasRest {
    
    @EJB
    private CitasFacade ejbCitasFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Citas citas) {
        ejbCitasFacade.create(citas);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Citas citas) {
        ejbCitasFacade.edit(citas);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbCitasFacade.remove(ejbCitasFacade.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Citas> findAll() {
        return ejbCitasFacade.findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Citas findById(@PathParam("id") Integer id) {
        return ejbCitasFacade.find(id);
    }
    
    @GET
    @Path("sede/{idSede}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Citas> findBySedeInCitas(@PathParam("idSede") Integer idSedes) {
        return ejbCitasFacade.findBySedeInCitas (new Sedes(idSedes)); 
    }
    
    @GET
    @Path("historias/{idIdentificacion}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Citas> findByIdUsuario(@PathParam("idIdentificacion") String idUsuario){
        return ejbCitasFacade.findByIdUsuario(idUsuario);
    }
    
    @GET
    @Path("fechahorarios/{fechaInicio}/{fechaFin}/{idSede}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Citas> findByFechas(@PathParam("fechaInicio") String fechaInicio, @PathParam("fechaFin") String fechaFin, @PathParam("idSede")Integer idSedes) {
        return ejbCitasFacade.FindByFechas(fechaInicio, fechaFin, new Sedes(idSedes));
    }
    
    @GET
    @Path("fechauser/{fechaInicio}/{fechaFin}/{idUsuario}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Citas> findByFechasUser(@PathParam("fechaInicio") String fechaInicio, @PathParam("fechaFin") String fechaFin, @PathParam("idUsuario") Integer idUsuario) {
        return ejbCitasFacade.FindByFechasUser(fechaInicio, fechaFin, idUsuario);
    }
    
    @GET
    @Path("fecha/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Citas findByFecha (@PathParam("id") int id) {
        return ejbCitasFacade.findByfecha(id);
    }
    
}
