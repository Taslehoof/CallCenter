package domainapp.modules.simple.dom.so.tecnico;

import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import org.apache.causeway.applib.annotation.*;
import java.util.List;

public class Tecnico implements Comparable<Tecnico>{
    @Property()
    @Title()
    private  int dni;

    @Property()
    @Title()
    private String nombre;

    @Property()
    private String apellido;

    @Property()
    private String direccion;

    @Property()
    private int telefono;

    @Property()
    private List<Cuadrilla> cuadrillaTecnico;

    public Tecnico(int dni, String nombre, String apellido, String direccion, int telefono) {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Cuadrilla> getCuadrillaTecnico() {
        return cuadrillaTecnico;
    }

    public void setCuadrillaTecnico(List<Cuadrilla> cuadrillaTecnico) {
        this.cuadrillaTecnico = cuadrillaTecnico;
    }

    public Tecnico() {}

    public Tecnico(int dni, String nombre, String apellido, String direccion, int telefono, List<Cuadrilla> cuadrillaTecnico) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuadrillaTecnico = cuadrillaTecnico;
    }

    @Override
    public int compareTo(Tecnico o) {
        return 0;
    }
}
