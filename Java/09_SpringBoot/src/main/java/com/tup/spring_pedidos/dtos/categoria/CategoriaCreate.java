package com.tup.spring_pedidos.dtos.categoria;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaCreate {
    private String nombre;
    private String descripcion;
}
