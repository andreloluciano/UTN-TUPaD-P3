package com.tup.spring_pedidos.dtos.pedido;

import com.tup.spring_pedidos.enums.Estado;
import com.tup.spring_pedidos.enums.FormaPago;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDto {
    private Long id;
    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;
    private Long usuarioId;
}