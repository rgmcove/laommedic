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
import javax.persistence.ManyToMany;
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
@Table(name = "OCUPACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocupaciones.findAll", query = "SELECT o FROM Ocupaciones o"),
    @NamedQuery(name = "Ocupaciones.findByIdOcupacion", query = "SELECT o FROM Ocupaciones o WHERE o.idOcupacion = :idOcupacion"),
    @NamedQuery(name = "Ocupaciones.findByNombreOcupacion", query = "SELECT o FROM Ocupaciones o WHERE o.nombreOcupacion LIKE :nombreOcupacion")})
public class Ocupaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Size(min = 1, max = 5)
    @Column(name = "id_ocupacion")
    private String idOcupacion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_ocupacion")
    private String nombreOcupacion;
    
    @ManyToMany(mappedBy = "ocupacionesList")
    private List<Usuarios> usuariosList;

    public Ocupaciones() {
    }

    public Ocupaciones(String idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public Ocupaciones(String idOcupacion, String nombreOcupacion) {
        this.idOcupacion = idOcupacion;
        this.nombreOcupacion = nombreOcupacion;
    }

    public String getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(String idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public String getNombreOcupacion() {
        return nombreOcupacion;
    }

    public void setNombreOcupacion(String nombreOcupacion) {
        this.nombreOcupacion = nombreOcupacion;
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
        hash += (idOcupacion != null ? idOcupacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocupaciones)) {
            return false;
        }
        Ocupaciones other = (Ocupaciones) object;
        if ((this.idOcupacion == null && other.idOcupacion != null) || (this.idOcupacion != null && !this.idOcupacion.equals(other.idOcupacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Ocupaciones[ idOcupacion=" + idOcupacion + " ]";
    }
    
}
