package entities;
import java.util.Objects;

public class DetallePedido extends Base {

    private int cantidad;
    private double subtotal;
    private Producto producto; // asociacion con producto, un detalle pertenece a otro producto

    public DetallePedido(int id, int cantidad, Producto producto) {
        super(id);
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = cantidad * producto.getPrecio();  // calculo el subtotal al crear el detalle
    }

    public int getCantidad() {
        return cantidad;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", producto=" + producto.getNombre() +
                '}';
    }

    // equals compara detalles, comparamos por product
    // en un Set no se repetiría el mismo producto en el mismo pedido
    @Override
    public boolean equals(Object o) {
        // si son el mismo objeto en memoria, son iguales
        if (this == o) return true;
        // si el objeto es null o no es de la misma clase, no son iguales
        if (o == null || getClass() != o.getClass()) return false;
        // convierto Object a DetallePedido.
        DetallePedido that = (DetallePedido) o;
        // comparo por producto.
        return Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() { // hashCode usa el mismo campo que equals
        return Objects.hash(producto);  // si equals compara producto hashCode tambien debe usar producto
    }

    // al comparar DetallePedido por producto,
    // un mismo Pedido no puede tener dos detalles del mismo producto dentro del Set

}
