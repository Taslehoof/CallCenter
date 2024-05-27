package domainapp.modules.simple.dom.so.reclamo;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.BookmarkPolicy;


import javax.inject.Inject;

import java.util.List;

@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, objectType = "simple.SimpleReclamoMenu", repositoryFor = Reclamo.class)
@DomainServiceLayout(named = "", menuOrder = "")
public class ReclamoMenu {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Reclamos")
    @MemberOrder(sequence = "2")
    public List<Reclamo> listAll(){
        List<Reclamo> reclamos = reclamosrepository.Listar();
        return reclamos;
    }

    @Inject
    ReclamoRepositorio reclamosrepository;

}