package Tests;

import Entidades.Producto;
import Gestion.ConexionBD;
import Gestion.Gestion_Productos;
import org.junit.Assert;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GestionProductosTest {
//    Test de filtrado por Busqueda Personalizada
    @Test
    public void ConsultaProductos_Busqueda()throws Exception{
        Gestion_Productos lista = new Gestion_Productos();
        List<Producto> lista_esperada = lista.TraerProductos(true,"sudadera");

        if(!lista_esperada.isEmpty()){
            System.out.println(  lista_esperada.getFirst().toString());

        }else{
            System.err.println("Lista Vacia");

        }
    }
    //    Test de filtrado por categoria
    @Test
    public void ConsultaProductos_Categoria()throws Exception{
        Gestion_Productos lista = new Gestion_Productos();
        List<Producto> lista_esperada = lista.TraerProductos(true,1);
        if(!lista_esperada.isEmpty()){
            System.out.println(  lista_esperada.getFirst().toString());
        }else{
            System.err.println("Lista Vacia");
        }
    }
    //    Sin filtro , devuelve todos los productos
    @Test
    public void ConsultaProductos_Todos()throws Exception{
        Gestion_Productos lista = new Gestion_Productos();
        List<Producto> lista_esperada = lista.TraerProductos(true);
        if(!lista_esperada.isEmpty()){
            System.out.println(  lista_esperada.getFirst().toString());
        }else{
            System.err.println("Lista Vacia");
        }
    }
    //     Agregar Productos ///pedido en los requerimientos
    @Test
public void AgregarProductos_Test() throws Exception {
    Gestion_Productos gestion = new Gestion_Productos();
    Producto producto = new Producto(22, "Nombre falso", "Descripcion falsa", 99.99, 22, "http://HolaMundo.com", 4);
    gestion.AgregarProducto(producto);

    // Retorno de la base de datos
    ConexionBD conn = new ConexionBD();
    try (Connection connect = conn.conectar()) {
        String query = "SELECT id_producto, nombre, descripcion, precio, stock, imagen, id_categoria FROM producto WHERE id_producto = ?";
        CallableStatement cs = connect.prepareCall(query);
        cs.setInt(1, 22);
        ResultSet response = cs.executeQuery();

        if (response.next()) { // Mover el cursor a la primera fila
            int id = response.getInt(1);
            String nombre = response.getString(2);
            String descripcion = response.getString(3);
            double precio = response.getDouble(4); // Ahora correctamente como double
            int stock = response.getInt(5);
            String imagen = response.getString(6);
            int id_categoria = response.getInt(7);

            Producto producto_db = new Producto(id, nombre, descripcion, precio, stock, imagen, id_categoria);

            Assert.assertEquals(producto.getNombre(), producto_db.getNombre());
            Assert.assertEquals(producto.getDescripcion(), producto_db.getDescripcion());
            Assert.assertEquals(producto.getPrecio(), producto_db.getPrecio(), 0.0001); // Usando delta para double
            Assert.assertEquals(producto.getStock(), producto_db.getStock());
            Assert.assertEquals(producto.getImagen(), producto_db.getImagen());
            Assert.assertEquals(producto.getId_categoria(), producto_db.getId_categoria());
        } else {
            Assert.fail("No se encontró el producto en la base de datos.");
        }
    } catch (Exception e) {
        Assert.fail("Error en el Test de consulta: " + e.getMessage());
    }
}

    //  Modificar Productos ///pedido en los requerimientos
    @Test
public void ModificarProducto_Test() throws Exception {
    // Datos de la modificación
    Map<String, Object> producto = new HashMap<>();
    producto.put("nombre", "Camisa Moderna mofy");
    producto.put("precio", 19.99);

    // Instancia de la gestión de productos
    Gestion_Productos gestion = new Gestion_Productos();
    
    // Se ejecuta la modificación y se verifica que devuelva true
    Assert.assertTrue("La modificación del producto falló", gestion.ModificarProducto(producto, 12));

    // Conexión a la base de datos para verificar los cambios
    ConexionBD conn = new ConexionBD();
    try (Connection connect = conn.conectar()) {
        String query = "SELECT nombre, precio FROM producto WHERE id_producto = ?";
        CallableStatement cs = connect.prepareCall(query);
        cs.setInt(1, 12);
        ResultSet response = cs.executeQuery();

        if (response.next()) { // Se mueve a la primera fila
            String nombre_db = response.getString("nombre");
            double precio_db = response.getDouble("precio");

            // Verificamos que los datos sean los correctos
            Assert.assertEquals("El nombre no se actualizó correctamente", "Camisa Moderna mofy", nombre_db);
            Assert.assertEquals("El precio no se actualizó correctamente", 19.99, precio_db, 0.0001);
        } else {
            Assert.fail("No se encontró el producto en la base de datos después de la modificación.");
        }
    } catch (Exception e) {
        Assert.fail("Error en el Test de modificación: " + e.getMessage());
    }
}

//    Eliminar Producto ///pedido en los requerimientos
@Test
public void EliminarProducto_Test() throws Exception {
    // Instancia de la gestión de productos
    Gestion_Productos gestion = new Gestion_Productos();

    // Elimina el producto con id 25
    Assert.assertTrue("La eliminación del producto falló", gestion.EliminarProducto(26));

    // Conexión a la base de datos para verificar si el producto fue eliminado
    ConexionBD conn = new ConexionBD();
    try (Connection connect = conn.conectar()) {
        String query = "SELECT id_producto FROM producto WHERE id_producto = ?";
        CallableStatement cs = connect.prepareCall(query);
        cs.setInt(1, 26);
        ResultSet response = cs.executeQuery();

        if (response.next()) {
            Assert.fail("El producto no fue eliminado correctamente.");
        } else {
            // Si no hay resultados, el producto fue correctamente eliminado
            System.out.println("El producto fue eliminado correctamente.");
        }
    } catch (Exception e) {
        Assert.fail("Error en el Test de eliminación: " + e.getMessage());
    }
}

}
