/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.Cups;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi2
 */
@Stateless
public class CupsFacade extends AbstractFacade<Cups>{

     @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CupsFacade() {
        super(Cups.class);
    }
    
     public List<Cups> findByNombre(String query) {
        return getEntityManager().createNamedQuery("Cups.findByDescripcion")
                .setParameter("descripcion", query + "%")
                .setMaxResults(5)
                .getResultList();
    }
    
}
