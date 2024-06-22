package domainapp.modules.simple.dom.so.cuadrilla;

import domainapp.modules.simple.dom.so.ayudante.Ayudante;
import domainapp.modules.simple.dom.so.reclamo.Reclamo;
import domainapp.modules.simple.dom.so.tecnico.Tecnico;

import org.apache.causeway.applib.annotation.Property;

import java.util.List;

public class Cuadrilla implements Comparable<Cuadrilla>{

    @Property()
    private String nombre;

    @Property()
    private Tecnico tecnico;

    @Property()
    private Ayudante ayudante;

    @Property()
   private List<Reclamo> relcamosAsignados;


    public Cuadrilla(String nombre, Tecnico tecnico, Ayudante ayudante) {}

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

    @Override
    public int compareTo(Cuadrilla o) {
        return 0;
    }
}
