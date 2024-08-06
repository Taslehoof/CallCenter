package domainapp.modules.simple.dom.so.planillaCuadrilla;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanillaCuadrillaRepo extends JpaRepository<PlanillaCuadrilla,Long> {

    List<PlanillaCuadrilla> findAll();
}
