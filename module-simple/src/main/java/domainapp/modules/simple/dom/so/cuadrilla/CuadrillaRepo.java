package domainapp.modules.simple.dom.so.cuadrilla;

import org.springframework.data.jpa.repository.JpaRepository;
import domainapp.modules.simple.dom.so.ayudante.Ayudante;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import java.util.List;

public interface CuadrillaRepo extends JpaRepository<Cuadrilla,Long> {

    Cuadrilla cuadrilla(final String nombre);

    Cuadrillas create(final String nombre, final Tecnico tecnico, final Ayudante ayudante);

    Cuadrillas update(final String nombre, final Tecnico tecnico, final Ayudante ayudante);

    Cuadrillas createUpdate(final String nombre, final Tecnico tecnico, final Ayudante ayudante);

    Cuadrilla findByNombre(final Cuadrilla nombre);

    List<Cuadrilla> findAll();

    boolean create();
}