package com.tup.spring_pedidos.services;

import com.tup.spring_pedidos.dtos.producto.ProductoCreate;
import com.tup.spring_pedidos.entities.Producto;
import com.tup.spring_pedidos.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

@Service // maneja la logica de productos
public class ProductoService {

    private final ProductoRepository productoRepository;
    // inyeccion via constructor
    public ProductoService(ProductoRepository productoRepository)
    {this.productoRepository = productoRepository;}

    // crea un producto a partir de dto
    public Producto crearProducto(ProductoCreate dto) {
        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .descripcion(dto.getDescripcion())
                .stock(dto.getStock())
                .imagen(dto.getImagen())
                .disponible(dto.isDisponible())
                .build();
        return productoRepository.save(producto);
    }
}