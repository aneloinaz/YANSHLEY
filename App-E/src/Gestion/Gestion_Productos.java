package Gestion;

import Entidades.Producto;
import Entidades.Producto_Stock;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Gestion_Productos {
    static ConexionBD conn = new ConexionBD();

//    sobrecarga de metodos
    
//    Traer todos los productos
    public List<Producto> TraerProductos(boolean order)throws Exception{
        return TraerProductos(order,null, -1);
    }
// Filtrado por Categoria
    public List<Producto> TraerProductos(boolean order,int id_categoria)throws Exception{
        return TraerProductos(order,null, id_categoria); //va a generar error
    }
//    filtrar por busqueda
    public List<Producto> TraerProductos(boolean order,String buscar)throws Exception{
        return TraerProductos(order, buscar, -1); //va a generar error
    }
// Metodo principal de listado de productos
    public List<Producto> TraerProductos(boolean order, String filtrar, int categoria )throws Exception{
        String orderString = "nombre";
        if(order == true){
            orderString = "precio";
        }else{
            orderString = "stock";
        }

        List<Producto> Lista_productos = new ArrayList<>();
        try( Connection connect = conn.conectar() ){
            String query = null;
            ResultSet response = null;

            if( filtrar==null && categoria!=-1 ){
                //        Si se le pasa -1 a categoria , pero se le pasa un dato valido a filtro entonces hace el filtrado por busqueda
                if(order){
                    query = "SELECT p.*,c.nombre FROM producto as p INNER JOIN categoria AS c ON p.ID_categoria = c.ID_categoria WHERE c.ID_categoria = ? ORDER BY p.precio ASC";
                }else{
                    query = "SELECT p.*,c.nombre FROM producto as p INNER JOIN categoria AS c ON p.ID_categoria = c.ID_categoria WHERE c.ID_categoria = ? ORDER BY p.stock ASC";
                }
                CallableStatement cs = connect.prepareCall(query);
                cs.setInt(1,categoria);
                response = cs.executeQuery();
            }else if( filtrar!=null && categoria==-1 ){//        Si se le pasa -1 a filtro , pero se le pasa un dato valido a categoria entonces hace el filtrado por categorias
                if(order){
                    query = "SELECT * FROM producto WHERE descripcion LIKE (?) ORDER BY precio ASC";
                }else{
                    query = "SELECT * FROM producto WHERE descripcion LIKE (?) ORDER BY stock ASC";
                }
                CallableStatement cs = connect.prepareCall(query);
                cs.setString(1,"%"+filtrar+"%");
                response = cs.executeQuery();
            }else if(filtrar!=null && categoria!=-1){
//            Aqui se aplicaria la casuistica de que se filtre los resultados personalizados por TERMINOS DE BÚSQUEDA Y categoria
//            No se va a aplicar debido a que no está en los requerimientos, pero para no dejar con la duda de que pasaria si se le pasan ambos props, por eso lo explico
            }else{
//            Ya que tanto categoria como filtrar son valores null entonces se hace la consulta de todos los productos
                if(order){
                    query = "SELECT * FROM producto ORDER BY precio ASC";
                }else{
                    query = "SELECT * FROM producto ORDER BY stock ASC";
                }
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
    public Boolean AgregarProducto(Producto producto)throws Exception{
    try( Connection connect = new ConexionBD().conectar();){
        String query = "INSERT INTO producto (nombre,descripcion,precio,stock,fecha_creacion,imagen,ID_categoria) VALUE (?,?,?,?,?,?,?)";
        CallableStatement cs = connect.prepareCall(query);
        cs.setString(1,producto.getNombre());
        cs.setString(2,producto.getDescripcion());
        cs.setDouble(3,producto.getPrecio());
        cs.setInt(4,producto.getStock());
        cs.setDate(5,producto.getFecha_creacion());
        cs.setString(6,producto.getImagen());
        cs.setInt(7,producto.getId_categoria());
        int response = cs.executeUpdate();
        return response > 0;
    }catch(Exception e){
        System.err.println("Error en la insercion: "+e);
        return false;
    }
    
}

//  MODIFICAR PRODUCTO
    public Boolean ModificarProducto(Map<String, Object> producto, int ID)throws Exception{
        try( Connection connect = conn.conectar() ){
            List<String> Rows = new ArrayList<>();

            StringBuilder query = new StringBuilder("UPDATE producto SET ");

            for(Map.Entry<String,Object> info : producto.entrySet()){
                Rows.add(info.getKey().concat("=?"));
            }
            query.append(String.join(",",Rows));
            query.append(" WHERE ID_producto=?");
            CallableStatement cs = connect.prepareCall(String.valueOf(query));
            int index = 1;
            for(Map.Entry<String, Object> info : producto.entrySet()){
                Object value = info.getValue();

                if(value instanceof String){
                    cs.setString(index, (String) value);
                }else if(value instanceof Integer){
                    cs.setInt(index,(Integer) value);
                }else if(value instanceof Double){
                    cs.setDouble(index,(Double) value);
                }
                index++;
            }
            cs.setInt(index,ID);

            int response = cs.executeUpdate();
            return response > 0;
        }catch(Exception e) {
            System.err.println("Exrror en la Conexión: "+e);
            return false;
        }
       

    }

// Eliminar producto
    public Boolean EliminarProducto(int ID)throws Exception{
        try( Connection connect = conn.conectar() ){
            String query = "DELETE FROM producto WHERE ID_producto = ?";
            CallableStatement cs = connect.prepareCall(query);
            cs.setInt(1,ID);
            int response = cs.executeUpdate();
            System.out.println("Producto eliminado");
            return response > 0;
        }catch(Exception e){
            System.err.println("Error al Eliminar el producto: "+e);
            return false;
        }
        
    }


    public List<Producto_Stock> ProductosMenosDeCinto()throws Exception{
        try(Connection connect = conn.conectar()){
            String query = "select ID_producto, nombre, stock from producto where stock < 5";
            CallableStatement cs = connect.prepareCall(query);
            ResultSet response = cs.executeQuery();
            List<Producto_Stock> ps = new ArrayList<>();
            while(response.next()){
                int id = response.getInt(1);
                String nombre = response.getString(2);
                int stock = response.getInt(3);
                Producto_Stock producto = new Producto_Stock(id,nombre,stock);
                ps.add(producto);
            }

            return ps;
        }catch(Exception e){
            System.err.println("Error en la consulta");
            return null;
        }
        
    }

    public List<StringBuilder> Productos_null()throws Exception{
        try(Connection connect = conn.conectar()){
            String query ="SELECT Producto.nombre FROM Producto LEFT JOIN detalle_pedido ON producto.ID_producto = detalle_pedido.ID_producto WHERE detalle_pedido.ID_producto IS NULL";
            CallableStatement cs = connect.prepareCall(query);
            
            List<StringBuilder> listaProd = new ArrayList<>();
            ResultSet response = cs.executeQuery();
           
            while(response.next()){
                StringBuilder nombre = new StringBuilder();
                nombre.append(response.getString(1));
                listaProd.add(nombre);
            }
            return listaProd;
        }catch(Exception e){
            System.err.println("Error en la consulta");
            return null;
        }
       
    }

//fin
}
