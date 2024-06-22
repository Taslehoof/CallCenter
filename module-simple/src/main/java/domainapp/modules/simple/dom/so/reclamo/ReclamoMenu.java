package domainapp.modules.simple.dom.so.reclamo;

import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.DomainServiceLayout;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.Action;
//import org.apache.causeway.applib.annotation.MemberOrder;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.SemanticsOf;
import org.apache.causeway.applib.annotation.BookmarkPolicy;


import javax.inject.Inject;

import java.util.List;

//@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, objectType = "simple.SimpleReclamoMenu", repositoryFor = Reclamo.class)
@DomainService()
//@DomainServiceLayout(named = "", menuOrder = "")
@DomainServiceLayout(named = "")
public class ReclamoMenu {

    @Action(semantics = SemanticsOf.SAFE)
    //@ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Reclamos")
    @ActionLayout(named = "Listado de Reclamos")
    //@MemberOrder(sequence = "2")
    public List<Reclamo> listAll(){
        List<Reclamo> reclamos = reclamosrepository.Listar();
        return reclamos;
    }

    @Inject
    ReclamoRepositorio reclamosrepository;

}