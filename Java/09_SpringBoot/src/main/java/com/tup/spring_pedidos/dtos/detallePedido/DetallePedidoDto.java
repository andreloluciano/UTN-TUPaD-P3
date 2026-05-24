package com.tup.spring_pedidos.dtos.detallePedido;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoDto {
    private Long id;
    private int cantidad;
    private double subtotal;
    private Long productoId;
    private String productoNombre;
}