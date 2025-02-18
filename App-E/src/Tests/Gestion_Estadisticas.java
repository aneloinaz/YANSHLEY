package Tests;

import org.junit.Test;

import Gestion.Gestion_Pedidos;
import Gestion.Gestion_Productos;
import Gestion.Gestion_Usuarios;

public class Gestion_Estadisticas {
    @Test
    public void Usuario_PedidosTest()throws Exception{
        Gestion_Usuarios gu = new Gestion_Usuarios();
        gu.UsuariosConMas_pedidos();
    }
    @Test
    public void Ganancias()throws Exception{
        Gestion_Pedidos gu = new Gestion_Pedidos();
        gu.Ganancias();
    }
    @Test
    public void Productos_Stock_menos5()throws Exception{
        Gestion_Productos g = new Gestion_Productos();
        g.ProductosMenosDeCinto();
    }
    @Test
    public void Ganancias_MesTest()throws Exception{
        Gestion_Pedidos gu = new Gestion_Pedidos();
        gu.Ganancias_Mes();
    }
    @Test
    public void ProudctoSinPedidos()throws Exception{
        Gestion_Productos g = new Gestion_Productos();
        g.Productos_null();
    }
    @Test
    public void Ganancias_Mas500Test()throws Exception{
        Gestion_Pedidos gu = new Gestion_Pedidos();
        gu.Ganancias_Mas500();
    }
}
