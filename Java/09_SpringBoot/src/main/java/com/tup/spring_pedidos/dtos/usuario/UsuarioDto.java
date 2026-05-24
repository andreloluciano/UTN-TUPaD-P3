package com.tup.spring_pedidos.dtos.usuario;
import com.tup.spring_pedidos.enums.Rol;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Rol rol;
}