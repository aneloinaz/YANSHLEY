// Función para cargar todos los productos desde la API
function cargarTodosLosProductos() {
    fetch('http://localhost/productos.json')
        .then(res => {
            if (!res.ok) throw new Error('Error en la respuesta de la API');
            return res.json();
        })
        .then(json => {
            const container = document.getElementById('productos-lista');
            if (!container) {
                console.error('Error: No se encontró el elemento con id "productos-lista"');
                return;
            }
            container.innerHTML = '';
            json.forEach(product => {
                // Verificación de la URL de la imagen
                const imgUrl = product.imagen.startsWith('http') ? product.imagen : `http://localhost/${product.imagen}`;
                
                // Prueba la URL en la consola
                console.log('URL de la imagen:', imgUrl);

                const
                 div = document.createElement('div');
                div.innerHTML = `
                    <div class="producto">
                        <img class="img-producto" src="${imgUrl}" alt="${product.nombre}" style="height:300px;margin-top:20px;" onclick="verProducto(${product.id})" onerror="this.onerror=null; this.src='https://via.placeholder.com/300x300?text=No+Image';">
                        <h2 style="height:55px; overflow:hidden;">${product.nombre}</h2>
                        <p><b>${product.precio}€</b></p>
                    </div>
                    <br>
                `;
                container.appendChild(div);
            });
        })
        .catch(error => console.error('Error al cargar los productos:', error));
}

// Función para cargar todos los productos después de hacer clic en el botón de productos
function verProductos() {
    cargarTodosLosProductos();
}

// Función para ver un producto específico
function verProducto(productId) {
    fetch('http://localhost/productos.json')
        .then(res => {
            if (!res.ok) throw new Error('Error en la respuesta de la API');
            return res.json();
        })
        .then(json => {
            const product = json.find(item => item.id === productId);
            if (!product) {
                console.error('Producto no encontrado');
                return;
            }

            const container = document.getElementById('productos-lista');
            container.innerHTML = '';

            const imgUrl = product.imagen.startsWith('http') ? product.imagen : `http://localhost/${product.imagen}`;
            const div = document.createElement('div');
            div.innerHTML = `
                <div class="producto">
                    <img class="img-producto" src="${imgUrl}" alt="${product.nombre}" style="height:300px;margin-top:20px;" onerror="this.onerror=null; this.src='https://via.placeholder.com/300x300?text=No+Image';">
                    <h2 style="height:55px; overflow:hidden;">${product.nombre}</h2>
                    <p><a class="Descripcion" style="height:200px; overflow:auto;">${product.descripcion}</a></p>
                    <p><b>${product.precio}€</b></p>
                    <button style="border: none; background-color: white;">
                        <a onclick="agregarAlCarrito(${product.id}, '${product.nombre}', '${product.descripcion}', ${product.precio}, ${product.stock}, '${product.imagen}')">Añadir al carrito</a>
                    </button>
                </div>
                <br>
            `;
            container.appendChild(div);
        })
        .catch(error => console.error('Error al cargar el producto:', error));
}

// Función para ver todos los productos de una categoría
function verCategoria(categoria) {
    fetch('http://localhost/productos.json')
        .then(res => {
            if (!res.ok) throw new Error('Error en la respuesta de la API');
            return res.json();
        })
        .then(products => {
            const container = document.getElementById('productos-lista');
            container.innerHTML = '';

            const productosFiltrados = products.filter(product => product.categoria === categoria);
            productosFiltrados.forEach(product => {
                const imgUrl = product.imagen.startsWith('http') ? product.imagen : `http://localhost/${product.imagen}`;
                const div = document.createElement('div');
                div.innerHTML = `
                    <div class="producto">
                        <img class="img-producto" src="${imgUrl}" alt="${product.nombre}" style="height:300px;margin-top:20px;" onclick="verProducto(${product.id})" onerror="this.onerror=null; this.src='https://via.placeholder.com/300x300?text=No+Image';">
                        <h2 style="height:55px; overflow:hidden;">${product.nombre}</h2>
                        <p><b>${product.precio}€</b></p>
                    </div>
                    <br>
                `;
                container.appendChild(div);
            });
        })
        .catch(error => console.error('Error al cargar los productos:', error));
}

// Función para filtrar productos por categoría
function filterProducts(categoria) {
    verCategoria(categoria);
}

// Llamar la función para cargar todos los productos al cargar la página
document.addEventListener('DOMContentLoaded', () => {
    cargarTodosLosProductos();
    document.getElementById('carrito')?.addEventListener('click', verCarrito);

    // Agregar event listeners para filtrar productos por categoría
    document.querySelectorAll('.categoria').forEach(element => {
        element.addEventListener('click', (event) => {
            event.preventDefault();  // Evita recargar la página
            const categoria = event.target.getAttribute('data-categoria');
            filterProducts(categoria);
        });
    });
});

function agregarAlCarrito(id_producto, nombre, descripcion, precio, stock, imagen) {
    const producto = {
        id_producto: id_producto,
        nombre: nombre,
        imagen: imagen,
        descripcion: descripcion,
        precio: precio,
        stock: stock,
        cantidad: 1,
    };

    let carrito = JSON.parse(localStorage.getItem('carrito')) || [];

    const productoExistente = carrito.find(item => item.id_producto === id_producto);
    if (productoExistente) {
        productoExistente.cantidad += 1;
    } else {
        carrito.push(producto);
    }

    localStorage.setItem('carrito', JSON.stringify(carrito));
    alert('Producto añadido al carrito');
}

