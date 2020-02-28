/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author adsi2
 */
@Embeddable
public class CiudadesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciudad")
    private int idCiudad;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_departamento")
    private int idDepartamento;

    public CiudadesPK() {
    }

    public CiudadesPK(int idCiudad, int idDepartamento) {
        this.idCiudad = idCiudad;
        this.idDepartamento = idDepartamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCiudad;
        hash += (int) idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadesPK)) {
            return false;
        }
        CiudadesPK other = (CiudadesPK) object;
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.CiudadesPK[ idCiudad=" + idCiudad + ", idDepartamento=" + idDepartamento + " ]";
    }
    
}
