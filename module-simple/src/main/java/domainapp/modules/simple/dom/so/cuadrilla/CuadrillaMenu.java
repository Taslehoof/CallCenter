package domainapp.modules.simple.dom.so.cuadrilla;

import domainapp.modules.simple.dom.so.ayudante.Ayudante;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import javax.inject.Inject;

@DomainService( nature = NatureOfService.VIEW_MENU_ONLY, objectType = "simple.SimpleCuadrillaMenu", repositoryFor = Cuadrilla.class)
@DomainServiceLayout(named = "", menuOrder = "")
public class CuadrillaMenu {

    @Action()
    @ActionLayout(named = "Crear Cuadrillla")
    @MemberOrder(sequence = "1")
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
    @ActionLayout(bookmarking= BookmarkPolicy.AS_ROOT, named = "Buscar Cuadrillla")
    @MemberOrder(sequence = "2")
    public Cuadrilla findByNombre(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por Nombre: ")
            final Cuadrilla cuadrilla){

        return cuadrilla;
    }



    @Inject
    CuadrillaRepositorio cuadrillarepository;
}
