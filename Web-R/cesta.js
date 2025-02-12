// Función para mostrar los productos del carrito
function mostrarCarrito() {
    const carrito = JSON.parse(localStorage.getItem('carrito')) || [];
    const carritoContenedor = document.getElementById('carritoContenedor');
    carritoContenedor.innerHTML = '';  // Limpiar el contenedor

    // Calcular el total
    let total = 0;
    carrito.forEach(producto => {
        const productoElement = document.createElement('div');
        productoElement.classList.add('carrito');
        productoElement.innerHTML = `
            <h3>${producto.title}</h3>
            <img src="${producto.image}" alt="${producto.title}" width="100">
            <p>${producto.description}</p>
            <p><strong>Precio: $${producto.price}</strong></p>
            <button onclick="eliminarProducto(${producto.id_producto})">Eliminar</button>
        `;
        carritoContenedor.appendChild(productoElement);
        
        total += producto.price * producto.cantidad;
    });

    // Mostrar el total
    document.getElementById('totalCarrito').textContent = `$${total.toFixed(2)}`;
}

// Función para eliminar un producto del carrito
function eliminarProducto(id_producto) {
    let carrito = JSON.parse(localStorage.getItem('carrito')) || [];
    carrito = carrito.filter(producto => producto.id_producto !== id_producto); // Eliminar producto
    localStorage.setItem('carrito', JSON.stringify(carrito)); // Guardar el carrito actualizado
    mostrarCarrito();  // Actualizar la vista del carrito
}

// Función para vaciar el carrito
function vaciarCarrito() {
    localStorage.removeItem('carrito');  // Eliminar carrito del localStorage
    mostrarCarrito();  // Actualizar la vista del carrito
}

// Función para finalizar la compra (puedes agregar más lógica aquí)
function finalizarCompra() {
    alert("Compra finalizada. ¡Gracias por tu compra!");
    localStorage.removeItem('carrito');  // Limpiar el carrito después de la compra
    mostrarCarrito();  // Actualizar la vista del carrito
}

// Llamar a la función para mostrar el carrito al cargar la página
document.addEventListener('DOMContentLoaded', mostrarCarrito);
