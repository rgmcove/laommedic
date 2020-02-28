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
@Table(name = "FINALIDADES_CONSULTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalidadesConsultas.findAll", query = "SELECT f FROM FinalidadesConsultas f"),
    @NamedQuery(name = "FinalidadesConsultas.findByIdFinalidadConsulta", query = "SELECT f FROM FinalidadesConsultas f WHERE f.idFinalidadConsulta = :idFinalidadConsulta"),
    @NamedQuery(name = "FinalidadesConsultas.findByFinalidadConsulta", query = "SELECT f FROM FinalidadesConsultas f WHERE f.finalidadConsulta LIKE :finalidadConsulta")})
public class FinalidadesConsultas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_finalidad_consulta")
    private Integer idFinalidadConsulta;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "finalidad_consulta")
    private String finalidadConsulta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFinalidadConsulta")
    private List<Citas> citasList;

    public FinalidadesConsultas() {
    }

    public FinalidadesConsultas(Integer idFinalidadConsulta) {
        this.idFinalidadConsulta = idFinalidadConsulta;
    }

    public FinalidadesConsultas(Integer idFinalidadConsulta, String finalidadConsulta) {
        this.idFinalidadConsulta = idFinalidadConsulta;
        this.finalidadConsulta = finalidadConsulta;
    }

    public Integer getIdFinalidadConsulta() {
        return idFinalidadConsulta;
    }

    public void setIdFinalidadConsulta(Integer idFinalidadConsulta) {
        this.idFinalidadConsulta = idFinalidadConsulta;
    }

    public String getFinalidadConsulta() {
        return finalidadConsulta;
    }

    public void setFinalidadConsulta(String finalidadConsulta) {
        this.finalidadConsulta = finalidadConsulta;
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
        hash += (idFinalidadConsulta != null ? idFinalidadConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalidadesConsultas)) {
            return false;
        }
        FinalidadesConsultas other = (FinalidadesConsultas) object;
        if ((this.idFinalidadConsulta == null && other.idFinalidadConsulta != null) || (this.idFinalidadConsulta != null && !this.idFinalidadConsulta.equals(other.idFinalidadConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.FinalidadesConsultas[ idFinalidadConsulta=" + idFinalidadConsulta + " ]";
    }
    
}
