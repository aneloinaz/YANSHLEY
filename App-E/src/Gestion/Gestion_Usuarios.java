package Gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entidades.Usuario_Pedidos;

public class Gestion_Usuarios{
    static ConexionBD conn = new ConexionBD();
    public List<Usuario_Pedidos> UsuariosConMas_pedidos()throws Exception{
        try(Connection connect = conn.conectar()){
            
            List<Usuario_Pedidos> usuario_p = new ArrayList<>();
            String query = "select usuario.nombre_usuario, usuario.ID_usuario, COUNT(pedido.ID_pedido) AS total_pedidos_realizados FROM usuario join pedido on usuario.ID_usuario = pedido.ID_usuario group by usuario.ID_Usuario ORDER BY `total_pedidos_realizados` DESC limit 10;";
            CallableStatement cs = connect.prepareCall(query);
            ResultSet response = cs.executeQuery();
            while(response.next()){
                String nombre_user = response.getString(1);
                int id = response.getInt(2);
                int CatidadPedido = response.getInt(3);
                Usuario_Pedidos usuario = new Usuario_Pedidos(id,nombre_user,CatidadPedido);
                usuario_p.add(usuario);
            }
            if(usuario_p.isEmpty()){
                System.err.println("No exite resultado en la consulta: Usuarios con Más Pedidos");
                return null;
            }
            return usuario_p;
        }catch(Exception e){
            System.err.println("Error en la consulta : Usuarios con más pedidos"+e);
            return null;
        }
        
    }
}
