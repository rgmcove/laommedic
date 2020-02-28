/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.Clinicas;
import com.laom.medic.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neney
 */
@Stateless
public class ClinicasFacade extends AbstractFacade<Clinicas> {

    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClinicasFacade() {
        super(Clinicas.class);
    }

    public List<Clinicas> findByNombre(String query) {
        return getEntityManager().createNamedQuery("Clinicas.findByNombreClinica")
                .setParameter("nombreClinica", query + "%")
                .setMaxResults(3)
                .getResultList();
    }

    public Clinicas findByEmailClinica(String email) {
        try {
            return (Clinicas) getEntityManager().createNamedQuery("Clinicas.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public Clinicas findByNit(Long nitClinica) {
        try {
            return (Clinicas) getEntityManager().createNamedQuery("Clinicas.findByNitClinica")
                    .setParameter("nitClinica", nitClinica)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    
    
    
}
