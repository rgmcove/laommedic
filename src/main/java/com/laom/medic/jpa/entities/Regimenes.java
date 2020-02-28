/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neney
 */
@Entity
@Table(name = "REGIMENES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regimenes.findAll", query = "SELECT r FROM Regimenes r"),
    @NamedQuery(name = "Regimenes.findByIdRegimen", query = "SELECT r FROM Regimenes r WHERE r.idRegimen = :idRegimen"),
    @NamedQuery(name = "Regimenes.findByNombreRegimen", query = "SELECT r FROM Regimenes r WHERE r.nombreRegimen LIKE :nombreRegimen")})
public class Regimenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_regimen")
    private String idRegimen;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre_regimen")
    private String nombreRegimen;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegimen")
    private List<Clinicas> clinicasList;

    public Regimenes() {
    }

    public Regimenes(String idRegimen) {
        this.idRegimen = idRegimen;
    }

    public Regimenes(String idRegimen, String nombreRegimen) {
        this.idRegimen = idRegimen;
        this.nombreRegimen = nombreRegimen;
    }

    public String getIdRegimen() {
        return idRegimen;
    }

    public void setIdRegimen(String idRegimen) {
        this.idRegimen = idRegimen;
    }

    public String getNombreRegimen() {
        return nombreRegimen;
    }

    public void setNombreRegimen(String nombreRegimen) {
        this.nombreRegimen = nombreRegimen;
    }

    @XmlTransient
    public List<Clinicas> getClinicasList() {
        return clinicasList;
    }

    public void setClinicasList(List<Clinicas> clinicasList) {
        this.clinicasList = clinicasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegimen != null ? idRegimen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regimenes)) {
            return false;
        }
        Regimenes other = (Regimenes) object;
        if ((this.idRegimen == null && other.idRegimen != null) || (this.idRegimen != null && !this.idRegimen.equals(other.idRegimen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Regimenes[ idRegimen=" + idRegimen + " ]";
    }
    
}
