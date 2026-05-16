package entities;
import java.util.Objects;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "producto", callSuper = false) // compara detalles por producto
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DetallePedido extends Base {
    private int cantidad;
    private double subtotal; // subtotal se calcula automaticamente, depende de cantidad y precio
    // asociacion con producto
    private Producto producto;  // un detalle pertenece a un producto

    // recalcula subtotal segun cantidad y producto
    public void calcularSubtotal() {
        subtotal = cantidad * producto.getPrecio();
    }

}
