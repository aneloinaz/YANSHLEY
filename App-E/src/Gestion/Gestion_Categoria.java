package Gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entidades.Categoria;

public class Gestion_Categoria {
     static private ConexionBD conn = new ConexionBD();
    
     public List<Categoria> ListaCategorias()throws Exception{
        try(Connection connect = conn.conectar()){
            String query = "SELECT ID_categoria, nombre FROM categoria"; // creación de la consulta
            CallableStatement cs = connect.prepareCall(query);// prepara la query
            List<Categoria> categorias = new ArrayList<>();//creo la lista de categorias lista para recibir objetos Categoria
            ResultSet response = cs.executeQuery(); // ejecuta la query
            while(response.next()){
                Categoria cat = new Categoria(response.getInt(1),response.getString(2));
                categorias.add(cat); // se ingresa el objeto a la lista
            }
            return categorias;
        }catch(Exception e){
            System.out.println("Error en la consulta");
            return null;
        }
     }
}
