package Gestion;

import Entidades.Producto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Gestion_Productos {
    static ConexionBD conn = new ConexionBD();

//    sobrecarga de metodos

//    Traer todos los productos
    public List<Producto> TraerProductos()throws Exception{
        return TraerProductos(null, -1);
    }
// Filtrado por Categoria
    public List<Producto> TraerProductos(int id_categoria)throws Exception{
        return TraerProductos(null, id_categoria); //va a generar error
    }
//    filtrar por busqueda
    public List<Producto> TraerProductos(String buscar)throws Exception{
        return TraerProductos(buscar, -1); //va a generar error
    }
// Metodo principal de listado de productos
    public List<Producto> TraerProductos( String filtrar, int categoria )throws Exception{
        List<Producto> Lista_productos = new ArrayList<>();
        try( Connection connect = conn.conectar() ){
            String query = null;
            ResultSet response = null;

            if( filtrar==null && categoria!=-1 ){
                //        Si se le pasa -1 a categoria , pero se le pasa un dato valido a filtro entonces hace el filtrado por busqueda
                query = "SELECT p.*,c.nombre FROM producto as p INNER JOIN categoria AS c ON p.ID_categoria = c.ID_categoria WHERE c.ID_categoria = ? ORDER BY p.precio ASC";
                CallableStatement cs = connect.prepareCall(query);
                cs.setInt(1,categoria);
                response = cs.executeQuery();
            }else if( filtrar!=null && categoria==-1 ){//        Si se le pasa -1 a filtro , pero se le pasa un dato valido a categoria entonces hace el filtrado por categorias
                query = "SELECT * FROM producto WHERE descripcion LIKE (?)";
                CallableStatement cs = connect.prepareCall(query);
                cs.setString(1,"%"+filtrar+"%");
                response = cs.executeQuery();
            }else if(filtrar!=null && categoria!=-1){
//            Aqui se aplicaria la casuistica de que se filtre los resultados personalizados por categoria
//            No se va a aplicar debido a que no está en los requerimientos, pero para no dejar con la duda de que pasaria si se le pasan ambos props, por eso lo explico
            }else{
//            Ya que tanto categoria como filtrar son valores null entonces se hace la consulta de todos los productos
                query = "SELECT * FROM producto";
                CallableStatement cs = connect.prepareCall(query);
                response = cs.executeQuery();
            }
            while(response != null && response.next()){
                int id_producto = response.getInt(1);
                String nombre = response.getString(2);
                String descripcion = response.getString(3);
                double precio = response.getDouble(4);
                int stock = response.getInt(5);
                java.sql.Date fecha_creacion = response.getDate(6);
                String imagen = response.getString(7);
                int id_categoria = response.getInt(8);
                Producto producto = new Producto(nombre,id_producto, descripcion, precio, stock, fecha_creacion, imagen, id_categoria);
                Lista_productos.add(producto);
            }
        }catch(Exception e){
            System.err.println("Error al Consultar Productos: "+e);
        }
        return Lista_productos;
    }




// AGREGAR PRODUCTOS
public Boolean AgregarProducto()throws Exception{



    return false;
}






//fin
}
