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
            String query = "SELECT ID_categoria, nombre FROM categoria";
            CallableStatement cs = connect.prepareCall(query);
            List<Categoria> categorias = new ArrayList<>();
            ResultSet response = cs.executeQuery();
            while(response.next()){
                Categoria cat = new Categoria(response.getInt(1),response.getString(2));
                categorias.add(cat);
            }
            return categorias;
        }catch(Exception e){
            System.out.println("Error en la consulta");
            return null;
        }
     }
}
