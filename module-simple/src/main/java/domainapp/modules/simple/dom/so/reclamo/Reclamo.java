package domainapp.modules.simple.dom.so.reclamo;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import domainapp.modules.simple.dom.so.usuario.Usuario;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainObject;
import org.apache.causeway.applib.annotation.DomainObjectLayout;
import org.apache.causeway.applib.annotation.Editing;
import org.apache.causeway.applib.annotation.Property;
import org.apache.causeway.applib.annotation.PropertyLayout;
import org.apache.causeway.applib.annotation.Publishing;
import org.apache.causeway.applib.annotation.Title;
import org.apache.causeway.applib.util.ObjectContracts;
import org.apache.causeway.persistence.jpa.applib.integration.CausewayEntityListener;

import javax.inject.Named;
import javax.jdo.annotations.*;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.validation.Schema;

import java.time.LocalDate;

@Entity
@Table(
        schema = SimpleModule.SCHEMA_reclamos,
        uniqueConstraints = {
                @UniqueConstraint(name="Reclamo_nroReclamo_UNQ", columnNames = {"nroReclamo"} )
        }
)
@NamedQueries({
        @NamedQuery(
                name = Reclamo.FIND,
                query = "SELECT "),
        @NamedQuery(
                name = Reclamo.FIND_LAST,
                query = "SELECT "
                        + "ORDER BY nroReclamo DESC"),
        @NamedQuery(
                name = Reclamo.FIND_BY_NRO_RECLAMO,
                query = "SELECT "
                        + "FROM domainapp.modules.simple.dom.reclamo.Reclamo "
                        + "WHERE nroReclamo == :nroReclamo "
                        + "ORDER BY nroReclamo ASC")
})
@EntityListeners(CausewayEntityListener.class)
@Named(SimpleModule.NAMESPACE_reclamos+".Reclamo")
//@DatastoreIdentity(strategy = IdGeneratorStrategy.IDENTITY,column = "id")
//@Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@DomainObject(entityChangePublishing = Publishing.DISABLED)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@ToString(onlyExplicitlyIncluded = true)
public class Reclamo implements Comparable<Reclamo>{

    static final String FIND = "Reclamo.find";
    static final String FIND_LAST = "Reclamo.findLast";
    static final String FIND_BY_NRO_RECLAMO = "Reclamo.findByNroReclamo";

    @Column(allowsNull = "true", length = 10)
    @Property(editing = Editing.DISABLED)
    @Id
    @Getter @Setter
    private String nroReclamo;

    @Column(allowsNull = "false")
    @NonNull
    @Property()
    @Getter @Setter
    private Usuario usuario;

    @Column(allowsNull = "true")
    @NonNull
    @Property()
    @Getter @Setter
    private String direccion;

    @Column(allowsNull = "false")
    @NonNull
    @PropertyLayout(named = "Fecha de Creacion del Reclamo: ")
    @Getter @Setter
    @Property(editing = Editing.DISABLED)
    private LocalDate fecha = LocalDate.now();

    @Column(allowsNull = "true")
    @Title(prepend = "Reclamo: ")
    @Property(editing = Editing.ENABLED)
    @Getter @Setter
    private TipoReclamo tipoReclamo;

    @Column(allowsNull = "true", length = 2000)
    @Property(editing = Editing.ENABLED)
    @Getter @Setter
    private String descripcion;

    @Column(allowsNull = "true", length = 2000)
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private Estado estado;

    @Column(allowsNull = "true",name = "cuadrilla_asig_id")
    @Property()
    @PropertyLayout(named = "Cuadrilla")
    @Getter @Setter
    private Cuadrilla cuadrillaAsigna;

    public Reclamo() {}

    public Reclamo(String nroReclamo, Usuario usuario, String direccion, LocalDate fecha, TipoReclamo tipoReclamo, String descripcion, Estado estado, Cuadrilla cuadrillaAsigna) {
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
    public int compareTo(final Reclamo other){
        return ObjectContracts.compare(this, other, nroReclamo);
    }
}
