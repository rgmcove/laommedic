/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import com.laom.medic.jpa.entities.Usuarios;
import com.laom.medic.jpa.models.RecoveryPassword;
import com.laom.medic.jpa.sessions.UsuariosFacade;
import com.laom.medic.rest.auth.DigestUtil;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author neney
 */
@Path("email")
@Stateless
public class EmailRest {
    
    @EJB
    UsuariosFacade usuariosFacade;
    
    @POST
    @Path("recoverypass")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void recoveryPass(RecoveryPassword recovery) throws EmailException {
        
        try {
            Usuarios user = usuariosFacade.findByEmail(recovery.getEmail());
            int x = (int) (Math.random() * 1000);
            
            String cd = null;
            try {
                cd = DigestUtil.generateDigest(String.valueOf(x));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            HtmlEmail email = new HtmlEmail();

            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("laomgs@gmail.com", "eiegcwtbjykzxckw"));
            email.setSSL(true);
            email.setFrom("laomgs@gmail.com");
            email.setSubject("Restablecer Contraseña De LaomMedic");
            email.setHtmlMsg("<div style=\"border-bottom:1px solid; text-align:center; background:#152836; display:inline-block; width:100%\"><img src=\"http://imageshack.com/a/img921/5408/YaSZbZ.png\" alt=\"Laom\" style=\"width:5em; padding-top:1em\"><h1 style=\"margin:0; padding:0.5em 0.5em 0.5em 0; color:white; font-family:sans-serif; width:80%; display:inline-block; float:right; text-align:right\">Restablecer Contraseña</h1></div><div style=\"\">\n"
                    + "          <p style=\"padding-left:2em; margin:2em 0 2em 0; font-family:sans-serif\">Abra el siguiente enlace para continuar con el proceso de recuperación <a href=\"http://localhost:8001/#/passconfirm/" + user.getIdUsuario() + "/" + cd + "\">http://localhost:8001/#/passconfrm/" + user.getIdUsuario() + "/" + cd + "</a></p>\n"
                    //+ "          <p style=\"padding-left:2em; margin:2em 0 2em 0; font-family:sans-serif\">Abra el siguiente enlace para continuar con el proceso de recuperación <a href=\"http://laomfront-laommedic.rhcloud.com/#/passconfirm/" + user.getIdUsuario() + "/" + cd + "\">http://laomfront-laommedic.rhcloud.com/#/passconfrm/" + user.getIdUsuario() + "/" + cd + "</a></p>\n"
                    + "      \n"
                    + "        </div>");
            email.addTo(recovery.getEmail());
            user.setRecuperacionPass(cd);
            usuariosFacade.edit(user);
            email.send();            
        } catch (EmailException ex) {
            Logger.getLogger(EmailRest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
