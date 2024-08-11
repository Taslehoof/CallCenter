package domainapp.modules.simple.dom.so.cuadrilla;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.dom.so.ayudante.Ayudante;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.val;

import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainObject;
import org.apache.causeway.applib.annotation.DomainObjectLayout;
import org.apache.causeway.applib.annotation.Editing;
import org.apache.causeway.applib.annotation.Property;
import org.apache.causeway.applib.annotation.Publishing;
import org.apache.causeway.applib.util.ObjectContracts;
import org.apache.causeway.persistence.jpa.applib.integration.CausewayEntityListener;

import javax.inject.Named;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.List;

@Entity
@Table(
        schema = SimpleModule.SCHEMA,
        uniqueConstraints = {
                @UniqueConstraint(name = "Cuadrilla_nombre_UNQ", columnNames = {"nombre"})
        }
)
@NamedQueries({
        @NamedQuery(
                name = Cuadrilla.FIND,
                query = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla "
                + "ORDER BY nombre ASC"),
        @NamedQuery(
                name = Cuadrilla.FIND_BY_NOMBRE,
                query = "SELECT "
                        + "FROM domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla "
                        + "WHERE nombre == :nombre"),
        @NamedQuery(
                name = Cuadrilla.FIND_BY_TECNICO,
                query = "SELECT "
                        + "FROM domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla "
                        + "WHERE tecnico == :tecnico "
                        + "ORDER BY nombre ASC"),
        @NamedQuery(
                name = Cuadrilla.FIND_BY_AYUDANTE,
                query = "SELECT "
                        + "FROM domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla "
                        + "WHERE ayudante == :ayudante "
                        + "ORDER BY nombre ASC"),

})
@EntityListeners(CausewayEntityListener.class)
@DomainObject(editing = Editing.DISABLED)
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@ToString(onlyExplicitlyIncluded = true)
@Getter @Setter
public class Cuadrilla implements Comparable<Cuadrilla>{

    static final String FIND = " Cuadrilla.find";
    static final String FIND_BY_NOMBRE = " Cuadrilla.findByNombre";
    static final String FIND_BY_TECNICO = " Cuadrilla.findByTecnico";
    static final String FIND_BY_AYUDANTE = " Cuadrilla.findByAyudante";

    @Column(allowsNull = "false", length = 40)
    @Property()
    private String nombre;

    @Column(allowsNull = "false")
    @Property()
    private Tecnico tecnico;

    @Column(allowsNull = "false")
    @Property()
    private Ayudante ayudante;

    @Property()
    @Persistent(mappedBy = "CuadrillaAsignada", defaultFetchGroup = "true")
    @Column(allowsNull = "true")
    private List<Reclamo> relcamosAsignados;

    public Cuadrilla() {}

    public Cuadrilla(String nombre, Tecnico tecnico, Ayudante ayudante, List<Reclamo> relcamosAsignados) {
        this.nombre = nombre;
        this.tecnico = tecnico;
        this.ayudante = ayudante;
        this.relcamosAsignados = relcamosAsignados;
    }

    public static Cuadrilla create(final String nombre, final Tecnico tecnico, final Ayudante ayudante){
        Cuadrilla cuadrilla= new Cuadrilla();
        cuadrilla.setNombre(nombre);
        cuadrilla.setTecnico(tecnico);
        cuadrilla.setAyudante(ayudante);
        return cuadrilla;
    }

    public static Cuadrilla update(final String nombre, final Tecnico tecnico, final Ayudante ayudante){
        Cuadrilla cuadrilla= new Cuadrilla();
        cuadrilla.setNombre(nombre);
        cuadrilla.setTecnico(tecnico);
        cuadrilla.setAyudante(ayudante);
        return cuadrilla;
    }


    @Override
    public int compareTo(final Cuadrilla other) {
        return ObjectContracts.compare(this, other, "nombre");
    }
}
