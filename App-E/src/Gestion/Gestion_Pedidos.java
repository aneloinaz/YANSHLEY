package Gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

public class Gestion_Pedidos{
    static ConexionBD conn = new ConexionBD();
    public Double Ganancias()throws Exception{
        try(Connection connect = conn.conectar()){ 
            String query = "SELECT SUM(monto_total) AS ganancias_total FROM Pedido";
            CallableStatement cs = connect.prepareCall(query);
            ResultSet response = cs.executeQuery();
            Double Total_Ganancias = 0.00;
            while(response.next()){
                Total_Ganancias = response.getDouble(1);
            }
            return Total_Ganancias;
        }catch(Exception e){
            System.err.println("Error en la consulta"+e); 
            return null;
        }
       
    }
    public  HashMap<String, Double> Ganancias_Mes()throws Exception{
        try(Connection connect = conn.conectar()){
            String query = "SELECT DATE_FORMAT(fecha_pedido, '%Y-%m') AS mes, SUM(monto_total) AS ganancias FROM Pedido GROUP BY mes ORDER BY mes desc";
            CallableStatement cs = connect.prepareCall(query);
            ResultSet response = cs.executeQuery();
            String mes = null;
            Double Total_Ganancias = 0.00;
            HashMap<String, Double> mesesGanacias = new HashMap<String, Double>();
            while(response.next()){
                mes = response.getString(1);
                Total_Ganancias = response.getDouble(2);
                mesesGanacias.put(mes,Total_Ganancias);
            }
            return mesesGanacias;
        }catch(Exception e){
            System.err.println("Error en la consulta"+e);
            return null;
        }
        
    }

    public HashMap<StringBuilder, Double> Ganancias_Mas500()throws Exception{
        try(Connection connect = conn.conectar()){
            String query = "SELECT Producto.nombre, SUM(Detalle_pedido.precio * Detalle_pedido.cantidad) AS total_ganancia FROM Producto JOIN Detalle_pedido ON Producto.ID_producto = Detalle_pedido.ID_producto GROUP BY Producto.ID_producto HAVING total_ganancia > 500;";
            CallableStatement cs = connect.prepareCall(query);
            ResultSet response = cs.executeQuery();
            HashMap<StringBuilder, Double> Lista = new HashMap<>();
            while(response.next()){
                StringBuilder nombre = new StringBuilder();
                nombre.append(response.getString(1));
                double total = response.getDouble(2);
                Lista.put(nombre,total);
            }
            return Lista;
        }catch(Exception e){
            System.err.println("Error en la consulta");
            return null;
        }
    }

}
