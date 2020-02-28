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
@Table(name = "TIPOS_SANGRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposSangre.findAll", query = "SELECT t FROM TiposSangre t"),
    @NamedQuery(name = "TiposSangre.findByIdTipoSangre", query = "SELECT t FROM TiposSangre t WHERE t.idTipoSangre = :idTipoSangre"),
    @NamedQuery(name = "TiposSangre.findByNombreTipoSangre", query = "SELECT t FROM TiposSangre t WHERE t.nombreTipoSangre = :nombreTipoSangre")})
public class TiposSangre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_sangre")
    private Integer idTipoSangre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_sangre")
    private String nombreTipoSangre;
    
    @OneToMany(mappedBy = "idTipoSangre")
    private List<Usuarios> usuariosList;

    public TiposSangre() {
    }

    public TiposSangre(Integer idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public TiposSangre(Integer idTipoSangre, String nombreTipoSangre) {
        this.idTipoSangre = idTipoSangre;
        this.nombreTipoSangre = nombreTipoSangre;
    }

    public Integer getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(Integer idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public String getNombreTipoSangre() {
        return nombreTipoSangre;
    }

    public void setNombreTipoSangre(String nombreTipoSangre) {
        this.nombreTipoSangre = nombreTipoSangre;
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
        hash += (idTipoSangre != null ? idTipoSangre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposSangre)) {
            return false;
        }
        TiposSangre other = (TiposSangre) object;
        if ((this.idTipoSangre == null && other.idTipoSangre != null) || (this.idTipoSangre != null && !this.idTipoSangre.equals(other.idTipoSangre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.TiposSangre[ idTipoSangre=" + idTipoSangre + " ]";
    }
    
}
