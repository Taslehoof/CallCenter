package domainapp.modules.simple.dom.so.reclamo;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import domainapp.modules.simple.dom.so.planillaCuadrilla.PlanillaCuadrilla;
import domainapp.modules.simple.dom.so.usuario.Usuario;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.Collection;
import org.apache.causeway.applib.annotation.DomainObject;
import org.apache.causeway.applib.annotation.DomainObjectLayout;
import org.apache.causeway.applib.annotation.Editing;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Parameter;
import org.apache.causeway.applib.annotation.ParameterLayout;
import org.apache.causeway.applib.annotation.Programmatic;
import org.apache.causeway.applib.annotation.Property;
import org.apache.causeway.applib.annotation.PropertyLayout;
import org.apache.causeway.applib.annotation.Publishing;
import org.apache.causeway.applib.annotation.SemanticsOf;
import org.apache.causeway.applib.annotation.Title;
import org.apache.causeway.applib.services.message.MessageService;
import org.apache.causeway.applib.util.ObjectContracts;
import org.apache.causeway.persistence.jpa.applib.integration.CausewayEntityListener;

import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jdo.annotations.*;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@Unique(name="Reclamo_nroReclamo_UNQ", members = {"nroReclamo"})
@PersistenceCapable(identityType = IdentityType.DATASTORE, schema = SimpleModule.SCHEMA)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@ToString(onlyExplicitlyIncluded = true)
@Getter @Setter
public class Reclamo implements Comparable<Reclamo>{

    static final String FIND = "Reclamo.find";
    static final String FIND_LAST = "Reclamo.findLast";
    static final String FIND_BY_NRO_RECLAMO = "Reclamo.findByNroReclamo";

    @Column(allowsNull = "true", length = 10)
    @Property(editing = Editing.DISABLED)
    @Id
    private String nroReclamo;

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

    @Persistent(mappedBy = "reclamoAsignado", dependentElement = "true")
    @Collection()
    private List<PlanillaCuadrilla> planillas = new ArrayList<PlanillaCuadrilla>();

    public Reclamo(){}

    public Reclamo(Usuario usuario, String direccion, LocalDate fecha, TipoReclamo tipoReclamo,Estado estado) {
        this.estado = estado;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipoReclamo = tipoReclamo;
    }

    public Reclamo(String nroReclamo, Usuario usuario, String direccion, LocalDate fecha, TipoReclamo tipoReclamo, Estado estado) {
        this.nroReclamo = nroReclamo;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipoReclamo = tipoReclamo;
        this.estado = estado;
    }

    public Reclamo(String nroReclamo, Usuario usuario, String direccion, LocalDate fecha, TipoReclamo tipoReclamo, String descripcion, Estado estado) {
        this.nroReclamo = nroReclamo;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Reclamo(String nroReclamo, Usuario usuario, String direccion, LocalDate fecha, TipoReclamo tipoReclamo, String descripcion, Estado estado,List<PlanillaCuadrilla> planillas) {
        this.nroReclamo = nroReclamo;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.planillas = planillas;
    }

    @Programmatic
    public void CambiarEstado(Estado estado){
        this.estado = estado;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(named = "Asignar Cuadrilla")
    public Reclamo AsignarCuadrilla(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Cuadrilla")
            final Cuadrilla cuadrilla){
        /*if (getEstado().equals(Estado.Anulado)){
           messageService.warnUser("No se puede asignar un reclamo Anulado!");
        } else if (getEstado().equals(Estado.Cerrado)) {
           messageService.warnUser("No se puede asignar un reclamo Cerrado!");
        }  else if (getEstado().equals(Estado.En_Proceso)) {
            messageService.warnUser("El reclamo ya posee una cuadrilla asignada!");
        } else {
            this.cuadrillaAsigna = cuadrilla;
            CambiarEstado(Estado.En_Proceso);
            messageService.warnUser("Reclamo Asignado");
        }*/

        switch (estado){
            case Anulado:
                messageService.warnUser("No se puede asignar un reclamo Anulado!");
                break;
            case Cerrado:
                messageService.warnUser("No se puede asignar un reclamo Cerrado!");
                break;
            case En_Proceso:
                messageService.warnUser("El reclamo ya posee una cuadrilla asignada!");
                break;
            case Asignado:
                messageService.warnUser("Reclamo Asignado");
                break;
            default:
                CambiarEstado(Estado.Sin_Asignar);
                messageService.warnUser("El reclamo no fue asignado todavia");
        }

        return this;
    }

    @Override
    public int compareTo(final Reclamo other){
        return ObjectContracts.compare(this, other, nroReclamo);
    }

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

    @Inject @NotPersistent
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    MessageService messageService;
}
