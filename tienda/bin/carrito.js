// Datos de productos (simulados aquí, pero en la práctica se obtendrían de productos.json)
const productos = {
    
        id_producto:"",
        nombre:"",
        descripcion:"",
        precio:"",
        stock:"",
        fecha_creacion:"",
        id_categoria:""
    
};

// Carrito de compras
let carrito = [];


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
/*productosapi();
mostrarCarrito(); // Mostrar el carrito al cargar la página*/

// Función para actualizar el carrito y el total
function actualizarCarrito() {
    const carritoItems = document.getElementById("carrito-items");
    const totalElem = document.getElementById("total");
    carritoItems.innerHTML = ""; // Limpiar el carrito

    let total = 0;
    carrito.forEach(item => {
        const divItem = document.createElement("div");
        divItem.innerHTML = `
            <p>${item.nombre} - $${item.precio}</p>
        `;
        carritoItems.appendChild(divItem);
        total += item.precio;
    });

    totalElem.textContent = total.toFixed(2);
}

// Función para realizar el pedido (simplemente muestra una alerta)
function realizarPedido() {
    if (carrito.length === 0) {
        alert("El carrito está vacío. Agrega productos antes de hacer un pedido.");
        return;
    }

    alert("Pedido realizado con éxito. Total: $" + document.getElementById("total").textContent);
    carrito = []; // Vaciar el carrito después del pedido
    actualizarCarrito(); // Actualizar la vista del carrito
}

// Cargar los productos al cargar la página
mostrarProductos();
