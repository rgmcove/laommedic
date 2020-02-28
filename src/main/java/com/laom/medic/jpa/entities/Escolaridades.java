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
@Table(name = "ESCOLARIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridades.findAll", query = "SELECT e FROM Escolaridades e"),
    @NamedQuery(name = "Escolaridades.findByIdEscolaridad", query = "SELECT e FROM Escolaridades e WHERE e.idEscolaridad = :idEscolaridad"),
    @NamedQuery(name = "Escolaridades.findByTipoEscolaridad", query = "SELECT e FROM Escolaridades e WHERE e.tipoEscolaridad LIKE :tipoEscolaridad")})
public class Escolaridades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_escolaridad")
    private Integer idEscolaridad;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_escolaridad")
    private String tipoEscolaridad;
    
    @OneToMany(mappedBy = "idEscolaridad")
    private List<Usuarios> usuariosList;

    public Escolaridades() {
    }

    public Escolaridades(Integer idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public Escolaridades(Integer idEscolaridad, String tipoEscolaridad) {
        this.idEscolaridad = idEscolaridad;
        this.tipoEscolaridad = tipoEscolaridad;
    }

    public Integer getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(Integer idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public String getTipoEscolaridad() {
        return tipoEscolaridad;
    }

    public void setTipoEscolaridad(String tipoEscolaridad) {
        this.tipoEscolaridad = tipoEscolaridad;
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
        hash += (idEscolaridad != null ? idEscolaridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridades)) {
            return false;
        }
        Escolaridades other = (Escolaridades) object;
        if ((this.idEscolaridad == null && other.idEscolaridad != null) || (this.idEscolaridad != null && !this.idEscolaridad.equals(other.idEscolaridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Escolaridades[ idEscolaridad=" + idEscolaridad + " ]";
    }
    
}
