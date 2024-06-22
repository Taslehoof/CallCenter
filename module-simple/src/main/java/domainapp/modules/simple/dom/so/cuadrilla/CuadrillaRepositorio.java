package domainapp.modules.simple.dom.so.cuadrilla;

import domainapp.modules.simple.dom.so.ayudante.Ayudante;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.Programmatic;
//import org.apache.causeway.applib.query.QueryDefault;
import org.apache.causeway.applib.services.repository.RepositoryService;

import javax.inject.Inject;

import java.util.List;

//@DomainService( nature = NatureOfService.DOMAIN, repositoryFor = Cuadrilla.class)
@DomainService()
public class CuadrillaRepositorio {

    @Programmatic
    public List<Cuadrilla> Listar(){
        //return repositoryService.allMatches(new QueryDefault<>(Cuadrilla.class,"find"));
        return null;
    }

    @Programmatic
    public List<Cuadrilla> Listar(Cuadrilla nombre){
        //return repositoryService.allMatches(new QueryDefault<>(Cuadrilla.class,"findByCuadrilla","nombre",nombre));
        return null;
    }

    @Programmatic
    public Cuadrilla create(final String nombre, final Tecnico tecnico, final Ayudante ayudante) {
        final Cuadrilla cuadrilla = new Cuadrilla(nombre, tecnico, ayudante);
        repositoryService.persist(cuadrilla);
        return cuadrilla;
    }

    @Programmatic
    public Cuadrilla findOrCreate(final String nombre, final Tecnico tecnico, final Ayudante ayudante) {
        Cuadrilla cuadrilla = findByNombre(nombre);
        if(cuadrilla ==null){
            cuadrilla = create(nombre, tecnico, ayudante);
        }
        return cuadrilla;
    }

    private Cuadrilla findByNombre(String nombre) {
        /*return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        Cuadrilla.class,
                        "findByNombre",
                        "nombre", nombre));*/
        return null;
    }

    @Inject
    RepositoryService repositoryService;
}
