/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.sessions;

import com.laom.medic.jpa.entities.Sedes;
import com.laom.medic.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neney
 */
@Stateless
public class SedesFacade extends AbstractFacade<Sedes> {
    @PersistenceContext(unitName = "com.laom.medic_LAOMMEDIC_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SedesFacade() {
        super(Sedes.class);
    }
    
    public List<Sedes> findByNombre(String query) {
        return getEntityManager().createNamedQuery("Sedes.findByNombreSede")
                .setParameter("nombreSede", query + "%")
                .setMaxResults(3)
                .getResultList();
    }
    
    public List<Sedes> findByIdUsuario(Usuarios usuario) {
        return getEntityManager().createNamedQuery("Sedes.idUsuario")
                .setParameter("idUsuario", usuario)
                .getResultList();
    }
    
}
