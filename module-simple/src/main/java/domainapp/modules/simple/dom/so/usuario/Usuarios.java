package domainapp.modules.simple.dom.so.usuario;

import domainapp.modules.simple.SimpleModule;
import domainapp.modules.simple.types.Name;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.RequiredArgsConstructor;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.PriorityPrecedence;
import org.apache.causeway.applib.annotation.PromptStyle;
import org.apache.causeway.applib.annotation.SemanticsOf;
import org.apache.causeway.applib.services.repository.RepositoryService;

import org.apache.causeway.applib.annotation.NatureOfService;

import java.util.List;

@Named(SimpleModule.NAMESPACE+"Usuarios")
@DomainService(nature = NatureOfService.VIEW)
@Priority(PriorityPrecedence.EARLY)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class Usuarios{

    final UserRepo UserRepoRepository;
    final RepositoryService respositoryService;

    @Action(semantics = SemanticsOf.SAFE)
    public List<Usuario> Listar(){
        return UserRepoRepository.findAll();
    }

    public Usuario findByDniExact(int dni){
        return UserRepoRepository.findByDni(dni);
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Usuario> findByNombre(
            @Name final String nombre){
        return UserRepoRepository.findByNombreContains(nombre);
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Usuario create(
            @Name final String nombre) {

        return respositoryService.persist(Usuario.withName(nombre));
    }

}
