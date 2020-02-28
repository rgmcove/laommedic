/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.Generos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neney
 */
@Stateless
public class GenerosFacade extends AbstractFacade<Generos> {
    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenerosFacade() {
        super(Generos.class);
    }
    
    public List<Generos> findByNombre (String query) {
        return getEntityManager().createNamedQuery("Generos.findByNombreGenero")
                .setParameter("nombreGenero", query + "%")
                .setMaxResults(3)
                .getResultList();
    }
    
}
