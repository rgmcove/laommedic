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
@Table(name = "TIPOS_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposUsuarios.findAll", query = "SELECT t FROM TiposUsuarios t"),
    @NamedQuery(name = "TiposUsuarios.findByIdTipoUsuario", query = "SELECT t FROM TiposUsuarios t WHERE t.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TiposUsuarios.findByTipoUsuario", query = "SELECT t FROM TiposUsuarios t WHERE t.tipoUsuario = :tipoUsuario")})
public class TiposUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_usuario")
    private Integer idTipoUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    
   
    @OneToMany(mappedBy = "idTipoUsuario")
    private List<Usuarios> usuariosList;

    public TiposUsuarios() {
    }

    public TiposUsuarios(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TiposUsuarios(Integer idTipoUsuario, String tipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposUsuarios)) {
            return false;
        }
        TiposUsuarios other = (TiposUsuarios) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.TiposUsuarios[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
