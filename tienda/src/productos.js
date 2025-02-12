let carrito = []; // Array para almacenar los productos en el carrito

// Función para cargar el carrito desde localStorage
function cargarCarrito() {
    const carritoGuardado = localStorage.getItem("carrito");
    if (carritoGuardado) {
        carrito = JSON.parse(carritoGuardado);
    }
}

// Llamar a la función para cargar el carrito al inicio
cargarCarrito();

async function productosapi() {
    try {
        // Obtener los productos de la API
        const respuesta = await fetch('https://fakestoreapi.com/products');
        const datos = await respuesta.json();

        // Seleccionar el contenedor en el HTML donde se mostrarán los productos
        const contenedorProductos = document.getElementById('productos-lista');
        
        // Limpiar el contenedor antes de agregar nuevos productos
        contenedorProductos.innerHTML = '';

        // Iterar sobre los productos y crear elementos HTML para cada uno
        datos.forEach(producto => {
            const divProducto = document.createElement('div');
            divProducto.classList.add('producto');

            // Crear contenido dentro del contenedor del producto
            divProducto.innerHTML = `
                <h3>${producto.title}</h3>
                <img src="${producto.image}" alt="${producto.title}" width="100">
                <p>${producto.description}</p>
                <p><strong>Precio: $${producto.price}</strong></p>
                <button onclick="agregarAlCarrito(${producto.id}, '${producto.title.replace(/'/g, "\\'")}', ${producto.price})">Agregar al carrito</button>
            `;

            // Agregar el div del producto al contenedor principal
            contenedorProductos.appendChild(divProducto);
        });
    } catch (error) {
        console.error("Hubo un error al obtener los productos:", error);
    }
}

// Función para agregar productos al carrito
function agregarAlCarrito(id, nombre, precio) {
    // Verificar si el producto ya está en el carrito
    const productoExistente = carrito.find(producto => producto.id === id);
    if (productoExistente) {
        // Si el producto ya está en el carrito, incrementar la cantidad
        productoExistente.cantidad++;
    } else {
        // Si no está, agregar el producto al carrito con cantidad 1
        carrito.push({
            id,
            nombre,
            precio,
            cantidad: 1
        });
    }
    localStorage.setItem("carrito", JSON.stringify(carrito));

    // Mostrar el carrito actualizado
    mostrarCarrito();

    // Mostrar una notificación de que el producto fue agregado
    alert(`${nombre} ha sido agregado al carrito.`);
}

// Función para mostrar el carrito
function mostrarCarrito() {
    const contenedorCarrito = document.getElementById('carrito');
    contenedorCarrito.innerHTML = ''; // Limpiar el carrito antes de mostrarlo

    if (carrito.length === 0) {
        contenedorCarrito.innerHTML = '<p>El carrito está vacío.</p>';
        return;
    }

    // Crear un listado con los productos del carrito
    carrito.forEach(producto => {
        const divProducto = document.createElement('div');
        divProducto.classList.add('carrito');
        divProducto.innerHTML = `
            <p>${producto.nombre} x ${producto.cantidad} - $${producto.precio * producto.cantidad}</p>
        `;
        contenedorCarrito.appendChild(divProducto);
    });

    // Mostrar el total del carrito
    const total = carrito.reduce((total, producto) => total + (producto.precio * producto.cantidad), 0);
    const totalCarrito = document.createElement('div');
    totalCarrito.innerHTML = `<p><strong>Total: $${total}</strong></p>`;
    contenedorCarrito.appendChild(totalCarrito);
}


// Llamar a la función para mostrar los productos cuando se cargue la página
productosapi();
mostrarCarrito(); // Mostrar el carrito al cargar la página*/