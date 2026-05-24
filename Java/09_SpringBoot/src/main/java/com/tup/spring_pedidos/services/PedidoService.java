package com.tup.spring_pedidos.services;
import com.tup.spring_pedidos.dtos.detallePedido.DetallePedidoCreate;
import com.tup.spring_pedidos.entities.Pedido;
import com.tup.spring_pedidos.entities.Producto;
import com.tup.spring_pedidos.entities.Usuario;
import com.tup.spring_pedidos.enums.Estado;
import com.tup.spring_pedidos.enums.FormaPago;
import com.tup.spring_pedidos.repositories.PedidoRepository;
import com.tup.spring_pedidos.repositories.ProductoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

// service para manejar la logica de pedidos
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository; // tambien necesito productos

    // inyeccion via constructor
    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    // crea un pedido usando usuario, datos del pedido y detalles desde dto
    public Pedido crearPedido(Usuario usuario, Estado estado, FormaPago formaPago,
                              List<DetallePedidoCreate> detallesDto) {
        // recibo lo necesario para crear un pedid oy lo creo
        Pedido pedido = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(estado)
                .formaPago(formaPago)
                .usuario(usuario)
                .build(); // sin detalles todavia

        for (DetallePedidoCreate detalleDto : detallesDto) {   // recorro los detalles recibidos

            // busco el producto usando el id que recibi
            Producto producto = productoRepository.findById(detalleDto.getProductoId())
                    .orElseThrow(() -> new RuntimeException("producto no encontrado"));
                    // si no encuentro id tiro error y corto el run

            // agrego el detalle al pedido
            pedido.addDetallePedido(detalleDto.getCantidad(), producto);
        }

        // guardo el pedido en la db
        return pedidoRepository.save(pedido);
    }
}
