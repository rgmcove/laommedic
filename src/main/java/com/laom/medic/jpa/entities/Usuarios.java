/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laom.medic.jpa.entities;

import com.laom.medic.rest.auth.DigestUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neney
 */
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByIdentRol", query = "SELECT u FROM Usuarios u WHERE u.idIdentificacion LIKE :idIdentificacion AND :idRol MEMBER OF u.rolesList"),
    @NamedQuery(name = "Usuarios.findByIdSede", query = "SELECT u FROM Usuarios u WHERE :idSede MEMBER OF u.sedesList"),
    @NamedQuery(name = "Usuarios.findByIdIdentificacion", query = "SELECT u FROM Usuarios u WHERE u.idIdentificacion LIKE :idIdentificacion"),
    @NamedQuery(name = "Usuarios.findByPrimerNombre", query = "SELECT u FROM Usuarios u WHERE u.primerNombre = :primerNombre"),
    @NamedQuery(name = "Usuarios.findBySegundoNombre", query = "SELECT u FROM Usuarios u WHERE u.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuarios.findByEdad", query = "SELECT u FROM Usuarios u WHERE u.edad = :edad"),
    @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByEmail2", query = "SELECT u FROM Usuarios u WHERE u.email2 = :email2"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByRecuperacionPass", query = "SELECT u FROM Usuarios u WHERE u.recuperacionPass = :recuperacionPass"),
    @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuarios.findByTelefono2", query = "SELECT u FROM Usuarios u WHERE u.telefono2 = :telefono2"),
    @NamedQuery(name = "Usuarios.findByFechaIngreso", query = "SELECT u FROM Usuarios u WHERE u.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Usuarios.findByEmpresa", query = "SELECT u FROM Usuarios u WHERE u.empresa = :empresa"),
    @NamedQuery(name = "Usuarios.findByTelefonoEmpresa", query = "SELECT u FROM Usuarios u WHERE u.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "Usuarios.findBySesionesOrdenadas", query = "SELECT u FROM Usuarios u WHERE u.sesionesOrdenadas = :sesionesOrdenadas")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_identificacion")
    private String idIdentificacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "primer_nombre")
    private String primerNombre;

    @Size(max = 25)
    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "primer_apellido")
    private String primerApellido;

    @Size(max = 25)
    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name = "edad")
    private Short edad;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;

    @Size(max = 100)
    @Column(name = "email_2")
    private String email2;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password")
    private String password;
    
    @Size(max = 64)
    @Column(name = "recuperacion_pass")
    private String recuperacionPass;

    @Size(max = 30)
    @Column(name = "direccion")
    private String direccion;

    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;

    @Size(max = 15)
    @Column(name = "telefono_2")
    private String telefono2;

    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Size(max = 100)
    @Column(name = "empresa")
    private String empresa;

    @Size(max = 15)
    @Column(name = "telefono_empresa")
    private String telefonoEmpresa;

    @Column(name = "sesiones_ordenadas")
    private Integer sesionesOrdenadas;

    @JoinTable(name = "USUARIOS_has_OCUPACIONES", joinColumns = {
        @JoinColumn(name = "USUARIOS_id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "OCUPACIONES_id_ocupacion", referencedColumnName = "id_ocupacion")})
    @ManyToMany
    private List<Ocupaciones> ocupacionesList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Citas> citasList;

    @JoinTable(name = "USUARIOS_has_ANTECEDENTES", joinColumns = {
        @JoinColumn(name = "USUARIOS_id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "ANTECEDENTES_id_antecedente", referencedColumnName = "id_antecedente")})
    @ManyToMany
    private List<Antecedentes> antecedentesList;

    @JoinTable(name = "USUARIOS_has_SEDES", joinColumns = {
        @JoinColumn(name = "USUARIOS_id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "SEDES_id_sedes", referencedColumnName = "id_sedes")})
    @ManyToMany
    private List<Sedes> sedesList;

    @JoinTable(name = "ROLES_DE_USUARIOS", joinColumns = {
        @JoinColumn(name = "USUARIOS_id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "ROLES_id_roles", referencedColumnName = "id_roles")})
    @ManyToMany
    private List<Roles> rolesList;

    @JoinColumn(name = "id_escolaridad", referencedColumnName = "id_escolaridad")
    @ManyToOne
    private Escolaridades idEscolaridad;

    @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad")
    @ManyToOne
    private Entidades idEntidad;

    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")})
    @ManyToOne
    private Ciudades ciudades;

    @JoinColumn(name = "codigo_entidad", referencedColumnName = "codigo_entidad")
    @ManyToOne
    private EntidadesAdministradoras codigoEntidad;

    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id_estado_civil")
    @ManyToOne
    private EstadosCiviles idEstadoCivil;

    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    @ManyToOne
    private Generos idGenero;

    @JoinColumn(name = "id_ips", referencedColumnName = "id_ips")
    @ManyToOne
    private Ips idIps;

    @JoinColumn(name = "id_tipo_sangre", referencedColumnName = "id_tipo_sangre")
    @ManyToOne
    private TiposSangre idTipoSangre;

    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
    @ManyToOne
    private TiposUsuarios idTipoUsuario;

    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne
    private TipoAfiliados codigo;

    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumentos idTipoDocumento;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String idIdentificacion, String primerNombre, String primerApellido, Date fechaNacimiento, Short edad, String email, String password) {
        this.idUsuario = idUsuario;
        this.idIdentificacion = idIdentificacion;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.email = email;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(String idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = DigestUtil.generateDigest(password);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRecuperacionPass() {
        return recuperacionPass;
    }

    public void setRecuperacionPass(String recuperacionPass) {
        this.recuperacionPass = recuperacionPass;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public Integer getSesionesOrdenadas() {
        return sesionesOrdenadas;
    }

    public void setSesionesOrdenadas(Integer sesionesOrdenadas) {
        this.sesionesOrdenadas = sesionesOrdenadas;
    }

    public List<Ocupaciones> getOcupacionesList() {
        return ocupacionesList;
    }

    public void setOcupacionesList(List<Ocupaciones> ocupacionesList) {
        this.ocupacionesList = ocupacionesList;
    }

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    public List<Antecedentes> getAntecedentesList() {
        return antecedentesList;
    }

    public void setAntecedentesList(List<Antecedentes> antecedentesList) {
        this.antecedentesList = antecedentesList;
    }

    public List<Sedes> getSedesList() {
        return sedesList;
    }

    public void setSedesList(List<Sedes> sedesList) {
        this.sedesList = sedesList;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public Escolaridades getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(Escolaridades idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    public EntidadesAdministradoras getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(EntidadesAdministradoras codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public EstadosCiviles getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadosCiviles idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Generos getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Generos idGenero) {
        this.idGenero = idGenero;
    }

    public Ips getIdIps() {
        return idIps;
    }

    public void setIdIps(Ips idIps) {
        this.idIps = idIps;
    }

    public TiposSangre getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(TiposSangre idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public TiposUsuarios getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TiposUsuarios idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TipoAfiliados getCodigo() {
        return codigo;
    }

    public void setCodigo(TipoAfiliados codigo) {
        this.codigo = codigo;
    }

    public TipoDocumentos getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumentos idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.laom.medic.jpa.entities.Usuarios[ idUsuario=" + idUsuario + " ]";
    }

}
