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
@Table(name = "FINALIDADES_PROCEDIMIENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalidadesProcedimientos.findAll", query = "SELECT f FROM FinalidadesProcedimientos f"),
    @NamedQuery(name = "FinalidadesProcedimientos.findByIdFinalidadProcedimiento", query = "SELECT f FROM FinalidadesProcedimientos f WHERE f.idFinalidadProcedimiento = :idFinalidadProcedimiento"),
    @NamedQuery(name = "FinalidadesProcedimientos.findByFinalidadProcedimiento", query = "SELECT f FROM FinalidadesProcedimientos f WHERE f.finalidadProcedimiento LIKE :finalidadProcedimiento")})
public class FinalidadesProcedimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_finalidad_procedimiento")
    private Integer idFinalidadProcedimiento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "finalidad_procedimiento")
    private String finalidadProcedimiento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFinalidadProcedimiento")
    private List<Citas> citasList;

    public FinalidadesProcedimientos() {
    }

    public FinalidadesProcedimientos(Integer idFinalidadProcedimiento) {
        this.idFinalidadProcedimiento = idFinalidadProcedimiento;
    }

    public FinalidadesProcedimientos(Integer idFinalidadProcedimiento, String finalidadProcedimiento) {
        this.idFinalidadProcedimiento = idFinalidadProcedimiento;
        this.finalidadProcedimiento = finalidadProcedimiento;
    }

    public Integer getIdFinalidadProcedimiento() {
        return idFinalidadProcedimiento;
    }

    public void setIdFinalidadProcedimiento(Integer idFinalidadProcedimiento) {
        this.idFinalidadProcedimiento = idFinalidadProcedimiento;
    }

    public String getFinalidadProcedimiento() {
        return finalidadProcedimiento;
    }

    public void setFinalidadProcedimiento(String finalidadProcedimiento) {
        this.finalidadProcedimiento = finalidadProcedimiento;
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
        hash += (idFinalidadProcedimiento != null ? idFinalidadProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalidadesProcedimientos)) {
            return false;
        }
        FinalidadesProcedimientos other = (FinalidadesProcedimientos) object;
        if ((this.idFinalidadProcedimiento == null && other.idFinalidadProcedimiento != null) || (this.idFinalidadProcedimiento != null && !this.idFinalidadProcedimiento.equals(other.idFinalidadProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.FinalidadesProcedimientos[ idFinalidadProcedimiento=" + idFinalidadProcedimiento + " ]";
    }
    
}
