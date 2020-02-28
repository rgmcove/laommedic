/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.Citas;
import com.laom.medic.jpa.entities.Roles;
import com.laom.medic.jpa.entities.Sedes;
import com.laom.medic.jpa.entities.Usuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author neney
 */
@Stateless
public class CitasFacade extends AbstractFacade<Citas> {

    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitasFacade() {
        super(Citas.class);
    }

    public List<Citas> findBySedeInCitas(Sedes sede) {
        
            
        return getEntityManager().createNamedQuery("Citas.findByIdSedes")
                .setParameter("idSede", sede)
                .setParameter("nuevaFecha", new Date())
                .getResultList();
        
    }

    public List<Citas> findByIdUsuario(String usuario) {
        return getEntityManager().createNamedQuery("Citas.findByIdUsuario")
                .setParameter("idRol", new Roles("USR"))
                .setParameter("idIdentificacion", usuario + '%')
                .getResultList();
    }

    public List<Citas> FindByFechas(String fechaInicio, String fechaFin, Sedes sede) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            Date dateFechaInicio = format.parse(fechaInicio);
            Date dateFechaFin = format.parse(fechaFin);
         
            return getEntityManager().createNamedQuery("Citas.findByFechaHorarios")
                    .setParameter("fechaInicio", dateFechaInicio)
                    .setParameter("fechaFin", sumarDate(dateFechaFin))
                    .setParameter("idSede", sede)
                    .getResultList();
        } catch (NoResultException | ParseException ex) {
            return null;
        }
    }
    
    public List<Citas> FindByFechasUser(String fechaInicio, String fechaFin, Integer idUsuario) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date dateFechaInicio = format.parse(fechaInicio);
            Date dateFechaFin = format.parse(fechaFin);
            
            return getEntityManager().createNamedQuery("Citas.findByFechaUser")
                    .setParameter("fechaInicio", dateFechaInicio)
                    .setParameter("fechaFin", sumarDate(dateFechaFin))
                    .setParameter("idUsuario", idUsuario)
                    .getResultList();
        } catch (NoResultException | ParseException ex) {
            return null;
        }
    }
    
    private Date sumarDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
    
    private Date asignar(Date date) {
        date = new Date();
        return date;
    }
    
     public Citas findByfecha(int idUsuario) {
        try {

            Query query = getEntityManager().createNativeQuery("SELECT * FROM CITAS c JOIN USUARIOS u ON c.id_usuario=?u.id_usuario WHERE fecha_cita >= curdate()", Citas.class);
            query.setParameter("id_usuario", idUsuario);
            Citas result = (Citas) query.getSingleResult();
            return result;

        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }

}
