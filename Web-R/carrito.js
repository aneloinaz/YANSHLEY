// Datos de productos (simulados aquí, pero en la práctica se obtendrían de productos.json)
const productos = [
    {
        "id_producto": 1,
        "nombre": "Camiseta Roja",
        "descripcion": "Camiseta de algodón roja, talla M",
        "precio": 19.99,
        "stock": 100,
        "fecha_creacion": "2025-02-10T12:00:00Z",
        "id_categoria": 1
    },
    {
        "id_producto": 2,
        "nombre": "Pantalón Jeans",
        "descripcion": "Pantalón de mezclilla, color azul, talla L",
        "precio": 39.99,
        "stock": 50,
        "fecha_creacion": "2025-02-09T14:30:00Z",
        "id_categoria": 2
    },
    {
        "id_producto": 3,
        "nombre": "Zapatos Deportivos",
        "descripcion": "Zapatos deportivos para correr, talla 42",
        "precio": 59.99,
        "stock": 75,
        "fecha_creacion": "2025-02-08T10:45:00Z",
        "id_categoria": 3
    }
];

// Carrito de compras
let carrito = [];

// Función para mostrar los productos
function mostrarProductos() {
    const listaProductos = document.getElementById("productos-lista");
    listaProductos.innerHTML = ""; // Limpiar la lista

    productos.forEach(producto => {
        const divProducto = document.createElement("div");
        divProducto.classList.add("producto");
        divProducto.innerHTML = `
            <h3>${producto.nombre}</h3>
            <p>${producto.descripcion}</p>
            <p>Precio: $${producto.precio}</p>
            <p>Stock: ${producto.stock}</p>
            <button onclick="agregarAlCarrito(${producto.id_producto})">Agregar al carrito</button>
        `;
        listaProductos.appendChild(divProducto);
    });
}

// Función para agregar productos al carrito
function agregarAlCarrito(idProducto) {
    const producto = productos.find(p => p.id_producto === idProducto);
    if (producto) {
        carrito.push(producto);
        actualizarCarrito();
    }
}

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
