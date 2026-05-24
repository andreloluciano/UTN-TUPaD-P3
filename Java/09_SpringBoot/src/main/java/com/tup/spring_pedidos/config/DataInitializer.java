package com.tup.spring_pedidos.config;

import com.tup.spring_pedidos.dtos.producto.ProductoCreate;
import com.tup.spring_pedidos.dtos.usuario.UsuarioCreate;
import com.tup.spring_pedidos.services.PedidoService;
import com.tup.spring_pedidos.services.ProductoService;
import com.tup.spring_pedidos.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.tup.spring_pedidos.entities.Usuario;
import com.tup.spring_pedidos.entities.Producto;
import com.tup.spring_pedidos.dtos.detallePedido.DetallePedidoCreate;
import com.tup.spring_pedidos.enums.Estado;
import com.tup.spring_pedidos.enums.FormaPago;
import java.util.List;

@Component // componente que se ejecuta al iniciar la aplicacion
public class DataInitializer implements CommandLineRunner {
    private final UsuarioService usuarioService;
    private final ProductoService productoService;
    private final PedidoService pedidoService;

    //  inyecto el service por constructor
    public DataInitializer(UsuarioService usuarioService, ProductoService productoService,  PedidoService pedidoService) {
        this.usuarioService = usuarioService;
        this.productoService = productoService;
        this.pedidoService = pedidoService;
    }

    @Override
    public void run(String[] args) {

        // dto para crear usuarios
        UsuarioCreate usuario1 = UsuarioCreate.builder()
                .nombre("Luciano")
                .apellido("Andrelo")
                .email("luciano@mail.com")
                .password("1234")
                .build();

        UsuarioCreate usuario2 = UsuarioCreate.builder()
                .nombre("Aldo")
                .apellido("Lujan")
                .email("aldolujan@mail.com")
                .password("1234")
                .build();

        ProductoCreate producto1 = ProductoCreate.builder()
                .nombre("Pizza Muzzarella")
                .precio(4500)
                .descripcion("pizza con queso")
                .stock(20)
                .imagen("pizza_muzzarella.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto2 = ProductoCreate.builder()
                .nombre("Pizza Napolitana")
                .precio(5200)
                .descripcion("pizza con tomate")
                .stock(15)
                .imagen("pizza_napolitana.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto3 = ProductoCreate.builder()
                .nombre("Pizza 4 Quesos")
                .precio(6800)
                .descripcion("pizza cuatro quesos")
                .stock(10)
                .imagen("pizza_4quesos.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto4 = ProductoCreate.builder()
                .nombre("Hamburguesa Clasica")
                .precio(3800)
                .descripcion("hamburguesa simple")
                .stock(30)
                .imagen("hamburguesa_clasica.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto5 = ProductoCreate.builder()
                .nombre("Hamburguesa BBQ Bacon")
                .precio(5100)
                .descripcion("hamburguesa con bacon")
                .stock(25)
                .imagen("hamburguesa_bbq.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto6 = ProductoCreate.builder()
                .nombre("Hamburguesa Veggie")
                .precio(4200)
                .descripcion("hamburguesa vegetariana")
                .stock(5)
                .imagen("hamburguesa_veggie.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto7 = ProductoCreate.builder()
                .nombre("Coca-Cola 500ml")
                .precio(1200)
                .descripcion("gaseosa fria")
                .stock(100)
                .imagen("cocacola.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto8 = ProductoCreate.builder()
                .nombre("Jugo de Naranja")
                .precio(1800)
                .descripcion("jugo natural")
                .stock(40)
                .imagen("jugo_naranja.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto9 = ProductoCreate.builder()
                .nombre("Agua Mineral")
                .precio(800)
                .descripcion("agua sin gas")
                .stock(150)
                .imagen("agua.jpg")
                .disponible(true)
                .build();

        ProductoCreate producto10 = ProductoCreate.builder()
                .nombre("Torta Rogel")
                .precio(3500)
                .descripcion("torta dulce")
                .stock(12)
                .imagen("torta_rogel.jpg")
                .disponible(true)
                .build();

        // creo a partir de dtos
        usuarioService.crearUsuario(usuario1);
        usuarioService.crearUsuario(usuario2);
        productoService.crearProducto(producto1);
        productoService.crearProducto(producto2);
        productoService.crearProducto(producto3);
        productoService.crearProducto(producto4);
        productoService.crearProducto(producto5);
        productoService.crearProducto(producto6);
        productoService.crearProducto(producto7);
        productoService.crearProducto(producto8);
        productoService.crearProducto(producto9);
        productoService.crearProducto(producto10);

        System.out.println("usuarios creados");
        System.out.println("productos creados desde dtos");

    }
}
