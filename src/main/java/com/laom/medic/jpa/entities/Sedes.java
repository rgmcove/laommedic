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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
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
 * @author rgmcove
 */
@Entity
@Table(name = "SEDES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sedes.findAll", query = "SELECT s FROM Sedes s"),
    @NamedQuery(name = "Sedes.idUsuario", query = "SELECT s FROM Sedes s WHERE s.usuariosList = :idUsuario"),
    @NamedQuery(name = "Sedes.findByIdSedes", query = "SELECT s FROM Sedes s WHERE s.idSedes = :idSedes"),
    @NamedQuery(name = "Sedes.findByNombreSede", query = "SELECT s FROM Sedes s WHERE s.nombreSede LIKE :nombreSede"),
    @NamedQuery(name = "Sedes.findByDireccion", query = "SELECT s FROM Sedes s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sedes.findByTelefono", query = "SELECT s FROM Sedes s WHERE s.telefono = :telefono")})
public class Sedes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sedes")
    private Integer idSedes;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_sede")
    private String nombreSede;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "direccion")
    private String direccion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono")
    private String telefono;
    
    @ManyToMany(mappedBy = "sedesList")
    private List<Usuarios> usuariosList;

    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")})
    @ManyToOne(optional = true)
    private Ciudades ciudades;

    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false)
    private Clinicas idClinica;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private List<Consultorios> consultoriosList;

    public Sedes() {
    }

    public Sedes(Integer idSedes) {
        this.idSedes = idSedes;
    }

    public Sedes(Integer idSedes, String nombreSede, String direccion, String telefono) {
        this.idSedes = idSedes;
        this.nombreSede = nombreSede;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getIdSedes() {
        return idSedes;
    }

    public void setIdSedes(Integer idSedes) {
        this.idSedes = idSedes;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }
    @XmlTransient
    public List<Consultorios> getConsultoriosList() {
        return consultoriosList;
    }

    public void setConsultoriosList(List<Consultorios> consultoriosList) {
        this.consultoriosList = consultoriosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedes != null ? idSedes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sedes)) {
            return false;
        }
        Sedes other = (Sedes) object;
        if ((this.idSedes == null && other.idSedes != null) || (this.idSedes != null && !this.idSedes.equals(other.idSedes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(idSedes);
    }

}
