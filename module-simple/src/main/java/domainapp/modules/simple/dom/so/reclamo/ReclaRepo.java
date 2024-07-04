package domainapp.modules.simple.dom.so.reclamo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclaRepo  extends JpaRepository<Reclamo, Long> {

    List<Reclamo> Listar(final String reclamo);

}
