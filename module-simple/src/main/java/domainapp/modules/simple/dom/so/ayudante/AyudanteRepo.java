package domainapp.modules.simple.dom.so.ayudante;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AyudanteRepo extends JpaRepository<Ayudante,Long> {

    Ayudante create(final int dni, final String nombre, final String apellido, final String direccion, final int telefono);

    Ayudante createUpdate(final int dni, final String nombre, final String apellido, final String direccion, final int telefono);

    Ayudante findByDni(final int dni);

    List<Ayudante> findAll();

    Ayudante update(final int dni, final String nombre, final String apellido, final String direccion, final int telefono);

    boolean create();
}
