package com.tup.spring_pedidos.dtos.usuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEdit {
    private String nombre;
    private String apellido;
    private String email;
}