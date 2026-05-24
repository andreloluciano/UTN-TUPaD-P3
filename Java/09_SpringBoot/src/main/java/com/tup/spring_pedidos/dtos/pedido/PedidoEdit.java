package com.tup.spring_pedidos.dtos.pedido;

import enums.Estado;
import enums.FormaPago;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoEdit {
    private Estado estado;
    private FormaPago formaPago;
}