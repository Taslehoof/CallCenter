package domainapp.modules.simple.dom.so.reclamo;

import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.Programmatic;
//import org.apache.causeway.applib.query.QueryDefault;
import org.apache.causeway.applib.services.repository.RepositoryService;
import javax.inject.Inject;

import java.util.List;

//@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Reclamo.class)
@DomainService()
public class ReclamoRepositorio {

    @Programmatic
    public List<Reclamo> Listar(){
        //return respositoryService.allMatches(new QueryDefault<>(Reclamo.class,"find"));
        return null;
    }

    @Inject
    RepositoryService respositoryService;
}
