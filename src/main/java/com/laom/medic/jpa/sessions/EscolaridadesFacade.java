/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.Escolaridades;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neney
 */
@Stateless
public class EscolaridadesFacade extends AbstractFacade<Escolaridades> {
    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EscolaridadesFacade() {
        super(Escolaridades.class);
    }
    
    public List<Escolaridades> findByNombre (String query) {
        return getEntityManager().createNamedQuery("Escolaridades.findByTipoEscolaridad")
                .setParameter("tipoEscolaridad", query + "%")
                .setMaxResults(3)
                .getResultList();
    }
    
}
