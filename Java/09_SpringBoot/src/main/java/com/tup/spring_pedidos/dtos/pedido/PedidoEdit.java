package com.tup.spring_pedidos.dtos.pedido;

import com.tup.spring_pedidos.enums.Estado;
import com.tup.spring_pedidos.enums.FormaPago;
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