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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CAUSAS_EXTERNAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CausasExternas.findAll", query = "SELECT c FROM CausasExternas c"),
    @NamedQuery(name = "CausasExternas.findByIdCausa", query = "SELECT c FROM CausasExternas c WHERE c.idCausa = :idCausa"),
    @NamedQuery(name = "CausasExternas.findByDescCausa", query = "SELECT c FROM CausasExternas c WHERE c.descCausa LIKE :descCausa")})
public class CausasExternas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_causa")
    private Integer idCausa;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "desc_causa")
    private String descCausa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCausa")
    private List<Citas> citasList;

    public CausasExternas() {
    }

    public CausasExternas(Integer idCausa) {
        this.idCausa = idCausa;
    }

    public CausasExternas(Integer idCausa, String descCausa) {
        this.idCausa = idCausa;
        this.descCausa = descCausa;
    }

    public Integer getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(Integer idCausa) {
        this.idCausa = idCausa;
    }

    public String getDescCausa() {
        return descCausa;
    }

    public void setDescCausa(String descCausa) {
        this.descCausa = descCausa;
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
        hash += (idCausa != null ? idCausa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CausasExternas)) {
            return false;
        }
        CausasExternas other = (CausasExternas) object;
        if ((this.idCausa == null && other.idCausa != null) || (this.idCausa != null && !this.idCausa.equals(other.idCausa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.CausasExternas[ idCausa=" + idCausa + " ]";
    }
    
}
