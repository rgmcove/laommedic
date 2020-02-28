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
 * @author neney
 */
@Entity
@Table(name = "CLINICAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinicas.findAll", query = "SELECT c FROM Clinicas c"),
    @NamedQuery(name = "Clinicas.findByIdClinica", query = "SELECT c FROM Clinicas c WHERE c.idClinica = :idClinica"),
    @NamedQuery(name = "Clinicas.findByNitClinica", query = "SELECT c FROM Clinicas c WHERE c.nitClinica = :nitClinica"),
    @NamedQuery(name = "Clinicas.findByNombreClinica", query = "SELECT c FROM Clinicas c WHERE c.nombreClinica LIKE :nombreClinica"),
    @NamedQuery(name = "Clinicas.findByDireccion", query = "SELECT c FROM Clinicas c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Clinicas.findByEmail", query = "SELECT c FROM Clinicas c WHERE c.email = :email"),
    @NamedQuery(name = "Clinicas.findByTelefono", query = "SELECT c FROM Clinicas c WHERE c.telefono = :telefono")})
public class Clinicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clinica")
    private Integer idClinica;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit_clinica")
    private Long nitClinica;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_clinica")
    private String nombreClinica;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "direccion")
    private String direccion;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono")
    private String telefono;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica")
    private List<Sedes> sedesList;
    
    @JoinColumn(name = "id_regimen", referencedColumnName = "id_regimen")
    @ManyToOne(optional = false)
    private Regimenes idRegimen;
    

    public Clinicas() {
    }

    public Clinicas(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public Clinicas(Integer idClinica, Long nitClinica, String nombreClinica, String direccion, String email, String telefono) {
        this.idClinica = idClinica;
        this.nitClinica = nitClinica;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public Long getNitClinica() {
        return nitClinica;
    }

    public void setNitClinica(Long nitClinica) {
        this.nitClinica = nitClinica;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @XmlTransient
    public List<Sedes> getSedesList() {
        return sedesList;
    }

    public void setSedesList(List<Sedes> sedesList) {
        this.sedesList = sedesList;
    }

    public Regimenes getIdRegimen() {
        return idRegimen;
    }

    public void setIdRegimen(Regimenes idRegimen) {
        this.idRegimen = idRegimen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClinica != null ? idClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicas)) {
            return false;
        }
        Clinicas other = (Clinicas) object;
        if ((this.idClinica == null && other.idClinica != null) || (this.idClinica != null && !this.idClinica.equals(other.idClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Clinicas[ idClinica=" + idClinica + " ]";
    }
    
}
