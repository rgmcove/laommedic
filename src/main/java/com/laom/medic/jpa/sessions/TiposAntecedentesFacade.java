/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.TiposAntecedentes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neney
 */
@Stateless
public class TiposAntecedentesFacade extends AbstractFacade<TiposAntecedentes> {
    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposAntecedentesFacade() {
        super(TiposAntecedentes.class);
    }
    
    public List<TiposAntecedentes> findByNombre (String query) {
        return getEntityManager().createNamedQuery("TiposAntecedentes.findByDescripcioTipoAnte")
                .setParameter("descripcioTipoAnte", query + "%")
                .setMaxResults(3)
                .getResultList();
    }
    
}
