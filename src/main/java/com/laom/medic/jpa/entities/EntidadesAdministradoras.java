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
 * @author neney
 */
@Entity
@Table(name = "ENTIDADES_ADMINISTRADORAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntidadesAdministradoras.findAll", query = "SELECT e FROM EntidadesAdministradoras e"),
    @NamedQuery(name = "EntidadesAdministradoras.findByCodigoEntidad", query = "SELECT e FROM EntidadesAdministradoras e WHERE e.codigoEntidad = :codigoEntidad"),
    @NamedQuery(name = "EntidadesAdministradoras.findByDescAdministradoras", query = "SELECT e FROM EntidadesAdministradoras e WHERE e.descAdministradoras LIKE :descAdministradoras")})
public class EntidadesAdministradoras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_entidad")
    private String codigoEntidad;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "desc_administradoras")
    private String descAdministradoras;
    
    @OneToMany(mappedBy = "codigoEntidad")
    private List<Usuarios> usuariosList;

    public EntidadesAdministradoras() {
    }

    public EntidadesAdministradoras(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public EntidadesAdministradoras(String codigoEntidad, String descAdministradoras) {
        this.codigoEntidad = codigoEntidad;
        this.descAdministradoras = descAdministradoras;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getDescAdministradoras() {
        return descAdministradoras;
    }

    public void setDescAdministradoras(String descAdministradoras) {
        this.descAdministradoras = descAdministradoras;
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
        hash += (codigoEntidad != null ? codigoEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadesAdministradoras)) {
            return false;
        }
        EntidadesAdministradoras other = (EntidadesAdministradoras) object;
        if ((this.codigoEntidad == null && other.codigoEntidad != null) || (this.codigoEntidad != null && !this.codigoEntidad.equals(other.codigoEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.EntidadesAdministradoras[ codigoEntidad=" + codigoEntidad + " ]";
    }
    
}
