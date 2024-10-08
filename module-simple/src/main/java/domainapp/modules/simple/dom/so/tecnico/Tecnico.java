package domainapp.modules.simple.dom.so.tecnico;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;

import domainapp.modules.simple.dom.so.cuadrilla.CuadrillaRepo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.causeway.applib.annotation.*;
import org.apache.causeway.applib.util.ObjectContracts;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = Tecnico.FIND,
                query = "SELECT "
                        + "FROM domainapp.modules.simple.dom.so.tecnico.Tecnico "
                        + "ORDER BY nombre ASC"),
        @NamedQuery(
                name = Tecnico.FIND_BY_DNI,
                query = "SELECT "
                        + "FROM domainapp.modules.simple.dom.so.tecnico.Tecnico "
                        + "ORDER BY dni ASC")
})
@PersistenceCapable(identityType = IdentityType.DATASTORE, schema = SimpleModule.SCHEMA)
@Unique(name = "Tecnico_dni_UNQ", members = {"dni"})
@DomainObjectLayout(bookmarking =  BookmarkPolicy.AS_ROOT)
@ToString(onlyExplicitlyIncluded = true)
@Getter @Setter
public class Tecnico implements Comparable<Tecnico>{

    static final String FIND = "Tecnico.find";
    static final String FIND_BY_DNI = "Tecnico.findByDni";

    @Property()
    @Column(allowsNull = "false",length = 40)
    @Title()
    private  int dni;

    @Property()
    @Column(allowsNull = "false",length = 40)
    @Title()
    private String nombre;

    @Property()
    @Column(allowsNull = "false",length = 40)
    private String apellido;

    @Property()
    @Column(allowsNull = "false",length = 40)
    private String direccion;

    @Column(allowsNull = "false",length = 40)
    @Property()
    private int telefono;

    @Column(allowsNull = "true")
    @Persistent(mappedBy = "tecnico", defaultFetchGroup = "true")
    @Property()
    private List<Cuadrilla> cuadrillaTecnico;

    public Tecnico(int dni, String nombre, String apellido, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Tecnico() {}

    public Tecnico(int dni, String nombre, String apellido, String direccion, int telefono, List<Cuadrilla> cuadrillaTecnico) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuadrillaTecnico = cuadrillaTecnico;
    }

    @Override
    public int compareTo(final Tecnico other) {
        return ObjectContracts.compare(this, other, "dni");
    }

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    CuadrillaRepo cuadrillaRepository;

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    TecRepo tecniRepository;
}
