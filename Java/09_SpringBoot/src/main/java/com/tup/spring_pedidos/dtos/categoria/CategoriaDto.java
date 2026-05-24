package com.tup.spring_pedidos.dtos.categoria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDto {
    private Long id;
    private String nombre;
    private String descripcion;
}
