/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.EntidadesAdministradoras;
import com.laom.medic.jpa.entities.Roles;
import com.laom.medic.jpa.entities.Sedes;
import com.laom.medic.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author neney
 *
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public Usuarios findByEmail(String email) {
        try {
            return (Usuarios) getEntityManager().createNamedQuery("Usuarios.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public EntidadesAdministradoras findByEps(EntidadesAdministradoras codigoEntidad) {
        try {
            return (EntidadesAdministradoras) getEntityManager().createNamedQuery("EntidadesAdministradoras.findByCodigoEntidad")
                    .setParameter("codigoEntidad", codigoEntidad)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Usuarios findByIdentificacion(String idIdentificacion) {
        try {
            return (Usuarios) getEntityManager().createNamedQuery("Usuarios.findByIdIdentificacion")
                    .setParameter("idIdentificacion", idIdentificacion)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Usuarios> findByPrimerNombre(String nombre) {
        return getEntityManager().createNamedQuery("Usuarios.findByPrimerNombre")
                .setParameter("primerNombre", nombre + "%")
                .getResultList();
    }

    public List<Usuarios> findByIdenti(String query) {
        return getEntityManager().createNamedQuery("Usuarios.findByIdIdentificacion")
                .setParameter("idIdentificacion", query + "%")
                .setMaxResults(10)
                .getResultList();
    }

    public List<Usuarios> findBySede(Sedes sede) {
        return getEntityManager().createNamedQuery("Usuarios.findByIdSede")
                .setParameter("idSede", sede)
                .getResultList();
    }

    public List<Usuarios> findByIdentiRol(String query) {
        return getEntityManager().createNamedQuery("Usuarios.findByIdentRol")
                .setParameter("idIdentificacion", query + "%")
                .setParameter("idRol", new Roles("USR"))
                .setMaxResults(10)
                .getResultList();
    }

    public List<Usuarios> findByFisio(String query) {
        return getEntityManager().createNamedQuery("Usuarios.findByIdentRol")
                .setParameter("idIdentificacion", query + "%")
                .setParameter("idRol", new Roles("FISIO"))
                .setMaxResults(6)
                .getResultList();
    }

    public Usuarios findByIdAndCode(int idUsuario, String recuperacion) {
        try {

            Query query = getEntityManager().createNativeQuery("SELECT * FROM USUARIOS u WHERE u.id_usuario=?id_usuario AND u.recuperacion_pass=?recuperacion_pass", Usuarios.class);
            query.setParameter("id_usuario", idUsuario);
            query.setParameter("recuperacion_pass", recuperacion);
            Usuarios result = (Usuarios) query.getSingleResult();
            return result;

        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }
}
