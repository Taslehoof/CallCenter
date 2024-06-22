package domainapp.modules.simple.dom.so.usuario;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.dom.so.cuadrilla.CuadrillaRepositorio;
import domainapp.modules.simple.dom.so.reclamo.Estado;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;
import domainapp.modules.simple.dom.so.reclamo.TipoReclamo;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.causeway.applib.services.factory.FactoryService;
import org.apache.causeway.applib.services.repository.RepositoryService;
import org.apache.causeway.applib.util.ObjectContracts;
import org.apache.causeway.applib.annotation.*;
import javax.inject.Inject;
import lombok.val;
import domainapp.modules.simple.types.Name;

import org.apache.causeway.persistence.jpa.applib.integration.CausewayEntityListener;

import javax.inject.Named;
import javax.jdo.annotations.*;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    schema = SimpleModule.SCHEMA_reclamos,
    uniqueConstraints = {
        @UniqueConstraint(name = "Usuario_dni_UNQ", columnNames = {"dni"})
    }
)
@NamedQueries({
        @NamedQuery(
                name = Usuario.FIND,
                query = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.usuario.Usuario"
                + "ORDER BY nombre ASC"),
        @NamedQuery(
                name = Usuario.FIND_BY_NRO_RECLAMO,
                query = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.usuario.Usuario"
                + "WHERE dni == :dni"
                + "ORDER BY dni ASC")
})
@EntityListeners(CausewayEntityListener.class)
@Named(SimpleModule.NAMESPACE_reclamos+".Usuario")
@DomainObject(entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@ToString(onlyExplicitlyIncluded = true)
public class Usuario implements Comparable<Usuario>{

    static final String FIND = " Usuario.find";
    static final String FIND_BY_NRO_RECLAMO = " Usuario.findByNroReclamo";

    @Column(allowsNull = "false", length = 8)
    @Property()
    @Id
    @Title()
    private int dni;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String nombre;

    @Column(allowsNull = "false", length = 40)
    @Property()
    private String apellido;

    @Column(allowsNull = "false", length = 40)
    @Property()
    private String direccion;

    @Column(allowsNull = "false", length = 40)
    @Property()
    private String email;

    @Column(allowsNull = "false", length = 19)
    @Property()
    private int telefono;

    @Persistent(mappedBy = "usuario", dependentElement = "true")
    @Collection()
    private List<Reclamo> reclamos = new ArrayList<Reclamo>();

    public static Usuario withName(final String nombre) {
        val usuario = new Usuario();
        usuario.setNombre(nombre);
        return usuario;
    }


    public int RepoDni(){return this.dni;}
    public String RepoNombre(){return this.nombre;}
    public String RepoApellido(){return this.apellido;}
    public String RepoDireccion(){return this.direccion;}
    public int RepoTelefono(){return this.telefono;}

    public Usuario() {}

    public Usuario(int dni, String nombre, String apellido, String direccion, String email, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public Usuario(int dni, String nombre, String apellido, String direccion, String email, int telefono, List<Reclamo> reclamos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.reclamos = reclamos;
    }

    public int default0Update(){return getDni();}
    public String default1Update(){return getNombre();}
    public String default2Update(){return getApellido();}
    public String default3Update(){return getDireccion();}
    public String default4Update(){return getEmail();}
    public int default5Update(){return getTelefono();}

    @Action()
    @ActionLayout(named = "Cargar reclamo")
    public Usuario addReclamo(@ParameterLayout(named = "Tipo de Reclamo") final TipoReclamo tipoReclamo){
        //final Reclamo reclamo = factoryService.instantiate(Reclamo.class);
        final Reclamo reclamo = factoryService.create(Reclamo.class);
        reclamo.setUsuario(this);
        reclamo.setDireccion(this.direccion);
        reclamo.setFecha(LocalDate.now());
        reclamo.setTipoReclamo(tipoReclamo);
        reclamo.setEstado(Estado.Sin_Asignar);
        getReclamos().add(reclamo);
        repositoryService.persist(reclamo);
        return this;
    }

    @Override
    public int compareTo(final Usuario other) {
        return ObjectContracts.compare(this, other, "dni");
    }

    @Override
    public String toString() {
        return ObjectContracts.toString(this,"dni");
    }

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    FactoryService factoryService;

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    CuadrillaRepositorio cuadrillaRepository;

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    Usuarios usuarioRepository;
}
