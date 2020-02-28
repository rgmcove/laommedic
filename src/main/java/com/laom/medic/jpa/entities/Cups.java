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
 * @author neney
 */
@Entity
@Table(name = "CUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cups.findAll", query = "SELECT c FROM Cups c"),
    @NamedQuery(name = "Cups.findByIdCup", query = "SELECT c FROM Cups c WHERE c.idCup = :idCup"),
    @NamedQuery(name = "Cups.findBySubcategoria", query = "SELECT c FROM Cups c WHERE c.subcategoria LIKE :subcategoria"),
    @NamedQuery(name = "Cups.findByDescripcion", query = "SELECT c FROM Cups c WHERE c.descripcion LIKE :descripcion"),
    @NamedQuery(name = "Cups.findByCobertura", query = "SELECT c FROM Cups c WHERE c.cobertura = :cobertura"),
    @NamedQuery(name = "Cups.findBySexo", query = "SELECT c FROM Cups c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Cups.findByAmbito", query = "SELECT c FROM Cups c WHERE c.ambito = :ambito"),
    @NamedQuery(name = "Cups.findByEstancia", query = "SELECT c FROM Cups c WHERE c.estancia = :estancia"),
    @NamedQuery(name = "Cups.findByDuplicado", query = "SELECT c FROM Cups c WHERE c.duplicado = :duplicado")})
public class Cups implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cup")
    private Integer idCup;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "subcategoria")
    private String subcategoria;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cobertura")
    private String cobertura;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sexo")
    private String sexo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ambito")
    private String ambito;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estancia")
    private String estancia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "duplicado")
    private String duplicado;
    
    @OneToMany(mappedBy = "idCup")
    private List<Citas> citasList;

    public Cups() {
    }

    public Cups(Integer idCup) {
        this.idCup = idCup;
    }

    public Cups(Integer idCup, String subcategoria, String descripcion, String cobertura, String sexo, String ambito, String estancia, String duplicado) {
        this.idCup = idCup;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.cobertura = cobertura;
        this.sexo = sexo;
        this.ambito = ambito;
        this.estancia = estancia;
        this.duplicado = duplicado;
    }

    public Integer getIdCup() {
        return idCup;
    }

    public void setIdCup(Integer idCup) {
        this.idCup = idCup;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getEstancia() {
        return estancia;
    }

    public void setEstancia(String estancia) {
        this.estancia = estancia;
    }

    public String getDuplicado() {
        return duplicado;
    }

    public void setDuplicado(String duplicado) {
        this.duplicado = duplicado;
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
        hash += (idCup != null ? idCup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cups)) {
            return false;
        }
        Cups other = (Cups) object;
        if ((this.idCup == null && other.idCup != null) || (this.idCup != null && !this.idCup.equals(other.idCup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Cups[ idCup=" + idCup + " ]";
    }

}
