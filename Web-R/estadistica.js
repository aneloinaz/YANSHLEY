
        // Cargar el archivo JSON de estadísticas
        fetch('estadisticas.json')
            .then(response => response.json())
            .then(data => {
                const selector = document.getElementById('estadisticaSelector');
                const tituloEstadistica = document.getElementById('tituloEstadistica');
                const descripcionEstadistica = document.getElementById('descripcionEstadistica');

                // Función para actualizar la estadística mostrada
                function actualizarEstadistica() {
                    const estadisticaSeleccionada = selector.value;

                    // Mostrar datos según la estadística seleccionada
                    switch(estadisticaSeleccionada) {
                        case 'gananciasTotales':
                            tituloEstadistica.innerText = 'Total de las Ganancias';
                            descripcionEstadistica.innerText = `Total de ganancias: €${data.gananciasTotales}`;
                            break;
                        case 'productosBajoStock':
                            tituloEstadistica.innerText = 'Productos con stock bajo (<5)';
                            descripcionEstadistica.innerText = 'Productos con stock bajo: ' + data.productosBajoStock.join(', ');
                            break;
                        case 'clientesMasPedidos':
                            tituloEstadistica.innerText = 'Clientes con más pedidos (10)';
                            descripcionEstadistica.innerText = 'Clientes con más de 10 pedidos: ' + data.clientesMasPedidos.join(', ');
                            break;
                        case 'gananciasPorMes':
                            tituloEstadistica.innerText = 'Ganancias por Mes';
                            descripcionEstadistica.innerText = 'Ganancias por mes: ' + data.gananciasPorMes.join(', ');
                            break;
                        case 'productosNuncaComprados':
                            tituloEstadistica.innerText = 'Productos Nunca Comprados';
                            descripcionEstadistica.innerText = 'Productos nunca comprados: ' + data.productosNuncaComprados.join(', ');
                            break;
                        case 'productosMasGanancia':
                            tituloEstadistica.innerText = 'Productos con más de 500€ de ganancia';
                            descripcionEstadistica.innerText = 'Productos con más de 500€ de ganancia: ' + data.productosMasGanancia.join(', ');
                            break;
                        default:
                            tituloEstadistica.innerText = 'Selecciona una estadística';
                            descripcionEstadistica.innerText = 'Aquí aparecerá la información cuando selecciones una estadística.';
                    }
                }

                // Actualizar la estadística cada vez que el usuario cambia la selección
                selector.addEventListener('change', actualizarEstadistica);

                // Inicializar la estadística al cargar
                actualizarEstadistica();
            })
            .catch(error => {
                console.error('Error al cargar el archivo de estadísticas:', error);
            });