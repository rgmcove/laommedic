/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ANTECEDENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedentes.findAll", query = "SELECT a FROM Antecedentes a"),
    @NamedQuery(name = "Antecedentes.findByIdAntecedente", query = "SELECT a FROM Antecedentes a WHERE a.idAntecedente = :idAntecedente"),
    @NamedQuery(name = "Antecedentes.findByDescripcionAntecedente", query = "SELECT a FROM Antecedentes a WHERE a.descripcionAntecedente = :descripcionAntecedente")})
public class Antecedentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antecedente")
    private Integer idAntecedente;
     
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion_antecedente")
    private String descripcionAntecedente;
   
    @ManyToMany(mappedBy = "antecedentesList")
    private List<Usuarios> usuariosList;
    
    @JoinColumn(name = "id_tipo_antecedente", referencedColumnName = "id_tipo_antecedente")
    @ManyToOne(optional = false)
    private TiposAntecedentes idTipoAntecedente;

    public Antecedentes() {
    }

    public Antecedentes(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public Antecedentes(Integer idAntecedente, String descripcionAntecedente) {
        this.idAntecedente = idAntecedente;
        this.descripcionAntecedente = descripcionAntecedente;
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public String getDescripcionAntecedente() {
        return descripcionAntecedente;
    }

    public void setDescripcionAntecedente(String descripcionAntecedente) {
        this.descripcionAntecedente = descripcionAntecedente;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public TiposAntecedentes getIdTipoAntecedente() {
        return idTipoAntecedente;
    }

    public void setIdTipoAntecedente(TiposAntecedentes idTipoAntecedente) {
        this.idTipoAntecedente = idTipoAntecedente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntecedente != null ? idAntecedente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedentes)) {
            return false;
        }
        Antecedentes other = (Antecedentes) object;
        if ((this.idAntecedente == null && other.idAntecedente != null) || (this.idAntecedente != null && !this.idAntecedente.equals(other.idAntecedente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Antecedentes[ idAntecedente=" + idAntecedente + " ]";
    }
    
}
