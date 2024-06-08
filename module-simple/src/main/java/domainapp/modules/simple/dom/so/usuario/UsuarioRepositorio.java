package domainapp.modules.simple.dom.so.usuario;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;
import java.util.List;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Usuario.class)
public class UsuarioRepositorio {

    @Programmatic
    public List<Usuario> Listar(){
        return respositoryService.allMatches(
                new QueryDefault<>(
                        Usuario.class,
                        "find"));
    }

    @Programmatic
    public Usuario findByDni(final String dni){
        return respositoryService.uniqueMatch(
                new QueryDefault<>(
                        Usuario.class,
                       "findByDni",
                        "dni",dni));
    }

    @Programmatic
    public List<Usuario> findByNombreContains(final String nombre){
        return respositoryService.allMatches(
                new QueryDefault<>(
                        Usuario.class,
                        "findByNombreContains",
                        "nombre",nombre));
    }


    @Programmatic
    public Usuario create(
            final int dni,
            final String nombre,
            final String apellido,
            final String direccion,
            final String email,
            final int telefono) {

        final Usuario usuario = new Usuario(dni, nombre, apellido, direccion, email, telefono);
        respositoryService.persist(usuario);
        return usuario;
    }

    @Programmatic
    public Usuario findOrCreate(
            final int dni,
            final String nombre,
            final String apellido,
            final String direccion,
            final String email,
            final int telefono) {

        Usuario usuario = findByDni(String.valueOf(dni));
        if (usuario ==null){
            usuario = create(dni, nombre, apellido, direccion, email, telefono);
        }
        return usuario;
    }



    @Inject
    RepositoryService respositoryService;
}