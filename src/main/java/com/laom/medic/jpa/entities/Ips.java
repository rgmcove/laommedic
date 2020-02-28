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
@Table(name = "IPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ips.findAll", query = "SELECT i FROM Ips i"),
    @NamedQuery(name = "Ips.findByIdIps", query = "SELECT i FROM Ips i WHERE i.idIps = :idIps"),
    @NamedQuery(name = "Ips.findByNombreIps", query = "SELECT i FROM Ips i WHERE i.nombreIps LIKE :nombreIps"),
    @NamedQuery(name = "Ips.findByRegistroIps", query = "SELECT i FROM Ips i WHERE i.registroIps = :registroIps")})
public class Ips implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_ips")
    private String idIps;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre_ips")
    private String nombreIps;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "registro_ips")
    private String registroIps;
    
    @OneToMany(mappedBy = "idIps")
    private List<Usuarios> usuariosList;

    public Ips() {
    }

    public Ips(String idIps) {
        this.idIps = idIps;
    }

    public Ips(String idIps, String nombreIps, String registroIps) {
        this.idIps = idIps;
        this.nombreIps = nombreIps;
        this.registroIps = registroIps;
    }

    public String getIdIps() {
        return idIps;
    }

    public void setIdIps(String idIps) {
        this.idIps = idIps;
    }

    public String getNombreIps() {
        return nombreIps;
    }

    public void setNombreIps(String nombreIps) {
        this.nombreIps = nombreIps;
    }

    public String getRegistroIps() {
        return registroIps;
    }

    public void setRegistroIps(String registroIps) {
        this.registroIps = registroIps;
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
        hash += (idIps != null ? idIps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ips)) {
            return false;
        }
        Ips other = (Ips) object;
        if ((this.idIps == null && other.idIps != null) || (this.idIps != null && !this.idIps.equals(other.idIps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Ips[ idIps=" + idIps + " ]";
    }
    
}
