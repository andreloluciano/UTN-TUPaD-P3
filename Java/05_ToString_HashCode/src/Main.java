import enums.Estado;
import enums.FormaPago;
import enums.Rol;
import entities.Categoria;
import entities.Pedido;
import entities.Producto;
import entities.Usuario;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // creo el set general de productos
        Set<Producto> productos = new HashSet<>();

        // instancio 10 productos
        Producto producto1 = new Producto(1, "Mouse Logitech", 25000, "mouse inalambrico", 20, "mouse.jpg", true);
        Producto producto2 = new Producto(2, "Teclado Redragon", 45000, "teclado mecanico", 15, "teclado.jpg", true);
        Producto producto3 = new Producto(3, "Monitor Samsung", 180000, "monitor 24 pulgadas", 8, "monitor.jpg", true);
        Producto producto4 = new Producto(4, "Auriculares HyperX", 70000, "auriculares gamer", 12, "auriculares.jpg", true);
        Producto producto5 = new Producto(5, "Mousepad XL", 15000, "mousepad grande", 30, "mousepad.jpg", true);
        Producto producto6 = new Producto(6, "Notebook Lenovo", 900000, "notebook i5", 5, "notebook.jpg", true);
        Producto producto7 = new Producto(7, "Parlantes Genius", 30000, "parlantes stereo", 10, "parlantes.jpg", true);
        Producto producto8 = new Producto(8, "Webcam Logitech", 60000, "webcam full hd", 6, "webcam.jpg", true);
        Producto producto9 = new Producto(9, "Microfono Fifine", 80000, "microfono usb", 7, "microfono.jpg", true);
        Producto producto10 = new Producto(10, "Silla Gamer", 250000, "silla ergonomica", 4, "silla.jpg", true);

        // agrego los productos al set
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);

        // instancio categorias
        Categoria categoria1 = new Categoria(1, "Perifericos", "productos para usar con la computadora");
        Categoria categoria2 = new Categoria(2, "Computadoras", "equipos informaticos");
        Categoria categoria3 = new Categoria(3, "Audio", "productos de sonido");

        // agregacion entre categoria y producto
        // la categoria agrupa productos pero el producto puede existir sin categoria
        categoria1.agregarProducto(producto1);
        categoria1.agregarProducto(producto2);
        categoria1.agregarProducto(producto5);
        categoria1.agregarProducto(producto8);
        categoria1.agregarProducto(producto9);

        categoria2.agregarProducto(producto3);
        categoria2.agregarProducto(producto6);
        categoria2.agregarProducto(producto10);

        categoria3.agregarProducto(producto4);
        categoria3.agregarProducto(producto7);

        // instancio usuarios
        Usuario usuario1 = new Usuario(1, "Luciano", "Andrelo", "luciano@mail.com", "1234", Rol.USUARIO);
        Usuario usuario2 = new Usuario(2, "Aldo", "Lujan", "AldoLujan@mail.com", "1234", Rol.USUARIO);

        // instancio pedidos
        Pedido pedido1 = new Pedido(1, LocalDate.now(), Estado.PENDIENTE, FormaPago.EFECTIVO, usuario1);
        Pedido pedido2 = new Pedido(2, LocalDate.now(), Estado.CONFIRMADO, FormaPago.TARJETA, usuario1);
        Pedido pedido3 = new Pedido(3, LocalDate.now(), Estado.TERMINADO, FormaPago.TRANSFERENCIA, usuario2);

        // composicion entre pedido y detallepedido
        // el detalle se crea dentro del pedido con addDetallePedido
        pedido1.addDetallePedido(2, producto1);
        pedido1.addDetallePedido(1, producto2);

        pedido2.addDetallePedido(1, producto3);
        pedido2.addDetallePedido(2, producto4);

        pedido3.addDetallePedido(1, producto6);
        pedido3.addDetallePedido(3, producto7);

        // asociacion entre usuario y pedido
        usuario1.addPedido(pedido1);
        usuario1.addPedido(pedido2);
        usuario2.addPedido(pedido3);

        // muestro un producto usando tostring
        System.out.println("----- un producto -----");
        System.out.println(producto1);

        // muestro listado de productos
        System.out.println("\n----- listado de productos -----");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // busco el usuario que mas pedidos tiene
        Usuario usuarioConMasPedidos = usuario1;

        if (usuario2.getPedidos().size() > usuarioConMasPedidos.getPedidos().size()) {
            usuarioConMasPedidos = usuario2;
        }

        // muestro los pedidos del usuario con mas pedidos
        System.out.println("\n----- usuario con mas pedidos -----");
        System.out.println(usuarioConMasPedidos.getNombre() + " " + usuarioConMasPedidos.getApellido());

        System.out.println("\n----- pedidos del usuario con mas pedidos -----");
        for (Pedido pedido : usuarioConMasPedidos.getPedidos()) {
            System.out.println(pedido);
        }

        // creo un producto nuevo con el mismo nombre que producto1
        // como equals compara por nombre, este producto se considera igual a producto1
        Producto productoRepetido = new Producto(99, "Mouse Logitech", 99999, "mouse repetido", 3, "mouse2.jpg", true);

        // comparo el producto repetido contra toda la coleccion
        System.out.println("\n----- comparacion con producto repetido -----");
        System.out.println("producto nuevo: " + productoRepetido);
        System.out.println("el set contiene el producto repetido?: " + productos.contains(productoRepetido));

        // intento agregarlo al set
        boolean agregado = productos.add(productoRepetido);

        System.out.println("se pudo agregar al set?: " + agregado);
        System.out.println("cantidad final de productos: " + productos.size());
    }



}
