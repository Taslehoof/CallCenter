package domainapp.modules.simple.dom.so.planillaCuadrilla;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import lombok.ToString;

import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainObject;
import org.apache.causeway.applib.annotation.DomainObjectLayout;
import org.apache.causeway.applib.annotation.Editing;
import org.apache.causeway.applib.annotation.Property;
import org.apache.causeway.applib.util.ObjectContracts;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.math.BigInteger;

@Entity
@Table(
        schema = SimpleModule.SCHEMA_reclamos,
        uniqueConstraints = {
                @UniqueConstraint(name = "PlanillaCuadrilla_idPlanillaCuadrilla_UNQ", columnNames = {"idPlanillaCuadrilla"})
        }
)
@NamedQueries({
        @NamedQuery(
                name = PlanillaCuadrilla.FIND,
                query = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.planillaCuadrilla.PlanillaCuadrilla "
                + "ORDER BY idPlanillaCuadrilla ASC")
})
@DomainObject(editing = Editing.DISABLED)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@DatastoreIdentity(strategy = IdGeneratorStrategy.IDENTITY, column = "id")
@PersistenceCapable(identityType = IdentityType.DATASTORE, schema = "simple", table = "PlanillaCuadrilla")
@ToString(onlyExplicitlyIncluded = true)
@Getter @Setter
public class PlanillaCuadrilla implements Comparable<PlanillaCuadrilla>{

    static final String FIND = "PlanillaCuadrilla.find";

    @Property(editing = Editing.DISABLED)
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @NonNull
    @Column(allowsNull = "true", length = 10)
    private BigInteger idPlanillaCuadrilla;

    @Property
    @NonNull
    @Column(allowsNull = "true")
    private Cuadrilla cuadrilla;

    @Property(editing = Editing.ENABLED)
    @NonNull
    @Column(allowsNull = "true")
    private Respuesta seRealizoConexion;

    @Property(editing = Editing.ENABLED)
    @NonNull
    @Column(allowsNull = "true")
    private Respuesta seCambioConexion;

    @Property(editing = Editing.ENABLED)
    @NonNull
    @Column(allowsNull = "true")
    private Respuesta seReparoConexion;

    @Property(editing = Editing.ENABLED)
    @NonNull
    @Column(allowsNull = "true")
    private Respuesta seAnuloConexion;

    @Property(editing = Editing.ENABLED)
    @NonNull
    @Column(allowsNull = "true")
    private Respuesta seDestapoRed;

    @Property(editing = Editing.ENABLED)
    @NonNull
    @Column(allowsNull = "true")
    private Respuesta colectoraNivelAlto;

    @Property(editing = Editing.ENABLED)
    @NonNull
    @Column(allowsNull = "true")
    private Respuesta problemaInterno;

    @Property
    @NonNull
    @Column(allowsNull = "true")
    private Reclamo reclamoAsignado;

    @Property
    @NonNull
    @Column(allowsNull = "true")
    private String observacion;

    public PlanillaCuadrilla(){}

    public PlanillaCuadrilla(
            final Cuadrilla cuadrilla,
            final Reclamo reclamoAsignado,
            final Respuesta seRealizoConexion,
            final Respuesta seCambioConexion,
            final Respuesta seReparoConexion,
            final Respuesta seAnuloConexion,
            final Respuesta seDestapoRed,
            final Respuesta colectoraNivelAlto,
            final Respuesta problemaInterno,
            final String observacion){
       this.cuadrilla = cuadrilla;
       this.reclamoAsignado = reclamoAsignado;
       this.seRealizoConexion = seRealizoConexion;
       this.seCambioConexion = seCambioConexion;
       this.seReparoConexion = seReparoConexion;
       this.seAnuloConexion = seAnuloConexion;
       this.seDestapoRed = seDestapoRed;
       this.colectoraNivelAlto = colectoraNivelAlto;
       this.problemaInterno = problemaInterno;
       this.observacion = observacion;
    }

    @Override
    public int compareTo(final PlanillaCuadrilla other){
        return ObjectContracts.compare(this, other, "idPlanillaCuadrilla");
    }
}
