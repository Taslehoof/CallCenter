package domainapp.modules.simple.dom.so.reclamo;

import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import domainapp.modules.simple.dom.so.usuario.Usuario;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainObject;
import org.apache.causeway.applib.annotation.DomainObjectLayout;
import org.apache.causeway.applib.annotation.Editing;
import org.apache.causeway.applib.annotation.Property;
import org.apache.causeway.applib.annotation.PropertyLayout;
import org.apache.causeway.applib.annotation.Title;

import javax.jdo.annotations.*;
import java.time.LocalDate;

@PersistenceCapable( identityType = IdentityType.DATASTORE, schema = "simple", table = "Reclamo")
@DatastoreIdentity(strategy = IdGeneratorStrategy.IDENTITY,column = "id")
@Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@Queries({
        @Query(
                name = "find", language = "JDOQL",
                value = "SELECT "),
        @Query(
                name = "findLast", language = "JDOQL",
                value = "SELECT "
                        + "ORDER BY nroReclamo DESC"),
        @Query(
                name = "dinsByNroReclamo", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dom.reclamo.Reclamo "
                        + "WHERE nroReclamo == :nroReclamo "
                        + "ORDER BY nroReclamo ASC")
})
@Unique(name="Reclamo_nroReclamo_UNQ", members = {"nroReclamo"})
@DomainObject(editing = Editing.DISABLED)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@Getter @Setter
public class Reclamo {

    @Column(allowsNull = "true", length = 10)
    @Property(editing = Editing.DISABLED)
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    private Integer nroReclamo;

    @Column(allowsNull = "false")
    @NonNull
    @Property()
    private Usuario usuario;

    @Column(allowsNull = "true")
    @NonNull
    @Property()
    private String direccion;

    @Column(allowsNull = "false")
    @NonNull
    @PropertyLayout(named = "Fecha de Creacion del Reclamo: ")
    @Property(editing = Editing.DISABLED)
    private LocalDate fecha = LocalDate.now();

    @Column(allowsNull = "true")
    @Title(prepend = "Reclamo: ")
    @Property(editing = Editing.ENABLED)
    private TipoReclamo tipoReclamo;

    @Column(allowsNull = "true", length = 2000)
    @Property(editing = Editing.ENABLED)
    private String descripcion;

    @Column(allowsNull = "true", length = 2000)
    @Property(editing = Editing.DISABLED)
    private Estado estado;

    @Column(allowsNull = "true",name = "cuadrilla_asig_id")
    @Property()
    @PropertyLayout(named = "Cuadrilla")
    private Cuadrilla cuadrillaAsigna;

    public Reclamo() {}

    public Reclamo(Integer nroReclamo, Usuario usuario, String direccion, LocalDate fecha, TipoReclamo tipoReclamo, String descripcion, Estado estado, Cuadrilla cuadrillaAsigna) {
        this.nroReclamo = nroReclamo;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.cuadrillaAsigna = cuadrillaAsigna;
    }

    @Override
    public String toString() {
        return "Reclamo{" +
                "nroReclamo=" + nroReclamo +
                ", usuario=" + usuario +
                ", direccion='" + direccion + '\'' +
                ", fecha=" + fecha +
                ", tipoReclamo=" + tipoReclamo +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", cuadrillaAsigna=" + cuadrillaAsigna +
                '}';
    }
}
