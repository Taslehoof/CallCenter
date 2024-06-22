package domainapp.modules.simple.dom.so.ayudante;

import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainServiceLayout;
//import org.apache.causeway.applib.annotation.MemberOrder;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Parameter;
import org.apache.causeway.applib.annotation.ParameterLayout;
import org.apache.causeway.applib.annotation.SemanticsOf;

import javax.inject.Inject;
import java.util.List;

//@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, objectType = "simple.SimpleAyudanteMenu", repositoryFor= Ayudante.class)
@DomainService()
//@DomainServiceLayout(named= "", menuOrder = "")
@DomainServiceLayout(named= "")
public class AyudanteMenu {

    @Action()
    @ActionLayout(named = "Crear Ayudante")
    //@MemberOrder( sequence = "1")
    public Ayudante create(

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "DNI: ")
            final int dni,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre: ")
            final String nombre,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Apellido: ")
            final String apellido,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Direccion: ")
            final String direccion,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Telefono: ")
            final int telefono){
        return ayudanterepository.create(dni, nombre, apellido, direccion, telefono);
    }

    @Action(semantics = SemanticsOf.SAFE)
    //@ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Adyudante")
    @ActionLayout(named = "Buscar Adyudante")
    //@MemberOrder(sequence = "2")
    public Ayudante findByDni(
        @Parameter(optionality = Optionality.MANDATORY)
        @ParameterLayout(named = "Por dni: ")
        final Ayudante ayudante){

        return ayudante;

    }

    @Action(semantics = SemanticsOf.SAFE)
    //@ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Adyudante")
    @ActionLayout(named = "Listado de Adyudante")
    //@MemberOrder(sequence = "3")
    public List<Ayudante> listAll(){
        List<Ayudante> ayudantes = ayudanterepository.Listar();
        return ayudantes;

    }

     @Inject
    AyudanteRepositorio ayudanterepository;
}
