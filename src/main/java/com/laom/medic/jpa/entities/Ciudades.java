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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CIUDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c"),
    @NamedQuery(name = "Ciudades.findByIdCiudad", query = "SELECT c FROM Ciudades c WHERE c.ciudadesPK.idCiudad = :idCiudad"),
    @NamedQuery(name = "Ciudades.findByNombre", query = "SELECT c FROM Ciudades c WHERE c.nombre LIKE :nombre"),
    @NamedQuery(name = "Ciudades.findByIdDepartamento", query = "SELECT c FROM Ciudades c WHERE c.ciudadesPK.idDepartamento = :idDepartamento")})
public class Ciudades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CiudadesPK ciudadesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "ciudades")
    private List<Sedes> sedesList;
    
    @OneToMany(mappedBy = "ciudades")
    private List<Usuarios> usuariosList;
    
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamentos departamentos;

    public Ciudades() {
    }

    public Ciudades(CiudadesPK ciudadesPK) {
        this.ciudadesPK = ciudadesPK;
    }

    public Ciudades(CiudadesPK ciudadesPK, String nombre) {
        this.ciudadesPK = ciudadesPK;
        this.nombre = nombre;
    }

    public Ciudades(int idCiudad, int idDepartamento) {
        this.ciudadesPK = new CiudadesPK(idCiudad, idDepartamento);
    }

    public CiudadesPK getCiudadesPK() {
        return ciudadesPK;
    }

    public void setCiudadesPK(CiudadesPK ciudadesPK) {
        this.ciudadesPK = ciudadesPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Sedes> getSedesList() {
        return sedesList;
    }

    public void setSedesList(List<Sedes> sedesList) {
        this.sedesList = sedesList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadesPK != null ? ciudadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.ciudadesPK == null && other.ciudadesPK != null) || (this.ciudadesPK != null && !this.ciudadesPK.equals(other.ciudadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Ciudades[ ciudadesPK=" + ciudadesPK + " ]";
    }
    
}
