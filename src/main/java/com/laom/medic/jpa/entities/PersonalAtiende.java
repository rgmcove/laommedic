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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "PERSONAL_ATIENDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalAtiende.findAll", query = "SELECT p FROM PersonalAtiende p"),
    @NamedQuery(name = "PersonalAtiende.findByIdAtiende", query = "SELECT p FROM PersonalAtiende p WHERE p.idAtiende = :idAtiende"),
    @NamedQuery(name = "PersonalAtiende.findByAtiende", query = "SELECT p FROM PersonalAtiende p WHERE p.atiende LIKE :atiende")})
public class PersonalAtiende implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atiende")
    private Integer idAtiende;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "atiende")
    private String atiende;
    
    @OneToMany(mappedBy = "idAtiende")
    private List<PersonalTratante> personalTratanteList;

    public PersonalAtiende() {
    }

    public PersonalAtiende(Integer idAtiende) {
        this.idAtiende = idAtiende;
    }

    public PersonalAtiende(Integer idAtiende, String atiende) {
        this.idAtiende = idAtiende;
        this.atiende = atiende;
    }

    public Integer getIdAtiende() {
        return idAtiende;
    }

    public void setIdAtiende(Integer idAtiende) {
        this.idAtiende = idAtiende;
    }

    public String getAtiende() {
        return atiende;
    }

    public void setAtiende(String atiende) {
        this.atiende = atiende;
    }

    @XmlTransient
    public List<PersonalTratante> getPersonalTratanteList() {
        return personalTratanteList;
    }

    public void setPersonalTratanteList(List<PersonalTratante> personalTratanteList) {
        this.personalTratanteList = personalTratanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtiende != null ? idAtiende.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalAtiende)) {
            return false;
        }
        PersonalAtiende other = (PersonalAtiende) object;
        if ((this.idAtiende == null && other.idAtiende != null) || (this.idAtiende != null && !this.idAtiende.equals(other.idAtiende))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.PersonalAtiende[ idAtiende=" + idAtiende + " ]";
    }
    
}
