package domainapp.modules.simple.dom.so.planilaCuadrilla;

import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;

import java.math.BigInteger;

public class PlanillaCuadrilla {

    private BigInteger idPlanillaCuadrilla;
    private Cuadrilla cuadrilla;
    private Respuesta seRealizoConexion;
    private Respuesta seCambioConexion;
    private Respuesta seReparoConexion;
    private Respuesta seAnuloConexion;
    private Respuesta seDestapoRed;
    private Respuesta colectoraNivelAlto;
    private Respuesta problemaInterno;
    private Reclamo reclamoAsignado;
    private String observacion;
}
