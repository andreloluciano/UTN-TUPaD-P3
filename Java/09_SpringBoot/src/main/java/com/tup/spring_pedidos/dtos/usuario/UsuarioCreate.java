package com.tup.spring_pedidos.dtos.usuario;
import enums.Rol;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioCreate {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    //private Rol rol; // testear con y sin rol
}