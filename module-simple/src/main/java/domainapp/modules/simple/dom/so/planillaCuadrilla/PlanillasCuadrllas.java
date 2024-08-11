package domainapp.modules.simple.dom.so.planillaCuadrilla;

import domainapp.modules.simple.SimpleModule;

import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;

import domainapp.modules.simple.dom.so.reclamo.Reclamo;

import lombok.RequiredArgsConstructor;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.NatureOfService;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Parameter;
import org.apache.causeway.applib.annotation.ParameterLayout;
import org.apache.causeway.applib.annotation.PriorityPrecedence;
import org.apache.causeway.applib.annotation.Programmatic;
import org.apache.causeway.applib.annotation.SemanticsOf;
import org.apache.causeway.applib.services.repository.RepositoryService;
import org.apache.causeway.applib.util.ObjectContracts;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

//@Named(SimpleModule.NAMESPACE_reclamos + ".PlanillaCuadrilla")
@DomainService(nature = NatureOfService.VIEW)
@Priority(PriorityPrecedence.EARLY)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class PlanillasCuadrllas {

    final PlanillaCuadrillaRepo planillaCuadrillaRepository;
    final RepositoryService repositoryService;

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listado de Planillas")
    public List<PlanillaCuadrilla> Listar(){
        return planillaCuadrillaRepository.findAll();
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Buscar por Cuadrilla")
    public PlanillaCuadrilla findByNombre(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por Cuadrilla")
            final Cuadrilla cuadrilla){
                return planillaCuadrillaRepository.findByNombre(cuadrilla);
    }

    @Programmatic
    public PlanillaCuadrilla createandupdate(
            final Cuadrilla cuadrilla,
            final Reclamo reclamoAsignado,
            final Respuesta seRealizoConexion,
            final Respuesta seCambioConexion,
            final Respuesta seReparoConexion,
            final Respuesta seAnuloConexion,
            final Respuesta seDestapoRed,
            final Respuesta colectoraNivelAlto,
            final Respuesta problemaInterno,
            final String observacion){
        return repositoryService.persist(planillaCuadrillaRepository.createandupdate(cuadrilla, reclamoAsignado, seRealizoConexion, seCambioConexion, seAnuloConexion, seReparoConexion, seDestapoRed, colectoraNivelAlto, problemaInterno, observacion));
    }

    /*@Action()
    @ActionLayout(named = "Editar")
    public PlanillaCuadrilla updatePlanillaCuadrilla(

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Se realizo conexion")
        final Respuesta seRealizoConexion,

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Se cambio conexion")
        final Respuesta seCambioConexion,

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Se reparo conexion")
        final Respuesta seReparoConexion,

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Se anulo conexion")
        final Respuesta seAnuloConexion,

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Se destapo red")
        final Respuesta seDestapoRed,

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Colectora nivel alto")
        final Respuesta colectoraNivelAlto,

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Problema Interno")
        final Respuesta problemaInterno,

        @Parameter(maxLength = 40)
        @ParameterLayout(named = "Observacion")
        final String observacion){

        this.seRealizoConexion = seRealizoConexion;
        this.seCambioConexion = seCambioConexion;
        this.seReparoConexion = seReparoConexion;
        this.seAnuloConexion = seAnuloConexion;
        this.seDestapoRed = seDestapoRed;
        this.colectoraNivelAlto = colectoraNivelAlto;
        this.problemaInterno = problemaInterno;
        this.observacion = observacion;

        return repositoryService.persist(PlanillaCuadrilla.updatePlanillaCuadrilla(seRealizoConexion, seCambioConexion, seReparoConexion,colectoraNivelAlto, seAnuloConexion, seDestapoRed, problemaInterno, observacion));
    }*/

    public int compareTo (final PlanillaCuadrilla other){
        return ObjectContracts.compare(this, other, "idPlanillaCuadrilla");
    }
}
