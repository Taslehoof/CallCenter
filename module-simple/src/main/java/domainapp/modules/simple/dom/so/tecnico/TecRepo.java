package domainapp.modules.simple.dom.so.tecnico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TecRepo extends JpaRepository<Tecnico, Long> {

    Tecnico create(final int dni, final String nombre, final String apellido, final String direccion, final int telefono);

    Tecnico findByDni(final int dni);
}
