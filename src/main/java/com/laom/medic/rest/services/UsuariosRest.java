/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laom.medic.jpa.entities.Sedes;
import com.laom.medic.jpa.entities.Usuarios;
import com.laom.medic.jpa.sessions.UsuariosFacade;
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
 * @author rgmcove
 */
@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosRest {

    @EJB
    private UsuariosFacade ejbUsuariosFacade;

    @EJB
    private EnviarEmail enviarEmail;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Usuarios usuarios) {
        System.out.println("Información Usuarios: ");
        System.out.println(usuarios.getIdIdentificacion());
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        final Usuarios foundUser;
        if (ejbUsuariosFacade.findByEmail(usuarios.getEmail()) == null) {
            if (ejbUsuariosFacade.findByIdentificacion(usuarios.getIdIdentificacion()) != null) {
                //Retorna error si ya existe el registro de la Identificacion
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(gson.toJson("La Identificacion ya esta registrada"))
                        .build();
            }
   
            String mensaje;
            String asunto;
            String emailEmisor = "laomgs@gmail.com";
            String mensajeBienvenida = "Su Registro en LAOMMEDIC fue Exitoso";
            String mensajeGenero = "Bienvenido Sr@ ";
            
            asunto = "Registro Exitoso en LAOMMEDIC";
            mensaje = "<html><body>";
            mensaje += "<div style='background: whitesmoke;'";
            mensaje += "<div style='height: 104px;text-align: center;'>";
            mensaje += "<h2 style='height: 80px;'>";
            mensaje += "<span style='text-transform: uppercase;'>";
            mensaje += "<img src=\"http://imageshack.com/a/img921/5408/YaSZbZ.png\" style='width:100px;height:115px'>";
            mensaje += "</span>";
            mensaje += "</h2>";
            mensaje += "</div>";
            mensaje += "<div>";
            mensaje += mensajeGenero;
            mensaje += usuarios.getPrimerNombre() + " " + usuarios.getPrimerApellido();
            mensaje += "</div>";
            mensaje += "<div>";
            mensaje += "<p> ¡Hola! Ya has sido registrado en LAOMMEDIC. Estos son sus Datos de Usuario";
            mensaje += "</p>";
            mensaje += "</div>";
            mensaje += "<div>";
            mensaje += "<label style='font-weight: bold;'>N° Identificacion: </label>";
            mensaje += "<label style='font-style: italic;'>";
            mensaje += usuarios.getIdIdentificacion();
            mensaje += "</label>";
            mensaje += "</div>";
            mensaje += "<div>";
            mensaje += "<label style='font-weight: bold;'>Email: </label>";
            mensaje += "<label style='font-style: italic;'>";
            mensaje += usuarios.getEmail();
            mensaje += "</label>";
            mensaje += "</div>";
            mensaje += "<div>";
            mensaje += "<label style='font-weight: bold;'>Password: ********</label>";
            mensaje += "<label style='font-style: italic;'>";
            //mensaje += usuarios.getPassword();
            mensaje += "</label>";
            mensaje += "</div>";
            mensaje += "</div>";
            mensaje += "</body></html>";

            ejbUsuariosFacade.create(usuarios);//Crea el usuario en la base de datos
            getEnviarEmail().send(usuarios.getEmail(), emailEmisor, asunto, mensaje);
            return Response.ok()
                    .entity(gson.toJson("El usuario fue creado exitosamente"))
                    .build();
        } else {
            //Retornar error si no cumple con la validación del email
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity(gson.toJson("El email ya esta registrado"))
                    .build();
        }
    }

    @PUT
    //@RolesAllowed({"ADMIN", "REC"})
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuarios usuarios) {
        ejbUsuariosFacade.edit(usuarios);
    }

    @PUT
    @Path("passconfirm/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePass(@PathParam("id") Integer id, Usuarios usuarios) {
        Usuarios user = ejbUsuariosFacade.find(id);
        String newpass = usuarios.getEmpresa();
        user.setPassword(newpass);
        ejbUsuariosFacade.edit(user);
        int x = 0;
//        usuarioSession.update(user);

    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbUsuariosFacade.remove(ejbUsuariosFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@RolesAllowed({"ADMIN", "REC", "FISIO"})
    public List<Usuarios> findAll() {
        try {
            List<Usuarios> temp = ejbUsuariosFacade.findAll();
            return temp;
        } catch (Exception ex) {
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@RolesAllowed({"ADMIN", "REC", "FISIO"})
    @Path("{id}")
    public Usuarios findById(@PathParam("id") Integer id) {
        return ejbUsuariosFacade.find(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@RolesAllowed({"ADMIN", "REC", "FISIO"})
    @Path("nombre/{nombre}")
    public List<Usuarios> findByNombre(@PathParam("nombre") String nombre) {
        return ejbUsuariosFacade.findByPrimerNombre(nombre);
    }

    @GET
    @Path("numero/{idIdentificacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> findByIdenti(@PathParam("idIdentificacion") String query) {
        return ejbUsuariosFacade.findByIdentiRol(query);
    }

    @GET
    @Path("numer/{idIdentificacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> findByFisio(@PathParam("idIdentificacion") String query) {
        return ejbUsuariosFacade.findByFisio(query);
    }

    @GET
    @Path("sede/{idSede}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> findBySede(@PathParam("idSede") Integer idSede) {
        return ejbUsuariosFacade.findBySede(new Sedes(idSede));
    }

    @GET
    @Path("codigo/{id}/{recuperacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios findByIdAndCode(@PathParam("id") String id, @PathParam("recuperacion") String recuperacion) {
        return ejbUsuariosFacade.findByIdAndCode(Integer.parseInt(id), recuperacion);
    }

    public EnviarEmail getEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(EnviarEmail enviarEmail) {
        this.enviarEmail = enviarEmail;
    }

}
