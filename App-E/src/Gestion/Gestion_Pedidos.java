package Gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

public class Gestion_Pedidos{
    static ConexionBD conn = new ConexionBD();
    public Double Ganancias()throws Exception{
        try(Connection connect = conn.conectar()){ 
            String query = "SELECT SUM(monto_total) AS ganancias_total FROM Pedido"; //consulta
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
            String query = "SELECT DATE_FORMAT(fecha_pedido, '%Y-%m') AS mes, SUM(monto_total) AS ganancias FROM Pedido GROUP BY mes ORDER BY mes desc"; //consulta
            CallableStatement cs = connect.prepareCall(query);
            ResultSet response = cs.executeQuery();
            String mes = null;
            Double Total_Ganancias = 0.00;
            // El HashMap es más comodo, puedo asignar la clave : valor, ambos de distinto tipo, algo que con un Array es inviable
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
        try(Connection connect = conn.conectar()){ //Hace la conexion
            String query = "SELECT producto.nombre, SUM(detalle_pedido.precio * detalle_pedido.cantidad) AS total_ganancia FROM producto JOIN detalle_pedido ON producto.ID_producto = detalle_pedido.ID_producto GROUP BY producto.ID_producto HAVING total_ganancia > 500;";
            CallableStatement cs = connect.prepareCall(query);//prepara la llamada
            ResultSet response = cs.executeQuery();//la ejecuta
            HashMap<StringBuilder, Double> Lista = new HashMap<>(); //lista para nombre(string):total(double)
            while(response.next()){
                StringBuilder nombre = new StringBuilder();
                nombre.append(response.getString(1));
                double total = response.getDouble(2);
                Lista.put(nombre,total); // se asignan a la lista
            }
            return Lista;
        }catch(Exception e){
            System.err.println("Error en la consulta");
            return null;
        }
    }

}
