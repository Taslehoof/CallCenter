package domainapp.modules.simple.dom.so.reclamo;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;
import javax.inject.Inject;

import java.util.List;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Reclamo.class)
public class ReclamoRepositorio {

    @Programmatic
    public List<Reclamo> Listar(){
        return respositoryService.allMatches(new QueryDefault<>(Reclamo.class,"find"));
    }

    @Inject
    RepositoryService respositoryService;
}
