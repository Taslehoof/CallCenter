package domainapp.modules.simple.dom.so.tecnico;

import org.apache.causeway.applib.annotation.*;

import javax.inject.Inject;
import java.util.List;

//@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, objectType="simple.SimpleTecnicoMenu", repositoryFor= Tecnico.class)
@DomainService()
//@DomainServiceLayout(named = "",menuOrder = "")
@DomainServiceLayout(named = "")
public class TecnicoMenu {

    @Action()
    @ActionLayout(named = "Cargar Tecnico")
    //@MemberOrder(sequence = "1")
    public Tecnico create(

            @Parameter(maxLength = 8)
            @ParameterLayout(named = "DNI:")
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

        return tecnicorepository.create(dni, nombre, apellido, direccion, telefono);
    }

    @Action(semantics = SemanticsOf.SAFE)
    //@ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Tecnico")
    @ActionLayout(named = "Buscar Tecnico")
    //@MemberOrder(sequence = "2")
    public Tecnico findByDni(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "por dni: ")
            final Tecnico tecnico){
        return tecnico;
    }

    @Action(semantics = SemanticsOf.SAFE)
    //@ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Tecnicos")
    @ActionLayout(named = "Listado de Tecnicos")
    //@MemberOrder(sequence = "3")
    public List<Tecnico> ListAll(){
        List<Tecnico> tecnicos = tecnicorepository.Listar();
        return tecnicos;
    }

    @Inject
    TecnicoRepositorio tecnicorepository;
}
