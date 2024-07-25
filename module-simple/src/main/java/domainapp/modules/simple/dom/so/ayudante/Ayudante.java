package domainapp.modules.simple.dom.so.ayudante;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainObject;
import org.apache.causeway.applib.annotation.DomainObjectLayout;
import org.apache.causeway.applib.annotation.Editing;
import org.apache.causeway.applib.annotation.Publishing;
import org.apache.causeway.applib.util.ObjectContracts;
import org.apache.causeway.persistence.jpa.applib.integration.CausewayEntityListener;

import javax.inject.Named;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.List;

@Entity
@Table(
        schema = SimpleModule.SCHEMA_reclamos,
        uniqueConstraints = {
                @UniqueConstraint(name = "Ayudante_dni_UNQ", columnNames = {"dni"})
        }
)
@NamedQueries({
        @NamedQuery(
                name = Ayudante.FIND,
                query = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.ayudante.Ayudante "
                + "ORDER BY nombre ASC"),
        @NamedQuery(
                name = Ayudante.FIND_BY_DNI,
                query = "SELECT "
                + "FROM domainapp.modules.simple.dom.so.ayudante.Ayudante "
                + "WHERE dni == :dni "
                + "ORDER BY dni ASC")

})
@EntityListeners(CausewayEntityListener.class)
//@Named(SimpleModule.NAMESPACE_reclamos+".Ayudante")
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@DomainObject(editing = Editing.DISABLED)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@ToString(onlyExplicitlyIncluded = true)
@Getter @Setter
public class Ayudante  implements Comparable<Ayudante>{

    static final String FIND = " Ayudante.find";
    static final String FIND_BY_DNI = "Ayudante.findByDni";

    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private List<Cuadrilla> cuadrillaAyudante;

    public Ayudante(int dni, String nombre, String apellido, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public static Ayudante create(final int dni, final String nombre, final String apellido, final String direccion, final int telefono){
        Ayudante ayudante = new Ayudante();
       ayudante.setDni(dni);
       ayudante.setNombre(nombre);
       ayudante.setApellido(apellido);
       ayudante.setDireccion(direccion);
       ayudante.setTelefono(telefono);
       return ayudante;
    }

    public static Ayudante update(final int dni, final String nombre, final String apellido, final String direccion, final int telefono){
        Ayudante ayudante = new Ayudante();
        ayudante.setDni(dni);
        ayudante.setNombre(nombre);
        ayudante.setApellido(apellido);
        ayudante.setDireccion(direccion);
        ayudante.setTelefono(telefono);
        return ayudante;
    }

    public Ayudante() {}

    public Ayudante(int dni, String nombre, String apellido, String direccion, int telefono, List<Cuadrilla> cuadrillaAyudante) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuadrillaAyudante = cuadrillaAyudante;
    }

    @Override
    public int compareTo(final Ayudante other) {
        return ObjectContracts.compare(this, other,"dni");
    }
}
