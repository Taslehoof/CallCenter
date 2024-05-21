package domainapp.modules.simple.dom.so.cuadrilla;

import domainapp.modules.simple.dom.so.ayudannte.Ayudante;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import java.util.List;

public class Cuadrilla {

    private String nombre;
    private Tecnico tecnico;
    private Ayudante ayudante;
    private List<Reclamo> relcamosAsignados;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Ayudante getAyudante() {
        return ayudante;
    }

    public void setAyudante(Ayudante ayudante) {
        this.ayudante = ayudante;
    }

    public List<Reclamo> getRelcamosAsignados() {
        return relcamosAsignados;
    }

    public void setRelcamosAsignados(List<Reclamo> relcamosAsignados) {
        this.relcamosAsignados = relcamosAsignados;
    }

    public Cuadrilla() {}

    public Cuadrilla(String nombre, Tecnico tecnico, Ayudante ayudante, List<Reclamo> relcamosAsignados) {
        this.nombre = nombre;
        this.tecnico = tecnico;
        this.ayudante = ayudante;
        this.relcamosAsignados = relcamosAsignados;
    }
}
