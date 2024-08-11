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
import org.apache.causeway.persistence.jpa.applib.integration.CausewayEntityListener;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table()
@EntityListeners(CausewayEntityListener.class)
//@Named(SimpleModule.NAMESPACE_reclamos+".Tecnico")
@DomainObject(entityChangePublishing = Publishing.DISABLED)
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@DomainObjectLayout(bookmarking =  BookmarkPolicy.AS_ROOT)
@ToString(onlyExplicitlyIncluded = true)
@Getter @Setter
public class Tecnico implements Comparable<Tecnico>{

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
