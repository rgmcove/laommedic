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
@Table(name = "CONSULTORIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultorios.findAll", query = "SELECT c FROM Consultorios c"),
    @NamedQuery(name = "Consultorios.findByIdConsultorio", query = "SELECT c FROM Consultorios c WHERE c.idConsultorio = :idConsultorio"),
    @NamedQuery(name = "Consultorios.findByCodigoConsultorio", query = "SELECT c FROM Consultorios c WHERE c.codigoConsultorio LIKE :codigoConsultorio")})
public class Consultorios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consultorio")
    private Integer idConsultorio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo_consultorio")
    private String codigoConsultorio;
    
    @JoinColumn(name = "id_sedes", referencedColumnName = "id_sedes")
    @ManyToOne(optional = false)
    private Sedes idSede;

    public Consultorios() {
    }

    public Consultorios(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Consultorios(Integer idConsultorio, String codigoConsultorio) {
        this.idConsultorio = idConsultorio;
        this.codigoConsultorio = codigoConsultorio;
    }

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getCodigoConsultorio() {
        return codigoConsultorio;
    }

    public void setCodigoConsultorio(String codigoConsultorio) {
        this.codigoConsultorio = codigoConsultorio;
    }

    public Sedes getIdSede() {
        return idSede;
    }

    public void setIdSede(Sedes idSede) {
        this.idSede = idSede;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultorio != null ? idConsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultorios)) {
            return false;
        }
        Consultorios other = (Consultorios) object;
        if ((this.idConsultorio == null && other.idConsultorio != null) || (this.idConsultorio != null && !this.idConsultorio.equals(other.idConsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Consultorios[ idConsultorio=" + idConsultorio + " ]";
    }
    
}
