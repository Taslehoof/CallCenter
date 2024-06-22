package domainapp.modules.simple.dom.so.cuadrilla;

import domainapp.modules.simple.dom.so.ayudante.Ayudante;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.DomainServiceLayout;
//import org.apache.causeway.applib.annotation.MemberOrder;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Parameter;
import org.apache.causeway.applib.annotation.ParameterLayout;
import org.apache.causeway.applib.annotation.SemanticsOf;

import javax.inject.Inject;

//@DomainService( nature = NatureOfService.VIEW_MENU_ONLY, objectType = "simple.SimpleCuadrillaMenu", repositoryFor = Cuadrilla.class)
@DomainService()
//@DomainServiceLayout(named = "", menuOrder = "")
@DomainServiceLayout(named = "")
public class CuadrillaMenu {

    @Action()
    @ActionLayout(named = "Crear Cuadrillla")
    //@MemberOrder(sequence = "1")
    public Cuadrilla create(

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre")
            final String nombre,

            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Tecnico")
            final Tecnico tecnico,

            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Ayudante")
            final Ayudante ayudante){

        return cuadrillarepository.create(nombre, tecnico, ayudante);
    }

    @Action(semantics= SemanticsOf.SAFE)
    //@ActionLayout(bookmarking= BookmarkPolicy.AS_ROOT, named = "Buscar Cuadrillla")
    @ActionLayout(named = "Buscar Cuadrillla")
    //@MemberOrder(sequence = "2")
    public Cuadrilla findByNombre(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por Nombre: ")
            final Cuadrilla cuadrilla){

        return cuadrilla;
    }



    @Inject
    CuadrillaRepositorio cuadrillarepository;
}
