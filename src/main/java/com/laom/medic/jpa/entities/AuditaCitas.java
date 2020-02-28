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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neney
 */
@Entity
@Table(name = "audita_citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditaCitas.findAll", query = "SELECT a FROM AuditaCitas a"),
    @NamedQuery(name = "AuditaCitas.findByCodigoAudita", query = "SELECT a FROM AuditaCitas a WHERE a.codigoAudita = :codigoAudita"),
    @NamedQuery(name = "AuditaCitas.findByUsuario", query = "SELECT a FROM AuditaCitas a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AuditaCitas.findByFechaCitaOld", query = "SELECT a FROM AuditaCitas a WHERE a.fechaCitaOld = :fechaCitaOld"),
    @NamedQuery(name = "AuditaCitas.findByFechaAccidenteOld", query = "SELECT a FROM AuditaCitas a WHERE a.fechaAccidenteOld = :fechaAccidenteOld"),
    @NamedQuery(name = "AuditaCitas.findByDescripcionAccidenteOld", query = "SELECT a FROM AuditaCitas a WHERE a.descripcionAccidenteOld = :descripcionAccidenteOld"),
    @NamedQuery(name = "AuditaCitas.findByFechaCirugiaOld", query = "SELECT a FROM AuditaCitas a WHERE a.fechaCirugiaOld = :fechaCirugiaOld"),
    @NamedQuery(name = "AuditaCitas.findByEdemaOld", query = "SELECT a FROM AuditaCitas a WHERE a.edemaOld = :edemaOld"),
    @NamedQuery(name = "AuditaCitas.findByDolorLocalizacionOld", query = "SELECT a FROM AuditaCitas a WHERE a.dolorLocalizacionOld = :dolorLocalizacionOld"),
    @NamedQuery(name = "AuditaCitas.findByTipoDolorOld", query = "SELECT a FROM AuditaCitas a WHERE a.tipoDolorOld = :tipoDolorOld"),
    @NamedQuery(name = "AuditaCitas.findByFrecuenciaDolorOld", query = "SELECT a FROM AuditaCitas a WHERE a.frecuenciaDolorOld = :frecuenciaDolorOld"),
    @NamedQuery(name = "AuditaCitas.findByCalificacionDolorOld", query = "SELECT a FROM AuditaCitas a WHERE a.calificacionDolorOld = :calificacionDolorOld"),
    @NamedQuery(name = "AuditaCitas.findByMovilidadArticularOld", query = "SELECT a FROM AuditaCitas a WHERE a.movilidadArticularOld = :movilidadArticularOld"),
    @NamedQuery(name = "AuditaCitas.findByFlexibilidadOld", query = "SELECT a FROM AuditaCitas a WHERE a.flexibilidadOld = :flexibilidadOld"),
    @NamedQuery(name = "AuditaCitas.findByTrofismoOld", query = "SELECT a FROM AuditaCitas a WHERE a.trofismoOld = :trofismoOld"),
    @NamedQuery(name = "AuditaCitas.findByTegumentarioOld", query = "SELECT a FROM AuditaCitas a WHERE a.tegumentarioOld = :tegumentarioOld"),
    @NamedQuery(name = "AuditaCitas.findBySensibilidadOld", query = "SELECT a FROM AuditaCitas a WHERE a.sensibilidadOld = :sensibilidadOld"),
    @NamedQuery(name = "AuditaCitas.findByPosturaOld", query = "SELECT a FROM AuditaCitas a WHERE a.posturaOld = :posturaOld"),
    @NamedQuery(name = "AuditaCitas.findByPlanTratamientoOld", query = "SELECT a FROM AuditaCitas a WHERE a.planTratamientoOld = :planTratamientoOld"),
    @NamedQuery(name = "AuditaCitas.findByDiagnosticoFisioterapeuticoOld", query = "SELECT a FROM AuditaCitas a WHERE a.diagnosticoFisioterapeuticoOld = :diagnosticoFisioterapeuticoOld"),
    @NamedQuery(name = "AuditaCitas.findByMarchaOld", query = "SELECT a FROM AuditaCitas a WHERE a.marchaOld = :marchaOld"),
    @NamedQuery(name = "AuditaCitas.findByObservacionesOld", query = "SELECT a FROM AuditaCitas a WHERE a.observacionesOld = :observacionesOld"),
    @NamedQuery(name = "AuditaCitas.findByIdFuerzaOld", query = "SELECT a FROM AuditaCitas a WHERE a.idFuerzaOld = :idFuerzaOld"),
    @NamedQuery(name = "AuditaCitas.findByIdPersonalOld", query = "SELECT a FROM AuditaCitas a WHERE a.idPersonalOld = :idPersonalOld"),
    @NamedQuery(name = "AuditaCitas.findByIdCausaOld", query = "SELECT a FROM AuditaCitas a WHERE a.idCausaOld = :idCausaOld"),
    @NamedQuery(name = "AuditaCitas.findByIdFinalidadConsultaOld", query = "SELECT a FROM AuditaCitas a WHERE a.idFinalidadConsultaOld = :idFinalidadConsultaOld"),
    @NamedQuery(name = "AuditaCitas.findByIdTipoDiagnosticoOld", query = "SELECT a FROM AuditaCitas a WHERE a.idTipoDiagnosticoOld = :idTipoDiagnosticoOld"),
    @NamedQuery(name = "AuditaCitas.findByIdFinalidadProcedimientoOld", query = "SELECT a FROM AuditaCitas a WHERE a.idFinalidadProcedimientoOld = :idFinalidadProcedimientoOld"),
    @NamedQuery(name = "AuditaCitas.findByIdAmbitoProcedimientoOld", query = "SELECT a FROM AuditaCitas a WHERE a.idAmbitoProcedimientoOld = :idAmbitoProcedimientoOld"),
    @NamedQuery(name = "AuditaCitas.findByIdCupOld", query = "SELECT a FROM AuditaCitas a WHERE a.idCupOld = :idCupOld"),
    @NamedQuery(name = "AuditaCitas.findByIdUsuarioOld", query = "SELECT a FROM AuditaCitas a WHERE a.idUsuarioOld = :idUsuarioOld"),
    @NamedQuery(name = "AuditaCitas.findByIdDiagnosticosOld", query = "SELECT a FROM AuditaCitas a WHERE a.idDiagnosticosOld = :idDiagnosticosOld"),
    @NamedQuery(name = "AuditaCitas.findByFechaCitaNew", query = "SELECT a FROM AuditaCitas a WHERE a.fechaCitaNew = :fechaCitaNew"),
    @NamedQuery(name = "AuditaCitas.findByFechaAccidenteNew", query = "SELECT a FROM AuditaCitas a WHERE a.fechaAccidenteNew = :fechaAccidenteNew"),
    @NamedQuery(name = "AuditaCitas.findByDescripcionAccidenteNew", query = "SELECT a FROM AuditaCitas a WHERE a.descripcionAccidenteNew = :descripcionAccidenteNew"),
    @NamedQuery(name = "AuditaCitas.findByFechaCirugiaNew", query = "SELECT a FROM AuditaCitas a WHERE a.fechaCirugiaNew = :fechaCirugiaNew"),
    @NamedQuery(name = "AuditaCitas.findByEdemaNew", query = "SELECT a FROM AuditaCitas a WHERE a.edemaNew = :edemaNew"),
    @NamedQuery(name = "AuditaCitas.findByDolorLocalizacionNew", query = "SELECT a FROM AuditaCitas a WHERE a.dolorLocalizacionNew = :dolorLocalizacionNew"),
    @NamedQuery(name = "AuditaCitas.findByTipoDolorNew", query = "SELECT a FROM AuditaCitas a WHERE a.tipoDolorNew = :tipoDolorNew"),
    @NamedQuery(name = "AuditaCitas.findByFrecuenciaDolorNew", query = "SELECT a FROM AuditaCitas a WHERE a.frecuenciaDolorNew = :frecuenciaDolorNew"),
    @NamedQuery(name = "AuditaCitas.findByCalificacionDolorNew", query = "SELECT a FROM AuditaCitas a WHERE a.calificacionDolorNew = :calificacionDolorNew"),
    @NamedQuery(name = "AuditaCitas.findByMovilidadArticularNew", query = "SELECT a FROM AuditaCitas a WHERE a.movilidadArticularNew = :movilidadArticularNew"),
    @NamedQuery(name = "AuditaCitas.findByFlexibilidadNew", query = "SELECT a FROM AuditaCitas a WHERE a.flexibilidadNew = :flexibilidadNew"),
    @NamedQuery(name = "AuditaCitas.findByTrofismoNew", query = "SELECT a FROM AuditaCitas a WHERE a.trofismoNew = :trofismoNew"),
    @NamedQuery(name = "AuditaCitas.findByTegumentarioNew", query = "SELECT a FROM AuditaCitas a WHERE a.tegumentarioNew = :tegumentarioNew"),
    @NamedQuery(name = "AuditaCitas.findBySensibilidadNew", query = "SELECT a FROM AuditaCitas a WHERE a.sensibilidadNew = :sensibilidadNew"),
    @NamedQuery(name = "AuditaCitas.findByPosturaNew", query = "SELECT a FROM AuditaCitas a WHERE a.posturaNew = :posturaNew"),
    @NamedQuery(name = "AuditaCitas.findByPlanTratamientoNew", query = "SELECT a FROM AuditaCitas a WHERE a.planTratamientoNew = :planTratamientoNew"),
    @NamedQuery(name = "AuditaCitas.findByDiagnosticoFisioterapeuticoNew", query = "SELECT a FROM AuditaCitas a WHERE a.diagnosticoFisioterapeuticoNew = :diagnosticoFisioterapeuticoNew"),
    @NamedQuery(name = "AuditaCitas.findByMarchaNew", query = "SELECT a FROM AuditaCitas a WHERE a.marchaNew = :marchaNew"),
    @NamedQuery(name = "AuditaCitas.findByObservacionesNew", query = "SELECT a FROM AuditaCitas a WHERE a.observacionesNew = :observacionesNew"),
    @NamedQuery(name = "AuditaCitas.findByIdFuerzaNew", query = "SELECT a FROM AuditaCitas a WHERE a.idFuerzaNew = :idFuerzaNew"),
    @NamedQuery(name = "AuditaCitas.findByIdPersonalNew", query = "SELECT a FROM AuditaCitas a WHERE a.idPersonalNew = :idPersonalNew"),
    @NamedQuery(name = "AuditaCitas.findByIdCausaNew", query = "SELECT a FROM AuditaCitas a WHERE a.idCausaNew = :idCausaNew"),
    @NamedQuery(name = "AuditaCitas.findByIdFinalidadConsultaNew", query = "SELECT a FROM AuditaCitas a WHERE a.idFinalidadConsultaNew = :idFinalidadConsultaNew"),
    @NamedQuery(name = "AuditaCitas.findByIdTipoDiagnosticoNew", query = "SELECT a FROM AuditaCitas a WHERE a.idTipoDiagnosticoNew = :idTipoDiagnosticoNew"),
    @NamedQuery(name = "AuditaCitas.findByIdFinalidadProcedimientoNew", query = "SELECT a FROM AuditaCitas a WHERE a.idFinalidadProcedimientoNew = :idFinalidadProcedimientoNew"),
    @NamedQuery(name = "AuditaCitas.findByIdAmbitoProcedimientoNew", query = "SELECT a FROM AuditaCitas a WHERE a.idAmbitoProcedimientoNew = :idAmbitoProcedimientoNew"),
    @NamedQuery(name = "AuditaCitas.findByIdCupNew", query = "SELECT a FROM AuditaCitas a WHERE a.idCupNew = :idCupNew"),
    @NamedQuery(name = "AuditaCitas.findByIdUsuarioNew", query = "SELECT a FROM AuditaCitas a WHERE a.idUsuarioNew = :idUsuarioNew"),
    @NamedQuery(name = "AuditaCitas.findByIdDiagnosticosNew", query = "SELECT a FROM AuditaCitas a WHERE a.idDiagnosticosNew = :idDiagnosticosNew"),
    @NamedQuery(name = "AuditaCitas.findByFechaModificacion", query = "SELECT a FROM AuditaCitas a WHERE a.fechaModificacion = :fechaModificacion")})
public class AuditaCitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_audita")
    private Integer codigoAudita;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "fecha_cita_old")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCitaOld;
    
    @Column(name = "fecha_accidente_old")
    @Temporal(TemporalType.DATE)
    private Date fechaAccidenteOld;
    
    @Size(max = 255)
    @Column(name = "descripcion_accidente_old")
    private String descripcionAccidenteOld;
    
    @Column(name = "fecha_cirugia_old")
    @Temporal(TemporalType.DATE)
    private Date fechaCirugiaOld;
    
    @Column(name = "edema_old")
    private Boolean edemaOld;
    
    @Size(max = 45)
    @Column(name = "dolor_localizacion_old")
    private String dolorLocalizacionOld;
    
    @Size(max = 45)
    @Column(name = "tipo_dolor_old")
    private String tipoDolorOld;
    
    @Size(max = 45)
    @Column(name = "frecuencia_dolor_old")
    private String frecuenciaDolorOld;
    
    @Column(name = "calificacion_dolor_old")
    private Integer calificacionDolorOld;
    
    @Size(max = 50)
    @Column(name = "movilidad_articular_old")
    private String movilidadArticularOld;
    
    @Size(max = 50)
    @Column(name = "flexibilidad_old")
    private String flexibilidadOld;
    
    @Size(max = 50)
    @Column(name = "trofismo_old")
    private String trofismoOld;
    
    @Size(max = 50)
    @Column(name = "tegumentario_old")
    private String tegumentarioOld;
    
    @Size(max = 50)
    @Column(name = "sensibilidad_old")
    private String sensibilidadOld;
    
    @Size(max = 50)
    @Column(name = "postura_old")
    private String posturaOld;
    
    @Size(max = 255)
    @Column(name = "plan_tratamiento_old")
    private String planTratamientoOld;
    
    @Size(max = 255)
    @Column(name = "diagnostico_fisioterapeutico_old")
    private String diagnosticoFisioterapeuticoOld;
    
    @Size(max = 50)
    @Column(name = "marcha_old")
    private String marchaOld;
    
    @Size(max = 255)
    @Column(name = "observaciones_old")
    private String observacionesOld;
    
    @Column(name = "codigo_factura_old")
    private Long codigoFacturaOld;
    
    @Column(name = "valor_factura_old")
    private Long valorFacturaOld;
    
    @Column(name = "valor_cita_old")
    private Long valorCitaOld;
    
    @Size(max = 5)
    @Column(name = "id_fuerza_old")
    private String idFuerzaOld;
    
    @Column(name = "id_personal_old")
    private Integer idPersonalOld;
    
    @Column(name = "id_causa_old")
    private Integer idCausaOld;
    
    @Column(name = "id_finalidad_consulta_old")
    private Integer idFinalidadConsultaOld;
    
    @Column(name = "id_tipo_diagnostico_old")
    private Integer idTipoDiagnosticoOld;
    
    @Column(name = "id_finalidad_procedimiento_old")
    private Integer idFinalidadProcedimientoOld;
    
    @Column(name = "id_ambito_procedimiento_old")
    private Integer idAmbitoProcedimientoOld;
    
    @Column(name = "id_cup_old")
    private Integer idCupOld;
    
    @Column(name = "id_usuario_old")
    private Integer idUsuarioOld;
    
    @Column(name = "id_diagnosticos_old")
    private Integer idDiagnosticosOld;
    
    @Column(name = "fecha_cita_new")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCitaNew;
    
    @Column(name = "fecha_accidente_new")
    @Temporal(TemporalType.DATE)
    private Date fechaAccidenteNew;
    
    @Size(max = 255)
    @Column(name = "descripcion_accidente_new")
    private String descripcionAccidenteNew;
    
    @Column(name = "fecha_cirugia_new")
    @Temporal(TemporalType.DATE)
    private Date fechaCirugiaNew;
    
    @Column(name = "edema_new")
    private Boolean edemaNew;
    
    @Size(max = 45)
    @Column(name = "dolor_localizacion_new")
    private String dolorLocalizacionNew;
    
    @Size(max = 45)
    @Column(name = "tipo_dolor_new")
    private String tipoDolorNew;
    
    @Size(max = 45)
    @Column(name = "frecuencia_dolor_new")
    private String frecuenciaDolorNew;
    
    @Column(name = "calificacion_dolor_new")
    private Integer calificacionDolorNew;
    
    @Size(max = 50)
    @Column(name = "movilidad_articular_new")
    private String movilidadArticularNew;
    
    @Size(max = 50)
    @Column(name = "flexibilidad_new")
    private String flexibilidadNew;
    
    @Size(max = 50)
    @Column(name = "trofismo_new")
    private String trofismoNew;
    
    @Size(max = 50)
    @Column(name = "tegumentario_new")
    private String tegumentarioNew;
    
    @Size(max = 50)
    @Column(name = "sensibilidad_new")
    private String sensibilidadNew;
    
    @Size(max = 50)
    @Column(name = "postura_new")
    private String posturaNew;
    
    @Size(max = 255)
    @Column(name = "plan_tratamiento_new")
    private String planTratamientoNew;
    
    @Size(max = 255)
    @Column(name = "diagnostico_fisioterapeutico_new")
    private String diagnosticoFisioterapeuticoNew;
    
    @Size(max = 50)
    @Column(name = "marcha_new")
    private String marchaNew;
    
    @Size(max = 255)
    @Column(name = "observaciones_new")
    private String observacionesNew;
    
    @Column(name = "codigo_factura_new")
    private Long codigoFacturaNew;
    
    @Column(name = "valor_factura_new")
    private Long valorFacturaNew;
    
    @Column(name = "valor_cita_new")
    private Long valorCitaNew;
    
    @Size(max = 5)
    @Column(name = "id_fuerza_new")
    private String idFuerzaNew;
    
    @Column(name = "id_personal_new")
    private Integer idPersonalNew;
    
    @Column(name = "id_causa_new")
    private Integer idCausaNew;
    
    @Column(name = "id_finalidad_consulta_new")
    private Integer idFinalidadConsultaNew;
    
    @Column(name = "id_tipo_diagnostico_new")
    private Integer idTipoDiagnosticoNew;
    
    @Column(name = "id_finalidad_procedimiento_new")
    private Integer idFinalidadProcedimientoNew;
    
    @Column(name = "id_ambito_procedimiento_new")
    private Integer idAmbitoProcedimientoNew;
    
    @Column(name = "id_cup_new")
    private Integer idCupNew;
    
    @Column(name = "id_usuario_new")
    private Integer idUsuarioNew;
    
    @Column(name = "id_diagnosticos_new")
    private Integer idDiagnosticosNew;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public AuditaCitas() {
    }

    public AuditaCitas(Integer codigoAudita) {
        this.codigoAudita = codigoAudita;
    }

    public AuditaCitas(Integer codigoAudita, String usuario) {
        this.codigoAudita = codigoAudita;
        this.usuario = usuario;
    }

    public Integer getCodigoAudita() {
        return codigoAudita;
    }

    public void setCodigoAudita(Integer codigoAudita) {
        this.codigoAudita = codigoAudita;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCitaOld() {
        return fechaCitaOld;
    }

    public void setFechaCitaOld(Date fechaCitaOld) {
        this.fechaCitaOld = fechaCitaOld;
    }

    public Date getFechaAccidenteOld() {
        return fechaAccidenteOld;
    }

    public void setFechaAccidenteOld(Date fechaAccidenteOld) {
        this.fechaAccidenteOld = fechaAccidenteOld;
    }

    public String getDescripcionAccidenteOld() {
        return descripcionAccidenteOld;
    }

    public void setDescripcionAccidenteOld(String descripcionAccidenteOld) {
        this.descripcionAccidenteOld = descripcionAccidenteOld;
    }

    public Date getFechaCirugiaOld() {
        return fechaCirugiaOld;
    }

    public void setFechaCirugiaOld(Date fechaCirugiaOld) {
        this.fechaCirugiaOld = fechaCirugiaOld;
    }

    public Boolean getEdemaOld() {
        return edemaOld;
    }

    public void setEdemaOld(Boolean edemaOld) {
        this.edemaOld = edemaOld;
    }

    public String getDolorLocalizacionOld() {
        return dolorLocalizacionOld;
    }

    public void setDolorLocalizacionOld(String dolorLocalizacionOld) {
        this.dolorLocalizacionOld = dolorLocalizacionOld;
    }

    public String getTipoDolorOld() {
        return tipoDolorOld;
    }

    public void setTipoDolorOld(String tipoDolorOld) {
        this.tipoDolorOld = tipoDolorOld;
    }

    public String getFrecuenciaDolorOld() {
        return frecuenciaDolorOld;
    }

    public void setFrecuenciaDolorOld(String frecuenciaDolorOld) {
        this.frecuenciaDolorOld = frecuenciaDolorOld;
    }

    public Integer getCalificacionDolorOld() {
        return calificacionDolorOld;
    }

    public void setCalificacionDolorOld(Integer calificacionDolorOld) {
        this.calificacionDolorOld = calificacionDolorOld;
    }

    public String getMovilidadArticularOld() {
        return movilidadArticularOld;
    }

    public void setMovilidadArticularOld(String movilidadArticularOld) {
        this.movilidadArticularOld = movilidadArticularOld;
    }

    public String getFlexibilidadOld() {
        return flexibilidadOld;
    }

    public void setFlexibilidadOld(String flexibilidadOld) {
        this.flexibilidadOld = flexibilidadOld;
    }

    public String getTrofismoOld() {
        return trofismoOld;
    }

    public void setTrofismoOld(String trofismoOld) {
        this.trofismoOld = trofismoOld;
    }

    public String getTegumentarioOld() {
        return tegumentarioOld;
    }

    public void setTegumentarioOld(String tegumentarioOld) {
        this.tegumentarioOld = tegumentarioOld;
    }

    public String getSensibilidadOld() {
        return sensibilidadOld;
    }

    public void setSensibilidadOld(String sensibilidadOld) {
        this.sensibilidadOld = sensibilidadOld;
    }

    public String getPosturaOld() {
        return posturaOld;
    }

    public void setPosturaOld(String posturaOld) {
        this.posturaOld = posturaOld;
    }

    public String getPlanTratamientoOld() {
        return planTratamientoOld;
    }

    public void setPlanTratamientoOld(String planTratamientoOld) {
        this.planTratamientoOld = planTratamientoOld;
    }

    public String getDiagnosticoFisioterapeuticoOld() {
        return diagnosticoFisioterapeuticoOld;
    }

    public void setDiagnosticoFisioterapeuticoOld(String diagnosticoFisioterapeuticoOld) {
        this.diagnosticoFisioterapeuticoOld = diagnosticoFisioterapeuticoOld;
    }

    public String getMarchaOld() {
        return marchaOld;
    }

    public void setMarchaOld(String marchaOld) {
        this.marchaOld = marchaOld;
    }

    public String getObservacionesOld() {
        return observacionesOld;
    }

    public void setObservacionesOld(String observacionesOld) {
        this.observacionesOld = observacionesOld;
    }

    public Long getCodigoFacturaOld() {
        return codigoFacturaOld;
    }

    public void setCodigoFacturaOld(Long codigoFacturaOld) {
        this.codigoFacturaOld = codigoFacturaOld;
    }

    public Long getValorFacturaOld() {
        return valorFacturaOld;
    }

    public void setValorFacturaOld(Long valorFacturaOld) {
        this.valorFacturaOld = valorFacturaOld;
    }

    public Long getValorCitaOld() {
        return valorCitaOld;
    }

    public void setValorCitaOld(Long valorCitaOld) {
        this.valorCitaOld = valorCitaOld;
    }

    public String getIdFuerzaOld() {
        return idFuerzaOld;
    }

    public void setIdFuerzaOld(String idFuerzaOld) {
        this.idFuerzaOld = idFuerzaOld;
    }

    public Integer getIdPersonalOld() {
        return idPersonalOld;
    }

    public void setIdPersonalOld(Integer idPersonalOld) {
        this.idPersonalOld = idPersonalOld;
    }

    public Integer getIdCausaOld() {
        return idCausaOld;
    }

    public void setIdCausaOld(Integer idCausaOld) {
        this.idCausaOld = idCausaOld;
    }

    public Integer getIdFinalidadConsultaOld() {
        return idFinalidadConsultaOld;
    }

    public void setIdFinalidadConsultaOld(Integer idFinalidadConsultaOld) {
        this.idFinalidadConsultaOld = idFinalidadConsultaOld;
    }

    public Integer getIdTipoDiagnosticoOld() {
        return idTipoDiagnosticoOld;
    }

    public void setIdTipoDiagnosticoOld(Integer idTipoDiagnosticoOld) {
        this.idTipoDiagnosticoOld = idTipoDiagnosticoOld;
    }

    public Integer getIdFinalidadProcedimientoOld() {
        return idFinalidadProcedimientoOld;
    }

    public void setIdFinalidadProcedimientoOld(Integer idFinalidadProcedimientoOld) {
        this.idFinalidadProcedimientoOld = idFinalidadProcedimientoOld;
    }

    public Integer getIdAmbitoProcedimientoOld() {
        return idAmbitoProcedimientoOld;
    }

    public void setIdAmbitoProcedimientoOld(Integer idAmbitoProcedimientoOld) {
        this.idAmbitoProcedimientoOld = idAmbitoProcedimientoOld;
    }

    public Integer getIdCupOld() {
        return idCupOld;
    }

    public void setIdCupOld(Integer idCupOld) {
        this.idCupOld = idCupOld;
    }

    public Integer getIdUsuarioOld() {
        return idUsuarioOld;
    }

    public void setIdUsuarioOld(Integer idUsuarioOld) {
        this.idUsuarioOld = idUsuarioOld;
    }

    public Integer getIdDiagnosticosOld() {
        return idDiagnosticosOld;
    }

    public void setIdDiagnosticosOld(Integer idDiagnosticosOld) {
        this.idDiagnosticosOld = idDiagnosticosOld;
    }

    public Date getFechaCitaNew() {
        return fechaCitaNew;
    }

    public void setFechaCitaNew(Date fechaCitaNew) {
        this.fechaCitaNew = fechaCitaNew;
    }

    public Date getFechaAccidenteNew() {
        return fechaAccidenteNew;
    }

    public void setFechaAccidenteNew(Date fechaAccidenteNew) {
        this.fechaAccidenteNew = fechaAccidenteNew;
    }

    public String getDescripcionAccidenteNew() {
        return descripcionAccidenteNew;
    }

    public void setDescripcionAccidenteNew(String descripcionAccidenteNew) {
        this.descripcionAccidenteNew = descripcionAccidenteNew;
    }

    public Date getFechaCirugiaNew() {
        return fechaCirugiaNew;
    }

    public void setFechaCirugiaNew(Date fechaCirugiaNew) {
        this.fechaCirugiaNew = fechaCirugiaNew;
    }

    public Boolean getEdemaNew() {
        return edemaNew;
    }

    public void setEdemaNew(Boolean edemaNew) {
        this.edemaNew = edemaNew;
    }

    public String getDolorLocalizacionNew() {
        return dolorLocalizacionNew;
    }

    public void setDolorLocalizacionNew(String dolorLocalizacionNew) {
        this.dolorLocalizacionNew = dolorLocalizacionNew;
    }

    public String getTipoDolorNew() {
        return tipoDolorNew;
    }

    public void setTipoDolorNew(String tipoDolorNew) {
        this.tipoDolorNew = tipoDolorNew;
    }

    public String getFrecuenciaDolorNew() {
        return frecuenciaDolorNew;
    }

    public void setFrecuenciaDolorNew(String frecuenciaDolorNew) {
        this.frecuenciaDolorNew = frecuenciaDolorNew;
    }

    public Integer getCalificacionDolorNew() {
        return calificacionDolorNew;
    }

    public void setCalificacionDolorNew(Integer calificacionDolorNew) {
        this.calificacionDolorNew = calificacionDolorNew;
    }

    public String getMovilidadArticularNew() {
        return movilidadArticularNew;
    }

    public void setMovilidadArticularNew(String movilidadArticularNew) {
        this.movilidadArticularNew = movilidadArticularNew;
    }

    public String getFlexibilidadNew() {
        return flexibilidadNew;
    }

    public void setFlexibilidadNew(String flexibilidadNew) {
        this.flexibilidadNew = flexibilidadNew;
    }

    public String getTrofismoNew() {
        return trofismoNew;
    }

    public void setTrofismoNew(String trofismoNew) {
        this.trofismoNew = trofismoNew;
    }

    public String getTegumentarioNew() {
        return tegumentarioNew;
    }

    public void setTegumentarioNew(String tegumentarioNew) {
        this.tegumentarioNew = tegumentarioNew;
    }

    public String getSensibilidadNew() {
        return sensibilidadNew;
    }

    public void setSensibilidadNew(String sensibilidadNew) {
        this.sensibilidadNew = sensibilidadNew;
    }

    public String getPosturaNew() {
        return posturaNew;
    }

    public void setPosturaNew(String posturaNew) {
        this.posturaNew = posturaNew;
    }

    public String getPlanTratamientoNew() {
        return planTratamientoNew;
    }

    public void setPlanTratamientoNew(String planTratamientoNew) {
        this.planTratamientoNew = planTratamientoNew;
    }

    public String getDiagnosticoFisioterapeuticoNew() {
        return diagnosticoFisioterapeuticoNew;
    }

    public void setDiagnosticoFisioterapeuticoNew(String diagnosticoFisioterapeuticoNew) {
        this.diagnosticoFisioterapeuticoNew = diagnosticoFisioterapeuticoNew;
    }

    public String getMarchaNew() {
        return marchaNew;
    }

    public void setMarchaNew(String marchaNew) {
        this.marchaNew = marchaNew;
    }

    public String getObservacionesNew() {
        return observacionesNew;
    }

    public void setObservacionesNew(String observacionesNew) {
        this.observacionesNew = observacionesNew;
    }

    public Long getCodigoFacturaNew() {
        return codigoFacturaNew;
    }

    public void setCodigoFacturaNew(Long codigoFacturaNew) {
        this.codigoFacturaNew = codigoFacturaNew;
    }

    public Long getValorFacturaNew() {
        return valorFacturaNew;
    }

    public void setValorFacturaNew(Long valorFacturaNew) {
        this.valorFacturaNew = valorFacturaNew;
    }

    public Long getValorCitaNew() {
        return valorCitaNew;
    }

    public void setValorCitaNew(Long valorCitaNew) {
        this.valorCitaNew = valorCitaNew;
    }

    public String getIdFuerzaNew() {
        return idFuerzaNew;
    }

    public void setIdFuerzaNew(String idFuerzaNew) {
        this.idFuerzaNew = idFuerzaNew;
    }

    public Integer getIdPersonalNew() {
        return idPersonalNew;
    }

    public void setIdPersonalNew(Integer idPersonalNew) {
        this.idPersonalNew = idPersonalNew;
    }

    public Integer getIdCausaNew() {
        return idCausaNew;
    }

    public void setIdCausaNew(Integer idCausaNew) {
        this.idCausaNew = idCausaNew;
    }

    public Integer getIdFinalidadConsultaNew() {
        return idFinalidadConsultaNew;
    }

    public void setIdFinalidadConsultaNew(Integer idFinalidadConsultaNew) {
        this.idFinalidadConsultaNew = idFinalidadConsultaNew;
    }

    public Integer getIdTipoDiagnosticoNew() {
        return idTipoDiagnosticoNew;
    }

    public void setIdTipoDiagnosticoNew(Integer idTipoDiagnosticoNew) {
        this.idTipoDiagnosticoNew = idTipoDiagnosticoNew;
    }

    public Integer getIdFinalidadProcedimientoNew() {
        return idFinalidadProcedimientoNew;
    }

    public void setIdFinalidadProcedimientoNew(Integer idFinalidadProcedimientoNew) {
        this.idFinalidadProcedimientoNew = idFinalidadProcedimientoNew;
    }

    public Integer getIdAmbitoProcedimientoNew() {
        return idAmbitoProcedimientoNew;
    }

    public void setIdAmbitoProcedimientoNew(Integer idAmbitoProcedimientoNew) {
        this.idAmbitoProcedimientoNew = idAmbitoProcedimientoNew;
    }

    public Integer getIdCupNew() {
        return idCupNew;
    }

    public void setIdCupNew(Integer idCupNew) {
        this.idCupNew = idCupNew;
    }

    public Integer getIdUsuarioNew() {
        return idUsuarioNew;
    }

    public void setIdUsuarioNew(Integer idUsuarioNew) {
        this.idUsuarioNew = idUsuarioNew;
    }

    public Integer getIdDiagnosticosNew() {
        return idDiagnosticosNew;
    }

    public void setIdDiagnosticosNew(Integer idDiagnosticosNew) {
        this.idDiagnosticosNew = idDiagnosticosNew;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAudita != null ? codigoAudita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditaCitas)) {
            return false;
        }
        AuditaCitas other = (AuditaCitas) object;
        if ((this.codigoAudita == null && other.codigoAudita != null) || (this.codigoAudita != null && !this.codigoAudita.equals(other.codigoAudita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.AuditaCitas[ codigoAudita=" + codigoAudita + " ]";
    }

    
    
}
