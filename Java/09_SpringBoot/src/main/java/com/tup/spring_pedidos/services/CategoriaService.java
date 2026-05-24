package com.tup.spring_pedidos.services;

import com.tup.spring_pedidos.dtos.categoria.CategoriaCreate;
import com.tup.spring_pedidos.entities.Categoria;
import com.tup.spring_pedidos.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    // inyeccion por constructor
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // creo una categoria a partir de un dto
    public Categoria crearCategoria(CategoriaCreate dto) {
        Categoria categoria = Categoria.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();   // convierto dto a entidad

        // guardo entidad en la db
        return categoriaRepository.save(categoria);
    }
}
