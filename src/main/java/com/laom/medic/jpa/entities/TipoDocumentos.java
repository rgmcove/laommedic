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
@Table(name = "TIPO_DOCUMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentos.findAll", query = "SELECT t FROM TipoDocumentos t"),
    @NamedQuery(name = "TipoDocumentos.findByIdTipoDocumento", query = "SELECT t FROM TipoDocumentos t WHERE t.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "TipoDocumentos.findByNombre", query = "SELECT t FROM TipoDocumentos t WHERE t.nombre LIKE :nombre")})
public class TipoDocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "id_tipo_documento")
    private String idTipoDocumento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private List<Usuarios> usuariosList;

    public TipoDocumentos() {
    }

    public TipoDocumentos(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public TipoDocumentos(String idTipoDocumento, String nombre) {
        this.idTipoDocumento = idTipoDocumento;
        this.nombre = nombre;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idTipoDocumento != null ? idTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentos)) {
            return false;
        }
        TipoDocumentos other = (TipoDocumentos) object;
        if ((this.idTipoDocumento == null && other.idTipoDocumento != null) || (this.idTipoDocumento != null && !this.idTipoDocumento.equals(other.idTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.TipoDocumentos[ idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
