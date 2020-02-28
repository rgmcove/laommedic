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
@Table(name = "TIPOS_ANTECEDENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposAntecedentes.findAll", query = "SELECT t FROM TiposAntecedentes t"),
    @NamedQuery(name = "TiposAntecedentes.findByIdTipoAntecedente", query = "SELECT t FROM TiposAntecedentes t WHERE t.idTipoAntecedente = :idTipoAntecedente"),
    @NamedQuery(name = "TiposAntecedentes.findByDescripcioTipoAnte", query = "SELECT t FROM TiposAntecedentes t WHERE t.descripcioTipoAnte LIKE :descripcioTipoAnte")})
public class TiposAntecedentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_antecedente")
    private Integer idTipoAntecedente;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcio_tipo_ante")
    private String descripcioTipoAnte;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAntecedente")
    private List<Antecedentes> antecedentesList;

    public TiposAntecedentes() {
    }

    public TiposAntecedentes(Integer idTipoAntecedente) {
        this.idTipoAntecedente = idTipoAntecedente;
    }

    public TiposAntecedentes(Integer idTipoAntecedente, String descripcioTipoAnte) {
        this.idTipoAntecedente = idTipoAntecedente;
        this.descripcioTipoAnte = descripcioTipoAnte;
    }

    public Integer getIdTipoAntecedente() {
        return idTipoAntecedente;
    }

    public void setIdTipoAntecedente(Integer idTipoAntecedente) {
        this.idTipoAntecedente = idTipoAntecedente;
    }

    public String getDescripcioTipoAnte() {
        return descripcioTipoAnte;
    }

    public void setDescripcioTipoAnte(String descripcioTipoAnte) {
        this.descripcioTipoAnte = descripcioTipoAnte;
    }

    @XmlTransient
    public List<Antecedentes> getAntecedentesList() {
        return antecedentesList;
    }

    public void setAntecedentesList(List<Antecedentes> antecedentesList) {
        this.antecedentesList = antecedentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAntecedente != null ? idTipoAntecedente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposAntecedentes)) {
            return false;
        }
        TiposAntecedentes other = (TiposAntecedentes) object;
        if ((this.idTipoAntecedente == null && other.idTipoAntecedente != null) || (this.idTipoAntecedente != null && !this.idTipoAntecedente.equals(other.idTipoAntecedente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.TiposAntecedentes[ idTipoAntecedente=" + idTipoAntecedente + " ]";
    }
    
}
