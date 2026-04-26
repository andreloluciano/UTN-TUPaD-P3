import { PRODUCTS, getCategories } from "../../../data/data";
const inputBuscar = document.getElementById("buscar") as HTMLInputElement;


// contenedor
const contenedor = document.getElementById("contenedor-productos") as HTMLDivElement;
const listaCategorias = document.getElementById("lista-categorias") as HTMLUListElement; //importo categorias


// funcion para agregar productos al carrito
const agregarAlCarrito = (producto: any) => { 
  // traigo carrito del localstg, si no existe creo array vacio
  const carrito = JSON.parse(localStorage.getItem("cart") || "[]");

  // busco si el producto ya existe
  const existe = carrito.find((item: any) => item.id === producto.id);

  if (existe) {
    existe.quantity += 1; // aumento cantidad si existe
  } else {
    carrito.push({ ...producto, quantity: 1 }); // sino, agrego con cantidad 1
  }

  localStorage.setItem("cart", JSON.stringify(carrito)); // guardo carrito actualizado el localSt

  alert("Producto agregado al carrito");
};

// función render, recorre los productos y los mete dentr odel contenedor
const renderProductos = (productos: typeof PRODUCTS) => { 
  contenedor.innerHTML = ""; // limpia antes de renderizar

  // si no hay productos para mostrar muestro mensaje
if (productos.length === 0) {
  const mensaje = document.createElement("p");
  mensaje.textContent = "No se encontraron productos";

  contenedor.appendChild(mensaje);
  return; // corto la funcion
}

  productos.forEach((producto) => {
    const card = document.createElement("div"); // creo la card donde van los datos

    card.innerHTML = `
      <h3>${producto.nombre}</h3>
      <p>${producto.descripcion}</p>
      <p>Precio: $${producto.precio}</p>
    `;

    // boton
    const button = document.createElement("button");
button.textContent = "Agregar al carrito";

button.addEventListener("click", () => {
  agregarAlCarrito(producto);
});

card.appendChild(button); // agrego el boton a la card

    contenedor.appendChild(card); // meto producto(card) dentro del contenedor
  });
};

// función para mostrar categorías en pantalla
const renderCategorias = () => {
  const categorias = getCategories(); // traigo categorias desde data.ts
  listaCategorias.innerHTML = ""; // limpio antes de renderizar
 
  const liTodos = document.createElement("li");  // opcion para mostrar todos los productos 
  liTodos.textContent = "Todos";
  liTodos.addEventListener("click", () => {
    renderProductos(PRODUCTS);
  });

  listaCategorias.appendChild(liTodos);

  // recorro categorias y muestro
  categorias.forEach((categoria) => {
    const li = document.createElement("li");
    li.textContent = categoria.nombre;

    // evento de click para filtrar productos por categoria
    li.addEventListener("click", () => {
      const productosFiltrados = PRODUCTS.filter((producto) => // filtra solo con cards de esa categoria
        producto.categorias.some((cat) => cat.nombre === categoria.nombre)
      ); // some pregunta si el producto tiene alguna categoria con ese nombre (por ser ICategory[])

      renderProductos(productosFiltrados);
    });

    listaCategorias.appendChild(li);
  });
};

// funcion busqueda
inputBuscar.addEventListener("input", () => { // listener para cuando el usuario escribe

  const texto = inputBuscar.value.toLowerCase(); // capturo texto ingresado

  const productosFiltrados = PRODUCTS.filter((producto) => // filtro productos que coincidan con el texto ingresado
    producto.nombre.toLowerCase().includes(texto)
  );

  // renderizo resultados
  renderProductos(productosFiltrados);
});

// render inicial
renderProductos(PRODUCTS); 
renderCategorias();

//console.log(contenedor) // testeo para ver productos