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
// Función para añadir un producto al carrito
function agregarAlCarrito(id_producto, nombre, descripcion, precio, stock, imagen) {
    // Crear el objeto del producto
    const producto = {
        id_producto: id_producto,
        nombre: nombre,
        descripcion: descripcion,
        precio: precio,
        stock: stock,
        cantidad: 1, // Por defecto, añadir 1 unidad del producto
        imagen: imagen
    };

    // Obtener el carrito actual del localStorage, o un array vacío si no existe
    let carrito = JSON.parse(localStorage.getItem('carrito')) || [];

    // Verificar si el producto ya está en el carrito
    const productoExistente = carrito.find(item => item.id_producto === id_producto);
    if (productoExistente) {
        // Si el producto ya existe, incrementar la cantidad
        productoExistente.cantidad += 1;
    } else {
        // Si no existe, añadir el nuevo producto
        carrito.push(producto);
    }

    // Guardar el carrito actualizado en localStorage
    localStorage.setItem('carrito', JSON.stringify(carrito));

    // Informar al usuario
    alert('Producto añadido al carrito');
}

// Ejemplo de llamada a la función cuando el usuario hace clic en "Añadir al carrito"
document.querySelector("#btnAgregarAlCarrito").addEventListener("click", function() {
    const id_producto = 1; // Esto se debería obtener dinámicamente
    const nombre = "Producto ejemplo";
    const descripcion = "Descripción del producto";
    const precio = 20;
    const stock = 100;
    const imagen = "url_imagen.jpg"; // URL de la imagen

    agregarAlCarrito(id_producto, nombre, descripcion, precio, stock, imagen);
});
