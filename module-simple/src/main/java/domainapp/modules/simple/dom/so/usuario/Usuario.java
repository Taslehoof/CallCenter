package domainapp.modules.simple.dom.so.usuario;

import org.apache.isis.applib.annotation.*;
public class Usuario implements Comparable<Usuario>{

    @Property()
    @Title
    private int dni;

    @Property()
    @Title()
    private String nombre;

    @Property()
    private String apellido;

    @Property()
    private String direccion;

    @Property()
    private String email;

    @Property()
    private int telefono;

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    public Usuario() {}

    public Usuario(int dni, String nombre, String apellido, String direccion, String email, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public int compareTo(Usuario o) {
        return 0;
    }
}
