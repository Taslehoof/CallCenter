package domainapp.modules.simple.dom.so.reclamo;

import domainapp.modules.simple.dom.so.cuadrilla.Cuadrilla;
import domainapp.modules.simple.dom.so.usuario.Usuario;
import java.time.LocalDate;

public class Reclamo {

    private Integer nroReclamo;
    private Usuario usuario;
    private String direccion;
    private LocalDate fecha = LocalDate.now();
    private TipoReclamo tipoReclamo;
    private String descripcion;
    private Estado estado;
    private Cuadrilla cuadrillaAsigna;

    public Integer getNroReclamo() {
        return nroReclamo;
    }

    public void setNroReclamo(Integer nroReclamo) {
        this.nroReclamo = nroReclamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoReclamo getTipoReclamo() {
        return tipoReclamo;
    }

    public void setTipoReclamo(TipoReclamo tipoReclamo) {
        this.tipoReclamo = tipoReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cuadrilla getCuadrillaAsigna() {
        return cuadrillaAsigna;
    }

    public void setCuadrillaAsigna(Cuadrilla cuadrillaAsigna) {
        this.cuadrillaAsigna = cuadrillaAsigna;
    }

    public Reclamo() {}

    public Reclamo(Integer nroReclamo, Usuario usuario, String direccion, LocalDate fecha, TipoReclamo tipoReclamo, String descripcion, Estado estado, Cuadrilla cuadrillaAsigna) {
        this.nroReclamo = nroReclamo;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.cuadrillaAsigna = cuadrillaAsigna;
    }

    @Override
    public String toString() {
        return "Reclamo{" +
                "nroReclamo=" + nroReclamo +
                ", usuario=" + usuario +
                ", direccion='" + direccion + '\'' +
                ", fecha=" + fecha +
                ", tipoReclamo=" + tipoReclamo +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", cuadrillaAsigna=" + cuadrillaAsigna +
                '}';
    }
}
