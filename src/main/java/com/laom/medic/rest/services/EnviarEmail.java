/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.rest.services;

import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author neney
 */
@Stateless
public class EnviarEmail implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public void send(String destinatario, String emisor, String asunto, String mensaje) {

        try {
            final String username = "laomgs@gmail.com";
            final String password = "eiegcwtbjykzxckw"; //Aqui va la contraseña del correo

            Properties props = new Properties();
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.password", "eiegcwtbjykzxckw");//Aqui va la contraseña del correo de nuevo
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setFrom(new InternetAddress(emisor));
            message.setSubject(asunto);
            //message.setText(mensaje);
            message.setContent(mensaje, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            Logger.getLogger(EnviarEmail.class.getName()).log(Level.WARNING, "No se envio el email", e);
        }
    }
    
}
