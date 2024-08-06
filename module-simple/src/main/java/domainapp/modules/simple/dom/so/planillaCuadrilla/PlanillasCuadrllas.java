package domainapp.modules.simple.dom.so.planillaCuadrilla;

import domainapp.modules.simple.SimpleModule;

import lombok.RequiredArgsConstructor;

import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.PriorityPrecedence;
import org.apache.causeway.applib.services.repository.RepositoryService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

@Named(SimpleModule.NAMESPACE_reclamos + ".PlanillaCuadrilla")
@DomainService(nature = NatureOfService.VIEW)
@Priority(PriorityPrecedence.EARLY)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class PlanillasCuadrllas {

    final PlanillaCuadrillaRepo planillaCuadrillaRepository;
    final RepositoryService repositoryService;

    public List<PlanillaCuadrilla> Listar(){
        return planillaCuadrillaRepository.findAll();
    }
}
