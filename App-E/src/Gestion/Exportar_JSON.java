package Gestion;

import Entidades.Producto;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Exportar_JSON {
    private static final String PRODUCTOS_C_JSON = "productos.JSON";
    private static final String PATH = "src/JSON/";
    public Boolean Export()throws Exception{
        Gestion_Productos gestionProductos = new Gestion_Productos();
        List<Producto>Listar_Productos  = gestionProductos.TraerProductos();

        File file = new File(PRODUCTOS_C_JSON);

        StringBuilder ParseJson = new StringBuilder();
        if(Listar_Productos.isEmpty()){
            System.err.println("No se encuentran coincidencias");
        }else {
            // ParseJson =  FormatJSON(Listar_Productos);
            ParseJson = FormatJSON(Listar_Productos);
        }

        try( FileWriter fileWriter = new FileWriter(PATH+PRODUCTOS_C_JSON);){

            fileWriter.write(String.valueOf(ParseJson));
            System.out.println("JSON Exportado");
            return true;
        }catch(Exception e){
            System.err.println("Error al Escribir Fichero: "+e);
        }
        return false;
    }

    public StringBuilder FormatJSON(List<Producto> Listar_Productos){
        StringBuilder ParseJson = new StringBuilder("[");
        for(Producto producto : Listar_Productos){
//                        ID
            ParseJson.append("{");
            ParseJson.append("\"id\""+":");
            ParseJson.append(producto.getId_producto());
            ParseJson.append(",");
//            Nombre
            ParseJson.append("\"nombre\""+":");
            ParseJson.append("\"").append(producto.getNombre()).append("\"");
            ParseJson.append(",");
//           Descripcion
            ParseJson.append("\"descripcion\""+":");
            ParseJson.append("\"").append(producto.getDescripcion()).append("\"");
            ParseJson.append(",");
//          Precio
            ParseJson.append("\"precio\""+":");
            ParseJson.append(producto.getPrecio());
            ParseJson.append(",");
//          Stock
            ParseJson.append("\"stock\""+":");
            ParseJson.append(producto.getStock());
            ParseJson.append(",");
//          Fecha Creacion
            ParseJson.append("\"fecha_creacion\""+":");
            ParseJson.append("\"").append(producto.getFecha_creacion()).append("\"");
            ParseJson.append(",");
//          Imagen
            ParseJson.append("\"imagen\""+":");
            ParseJson.append("\"").append(producto.getImagen()).append("\"");
            ParseJson.append(",");
//          ID Categoria
            ParseJson.append("\"categoria\""+":");
            ParseJson.append(producto.getId_categoria());
            ParseJson.append("},");
        }
        ParseJson.append("]");
        ParseJson.replace(ParseJson.lastIndexOf(","),ParseJson.lastIndexOf("]"),"");

        return ParseJson;
    }
    public StringBuilder CSV(List<Producto> L){
        StringBuilder texto = new StringBuilder();
        
        for(Producto p : L){
            texto.append(p.getId_producto());
            texto.append(",");
            texto.append(p.getNombre());
            texto.append(",");
            texto.append(p.getDescripcion());
            texto.append(p.getPrecio());
            texto.append(",");
            texto.append(p.getStock());
            texto.append(",");
            texto.append(p.getFecha_creacion());
            texto.append(",");
            texto.append(p.getImagen());
            texto.append(",");
            texto.append(p.getId_categoria());
            texto.append("\n");
        }

        return texto;
    }
    
}
