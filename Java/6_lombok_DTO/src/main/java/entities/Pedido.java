package entities;
import enums.Estado;
import enums.FormaPago;
import interfaces.Calculable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(exclude = "usuario") // evito usuario para prevenir stackoverflow
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
// hereda de base e implementa la interfaz Calculable
public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    @Builder.Default
    private double total = 0;
    private FormaPago formaPago;
    private Usuario usuario; // asociacion con usuario, un pedido pertenece a un usuario
    @Builder.Default
    private Set<DetallePedido> detallesPedido = new HashSet<>(); // composicion con DetallePedido
    // un pedido contiene muchos detalles, si desaparece el pedido, los detalles tambien

    @Override
    public void calcularTotal() {

        total = 0;  // reinicio el  total
        for (DetallePedido detalle : detallesPedido) { // recorro los detalles
            total += detalle.getSubtotal(); // sumo subtotales
        }
    }

    // metodo para agregar detalles al pedido
    public void addDetallePedido(int cantidad, Producto producto){
        // creo el detalle dentro de pedido
        DetallePedido detalle = DetallePedido.builder()
                .cantidad(cantidad)
                .producto(producto)
                .build();

        detalle.calcularSubtotal(); // el subtotal ya no se calcula dentro del constructor, entonces calculo manual

        detallesPedido.add(detalle); // agrego detalle al set
        calcularTotal(); // recalculo total
    }

}
