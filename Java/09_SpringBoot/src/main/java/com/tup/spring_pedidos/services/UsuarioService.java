package com.tup.spring_pedidos.services;

import com.tup.spring_pedidos.dtos.usuario.UsuarioCreate;
import com.tup.spring_pedidos.entities.Usuario;
import com.tup.spring_pedidos.enums.Rol;
import com.tup.spring_pedidos.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service // para manejar la logica de usuarios
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // inyecto por constructor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(UsuarioCreate dto) {

        // convierto dto a entidad
        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rol(Rol.USUARIO)
                .build();

        // guardo entidad en la db
        return usuarioRepository.save(usuario);
    }
}
