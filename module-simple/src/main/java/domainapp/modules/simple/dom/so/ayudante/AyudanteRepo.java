package domainapp.modules.simple.dom.so.ayudante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AyudanteRepo extends JpaRepository<Ayudante,Long> {

    Ayudante create(final int dni, final String nombre, final String apellido, final String direccion, final int telefono);

    Ayudante createUpdate(final int dni, final String nombre, final String apellido, final String direccion, final int telefono);

    Ayudante findByDni(final int dni);

    Ayudante update(final int dni, final String nombre, final String apellido, final String direccion, final int telefono);

    boolean create();
}
