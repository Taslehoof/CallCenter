package domainapp.modules.simple.dom.so.ayudante;

import domainapp.modules.simple.SimpleModule;

import lombok.RequiredArgsConstructor;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Parameter;
import org.apache.causeway.applib.annotation.ParameterLayout;
import org.apache.causeway.applib.annotation.PriorityPrecedence;
import org.apache.causeway.applib.annotation.SemanticsOf;
import org.apache.causeway.applib.services.repository.RepositoryService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

@Named(SimpleModule.NAMESPACE_reclamos + ".Ayudante")
@DomainService(nature = NatureOfService.VIEW)
@Priority(PriorityPrecedence.EARLY)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class Ayudantes {

    final AyudanteRepo ayudanteRepo;
    final RepositoryService repositoryService;

    @Action()
    @ActionLayout(named = "Crear Ayudante")
    public Ayudante createUpdate(

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

        if (ayudanteRepo.create()==true){
            return repositoryService.persist(Ayudante.create(dni,nombre,apellido,direccion,telefono));
        }else {
            return Ayudante.update(dni,nombre, apellido, direccion,telefono);
        }
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listado de Ayudante")
    public List<Ayudante> listAll(){
        return ayudanteRepo.findAll();
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Buscar Ayudante")
    public Ayudante findByDni(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por DNI: ")
            final int dni){
        return ayudanteRepo.findByDni(dni);
    }
    @Action()
    @ActionLayout(named = "Editar")
    public Ayudante update(

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

        return repositoryService.persist(Ayudante.update(dni,nombre,apellido,direccion,telefono));
    }



}
