// Función para cargar todos los productos desde la API
function cargarTodosLosProductos() {
    fetch('https://fakestoreapi.com/products')
        .then(res => res.json())
        .then(json => {
            const container = document.getElementById('productos-lista');
            if (!container) {
                console.error('Error: No se encontró el elemento con id "productos-lista"');
                return;
            }
            container.innerHTML = '';
            json.forEach(product => {
                const div = document.createElement('div');
                div.innerHTML = `
                    <div class="producto">
                        <img class="img-producto" src="${product.image}" alt="${product.title}" style="height:300px;margin-top:20px;" onclick="verProducto(${product.id})">
                        <h2 style="height:55px; overflow:hidden;">${product.title}</h2>
                        <p><b>${product.price}€</b></p>
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
    fetch(`https://fakestoreapi.com/products/${productId}`)
        .then(res => res.json())
        .then(product => {
            const container = document.getElementById('productos-lista');
            container.innerHTML = '';
            const div = document.createElement('div');
            div.innerHTML = `
                <div class="producto">
                    <img class="img-producto" src="${product.image}" alt="${product.title}" style="height:300px;margin-top:20px;">
                    <h2 style="height:55px; overflow:hidden;">${product.title}</h2>
                    <p><a class="Descripcion" style="height:200px; overflow:auto;">${product.description}</a></p>
                    <p><b>${product.price}€</b></p>
                    <button style="border: none; background-color: white;">
                        <a onclick="agregarAlCarrito(${product.id}, '${product.title}', '${product.description}', ${product.price}, ${product.stock}, '${product.image}')">Añadir al carrito</a>
                    </button>
                </div>
                <br>
            `;
            container.appendChild(div);
        })
        .catch(error => console.error('Error al cargar el producto:', error));
}

// Función para ver todos los productos de una categoría
function verCategoria(category) {
    fetch(`https://fakestoreapi.com/products/category/${category}`)
        .then(res => res.json())
        .then(products => {
            const container = document.getElementById('productos-lista');
            container.innerHTML = '';
            products.forEach(product => {
                const div = document.createElement('div');
                div.innerHTML = `
                    <div class="producto">
                        <img class="img-producto" src="${product.image}" alt="${product.title}" style="height:300px;margin-top:20px;" onclick="verProducto(${product.id})">
                        <h2 style="height:55px; overflow:hidden;">${product.title}</h2>
                        <p><b>${product.price}€</b></p>
                    </div>
                    <br>
                `;
                container.appendChild(div);
            });
        })
        .catch(error => console.error('Error al cargar los productos:', error));
}

// Función para filtrar productos por categoría
function filterProducts(category) {
    verCategoria(category);
}

// Llamar la función para cargar todos los productos al cargar la página
document.addEventListener('DOMContentLoaded', () => {
    cargarTodosLosProductos();
    document.getElementById('carrito')?.addEventListener('click', verCarrito);

    // Agregar event listeners para filtrar productos por categoría
    document.querySelectorAll('.categoria').forEach(element => {
        element.addEventListener('click', (event) => {
            event.preventDefault();  // Evita recargar la página
            const category = event.target.getAttribute('data-category');
            filterProducts(category);
        });
    });
});

function agregarAlCarrito(id_producto, title, description, price, stock, image) {
    const producto = {
        id_producto: id_producto,
        title: title,
        image: image,
        description: description,
        price: price,
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
