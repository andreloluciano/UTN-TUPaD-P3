package entities;
import java.util.Objects;

public class Producto extends Base {

    private String nombre;
    private double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;

    public Producto(int id, String nombre, double precio, String descripcion, int stock, String imagen, boolean disponible) {
        super(id);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public String getImagen() {
        return imagen;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", imagen='" + imagen + '\'' +
                ", disponible=" + disponible +
                '}';
    }

    @Override // dos productos con el mismo nombre seran considerados el mismo producto
    public boolean equals(Object o) {
        if (this == o) return true; // si son el mismo objeto en memoria son iguales
        // si el objeto es null o no pertenece a la clase Producto no son iguales
        if (o == null || getClass() != o.getClass()) return false;
        // convierto el Object recibido a producto para poder acceder a sus datos
        Producto producto = (Producto) o;

        // comparo por nombre
        return Objects.equals(nombre, producto.nombre);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nombre);    // como equals compara por nombre hashcode usa nombre
    }

}
