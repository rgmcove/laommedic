/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.TiposUsuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neney
 */
@Stateless
public class TiposUsuariosFacade extends AbstractFacade<TiposUsuarios> {
    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposUsuariosFacade() {
        super(TiposUsuarios.class);
    }
    
}
