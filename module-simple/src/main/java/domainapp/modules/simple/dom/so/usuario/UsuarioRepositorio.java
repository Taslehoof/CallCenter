package domainapp.modules.simple.dom.so.usuario;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Usuario.class)
public class UsuarioRepositorio {
    
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

    @Inject
    RepositoryService respositoryService;
}