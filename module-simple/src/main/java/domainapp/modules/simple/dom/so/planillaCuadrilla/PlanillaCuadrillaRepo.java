package domainapp.modules.simple.dom.so.planillaCuadrilla;

import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanillaCuadrillaRepo extends JpaRepository<PlanillaCuadrilla,Long> {

    List<PlanillaCuadrilla> findAll();

    PlanillaCuadrilla createandupdate(final Cuadrilla cuadrilla, final Reclamo reclamoAsignado, final Respuesta seRealizoConexion, final Respuesta seCambioConexion, final Respuesta seReparoConexion, final Respuesta seAnuloConexin, final Respuesta seDestapoRed, final Respuesta colectoraNivelAlto, final Respuesta problemaInterno, final String observacion);

    PlanillaCuadrilla findByNombre(final Cuadrilla cuadrilla);

    //PlanillaCuadrilla updatePlanillaCuadrilla(final Cuadrilla cuadrilla, final Reclamo reclamoAsignado, final Respuesta seRealizoConexion, final Respuesta seCambioConexion, final Respuesta seReparoConexion, final Respuesta seAnuloConexin, final Respuesta seDestapoRed, final Respuesta colectoraNivelAlto, final Respuesta problemaInterno, final String observacion);
}
