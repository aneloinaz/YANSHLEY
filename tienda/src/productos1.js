// Función para cargar productos desde la API
function cargarProductos() {
    fetch('https://fakestoreapi.com/products')  // Cambia la URL por la de tu API
        .then(response => response.json())
        .then(productos => {
            productos.forEach(producto => {
                const productoElement = document.createElement('div');
                productoElement.classList.add('producto');
                productoElement.innerHTML = `
                <h3>${producto.title}</h3>
                <img src="${producto.image}" alt="${producto.title}" width="100">
                <p>${producto.description}</p>
                <p><strong>Precio: $${producto.price}</strong></p>
                <button onclick='agregarAlCarrito(${producto.id}, "${producto.title}", "${producto.description}",${producto.price}, ${producto.stock}, "${producto.image}")'>Añadir al carrito</button>
                `;
                document.getElementById('productos-lista').appendChild(productoElement);
            });
        })
        .catch(error => console.error('Error al cargar los productos:', error));
}

// Llamar la función para cargar los productos al cargar la página
document.addEventListener('DOMContentLoaded', cargarProductos);

// Función para agregar productos al carrito
function agregarAlCarrito(id_producto, title, description, price, stock, image) {
    const producto = {
        id_producto:id_producto,
        title:title,
        image:image,
        description:description,
        price:price,
        stock:stock,
        cantidad: 1,  // Asumimos que el usuario agrega una unidad
        
    };

    // Obtener el carrito del localStorage, si no existe inicializa como un array vacío
    let carrito = JSON.parse(localStorage.getItem('carrito')) || [];

    // Verificar si el producto ya está en el carrito
    const productoExistente = carrito.find(item => item.id_producto === id_producto);
    if (productoExistente) {
        productoExistente.cantidad += 1;  // Aumentar la cantidad
    } else {
        carrito.push(producto);
    }

    // Guardar el carrito actualizado en localStorage
    localStorage.setItem('carrito', JSON.stringify(carrito));
    console.log(producto);
    alert('Producto añadido al carrito');
}
