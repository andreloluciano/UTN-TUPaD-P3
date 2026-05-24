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
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    // punto 4 TP progFuncional
    public static void mostrarProductosConBajoStock(Set<Producto> productos, int stockMinimo) {
        productos.stream()
                .filter(producto -> producto.getStock() < stockMinimo) // filtro productos al valor indicado
                .forEach(producto -> System.out.println( // muestro los productos encontrados
                        producto.getNombre()
                                + " - stock: "
                                + producto.getStock()
                ));
    }

    public static void main(String[] args) {

        // creo el set general de productos
        //Set<Producto> productos = new HashSet<>();

        //TP JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidad");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

        Producto producto1 = Producto.builder()
                //.id(1)
                .nombre("Pizza Muzzarella")
                .precio(4500)
                .descripcion("pizza con queso")
                .stock(20)
                .imagen("pizza_muzzarella.jpg")
                .disponible(true)
                .build(); // creo el objeto

        Producto producto2 = Producto.builder()
                //.id(2)
                .nombre("Pizza Napolitana")
                .precio(5200)
                .descripcion("pizza con tomate")
                .stock(15)
                .imagen("pizza_napolitana.jpg")
                .disponible(true)
                .build();

        Producto producto3 = Producto.builder()
                //.id(3)
                .nombre("Pizza 4 Quesos")
                .precio(6800)
                .descripcion("pizza cuatro quesos")
                .stock(10)
                .imagen("pizza_4quesos.jpg")
                .disponible(true)
                .build();

        Producto producto4 = Producto.builder()
                //.id(4)
                .nombre("Hamburguesa Clasica")
                .precio(3800)
                .descripcion("hamburguesa simple")
                .stock(30)
                .imagen("hamburguesa_clasica.jpg")
                .disponible(true)
                .build();

        Producto producto5 = Producto.builder()
                //.id(5)
                .nombre("Hamburguesa BBQ Bacon")
                .precio(5100)
                .descripcion("hamburguesa con bacon")
                .stock(25)
                .imagen("hamburguesa_bbq.jpg")
                .disponible(true)
                .build();

        Producto producto6 = Producto.builder()
                //.id(6)
                .nombre("Hamburguesa Veggie")
                .precio(4200)
                .descripcion("hamburguesa vegetariana")
                .stock(5)
                .imagen("hamburguesa_veggie.jpg")
                .disponible(true)
                .build();

        Producto producto7 = Producto.builder()
                //.id(7)
                .nombre("Coca-Cola 500ml")
                .precio(1200)
                .descripcion("gaseosa fria")
                .stock(100)
                .imagen("cocacola.jpg")
                .disponible(true)
                .build();

        Producto producto8 = Producto.builder()
                //.id(8)
                .nombre("Jugo de Naranja")
                .precio(1800)
                .descripcion("jugo natural")
                .stock(40)
                .imagen("jugo_naranja.jpg")
                .disponible(true)
                .build();

        Producto producto9 = Producto.builder()
                //.id(9)
                .nombre("Agua Mineral")
                .precio(800)
                .descripcion("agua sin gas")
                .stock(150)
                .imagen("agua.jpg")
                .disponible(true)
                .build();

        Producto producto10 = Producto.builder()
                //.id(10)
                .nombre("Torta Rogel")
                .precio(3500)
                .descripcion("torta dulce")
                .stock(12)
                .imagen("torta_rogel.jpg")
                .disponible(true)
                .build();

        // agrego productos al set
        /*productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
         */

        // guardo los productos
        em.persist(producto1);
        em.persist(producto2);
        em.persist(producto3);
        em.persist(producto4);
        em.persist(producto5);
        em.persist(producto6);
        em.persist(producto7);
        em.persist(producto8);
        em.persist(producto9);
        em.persist(producto10);

        // usuarios
        Usuario usuario1 = Usuario.builder()
                //.id(1)
                .nombre("Luciano")
                .apellido("Andrelo")
                .email("luciano@mail.com")
                .password("1234")
                .rol(Rol.USUARIO)
                // pedidos se inicializa automaticamente en builder.default
                .build();

        Usuario usuario2 = Usuario.builder()
                //.id(2)
                .nombre("Aldo")
                .apellido("Lujan")
                .email("aldolujan@mail.com")
                .password("1234")
                .rol(Rol.USUARIO)
                // pedidos se inicializa automaticamente en builder.default
                .build();

// categorias
        Categoria categoria1 = Categoria.builder()
                //.id(1)
                .nombre("Pizzas")
                .descripcion("pizzas artesanales")
                // aca iria productos pero no hace falta porque usa builder.default
                .build();

        Categoria categoria2 = Categoria.builder()
                //.id(2)
                .nombre("Hamburguesas")
                .descripcion("hamburguesas gourmet")
                .build();

        Categoria categoria3 = Categoria.builder()
                //.id(3)
                .nombre("Bebidas")
                .descripcion("bebidas frias")
                .build();

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

        // guardo categorias
        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(categoria3);

        // pedidos
        Pedido pedido1 = Pedido.builder()
                //.id(1)
                .fecha(LocalDate.now())
                .estado(Estado.PENDIENTE)
                // aca iria total pero no hace falta porque usa builder.default
                .formaPago(FormaPago.EFECTIVO)
                .usuario(usuario1)
                // aca iria detallesPedido pero no hace falta porque usa builder.default
                .build();

        Pedido pedido2 = Pedido.builder()
                //.id(2)
                .fecha(LocalDate.now())
                .estado(Estado.CONFIRMADO)
                .formaPago(FormaPago.TARJETA)
                .usuario(usuario1)
                .build();

        Pedido pedido3 = Pedido.builder()
                //.id(3)
                .fecha(LocalDate.now())
                .estado(Estado.TERMINADO)
                .formaPago(FormaPago.TRANSFERENCIA)
                .usuario(usuario2)
                .build();

        // agrego detalles de pedido
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

        // persisto usuarios y por en cascada se guardan pedidos y detalles
        em.persist(usuario1);
        em.persist(usuario2);
        em.getTransaction().commit();
            System.out.println("datos persistidos");


        // busco por id
        Long idBuscado = usuario1.getId(); // obtengo id del usuario
        Usuario buscoUsuario = em.find(Usuario.class, idBuscado); // obtengo datos del usuario
            System.out.println(buscoUsuario != null ? buscoUsuario : "usuario no encontrado"); // verifico y sout

        // busco por mail
        Usuario buscoUsuarioMail = em.createQuery(
            "SELECT u FROM Usuario u WHERE u.email = :email", // parametr jpql
            Usuario.class ) // tipo de retorno
                .setParameter("email", "luciano@mail.com") // parametros
                .getSingleResult();

        System.out.println(buscoUsuarioMail != null ? buscoUsuarioMail : "usuario no encontrado"); // verifico y sout

        // actualizo productos
        em.getTransaction().begin();

        // obtengo ids
        Long idProducto1 = producto1.getId();
        Long idProducto2 = producto2.getId();
        Producto productoActualizar1 = em.find(Producto.class, idProducto1);
        Producto productoActualizar2 = em.find(Producto.class, idProducto2);

        if(productoActualizar1 != null) {
            productoActualizar1.setPrecio(5000);
            productoActualizar1.setStock(50);
            System.out.println("producto " + productoActualizar1.getNombre() + " actualizado");
        }

        // verifico producto 2
            if(productoActualizar2 != null) {
                productoActualizar2.setDescripcion("pizza napolitana especial");
                productoActualizar2.setDisponible(false);
                System.out.println("producto " + productoActualizar2.getNombre() + " actualizado");
            }

            // guardo en db
            em.getTransaction().commit();


        // borro un producto
         em.getTransaction().begin();
         Long idProductoEliminar = producto10.getId();
         Producto productoEliminar = em.find(Producto.class, idProductoEliminar);

         if (productoEliminar != null) {
             System.out.println("el producto " + productoEliminar.getNombre() + " sera eliminado");
             // elimino relacion (fk) con categoria, probar cascade.ALL o REMOVE ???
             categoria2.eliminarProducto(productoEliminar);

             em.remove(productoEliminar);
             System.out.println("se elimino el producto " + productoEliminar.getNombre()); // sigue existiendo en memoria
         } else {
             System.out.println("producto no encontrado");
         }

         em.getTransaction().commit(); // luego del commit se elimina de la db


        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("error al persistir los datos");
            e.printStackTrace(); // para ver datos del error

        } finally {
            em.close();
            emf.close();
        }

        /*
        // muestro tostring
        System.out.println("----- un producto -----");
        System.out.println(producto1);

        // muestro listado completo de productos
        System.out.println("\n----- listado de productos -----");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // busco usuario con mayor cantidad de pedidos
        Usuario usuarioConMasPedidos = usuario1;
        if (usuario2.getPedidos().size() > usuarioConMasPedidos.getPedidos().size()) {
            usuarioConMasPedidos = usuario2;
        }
        // muestro usuario con mas pedidos
        System.out.println("\n----- usuario con mas pedidos -----");
        System.out.println(usuarioConMasPedidos.getNombre()
                + " "
                + usuarioConMasPedidos.getApellido());
        // muestro pedidos del usuario con mas pedidos
        System.out.println("\n----- pedidos del usuario con mas pedidos -----");
        for (Pedido pedido : usuarioConMasPedidos.getPedidos()) {
            System.out.println(pedido);
        }

        // punto 5, ya que producto compara con nombre, creo otro con el mismo nombre
        Producto productoRepetido = Producto.builder()
                .id(99)
                .nombre("Pizza Muzzarella") // mismo nombre
                .precio(999999)
                .descripcion("producto repetido")
                .stock(1)
                .imagen("repetido.jpg")
                .disponible(true)
                .build();

        // comparo producto repetido con todos los productos del set
        // Pizza Muzzarella deberia dar true
        System.out.println("\n----- comparacion de equals -----");

        for (Producto producto : productos) {
            System.out.println(
                    "comparando con: "
                            + producto.getNombre()
                            + " = "
                            + productoRepetido.equals(producto)
            );
        }
       // System.out.println(productos.contains(productoRepetido)); // si da true es repetido

        // punto 2 TP progFuncional
        System.out.println("\n----- productos disponibles -----");
        productos.stream()
                .filter(producto -> producto.isDisponible())
                .forEach(producto -> System.out.println(producto));

        // punto 3 TP  progFuncional
        System.out.println("\n----- cantidad de items del pedido -----");
        System.out.println("El pedido 1 tiene " + pedido1.calcularCantidadItems() + " items");

        // punto 4 TP  progFuncional
        System.out.println("\n----- productos con bajo stock -----");
        mostrarProductosConBajoStock(productos, 6);
        */

    }
}
