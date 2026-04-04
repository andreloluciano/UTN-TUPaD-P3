// A. Función para renderizar las categorías
const cargarCategorias = () => {
    // 1. Seleccionamos el <ul> donde irán las categorías 
    // Usamos el ID que definimos en el Paso 1 
    const contenedorCategorias = document.getElementById('lista-categorias');

    // 2. Recorremos el array 'categorias' que definimos en data.js 
    // Usamos forEach porque es más legible que un for tradicional 
    categorias.forEach((categoria) => {
        // 3. Por cada categoría, "inyectamos" un <li> con su <a> adentro 
        // Usamos += para ir sumando elementos sin borrar los anteriores
        // El ${categoria} pone el nombre de la categoría automáticamente 
        contenedorCategorias.innerHTML += `
            <li>
                <a href="#">${categoria}</a>
            </li>
        `;
    });
};

// 4. MUY IMPORTANTE: Llamamos a la función para que se ejecute al cargar la página
cargarCategorias();

// B. Función para renderizar los productos
const cargarProductos = () => {
    // 1. Seleccionamos el contenedor de productos (el <section> con id) 
    const contenedor = document.getElementById('contenedor-productos');

    // 2. Iteramos sobre el array de productos 
    productos.forEach((producto) => {
        // 3. Creamos la estructura HTML dinámicamente 
        // Usamos las comillas invertidas `` para meter las variables con ${} 
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

// 5. Ejecutamos la función al cargar la página 
cargarProductos();