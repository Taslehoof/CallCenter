package domainapp.modules.simple.dom.so.cuadrilla;

import domainapp.modules.simple.SimpleModule;

import domainapp.modules.simple.dom.so.ayudante.Ayudante;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import lombok.RequiredArgsConstructor;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.BookmarkPolicy;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Parameter;
import org.apache.causeway.applib.annotation.ParameterLayout;
import org.apache.causeway.applib.annotation.PriorityPrecedence;

import org.apache.causeway.applib.services.repository.RepositoryService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;

@Named(SimpleModule.NAMESPACE_reclamos+"Cuadrillas")
@DomainService(nature = NatureOfService.VIEW)
@Priority(PriorityPrecedence.EARLY)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class Cuadrillas {

    final CuadrillaRepo cuadrillaRepoRepository;
    final RepositoryService repositoryService;

    @Action()
    @ActionLayout(named = "Crear Cuadrilla")
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

        return repositoryService.persist(Cuadrilla.create(nombre,tecnico,ayudante));
    }

    @ActionLayout(named = "Buscar Cuadrilla")
    public Cuadrilla findByNombre(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por Nombre: ")
            final Cuadrilla nombre){
        return nombre;
    }

}
