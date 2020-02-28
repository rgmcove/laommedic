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
 * @author adsi2
 */
@Entity
@Table(name = "PERSONAL_TRATANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalTratante.findAll", query = "SELECT p FROM PersonalTratante p"),
    @NamedQuery(name = "PersonalTratante.findByIdPersonal", query = "SELECT p FROM PersonalTratante p WHERE p.idPersonal = :idPersonal"),
    @NamedQuery(name = "PersonalTratante.findByEspecialidad", query = "SELECT p FROM PersonalTratante p WHERE p.especialidad = :especialidad")})
public class PersonalTratante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personal")
    private Integer idPersonal;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "especialidad")
    private String especialidad;
    
    @JoinColumn(name = "id_atiende", referencedColumnName = "id_atiende")
    @ManyToOne
    private PersonalAtiende idAtiende;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonal")
    private List<Citas> citasList;

    public PersonalTratante() {
    }

    public PersonalTratante(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public PersonalTratante(Integer idPersonal, String especialidad) {
        this.idPersonal = idPersonal;
        this.especialidad = especialidad;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public PersonalAtiende getIdAtiende() {
        return idAtiende;
    }

    public void setIdAtiende(PersonalAtiende idAtiende) {
        this.idAtiende = idAtiende;
    }

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalTratante)) {
            return false;
        }
        PersonalTratante other = (PersonalTratante) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.PersonalTratante[ idPersonal=" + idPersonal + " ]";
    }
    
}
