package domainapp.modules.simple.dom.so.usuario;

import domainapp.modules.simple.dom.so.cuadrilla.CuadrillaRepositorio;
import domainapp.modules.simple.dom.so.reclamo.Estado;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;
import domainapp.modules.simple.dom.so.reclamo.TipoReclamo;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import javax.inject.Inject;
import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(identityType = IdentityType.DATASTORE, schema = "simple", table = "Usuario")
@DatastoreIdentity(strategy = IdGeneratorStrategy.IDENTITY, column = "id")
@Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@Queries({
        @Query(
                name = "find", language = "JDOQL",
                value = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.usuario.Usuario"
                + "ORDER BY nombre ASC"),
        @Query(
                name = "findByNroReclamo", language = "JDOQL",
                value = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.usuario.Usuario"
                + "WHERE dni == :dni"
                + "ORDER BY dni ASC")
})
@Unique(name = "Usuario_dni_UNQ", members = {"dni"})
@DomainObject(editing = Editing.DISABLED)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@Getter @Setter
public class Usuario implements Comparable<Usuario>{

    @Column(allowsNull = "false", length = 8)
    @Property()
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

    @Override
    public String toString() {
        return ObjectContracts.toString(this,"dni");
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

    @Action()
    @ActionLayout(named = "Cargar reclamo")
    public Usuario addReclamo(@ParameterLayout(named = "Tipo de Reclamo") final TipoReclamo tipoReclamo){
        final Reclamo reclamo = factoryService.instantiate(Reclamo.class);
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
    UsuarioRepositorio usuarioRepository;
}
