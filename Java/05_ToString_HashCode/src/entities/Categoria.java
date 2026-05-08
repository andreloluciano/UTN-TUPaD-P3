package entities;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base {

    private String nombre;
    private String descripcion;
    private Set<Producto> productos; // agregación con Productos
    // una categoria contiene productos, pero producto puede existir sin categoria

    public Categoria(int id, String nombre, String descripcion) {
        super(id);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = new HashSet<>(); // inicializo la coleccion
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", productos=" + productos +
                '}';
    }

    // equals compara categorías
    @Override
    public boolean equals(Object o) { // comparamos por nombre

        if (this == o) return true;  // Si son el mismo objeto en memoria

        if (o == null || getClass() != o.getClass()) return false; // Si no son la misma clase

        Categoria categoria = (Categoria) o; // convierto object a categoria

        return Objects.equals(nombre, categoria.nombre); // comparo por nombre
    }

    // debe usar el mismo campo que equals
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
