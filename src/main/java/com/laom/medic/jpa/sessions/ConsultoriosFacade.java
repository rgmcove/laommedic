/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.Consultorios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi2
 */
@Stateless
public class ConsultoriosFacade extends AbstractFacade<Consultorios>{

     @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultoriosFacade() {
        super(Consultorios.class);
    }
    
    public List<Consultorios> findByNombre (String query) {
        return getEntityManager().createNamedQuery("Consultorios.findByCodigoConsultorio")
                .setParameter("codigoConsultorio", query + "%")
                .setMaxResults(3)
                .getResultList();
    }
}
