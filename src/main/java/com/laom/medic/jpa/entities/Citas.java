/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neney
 */
@Entity
@Table(name = "CITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByIdCita", query = "SELECT c FROM Citas c WHERE c.idCita = :idCita"),
    @NamedQuery(name = "Citas.findByFechaHorarios", query = "SELECT c FROM Citas c JOIN c.idUsuario u WHERE :idSede MEMBER OF u.sedesList AND c.fechaCita BETWEEN :fechaInicio AND :fechaFin"),
    @NamedQuery(name = "Citas.findByFechaUsuario", query = "SELECT c FROM Citas c JOIN c.idUsuario u WHERE :idUsuario MEMBER OF u.sedesList"),

    @NamedQuery(name = "Citas.findByFechaUser", query = "SELECT c FROM Citas c WHERE c.idUsuario.idUsuario = :idUsuario AND c.fechaCita BETWEEN :fechaInicio AND :fechaFin"),
    @NamedQuery(name = "Citas.findByIdSedes", query = "SELECT c FROM Citas c JOIN c.idUsuario u WHERE :idSede MEMBER OF u.sedesList AND c.fechaCita >= :nuevaFecha"),
    @NamedQuery(name = "Citas.findByIdUsuario", query = "SELECT c FROM Citas c JOIN c.idUsuario u WHERE u.rolesList = :idRol AND u.idIdentificacion LIKE :idIdentificacion"),
    @NamedQuery(name = "Citas.findByFechaCita", query = "SELECT c FROM Citas c WHERE c.fechaCita = :fechaCita"),
    @NamedQuery(name = "Citas.findByFechaAccidente", query = "SELECT c FROM Citas c WHERE c.fechaAccidente = :fechaAccidente"),
    @NamedQuery(name = "Citas.findByDescripcionAccidente", query = "SELECT c FROM Citas c WHERE c.descripcionAccidente = :descripcionAccidente"),
    @NamedQuery(name = "Citas.findByFechaCirugia", query = "SELECT c FROM Citas c WHERE c.fechaCirugia = :fechaCirugia"),
    @NamedQuery(name = "Citas.findByEdema", query = "SELECT c FROM Citas c WHERE c.edema = :edema"),
    @NamedQuery(name = "Citas.findByDolorLocalizacion", query = "SELECT c FROM Citas c WHERE c.dolorLocalizacion = :dolorLocalizacion"),
    @NamedQuery(name = "Citas.findByTipoDolor", query = "SELECT c FROM Citas c WHERE c.tipoDolor = :tipoDolor"),
    @NamedQuery(name = "Citas.findByFrecuenciaDolor", query = "SELECT c FROM Citas c WHERE c.frecuenciaDolor = :frecuenciaDolor"),
    @NamedQuery(name = "Citas.findByCalificacionDolor", query = "SELECT c FROM Citas c WHERE c.calificacionDolor = :calificacionDolor"),
    @NamedQuery(name = "Citas.findByMovilidadArticular", query = "SELECT c FROM Citas c WHERE c.movilidadArticular = :movilidadArticular"),
    @NamedQuery(name = "Citas.findByFlexibilidad", query = "SELECT c FROM Citas c WHERE c.flexibilidad = :flexibilidad"),
    @NamedQuery(name = "Citas.findByTrofismo", query = "SELECT c FROM Citas c WHERE c.trofismo = :trofismo"),
    @NamedQuery(name = "Citas.findByTegumentario", query = "SELECT c FROM Citas c WHERE c.tegumentario = :tegumentario"),
    @NamedQuery(name = "Citas.findBySensibilidad", query = "SELECT c FROM Citas c WHERE c.sensibilidad = :sensibilidad"),
    @NamedQuery(name = "Citas.findByPostura", query = "SELECT c FROM Citas c WHERE c.postura = :postura"),
    @NamedQuery(name = "Citas.findByPlanTratamiento", query = "SELECT c FROM Citas c WHERE c.planTratamiento = :planTratamiento"),
    @NamedQuery(name = "Citas.findByDiagnosticoFisioterapeutico", query = "SELECT c FROM Citas c WHERE c.diagnosticoFisioterapeutico = :diagnosticoFisioterapeutico"),
    @NamedQuery(name = "Citas.findByMarcha", query = "SELECT c FROM Citas c WHERE c.marcha = :marcha"),
    @NamedQuery(name = "Citas.findByObservaciones", query = "SELECT c FROM Citas c WHERE c.observaciones = :observaciones")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cita")
    private Integer idCita;

    @Column(name = "fecha_cita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCita;

    @Column(name = "fecha_accidente")
    @Temporal(TemporalType.DATE)
    private Date fechaAccidente;

    @Size(max = 255)
    @Column(name = "descripcion_accidente")
    private String descripcionAccidente;

    @Column(name = "fecha_cirugia")
    @Temporal(TemporalType.DATE)
    private Date fechaCirugia;

    @Column(name = "edema")
    private Boolean edema;

    @Size(max = 45)
    @Column(name = "dolor_localizacion")
    private String dolorLocalizacion;

    @Size(max = 45)
    @Column(name = "tipo_dolor")
    private String tipoDolor;

    @Size(max = 45)
    @Column(name = "frecuencia_dolor")
    private String frecuenciaDolor;

    @Column(name = "calificacion_dolor")
    private Integer calificacionDolor;

    @Size(max = 50)
    @Column(name = "movilidad_articular")
    private String movilidadArticular;

    @Size(max = 50)
    @Column(name = "flexibilidad")
    private String flexibilidad;

    @Size(max = 50)
    @Column(name = "trofismo")
    private String trofismo;

    @Size(max = 50)
    @Column(name = "tegumentario")
    private String tegumentario;

    @Size(max = 50)
    @Column(name = "sensibilidad")
    private String sensibilidad;

    @Size(max = 50)
    @Column(name = "postura")
    private String postura;

    @Size(max = 255)
    @Column(name = "plan_tratamiento")
    private String planTratamiento;

    @Size(max = 255)
    @Column(name = "diagnostico_fisioterapeutico")
    private String diagnosticoFisioterapeutico;

    @Size(max = 50)
    @Column(name = "marcha")
    private String marcha;

    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name = "codigo_factura")
    private Long codigoFactura;
    
    @Column(name = "valor_factura")
    private Long valorFactura;
    
    @Column(name = "valor_cita")
    private Long valorCita;

    @JoinColumn(name = "id_ambito_procedimiento", referencedColumnName = "id_ambito_procedimiento")
    @ManyToOne
    private AmbitosProcedimientos idAmbitoProcedimiento;

    @JoinColumn(name = "id_causa", referencedColumnName = "id_causa")
    @ManyToOne
    private CausasExternas idCausa;

    @JoinColumn(name = "id_cup", referencedColumnName = "id_cup")
    @ManyToOne
    private Cups idCup;

    @JoinColumn(name = "id_diagnosticos", referencedColumnName = "id_diagnosticos")
    @ManyToOne
    private Diagnosticos idDiagnosticos;

    @JoinColumn(name = "id_finalidad_consulta", referencedColumnName = "id_finalidad_consulta")
    @ManyToOne
    private FinalidadesConsultas idFinalidadConsulta;

    @JoinColumn(name = "id_finalidad_procedimiento", referencedColumnName = "id_finalidad_procedimiento")
    @ManyToOne
    private FinalidadesProcedimientos idFinalidadProcedimiento;

    @JoinColumn(name = "id_fuerza", referencedColumnName = "id_fuerza")
    @ManyToOne
    private FuerzasMusculares idFuerza;

    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal")
    @ManyToOne
    private PersonalTratante idPersonal;

    @JoinColumn(name = "id_tipo_diagnostico", referencedColumnName = "id_tipo_diagnostico")
    @ManyToOne
    private TiposDeDiagnosticosPrincipales idTipoDiagnostico;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idUsuario;

    public Citas() {
    }

    public Citas(Integer idCita) {
        this.idCita = idCita;
    }

    public Citas(Integer idCita, Date fechaAccidente, Date fechaCita) {
        this.idCita = idCita;
        this.fechaAccidente = fechaAccidente;
        this.fechaCita = fechaCita;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Date getFechaAccidente() {
        return fechaAccidente;
    }

    public void setFechaAccidente(Date fechaAccidente) {
        this.fechaAccidente = fechaAccidente;
    }

    public String getDescripcionAccidente() {
        return descripcionAccidente;
    }

    public void setDescripcionAccidente(String descripcionAccidente) {
        this.descripcionAccidente = descripcionAccidente;
    }

    public Date getFechaCirugia() {
        return fechaCirugia;
    }

    public void setFechaCirugia(Date fechaCirugia) {
        this.fechaCirugia = fechaCirugia;
    }

    public Boolean getEdema() {
        return edema;
    }

    public void setEdema(Boolean edema) {
        this.edema = edema;
    }

    public String getDolorLocalizacion() {
        return dolorLocalizacion;
    }

    public void setDolorLocalizacion(String dolorLocalizacion) {
        this.dolorLocalizacion = dolorLocalizacion;
    }

    public String getTipoDolor() {
        return tipoDolor;
    }

    public void setTipoDolor(String tipoDolor) {
        this.tipoDolor = tipoDolor;
    }

    public String getFrecuenciaDolor() {
        return frecuenciaDolor;
    }

    public void setFrecuenciaDolor(String frecuenciaDolor) {
        this.frecuenciaDolor = frecuenciaDolor;
    }

    public Integer getCalificacionDolor() {
        return calificacionDolor;
    }

    public void setCalificacionDolor(Integer calificacionDolor) {
        this.calificacionDolor = calificacionDolor;
    }

    public String getMovilidadArticular() {
        return movilidadArticular;
    }

    public void setMovilidadArticular(String movilidadArticular) {
        this.movilidadArticular = movilidadArticular;
    }

    public String getFlexibilidad() {
        return flexibilidad;
    }

    public void setFlexibilidad(String flexibilidad) {
        this.flexibilidad = flexibilidad;
    }

    public String getTrofismo() {
        return trofismo;
    }

    public void setTrofismo(String trofismo) {
        this.trofismo = trofismo;
    }

    public String getTegumentario() {
        return tegumentario;
    }

    public void setTegumentario(String tegumentario) {
        this.tegumentario = tegumentario;
    }

    public String getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(String sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public String getPostura() {
        return postura;
    }

    public void setPostura(String postura) {
        this.postura = postura;
    }

    public String getPlanTratamiento() {
        return planTratamiento;
    }

    public void setPlanTratamiento(String planTratamiento) {
        this.planTratamiento = planTratamiento;
    }

    public String getDiagnosticoFisioterapeutico() {
        return diagnosticoFisioterapeutico;
    }

    public void setDiagnosticoFisioterapeutico(String diagnosticoFisioterapeutico) {
        this.diagnosticoFisioterapeutico = diagnosticoFisioterapeutico;
    }

    public String getMarcha() {
        return marcha;
    }

    public void setMarcha(String marcha) {
        this.marcha = marcha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Long getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(Long valorFactura) {
        this.valorFactura = valorFactura;
    }

    public Long getValorCita() {
        return valorCita;
    }

    public void setValorCita(Long valorCita) {
        this.valorCita = valorCita;
    }

    public AmbitosProcedimientos getIdAmbitoProcedimiento() {
        return idAmbitoProcedimiento;
    }

    public void setIdAmbitoProcedimiento(AmbitosProcedimientos idAmbitoProcedimiento) {
        this.idAmbitoProcedimiento = idAmbitoProcedimiento;
    }

    public CausasExternas getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(CausasExternas idCausa) {
        this.idCausa = idCausa;
    }

    public Cups getIdCup() {
        return idCup;
    }

    public void setIdCup(Cups idCup) {
        this.idCup = idCup;
    }

    public Diagnosticos getIdDiagnosticos() {
        return idDiagnosticos;
    }

    public void setIdDiagnosticos(Diagnosticos idDiagnosticos) {
        this.idDiagnosticos = idDiagnosticos;
    }

    public FinalidadesConsultas getIdFinalidadConsulta() {
        return idFinalidadConsulta;
    }

    public void setIdFinalidadConsulta(FinalidadesConsultas idFinalidadConsulta) {
        this.idFinalidadConsulta = idFinalidadConsulta;
    }

    public FinalidadesProcedimientos getIdFinalidadProcedimiento() {
        return idFinalidadProcedimiento;
    }

    public void setIdFinalidadProcedimiento(FinalidadesProcedimientos idFinalidadProcedimiento) {
        this.idFinalidadProcedimiento = idFinalidadProcedimiento;
    }

    public FuerzasMusculares getIdFuerza() {
        return idFuerza;
    }

    public void setIdFuerza(FuerzasMusculares idFuerza) {
        this.idFuerza = idFuerza;
    }

    public PersonalTratante getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(PersonalTratante idPersonal) {
        this.idPersonal = idPersonal;
    }

    public TiposDeDiagnosticosPrincipales getIdTipoDiagnostico() {
        return idTipoDiagnostico;
    }

    public void setIdTipoDiagnostico(TiposDeDiagnosticosPrincipales idTipoDiagnostico) {
        this.idTipoDiagnostico = idTipoDiagnostico;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Citas[ idCita=" + idCita + " ]";
    }

}
