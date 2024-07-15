package domainapp.modules.simple.dom.so.reclamo;

import domainapp.modules.simple.SimpleModule;

import lombok.RequiredArgsConstructor;

import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.PriorityPrecedence;
import org.apache.causeway.applib.annotation.Programmatic;
import org.apache.causeway.applib.services.repository.RepositoryService;

import org.apache.causeway.applib.annotation.NatureOfService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

@Named(SimpleModule.NAMESPACE_reclamos+"Reclamos")
@DomainService(nature = NatureOfService.VIEW)
@Priority(PriorityPrecedence.EARLY)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class Reclamos {

    final ReclaRepo ReclaRepoRepository;
    final RepositoryService repositoryService;

    public Estado ReclaEstado(Estado estado) {
        return ReclaRepoRepository.CambiarEstado(estado);
    }


    @Programmatic
    public List<Reclamo> Listar(){
        return ReclaRepoRepository.findAll();
    }



}
