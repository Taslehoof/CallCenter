package domainapp.modules.simple.dom.so.tecnico;

import org.apache.causeway.applib.annotation.Programmatic;
//import org.apache.causeway.applib.query.QueryDefault;
import org.apache.causeway.applib.services.repository.RepositoryService;

import javax.inject.Inject;

import java.util.List;

public class TecnicoRepositorio {

    @Programmatic
    public List<Tecnico> Listar(){
        /*return repositoryService.allMatches(
                new QueryDefault<>(
                        Tecnico.class, "find"));*/
        return null;
    }

    @Programmatic
    public Tecnico findByDni(final int dni){
        /*return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        Tecnico.class, "findByDni", "dni", dni));*/
        return null;

    }

    @Programmatic
    public Tecnico create(
            final int dni,
            final String nombre,
            final String apellido,
            final String direccion,
            final int telefono){
        final Tecnico tecnico = new Tecnico(dni, nombre, apellido, direccion, telefono);
        repositoryService.persist(tecnico);
        return tecnico;
    }

    @Programmatic
    public Tecnico findOrCreate(
            final int dni,
            final String nombre,
            final String apellido,
            final String direccion,
            final int telefono){

        Tecnico tecnico = findByDni(dni);
        if ( tecnico == null){
            tecnico =create(dni, nombre, apellido, direccion, telefono);
        }
        repositoryService.persist(tecnico);
        return tecnico;
    }

    @Inject
    RepositoryService repositoryService;
}
