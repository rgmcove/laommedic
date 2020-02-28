/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "audita_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditaUsuarios.findAll", query = "SELECT a FROM AuditaUsuarios a"),
    @NamedQuery(name = "AuditaUsuarios.findByCodigo", query = "SELECT a FROM AuditaUsuarios a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "AuditaUsuarios.findByUsuario", query = "SELECT a FROM AuditaUsuarios a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AuditaUsuarios.findByIdIdentificacionOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idIdentificacionOld = :idIdentificacionOld"),
    @NamedQuery(name = "AuditaUsuarios.findByPrimerNombreOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.primerNombreOld = :primerNombreOld"),
    @NamedQuery(name = "AuditaUsuarios.findBySegundoNombreOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.segundoNombreOld = :segundoNombreOld"),
    @NamedQuery(name = "AuditaUsuarios.findByPrimerApellidoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.primerApellidoOld = :primerApellidoOld"),
    @NamedQuery(name = "AuditaUsuarios.findBySegundoApellidoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.segundoApellidoOld = :segundoApellidoOld"),
    @NamedQuery(name = "AuditaUsuarios.findByFechaNacimientoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.fechaNacimientoOld = :fechaNacimientoOld"),
    @NamedQuery(name = "AuditaUsuarios.findByEmailOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.emailOld = :emailOld"),
    @NamedQuery(name = "AuditaUsuarios.findByEmail2Old", query = "SELECT a FROM AuditaUsuarios a WHERE a.email2Old = :email2Old"),
    @NamedQuery(name = "AuditaUsuarios.findByPasswordOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.passwordOld = :passwordOld"),
    @NamedQuery(name = "AuditaUsuarios.findByDireccionOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.direccionOld = :direccionOld"),
    @NamedQuery(name = "AuditaUsuarios.findByTelefonoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.telefonoOld = :telefonoOld"),
    @NamedQuery(name = "AuditaUsuarios.findByTelefono2Old", query = "SELECT a FROM AuditaUsuarios a WHERE a.telefono2Old = :telefono2Old"),
    @NamedQuery(name = "AuditaUsuarios.findByFechaIngresoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.fechaIngresoOld = :fechaIngresoOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdEstadoCivilOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idEstadoCivilOld = :idEstadoCivilOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdEscolaridadOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idEscolaridadOld = :idEscolaridadOld"),
    @NamedQuery(name = "AuditaUsuarios.findByEmpresaOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.empresaOld = :empresaOld"),
    @NamedQuery(name = "AuditaUsuarios.findByTelefonoEmpresaOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.telefonoEmpresaOld = :telefonoEmpresaOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdCiudadOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idCiudadOld = :idCiudadOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdDepartamentoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idDepartamentoOld = :idDepartamentoOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdEntidadOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idEntidadOld = :idEntidadOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdTipoDocumentoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idTipoDocumentoOld = :idTipoDocumentoOld"),
    @NamedQuery(name = "AuditaUsuarios.findBySesionesOrdenadasOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.sesionesOrdenadasOld = :sesionesOrdenadasOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdTipoUsuarioOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idTipoUsuarioOld = :idTipoUsuarioOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdGeneroOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idGeneroOld = :idGeneroOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdTipoSangreOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idTipoSangreOld = :idTipoSangreOld"),
    @NamedQuery(name = "AuditaUsuarios.findByCodigoOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.codigoOld = :codigoOld"),
    @NamedQuery(name = "AuditaUsuarios.findByCodigoEntidadOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.codigoEntidadOld = :codigoEntidadOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdIpsOld", query = "SELECT a FROM AuditaUsuarios a WHERE a.idIpsOld = :idIpsOld"),
    @NamedQuery(name = "AuditaUsuarios.findByIdIdentificacionNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idIdentificacionNew = :idIdentificacionNew"),
    @NamedQuery(name = "AuditaUsuarios.findByPrimerNombreNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.primerNombreNew = :primerNombreNew"),
    @NamedQuery(name = "AuditaUsuarios.findBySegundoNombreNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.segundoNombreNew = :segundoNombreNew"),
    @NamedQuery(name = "AuditaUsuarios.findByPrimerApellidoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.primerApellidoNew = :primerApellidoNew"),
    @NamedQuery(name = "AuditaUsuarios.findBySegundoApellidoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.segundoApellidoNew = :segundoApellidoNew"),
    @NamedQuery(name = "AuditaUsuarios.findByFechaNacimientoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.fechaNacimientoNew = :fechaNacimientoNew"),
    @NamedQuery(name = "AuditaUsuarios.findByEmailNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.emailNew = :emailNew"),
    @NamedQuery(name = "AuditaUsuarios.findByEmail2New", query = "SELECT a FROM AuditaUsuarios a WHERE a.email2New = :email2New"),
    @NamedQuery(name = "AuditaUsuarios.findByPasswordNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.passwordNew = :passwordNew"),
    @NamedQuery(name = "AuditaUsuarios.findByDireccionNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.direccionNew = :direccionNew"),
    @NamedQuery(name = "AuditaUsuarios.findByTelefonoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.telefonoNew = :telefonoNew"),
    @NamedQuery(name = "AuditaUsuarios.findByTelefono2New", query = "SELECT a FROM AuditaUsuarios a WHERE a.telefono2New = :telefono2New"),
    @NamedQuery(name = "AuditaUsuarios.findByFechaIngresoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.fechaIngresoNew = :fechaIngresoNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdEstadoCivilNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idEstadoCivilNew = :idEstadoCivilNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdEscolaridadNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idEscolaridadNew = :idEscolaridadNew"),
    @NamedQuery(name = "AuditaUsuarios.findByEmpresaNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.empresaNew = :empresaNew"),
    @NamedQuery(name = "AuditaUsuarios.findByTelefonoEmpresaNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.telefonoEmpresaNew = :telefonoEmpresaNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdCiudadNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idCiudadNew = :idCiudadNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdDepartamentoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idDepartamentoNew = :idDepartamentoNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdEntidadNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idEntidadNew = :idEntidadNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdTipoDocumentoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idTipoDocumentoNew = :idTipoDocumentoNew"),
    @NamedQuery(name = "AuditaUsuarios.findBySesionesOrdenadasNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.sesionesOrdenadasNew = :sesionesOrdenadasNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdTipoUsuarioNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idTipoUsuarioNew = :idTipoUsuarioNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdGeneroNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idGeneroNew = :idGeneroNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdTipoSangreNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idTipoSangreNew = :idTipoSangreNew"),
    @NamedQuery(name = "AuditaUsuarios.findByCodigoNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.codigoNew = :codigoNew"),
    @NamedQuery(name = "AuditaUsuarios.findByCodigoEntidadNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.codigoEntidadNew = :codigoEntidadNew"),
    @NamedQuery(name = "AuditaUsuarios.findByIdIpsNew", query = "SELECT a FROM AuditaUsuarios a WHERE a.idIpsNew = :idIpsNew"),
    @NamedQuery(name = "AuditaUsuarios.findByFechaModificacion", query = "SELECT a FROM AuditaUsuarios a WHERE a.fechaModificacion = :fechaModificacion")})
public class AuditaUsuarios implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "id_identificacion_old")
    private String idIdentificacionOld;
    
    @Size(max = 25)
    @Column(name = "primer_nombre_old")
    private String primerNombreOld;
    
    @Size(max = 25)
    @Column(name = "segundo_nombre_old")
    private String segundoNombreOld;
    
    @Size(max = 25)
    @Column(name = "primer_apellido_old")
    private String primerApellidoOld;
    
    @Size(max = 25)
    @Column(name = "segundo_apellido_old")
    private String segundoApellidoOld;
    
    @Column(name = "fecha_nacimiento_old")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoOld;
    
    @Column(name = "edad_old")
    private Short edadOld;
    
    @Size(max = 100)
    @Column(name = "email_old")
    private String emailOld;
    
    @Size(max = 100)
    @Column(name = "email_2_old")
    private String email2Old;
    
    @Size(max = 64)
    @Column(name = "password_old")
    private String passwordOld;
    
    @Size(max = 64)
    @Column(name = "recuperacion_pass_old")
    private String recuperacionPassOld;
    
    @Size(max = 30)
    @Column(name = "direccion_old")
    private String direccionOld;
    
    @Size(max = 15)
    @Column(name = "telefono_old")
    private String telefonoOld;
    
    @Size(max = 15)
    @Column(name = "telefono_2_old")
    private String telefono2Old;
    
    @Column(name = "fecha_ingreso_old")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoOld;
    
    @Column(name = "id_estado_civil_old")
    private Integer idEstadoCivilOld;
    
    @Column(name = "id_escolaridad_old")
    private Integer idEscolaridadOld;
    
    @Size(max = 100)
    @Column(name = "empresa_old")
    private String empresaOld;
    
    @Size(max = 15)
    @Column(name = "telefono_empresa_old")
    private String telefonoEmpresaOld;
    
    @Column(name = "id_ciudad_old")
    private Integer idCiudadOld;
    
    @Column(name = "id_departamento_old")
    private Integer idDepartamentoOld;
    
    @Size(max = 5)
    @Column(name = "id_entidad_old")
    private String idEntidadOld;
    
    @Size(max = 3)
    @Column(name = "id_tipo_documento_old")
    private String idTipoDocumentoOld;
    
    @Column(name = "sesiones_ordenadas_old")
    private Integer sesionesOrdenadasOld;
    
    @Column(name = "id_tipo_usuario_old")
    private Integer idTipoUsuarioOld;
    
    @Column(name = "id_genero_old")
    private Integer idGeneroOld;
    
    @Column(name = "id_tipo_sangre_old")
    private Integer idTipoSangreOld;
    
    @Column(name = "codigo_old")
    private Integer codigoOld;
    
    @Size(max = 10)
    @Column(name = "codigo_entidad_old")
    private String codigoEntidadOld;
    
    @Size(max = 10)
    @Column(name = "id_ips_old")
    private String idIpsOld;
    
    @Column(name = "id_identificacion_new")
    private String idIdentificacionNew;
    
    @Size(max = 25)
    @Column(name = "primer_nombre_new")
    private String primerNombreNew;
    
    @Size(max = 25)
    @Column(name = "segundo_nombre_new")
    private String segundoNombreNew;
    
    @Size(max = 25)
    @Column(name = "primer_apellido_new")
    private String primerApellidoNew;
    
    @Size(max = 25)
    @Column(name = "segundo_apellido_new")
    private String segundoApellidoNew;
    
    @Column(name = "fecha_nacimiento_new")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoNew;
    
    @Column(name = "edad_new")
    private Short edadNew;
    
    @Size(max = 100)
    @Column(name = "email_new")
    private String emailNew;
    
    @Size(max = 100)
    @Column(name = "email_2_new")
    private String email2New;
    
    @Size(max = 64)
    @Column(name = "password_new")
    private String passwordNew;
    
    @Size(max = 64)
    @Column(name = "recuperacion_pass_new")
    private String recuperacionPassNew;
    
    @Size(max = 30)
    @Column(name = "direccion_new")
    private String direccionNew;
    
    @Size(max = 15)
    @Column(name = "telefono_new")
    private String telefonoNew;
    
    @Size(max = 15)
    @Column(name = "telefono_2_new")
    private String telefono2New;
    
    @Column(name = "fecha_ingreso_new")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoNew;
    
    @Column(name = "id_estado_civil_new")
    private Integer idEstadoCivilNew;
    
    @Column(name = "id_escolaridad_new")
    private Integer idEscolaridadNew;
    
    @Size(max = 100)
    @Column(name = "empresa_new")
    private String empresaNew;
    
    @Size(max = 15)
    @Column(name = "telefono_empresa_new")
    private String telefonoEmpresaNew;
    
    @Column(name = "id_ciudad_new")
    private Integer idCiudadNew;
    
    @Column(name = "id_departamento_new")
    private Integer idDepartamentoNew;
    
    @Size(max = 5)
    @Column(name = "id_entidad_new")
    private String idEntidadNew;
    
    @Size(max = 3)
    @Column(name = "id_tipo_documento_new")
    private String idTipoDocumentoNew;
    
    @Column(name = "sesiones_ordenadas_new")
    private Integer sesionesOrdenadasNew;
    
    @Column(name = "id_tipo_usuario_new")
    private Integer idTipoUsuarioNew;
    
    @Column(name = "id_genero_new")
    private Integer idGeneroNew;
    
    @Column(name = "id_tipo_sangre_new")
    private Integer idTipoSangreNew;
    
    @Column(name = "codigo_new")
    private Integer codigoNew;
    
    @Size(max = 10)
    @Column(name = "codigo_entidad_new")
    private String codigoEntidadNew;
    
    @Size(max = 10)
    @Column(name = "id_ips_new")
    private String idIpsNew;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public AuditaUsuarios() {
    }

    public AuditaUsuarios(Integer codigo) {
        this.codigo = codigo;
    }

    public AuditaUsuarios(Integer codigo, String usuario) {
        this.codigo = codigo;
        this.usuario = usuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIdIdentificacionOld() {
        return idIdentificacionOld;
    }

    public void setIdIdentificacionOld(String idIdentificacionOld) {
        this.idIdentificacionOld = idIdentificacionOld;
    }

    public String getPrimerNombreOld() {
        return primerNombreOld;
    }

    public void setPrimerNombreOld(String primerNombreOld) {
        this.primerNombreOld = primerNombreOld;
    }

    public String getSegundoNombreOld() {
        return segundoNombreOld;
    }

    public void setSegundoNombreOld(String segundoNombreOld) {
        this.segundoNombreOld = segundoNombreOld;
    }

    public String getPrimerApellidoOld() {
        return primerApellidoOld;
    }

    public void setPrimerApellidoOld(String primerApellidoOld) {
        this.primerApellidoOld = primerApellidoOld;
    }

    public String getSegundoApellidoOld() {
        return segundoApellidoOld;
    }

    public void setSegundoApellidoOld(String segundoApellidoOld) {
        this.segundoApellidoOld = segundoApellidoOld;
    }

    public Date getFechaNacimientoOld() {
        return fechaNacimientoOld;
    }

    public void setFechaNacimientoOld(Date fechaNacimientoOld) {
        this.fechaNacimientoOld = fechaNacimientoOld;
    }

    public Short getEdadOld() {
        return edadOld;
    }

    public void setEdadOld(Short edadOld) {
        this.edadOld = edadOld;
    }

    public String getEmailOld() {
        return emailOld;
    }

    public void setEmailOld(String emailOld) {
        this.emailOld = emailOld;
    }

    public String getEmail2Old() {
        return email2Old;
    }

    public void setEmail2Old(String email2Old) {
        this.email2Old = email2Old;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getRecuperacionPassOld() {
        return recuperacionPassOld;
    }

    public void setRecuperacionPassOld(String recuperacionPassOld) {
        this.recuperacionPassOld = recuperacionPassOld;
    }

    public String getDireccionOld() {
        return direccionOld;
    }

    public void setDireccionOld(String direccionOld) {
        this.direccionOld = direccionOld;
    }

    public String getTelefonoOld() {
        return telefonoOld;
    }

    public void setTelefonoOld(String telefonoOld) {
        this.telefonoOld = telefonoOld;
    }

    public String getTelefono2Old() {
        return telefono2Old;
    }

    public void setTelefono2Old(String telefono2Old) {
        this.telefono2Old = telefono2Old;
    }

    public Date getFechaIngresoOld() {
        return fechaIngresoOld;
    }

    public void setFechaIngresoOld(Date fechaIngresoOld) {
        this.fechaIngresoOld = fechaIngresoOld;
    }

    public Integer getIdEstadoCivilOld() {
        return idEstadoCivilOld;
    }

    public void setIdEstadoCivilOld(Integer idEstadoCivilOld) {
        this.idEstadoCivilOld = idEstadoCivilOld;
    }

    public Integer getIdEscolaridadOld() {
        return idEscolaridadOld;
    }

    public void setIdEscolaridadOld(Integer idEscolaridadOld) {
        this.idEscolaridadOld = idEscolaridadOld;
    }

    public String getEmpresaOld() {
        return empresaOld;
    }

    public void setEmpresaOld(String empresaOld) {
        this.empresaOld = empresaOld;
    }

    public String getTelefonoEmpresaOld() {
        return telefonoEmpresaOld;
    }

    public void setTelefonoEmpresaOld(String telefonoEmpresaOld) {
        this.telefonoEmpresaOld = telefonoEmpresaOld;
    }

    public Integer getIdCiudadOld() {
        return idCiudadOld;
    }

    public void setIdCiudadOld(Integer idCiudadOld) {
        this.idCiudadOld = idCiudadOld;
    }

    public Integer getIdDepartamentoOld() {
        return idDepartamentoOld;
    }

    public void setIdDepartamentoOld(Integer idDepartamentoOld) {
        this.idDepartamentoOld = idDepartamentoOld;
    }

    public String getIdEntidadOld() {
        return idEntidadOld;
    }

    public void setIdEntidadOld(String idEntidadOld) {
        this.idEntidadOld = idEntidadOld;
    }

    public String getIdTipoDocumentoOld() {
        return idTipoDocumentoOld;
    }

    public void setIdTipoDocumentoOld(String idTipoDocumentoOld) {
        this.idTipoDocumentoOld = idTipoDocumentoOld;
    }

    public Integer getSesionesOrdenadasOld() {
        return sesionesOrdenadasOld;
    }

    public void setSesionesOrdenadasOld(Integer sesionesOrdenadasOld) {
        this.sesionesOrdenadasOld = sesionesOrdenadasOld;
    }

    public Integer getIdTipoUsuarioOld() {
        return idTipoUsuarioOld;
    }

    public void setIdTipoUsuarioOld(Integer idTipoUsuarioOld) {
        this.idTipoUsuarioOld = idTipoUsuarioOld;
    }

    public Integer getIdGeneroOld() {
        return idGeneroOld;
    }

    public void setIdGeneroOld(Integer idGeneroOld) {
        this.idGeneroOld = idGeneroOld;
    }

    public Integer getIdTipoSangreOld() {
        return idTipoSangreOld;
    }

    public void setIdTipoSangreOld(Integer idTipoSangreOld) {
        this.idTipoSangreOld = idTipoSangreOld;
    }

    public Integer getCodigoOld() {
        return codigoOld;
    }

    public void setCodigoOld(Integer codigoOld) {
        this.codigoOld = codigoOld;
    }

    public String getCodigoEntidadOld() {
        return codigoEntidadOld;
    }

    public void setCodigoEntidadOld(String codigoEntidadOld) {
        this.codigoEntidadOld = codigoEntidadOld;
    }

    public String getIdIpsOld() {
        return idIpsOld;
    }

    public void setIdIpsOld(String idIpsOld) {
        this.idIpsOld = idIpsOld;
    }

    public String getIdIdentificacionNew() {
        return idIdentificacionNew;
    }

    public void setIdIdentificacionNew(String idIdentificacionNew) {
        this.idIdentificacionNew = idIdentificacionNew;
    }

    public String getPrimerNombreNew() {
        return primerNombreNew;
    }

    public void setPrimerNombreNew(String primerNombreNew) {
        this.primerNombreNew = primerNombreNew;
    }

    public String getSegundoNombreNew() {
        return segundoNombreNew;
    }

    public void setSegundoNombreNew(String segundoNombreNew) {
        this.segundoNombreNew = segundoNombreNew;
    }

    public String getPrimerApellidoNew() {
        return primerApellidoNew;
    }

    public void setPrimerApellidoNew(String primerApellidoNew) {
        this.primerApellidoNew = primerApellidoNew;
    }

    public String getSegundoApellidoNew() {
        return segundoApellidoNew;
    }

    public void setSegundoApellidoNew(String segundoApellidoNew) {
        this.segundoApellidoNew = segundoApellidoNew;
    }

    public Date getFechaNacimientoNew() {
        return fechaNacimientoNew;
    }

    public void setFechaNacimientoNew(Date fechaNacimientoNew) {
        this.fechaNacimientoNew = fechaNacimientoNew;
    }

    public Short getEdadNew() {
        return edadNew;
    }

    public void setEdadNew(Short edadNew) {
        this.edadNew = edadNew;
    }

    public String getEmailNew() {
        return emailNew;
    }

    public void setEmailNew(String emailNew) {
        this.emailNew = emailNew;
    }

    public String getEmail2New() {
        return email2New;
    }

    public void setEmail2New(String email2New) {
        this.email2New = email2New;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getRecuperacionPassNew() {
        return recuperacionPassNew;
    }

    public void setRecuperacionPassNew(String recuperacionPassNew) {
        this.recuperacionPassNew = recuperacionPassNew;
    }

    public String getDireccionNew() {
        return direccionNew;
    }

    public void setDireccionNew(String direccionNew) {
        this.direccionNew = direccionNew;
    }

    public String getTelefonoNew() {
        return telefonoNew;
    }

    public void setTelefonoNew(String telefonoNew) {
        this.telefonoNew = telefonoNew;
    }

    public String getTelefono2New() {
        return telefono2New;
    }

    public void setTelefono2New(String telefono2New) {
        this.telefono2New = telefono2New;
    }

    public Date getFechaIngresoNew() {
        return fechaIngresoNew;
    }

    public void setFechaIngresoNew(Date fechaIngresoNew) {
        this.fechaIngresoNew = fechaIngresoNew;
    }

    public Integer getIdEstadoCivilNew() {
        return idEstadoCivilNew;
    }

    public void setIdEstadoCivilNew(Integer idEstadoCivilNew) {
        this.idEstadoCivilNew = idEstadoCivilNew;
    }

    public Integer getIdEscolaridadNew() {
        return idEscolaridadNew;
    }

    public void setIdEscolaridadNew(Integer idEscolaridadNew) {
        this.idEscolaridadNew = idEscolaridadNew;
    }

    public String getEmpresaNew() {
        return empresaNew;
    }

    public void setEmpresaNew(String empresaNew) {
        this.empresaNew = empresaNew;
    }

    public String getTelefonoEmpresaNew() {
        return telefonoEmpresaNew;
    }

    public void setTelefonoEmpresaNew(String telefonoEmpresaNew) {
        this.telefonoEmpresaNew = telefonoEmpresaNew;
    }

    public Integer getIdCiudadNew() {
        return idCiudadNew;
    }

    public void setIdCiudadNew(Integer idCiudadNew) {
        this.idCiudadNew = idCiudadNew;
    }

    public Integer getIdDepartamentoNew() {
        return idDepartamentoNew;
    }

    public void setIdDepartamentoNew(Integer idDepartamentoNew) {
        this.idDepartamentoNew = idDepartamentoNew;
    }

    public String getIdEntidadNew() {
        return idEntidadNew;
    }

    public void setIdEntidadNew(String idEntidadNew) {
        this.idEntidadNew = idEntidadNew;
    }

    public String getIdTipoDocumentoNew() {
        return idTipoDocumentoNew;
    }

    public void setIdTipoDocumentoNew(String idTipoDocumentoNew) {
        this.idTipoDocumentoNew = idTipoDocumentoNew;
    }

    public Integer getSesionesOrdenadasNew() {
        return sesionesOrdenadasNew;
    }

    public void setSesionesOrdenadasNew(Integer sesionesOrdenadasNew) {
        this.sesionesOrdenadasNew = sesionesOrdenadasNew;
    }

    public Integer getIdTipoUsuarioNew() {
        return idTipoUsuarioNew;
    }

    public void setIdTipoUsuarioNew(Integer idTipoUsuarioNew) {
        this.idTipoUsuarioNew = idTipoUsuarioNew;
    }

    public Integer getIdGeneroNew() {
        return idGeneroNew;
    }

    public void setIdGeneroNew(Integer idGeneroNew) {
        this.idGeneroNew = idGeneroNew;
    }

    public Integer getIdTipoSangreNew() {
        return idTipoSangreNew;
    }

    public void setIdTipoSangreNew(Integer idTipoSangreNew) {
        this.idTipoSangreNew = idTipoSangreNew;
    }

    public Integer getCodigoNew() {
        return codigoNew;
    }

    public void setCodigoNew(Integer codigoNew) {
        this.codigoNew = codigoNew;
    }

    public String getCodigoEntidadNew() {
        return codigoEntidadNew;
    }

    public void setCodigoEntidadNew(String codigoEntidadNew) {
        this.codigoEntidadNew = codigoEntidadNew;
    }

    public String getIdIpsNew() {
        return idIpsNew;
    }

    public void setIdIpsNew(String idIpsNew) {
        this.idIpsNew = idIpsNew;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditaUsuarios)) {
            return false;
        }
        AuditaUsuarios other = (AuditaUsuarios) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.AuditaUsuarios[ codigo=" + codigo + " ]";
    }
    
}
