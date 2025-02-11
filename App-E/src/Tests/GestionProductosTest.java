package Tests;

import Entidades.Producto;
import Gestion.Gestion_Productos;
import org.junit.Test;
import java.util.List;


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

}
