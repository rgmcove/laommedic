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
@Table(name = "DIAGNOSTICOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnosticos.findAll", query = "SELECT d FROM Diagnosticos d"),
    @NamedQuery(name = "Diagnosticos.findByIdDiagnosticos", query = "SELECT d FROM Diagnosticos d WHERE d.idDiagnosticos = :idDiagnosticos"),
    @NamedQuery(name = "Diagnosticos.findByCapitulo", query = "SELECT d FROM Diagnosticos d WHERE d.capitulo = :capitulo"),
    @NamedQuery(name = "Diagnosticos.findByNombreCapitulo", query = "SELECT d FROM Diagnosticos d WHERE d.nombreCapitulo = :nombreCapitulo"),
    @NamedQuery(name = "Diagnosticos.findByCodigoCuatro", query = "SELECT d FROM Diagnosticos d WHERE d.codigoCuatro LIKE :codigoCuatro"),
    @NamedQuery(name = "Diagnosticos.findByDescripcionCuatro", query = "SELECT d FROM Diagnosticos d WHERE d.descripcionCuatro LIKE :descripcionCuatro"),
    @NamedQuery(name = "Diagnosticos.findByCodigoTres", query = "SELECT d FROM Diagnosticos d WHERE d.codigoTres = :codigoTres"),
    @NamedQuery(name = "Diagnosticos.findByDescripcionTres", query = "SELECT d FROM Diagnosticos d WHERE d.descripcionTres = :descripcionTres"),
    @NamedQuery(name = "Diagnosticos.findByLimiteSexo", query = "SELECT d FROM Diagnosticos d WHERE d.limiteSexo = :limiteSexo"),
    @NamedQuery(name = "Diagnosticos.findByInferiorEdad", query = "SELECT d FROM Diagnosticos d WHERE d.inferiorEdad = :inferiorEdad"),
    @NamedQuery(name = "Diagnosticos.findBySuperiorEdad", query = "SELECT d FROM Diagnosticos d WHERE d.superiorEdad = :superiorEdad"),
    @NamedQuery(name = "Diagnosticos.findByGrupoMortal", query = "SELECT d FROM Diagnosticos d WHERE d.grupoMortal = :grupoMortal"),
    @NamedQuery(name = "Diagnosticos.findByGrupoMortalidad", query = "SELECT d FROM Diagnosticos d WHERE d.grupoMortalidad = :grupoMortalidad"),
    @NamedQuery(name = "Diagnosticos.findByValorInferior", query = "SELECT d FROM Diagnosticos d WHERE d.valorInferior = :valorInferior"),
    @NamedQuery(name = "Diagnosticos.findByValorSuperior", query = "SELECT d FROM Diagnosticos d WHERE d.valorSuperior = :valorSuperior")})
public class Diagnosticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diagnosticos")
    private Integer idDiagnosticos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "capitulo")
    private Short capitulo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre_capitulo")
    private String nombreCapitulo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo_cuatro")
    private String codigoCuatro;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion_cuatro")
    private String descripcionCuatro;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_tres")
    private String codigoTres;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion_tres")
    private String descripcionTres;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "limite_sexo")
    private String limiteSexo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "inferior_edad")
    private String inferiorEdad;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "superior_edad")
    private String superiorEdad;
    
    @Column(name = "grupo_mortal")
    private Integer grupoMortal;
    
    @Column(name = "grupo_mortalidad")
    private Integer grupoMortalidad;
    
    @Column(name = "valor_inferior")
    private Integer valorInferior;
    
    @Column(name = "valor_superior")
    private Integer valorSuperior;
    
    @OneToMany(mappedBy = "idDiagnosticos")
    private List<Citas> citasList;

    public Diagnosticos() {
    }

    public Diagnosticos(Integer idDiagnosticos) {
        this.idDiagnosticos = idDiagnosticos;
    }

    public Diagnosticos(Integer idDiagnosticos, Short capitulo, String nombreCapitulo, String codigoCuatro, String descripcionCuatro, String codigoTres, String descripcionTres, String limiteSexo, String inferiorEdad, String superiorEdad) {
        this.idDiagnosticos = idDiagnosticos;
        this.capitulo = capitulo;
        this.nombreCapitulo = nombreCapitulo;
        this.codigoCuatro = codigoCuatro;
        this.descripcionCuatro = descripcionCuatro;
        this.codigoTres = codigoTres;
        this.descripcionTres = descripcionTres;
        this.limiteSexo = limiteSexo;
        this.inferiorEdad = inferiorEdad;
        this.superiorEdad = superiorEdad;
    }

    public Integer getIdDiagnosticos() {
        return idDiagnosticos;
    }

    public void setIdDiagnosticos(Integer idDiagnosticos) {
        this.idDiagnosticos = idDiagnosticos;
    }

    public Short getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Short capitulo) {
        this.capitulo = capitulo;
    }

    public String getNombreCapitulo() {
        return nombreCapitulo;
    }

    public void setNombreCapitulo(String nombreCapitulo) {
        this.nombreCapitulo = nombreCapitulo;
    }

    public String getCodigoCuatro() {
        return codigoCuatro;
    }

    public void setCodigoCuatro(String codigoCuatro) {
        this.codigoCuatro = codigoCuatro;
    }

    public String getDescripcionCuatro() {
        return descripcionCuatro;
    }

    public void setDescripcionCuatro(String descripcionCuatro) {
        this.descripcionCuatro = descripcionCuatro;
    }

    public String getCodigoTres() {
        return codigoTres;
    }

    public void setCodigoTres(String codigoTres) {
        this.codigoTres = codigoTres;
    }

    public String getDescripcionTres() {
        return descripcionTres;
    }

    public void setDescripcionTres(String descripcionTres) {
        this.descripcionTres = descripcionTres;
    }

    public String getLimiteSexo() {
        return limiteSexo;
    }

    public void setLimiteSexo(String limiteSexo) {
        this.limiteSexo = limiteSexo;
    }

    public String getInferiorEdad() {
        return inferiorEdad;
    }

    public void setInferiorEdad(String inferiorEdad) {
        this.inferiorEdad = inferiorEdad;
    }

    public String getSuperiorEdad() {
        return superiorEdad;
    }

    public void setSuperiorEdad(String superiorEdad) {
        this.superiorEdad = superiorEdad;
    }

    public Integer getGrupoMortal() {
        return grupoMortal;
    }

    public void setGrupoMortal(Integer grupoMortal) {
        this.grupoMortal = grupoMortal;
    }

    public Integer getGrupoMortalidad() {
        return grupoMortalidad;
    }

    public void setGrupoMortalidad(Integer grupoMortalidad) {
        this.grupoMortalidad = grupoMortalidad;
    }

    public Integer getValorInferior() {
        return valorInferior;
    }

    public void setValorInferior(Integer valorInferior) {
        this.valorInferior = valorInferior;
    }

    public Integer getValorSuperior() {
        return valorSuperior;
    }

    public void setValorSuperior(Integer valorSuperior) {
        this.valorSuperior = valorSuperior;
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
        hash += (idDiagnosticos != null ? idDiagnosticos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosticos)) {
            return false;
        }
        Diagnosticos other = (Diagnosticos) object;
        if ((this.idDiagnosticos == null && other.idDiagnosticos != null) || (this.idDiagnosticos != null && !this.idDiagnosticos.equals(other.idDiagnosticos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Diagnosticos[ idDiagnosticos=" + idDiagnosticos + " ]";
    }
    
}
