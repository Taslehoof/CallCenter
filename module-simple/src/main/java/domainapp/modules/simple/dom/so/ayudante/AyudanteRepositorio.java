package domainapp.modules.simple.dom.so.ayudante;

import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.query.QueryDefault;

import javax.inject.Inject;
import java.util.List;

public class AyudanteRepositorio {

    @Programmatic
    public List<Ayudante> Listar(){

        return repositoryService.allMatches(
                new QueryDefault<>(
                        Ayudante.class,
                        "find"));

    }

    @Programmatic
    public Ayudante findByDni(final int dni){

        return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        Ayudante.class,
                        "findByDni",
                        "dni",dni));

    }


    @Programmatic
    public Ayudante create(
            final int dni,
            final String nombre,
            final String apellido,
            final String direccion,
            final int telefono){
        final Ayudante ayudante = new Ayudante(dni, nombre, apellido, direccion, telefono);
        repositoryService.persist(ayudante);
        return ayudante;
    }

    @Programmatic
    public Ayudante findOrCreate(
            final int dni,
            final String nombre,
            final String apellido,
            final String direccion,
            final int telefono){
        Ayudante ayudante = findByDni(dni);
        if (ayudante == null){
            ayudante = create(dni, nombre,apellido, direccion, telefono);
        }
        return ayudante;
    }

    @Inject
    RepositoryService repositoryService;
}
