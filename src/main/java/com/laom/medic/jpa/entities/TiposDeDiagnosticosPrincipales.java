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
@Table(name = "TIPOS_DE_DIAGNOSTICOS_PRINCIPALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeDiagnosticosPrincipales.findAll", query = "SELECT t FROM TiposDeDiagnosticosPrincipales t"),
    @NamedQuery(name = "TiposDeDiagnosticosPrincipales.findByIdTipoDiagnostico", query = "SELECT t FROM TiposDeDiagnosticosPrincipales t WHERE t.idTipoDiagnostico = :idTipoDiagnostico"),
    @NamedQuery(name = "TiposDeDiagnosticosPrincipales.findByTipoDiagnostico", query = "SELECT t FROM TiposDeDiagnosticosPrincipales t WHERE t.tipoDiagnostico LIKE :tipoDiagnostico")})
public class TiposDeDiagnosticosPrincipales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_diagnostico")
    private Integer idTipoDiagnostico;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_diagnostico")
    private String tipoDiagnostico;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDiagnostico")
    private List<Citas> citasList;

    public TiposDeDiagnosticosPrincipales() {
    }

    public TiposDeDiagnosticosPrincipales(Integer idTipoDiagnostico) {
        this.idTipoDiagnostico = idTipoDiagnostico;
    }

    public TiposDeDiagnosticosPrincipales(Integer idTipoDiagnostico, String tipoDiagnostico) {
        this.idTipoDiagnostico = idTipoDiagnostico;
        this.tipoDiagnostico = tipoDiagnostico;
    }

    public Integer getIdTipoDiagnostico() {
        return idTipoDiagnostico;
    }

    public void setIdTipoDiagnostico(Integer idTipoDiagnostico) {
        this.idTipoDiagnostico = idTipoDiagnostico;
    }

    public String getTipoDiagnostico() {
        return tipoDiagnostico;
    }

    public void setTipoDiagnostico(String tipoDiagnostico) {
        this.tipoDiagnostico = tipoDiagnostico;
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
        hash += (idTipoDiagnostico != null ? idTipoDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeDiagnosticosPrincipales)) {
            return false;
        }
        TiposDeDiagnosticosPrincipales other = (TiposDeDiagnosticosPrincipales) object;
        if ((this.idTipoDiagnostico == null && other.idTipoDiagnostico != null) || (this.idTipoDiagnostico != null && !this.idTipoDiagnostico.equals(other.idTipoDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.TiposDeDiagnosticosPrincipales[ idTipoDiagnostico=" + idTipoDiagnostico + " ]";
    }
    
}
