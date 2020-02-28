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
@Table(name = "ESTADOS_CIVILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosCiviles.findAll", query = "SELECT e FROM EstadosCiviles e"),
    @NamedQuery(name = "EstadosCiviles.findByIdEstadoCivil", query = "SELECT e FROM EstadosCiviles e WHERE e.idEstadoCivil = :idEstadoCivil"),
    @NamedQuery(name = "EstadosCiviles.findByTipoEstado", query = "SELECT e FROM EstadosCiviles e WHERE e.tipoEstado = :tipoEstado")})
public class EstadosCiviles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_civil")
    private Integer idEstadoCivil;
    
    @Size(max = 50)
    @Column(name = "tipo_estado")
    private String tipoEstado;
    
    @OneToMany(mappedBy = "idEstadoCivil")
    private List<Usuarios> usuariosList;

    public EstadosCiviles() {
    }

    public EstadosCiviles(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCivil != null ? idEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosCiviles)) {
            return false;
        }
        EstadosCiviles other = (EstadosCiviles) object;
        if ((this.idEstadoCivil == null && other.idEstadoCivil != null) || (this.idEstadoCivil != null && !this.idEstadoCivil.equals(other.idEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.EstadosCiviles[ idEstadoCivil=" + idEstadoCivil + " ]";
    }
    
}
