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
 * @author adsi2
 */
@Entity
@Table(name = "FUERZAS_MUSCULARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuerzasMusculares.findAll", query = "SELECT f FROM FuerzasMusculares f"),
    @NamedQuery(name = "FuerzasMusculares.findByIdFuerza", query = "SELECT f FROM FuerzasMusculares f WHERE f.idFuerza = :idFuerza"),
    @NamedQuery(name = "FuerzasMusculares.findByNombreFuerza", query = "SELECT f FROM FuerzasMusculares f WHERE f.nombreFuerza LIKE :nombreFuerza")})
public class FuerzasMusculares implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_fuerza")
    private String idFuerza;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_fuerza")
    private String nombreFuerza;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuerza")
    private List<Citas> citasList;

    public FuerzasMusculares() {
    }

    public FuerzasMusculares(String idFuerza) {
        this.idFuerza = idFuerza;
    }

    public FuerzasMusculares(String idFuerza, String nombreFuerza) {
        this.idFuerza = idFuerza;
        this.nombreFuerza = nombreFuerza;
    }

    public String getIdFuerza() {
        return idFuerza;
    }

    public void setIdFuerza(String idFuerza) {
        this.idFuerza = idFuerza;
    }

    public String getNombreFuerza() {
        return nombreFuerza;
    }

    public void setNombreFuerza(String nombreFuerza) {
        this.nombreFuerza = nombreFuerza;
    }

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuerza != null ? idFuerza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuerzasMusculares)) {
            return false;
        }
        FuerzasMusculares other = (FuerzasMusculares) object;
        if ((this.idFuerza == null && other.idFuerza != null) || (this.idFuerza != null && !this.idFuerza.equals(other.idFuerza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.FuerzasMusculares[ idFuerza=" + idFuerza + " ]";
    }
    
}
