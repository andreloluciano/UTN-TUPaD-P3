package com.tup.spring_pedidos.dtos.detallePedido;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoCreate {
    private int cantidad;
    private Long productoId;
}