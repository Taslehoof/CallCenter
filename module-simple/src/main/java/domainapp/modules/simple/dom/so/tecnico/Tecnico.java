package domainapp.modules.simple.dom.so.tecnico;

import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import java.util.List;

public class Tecnico {
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private List<Cuadrilla> cuadrillaTecnico;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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

    public Tecnico(String dni, String nombre, String apellido, String direccion, int telefono, List<Cuadrilla> cuadrillaTecnico) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuadrillaTecnico = cuadrillaTecnico;
    }
}
