package Tests;

import Entidades.Producto;
import Gestion.Gestion_Productos;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GestionProductosTest {
//    Test de filtrado por Busqueda Personalizada
    @Test
    public void ConsultaProductos_Busqueda()throws Exception{
        Gestion_Productos lista = new Gestion_Productos();
        List<Producto> lista_esperada = lista.TraerProductos("camisa");

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
        List<Producto> lista_esperada = lista.TraerProductos(1);
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
        List<Producto> lista_esperada = lista.TraerProductos();
        if(!lista_esperada.isEmpty()){
            System.out.println(  lista_esperada.getFirst().toString());
        }else{
            System.err.println("Lista Vacia");
        }
    }
    //     Agregar Productos
    @Test
    public void AgregarProductos_Test()throws Exception{
        Gestion_Productos gestion = new Gestion_Productos();
        Producto producto = new Producto("Nombre falso","Descripcion falsa",99.99,22,"http://HolaMundo.com",4);
        Assert.assertTrue(gestion.AgregarProducto(producto));
    }
    //  Modificar Productos
    @Test
    public void ModificarProducto()throws Exception{
        Map<String, Object> producto = new HashMap<>();
        producto.put("nombre","Camisa Moderna");
        producto.put("precio",19.99);
        Gestion_Productos gestion = new Gestion_Productos();
        Assert.assertTrue(gestion.ModificarProducto(producto,12));
    }
//    Eliminar Producto
    @Test
    public void EliminarProducto()throws Exception{
        Gestion_Productos gestion = new Gestion_Productos();
        Assert.assertTrue(gestion.EliminarProducto(25));
    }
}
