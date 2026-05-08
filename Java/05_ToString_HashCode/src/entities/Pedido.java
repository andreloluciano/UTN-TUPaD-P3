package entities;
import enums.Estado;
import enums.FormaPago;
import interfaces.Calculable;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// hereda de base e implementa la interfaz Calculable
public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;
    private Usuario usuario; // asociacion con usuario, un pedido pertenece a un usuario
    private Set<DetallePedido> detallesPedido; // composicion con DetallePedido
    // un pedido contiene muchos detalles, si desaparece el pedido, los detalles tambien

    public Pedido (int id, LocalDate fecha, Estado estado, FormaPago formaPago, Usuario usuario){
        super(id);
        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.detallesPedido = new HashSet<>();      // inicializo el Set vacío
        this.total = 0; // inicializo total en 0
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }


    public FormaPago getFormaPago() {
        return formaPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

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
        DetallePedido detalle =
                new DetallePedido(detallesPedido.size() + 1,
                        cantidad,
                        producto);

        detallesPedido.add(detalle); // agrego detalle al set
        calcularTotal(); // recalculo total
    }

    public double getTotal() {
        return total;
    }

    public Set<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formaPago=" + formaPago +
                ", detallesPedido=" + detallesPedido +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // si son el mismo objeto

        if (o == null || getClass() != o.getClass()) return false;  // si no son de la misma clase
        Pedido pedido = (Pedido) o;
        return getId() == pedido.getId();  // comparacion por id heredado de Base
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getId()); // uso el mismo campo que equals
    }



}
