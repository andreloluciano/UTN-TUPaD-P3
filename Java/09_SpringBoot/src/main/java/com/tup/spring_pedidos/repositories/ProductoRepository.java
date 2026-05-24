package com.tup.spring_pedidos.repositories;

import com.tup.spring_pedidos.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository // acceder a productos en la db
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Optional<Producto> findByNombre(String nombre);// para buscar producto por nombre
}
