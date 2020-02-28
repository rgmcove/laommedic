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
@Table(name = "AMBITOS_PROCEDIMIENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbitosProcedimientos.findAll", query = "SELECT a FROM AmbitosProcedimientos a"),
    @NamedQuery(name = "AmbitosProcedimientos.findByIdAmbitoProcedimiento", query = "SELECT a FROM AmbitosProcedimientos a WHERE a.idAmbitoProcedimiento = :idAmbitoProcedimiento"),
    @NamedQuery(name = "AmbitosProcedimientos.findByAmbitoProcedimiento", query = "SELECT a FROM AmbitosProcedimientos a WHERE a.ambitoProcedimiento LIKE :ambitoProcedimiento")})
public class AmbitosProcedimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ambito_procedimiento")
    private Integer idAmbitoProcedimiento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ambito_procedimiento")
    private String ambitoProcedimiento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbitoProcedimiento")
    private List<Citas> citasList;

    public AmbitosProcedimientos() {
    }

    public AmbitosProcedimientos(Integer idAmbitoProcedimiento) {
        this.idAmbitoProcedimiento = idAmbitoProcedimiento;
    }

    public AmbitosProcedimientos(Integer idAmbitoProcedimiento, String ambitoProcedimiento) {
        this.idAmbitoProcedimiento = idAmbitoProcedimiento;
        this.ambitoProcedimiento = ambitoProcedimiento;
    }

    public Integer getIdAmbitoProcedimiento() {
        return idAmbitoProcedimiento;
    }

    public void setIdAmbitoProcedimiento(Integer idAmbitoProcedimiento) {
        this.idAmbitoProcedimiento = idAmbitoProcedimiento;
    }

    public String getAmbitoProcedimiento() {
        return ambitoProcedimiento;
    }

    public void setAmbitoProcedimiento(String ambitoProcedimiento) {
        this.ambitoProcedimiento = ambitoProcedimiento;
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
        hash += (idAmbitoProcedimiento != null ? idAmbitoProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbitosProcedimientos)) {
            return false;
        }
        AmbitosProcedimientos other = (AmbitosProcedimientos) object;
        if ((this.idAmbitoProcedimiento == null && other.idAmbitoProcedimiento != null) || (this.idAmbitoProcedimiento != null && !this.idAmbitoProcedimiento.equals(other.idAmbitoProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.AmbitosProcedimientos[ idAmbitoProcedimiento=" + idAmbitoProcedimiento + " ]";
    }
    
}
