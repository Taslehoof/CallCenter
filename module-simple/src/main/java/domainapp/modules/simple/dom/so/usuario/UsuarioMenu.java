package domainapp.modules.simple.dom.so.usuario;

import org.apache.causeway.applib.annotation.*;

import javax.inject.Inject;
import java.util.regex.Pattern;
import java.util.List;

//@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, objectType="simple.SimpleUsuarioMenu", repositoryFor= Usuario.class)
@DomainService()
//@DomainServiceLayout(named = "",menuOrder = "")
@DomainServiceLayout(named = "")
public class UsuarioMenu {

    /*@Action()
    @ActionLayout(named = "Cargar Usuario")
    //@MemberOrder(sequence = "1")
    public Usuario create( 
            
            @Parameter(maxLength = 8)
            @ParameterLayout(named = "DNI:") 
            final int dni,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre: ")
            final String nombre,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Apellido: ")
            final String apellido,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Direccion: ")
            final String direccion,

            @Parameter(
                    maxLength = 40,
                    regexPattern = "(\\w+\\.)*\\w*@(\\w*\\.)*[A-Za-z]+",
                    regexPatternFlags = Pattern.CASE_INSENSITIVE,
                    regexPatternReplacement = "Debe ser una direccion de Correo Valida (que contiene '@')")
            @ParameterLayout(named = "Email: ")
            final String email,

            @Parameter(
                    maxLength = 19,
                    regexPattern = "[+]?[0-9 ]+",
                    regexPatternReplacement =
                            "Solo puede especificar numeros, espacios y opcionalmente el prefijo '+'." +
                                    " Por ejemplo:, '+54 299 4484857' ")
            @ParameterLayout(named = "Telefono: ")
            final int telefono){

        return usuariorepository.create(dni, nombre, apellido, direccion, email, telefono);    
    }*/

    /*@Action(semantics = SemanticsOf.SAFE)
    //@ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Usuario")
    @ActionLayout(named = "Buscar Usuario")
    //@MemberOrder(sequence = "2")
    public Usuario findByDni(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por dni: ")
            final Usuario usuario){
        return usuario;
    }*/

    /*@Action(semantics = SemanticsOf.SAFE)
    //@ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Usuarios")
    @ActionLayout(named = "Listado de Usuarios")
    //@MemberOrder(sequence = "3")
    public List<Usuario> ListAll(){
        List<Usuario> usuarios = usuariorepository.Listar();
        return usuarios;
    }*/


//    @Inject
    //Usuarios usuariorepository;
}