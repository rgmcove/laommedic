/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.auth;

import com.laom.medic.jpa.entities.Roles;
import com.laom.medic.jpa.entities.Usuarios;
import com.laom.medic.jpa.sessions.UsuariosFacade;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import org.joda.time.DateTime;

/**
 *
 * @author APRENDIZ
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @EJB
    private UsuariosFacade ejbFacadeUsuarios;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        SecurityContext originalContext = requestContext.getSecurityContext();
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || authHeader.isEmpty() || authHeader.split(" ").length !=2) {
            Authorizer authorizer = new Authorizer(new ArrayList<Roles>(), " ", originalContext.isSecure());
            requestContext.setSecurityContext(authorizer);
        } else {
            JWTClaimsSet claimsSet;
            try {
                claimsSet = (JWTClaimsSet) AuthUtils.decodeToken(authHeader);
            } catch (ParseException ex) {
                throw new IOException("Error de conversion de JWT");
            } catch (JOSEException ex) {
                throw new IOException("JWT Invalido");
            }
            
            if (new DateTime(claimsSet.getExpirationTime()).isBefore(DateTime.now())) {
                throw new IOException("El token ya expiro");
            } else {
                Usuarios user = ejbFacadeUsuarios.find(Integer.parseInt(claimsSet.getSubject()));
                Authorizer authorizer = new Authorizer(user.getRolesList(),
                        user.getEmail(),
                        originalContext.isSecure());
                requestContext.setSecurityContext(authorizer);
            }
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
    
    
    public static class Authorizer implements SecurityContext {//Static sirve para usar una clase sin instanciar un objeto
        List<Roles> roles;
        String username;
        boolean isSecure;

        public Authorizer(List<Roles> roles, String username, boolean isSecure) {
            this.roles = roles;
            this.username = username;
            this.isSecure = isSecure;
        }

        @Override
        public Principal getUserPrincipal() {
            return new User(username);
        }

        @Override
        public boolean isUserInRole(String role) {
            return roles.contains(new Roles(role));
        }

        @Override
        public boolean isSecure() {
            return isSecure;
        }

        @Override
        public String getAuthenticationScheme() {
            return "JWT";
        }
        
    }

    public static class User implements Principal {
        
        String name;

        public User(String name) {
            this.name = name;
        }
        
        @Override
        public String getName() {
            return name;
        }
        
    }
}
