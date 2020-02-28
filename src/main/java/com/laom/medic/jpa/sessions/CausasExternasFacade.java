/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.CausasExternas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neney
 */
@Stateless
public class CausasExternasFacade extends AbstractFacade<CausasExternas> {
    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CausasExternasFacade() {
        super(CausasExternas.class);
    }
    
    public List<CausasExternas> findByNombre(String query) {
        return getEntityManager().createNamedQuery("CausasExternas.findByDescCausa")
                .setParameter("nombre", query + "%")
                .setMaxResults(3)
                .getResultList();
    }
    
}
