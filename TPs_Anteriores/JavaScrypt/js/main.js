//Función para renderizar las categorías
const cargarCategorias = () => {
    const contenedorCategorias = document.getElementById('lista-categorias');
    //Recorremos el array 'categorias' que definimos en data.js 
    categorias.forEach((categoria) => {
        contenedorCategorias.innerHTML += `
            <li>
                <a href="#">${categoria}</a>
            </li>
        `;
    });
};

//Llamamos a la función para que se ejecute al cargar la página
cargarCategorias();

//Función para renderizar los productos
const cargarProductos = () => {
    const contenedor = document.getElementById('contenedor-productos');

    productos.forEach((producto) => {
        contenedor.innerHTML += `
            <article class="producto-card">
                <img src="${producto.imagen}" alt="${producto.nombre}" width="250px">
                <h3>${producto.nombre}</h3>
                <p>${producto.descripcion}</p>
                <p><strong>Precio: ${producto.precio} dólares</strong></p>
                
                <button onclick="alert('Has seleccionado: ${producto.nombre}')">
                    Agregar al carrito
                </button>
            </article>
            <br>
        `;
    });
};

//Ejecutamos la función al cargar la página 
cargarProductos();