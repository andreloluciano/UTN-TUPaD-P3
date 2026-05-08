package entities;
import java.time.LocalDateTime;
import java.util.Objects;

public class Base {

    private int id;
    private boolean eliminado;
    private LocalDateTime creadoFecha;

    public Base(int id) {
        this.id = id;
        this.eliminado = false;
        this.creadoFecha = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public LocalDateTime getCreadoFecha() {
        return creadoFecha;
    }

    public void eliminar(){
        this.eliminado = true;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", eliminado=" + eliminado +
                ", creadoFecha=" + creadoFecha +
                '}';
    }

    @Override // compara objetos
    public boolean equals(Object o) {
        if (this == o) return true; // si son el mismo objeto en memoria
        Base base = (Base) o; // convierte objeto a Base
        return id == base.id; // compara por id
    }

    @Override // genera hash basado en id
    public int hashCode() {
        return Objects.hash(id);
    }
}
