package domainapp.modules.simple.dom.so.tecnico;

import domainapp.modules.simple.SimpleModule;

import lombok.RequiredArgsConstructor;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Parameter;
import org.apache.causeway.applib.annotation.ParameterLayout;
import org.apache.causeway.applib.annotation.SemanticsOf;
import org.apache.causeway.applib.services.repository.RepositoryService;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

//@Named(SimpleModule.NAMESPACE_reclamos + ".Tecnico")
@DomainService(nature = NatureOfService.VIEW)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class Tecnicos {

    final TecRepo tecnicoRepository;
    final RepositoryService repositoryService;

    @Action()
    @ActionLayout(named = "Crear Tecnico")
    public Tecnico create(
            @Parameter(maxLength = 8)
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
            @ParameterLayout(named = "Telefono")
            final int telefono){

        return tecnicoRepository.create(dni, nombre, apellido, direccion,telefono);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Buscar Tecnico")
    public Tecnico findByDni(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "por Dni: ")
            final Tecnico tecnico){
        return tecnico;
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listado de Tecnicos")
    public List<Tecnico> ListAll(){
        return tecnicoRepository.listAll();
    }

}
