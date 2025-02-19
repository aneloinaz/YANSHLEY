package Gestion;

import Entidades.Producto;
import Entidades.Producto_Stock;
import Entidades.Usuario_Pedidos;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exportar_JSON {
    private static final String PRODUCTOS_C_JSON = "productos.json"; //Nombre del fichero
    private static final String ESTADISTICAS = "estadisticas.json"; //Nombre del fichero
    private static final String PATH = "src/JSON/"; // Path
    public Boolean Export_Product()throws Exception{
        Gestion_Productos gestionProductos = new Gestion_Productos(); // Se instancia de gestion productos
        List<Producto>Listar_Productos  = gestionProductos.TraerProductos(true);//se crea una lista y se le asigna la lista de productos

        File file = new File(PRODUCTOS_C_JSON);

        StringBuilder ParseJson = new StringBuilder();
        if(Listar_Productos.isEmpty()){ 
            System.err.println("No se encuentran coincidencias");
        }else {
            // ParseJson =  FormatJSON(Listar_Productos);
            ParseJson = FormatJSON(Listar_Productos);
        }

        try( FileWriter fileWriter = new FileWriter(PATH+PRODUCTOS_C_JSON);){ // Se escribe el el fichero

            fileWriter.write(String.valueOf(ParseJson));
            System.out.println("JSON Exportado");
            return true;
        }catch(Exception e){
            System.err.println("Error al Escribir Fichero: "+e);
        }
        return false;
    }

    //Exportar Estats
    public Boolean Export_Stats()throws Exception{
        Gestion_Productos g_Productos = new Gestion_Productos(); //instacia de gestion de productos
        Gestion_Usuarios g_usuarios = new Gestion_Usuarios(); // instancia de gestion de usuarios
        Gestion_Pedidos g_Pedidos = new Gestion_Pedidos(); // instancia de pedidos

        //Ignorar el nombre de las variables, ya se me acaban las ideas.
        HashMap<StringBuilder, Double> Lista = g_Pedidos.Ganancias_Mas500(); // asigna la lista que retorna la funcion Ganancias mayores a 500

        HashMap<String, Double> mesesGanacias = g_Pedidos.Ganancias_Mes();//asigna la lista que retorna la funcion ganancias al mes
        
        List<StringBuilder>L_productos_null  = g_Productos.Productos_null();//asigna la lista que retorna la funcion de productos nunca comprados
       
        List<Producto_Stock>L_productos_M5 = g_Productos.ProductosMenosDeCinto();//asigna la lista de productos con menos de 5 en stock

        double ganancias = g_Pedidos.Ganancias(); //ganancias totales

        List<Usuario_Pedidos> usuario_p = g_usuarios.UsuariosConMas_pedidos(); //usuarios con mas pedidos
        

        File file = new File(ESTADISTICAS);

        StringBuilder ParseJson = new StringBuilder();


        try( FileWriter fileWriter = new FileWriter(PATH+ESTADISTICAS);){
            ParseJson = FormatJSON_stats(Lista,mesesGanacias,L_productos_null,L_productos_M5,ganancias,usuario_p); //llama al metodo que va a escribir
            fileWriter.write(String.valueOf(ParseJson));
            System.out.println("JSON Exportado");
            return true;
        }catch(Exception e){
            System.err.println("Error al Escribir Fichero: "+e);
        }
        return false;        
        
    }
   
   // Se arma poco a poco
    public StringBuilder FormatJSON(List<Producto> Listar_Productos){ //metodo que escribe el json productos
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



    ////!!!!!!!!!!!!! aqui leo el CSV
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
        System.out.println("\nCSV CARGADO\n");
        return texto;
    }
    private void removeLastComma(StringBuilder sb) {
        int lastComma = sb.lastIndexOf(",");
        if (lastComma != -1) {
            sb.deleteCharAt(lastComma);
        }
    }
    
    //json de estadisticas
    //quedó un poco larguito, esque son muchas funcionalidades
    public StringBuilder FormatJSON_stats(HashMap<StringBuilder, Double> Lista, HashMap<String, Double> mesesGanacias, List<StringBuilder> L_productos_null, List<Producto_Stock> L_productos_M5, double ganancias, List<Usuario_Pedidos> usuario_p) {
        StringBuilder ParseJson = new StringBuilder("{\n"); // Inicio del JSON
    
        // Productos con ganancias mayores a 500
        ParseJson.append("\"p_mayor_a_quinientos\": [");
        for (Map.Entry<StringBuilder, Double> item : Lista.entrySet()) {
            ParseJson.append("{");
            ParseJson.append("\"nombre\": \"").append(item.getKey().toString()).append("\",");
            ParseJson.append("\"ganancia\": ").append(item.getValue());
            ParseJson.append("},");
        }
        removeLastComma(ParseJson);
        ParseJson.append("],\n");
    
        // Ganancias por mes
        ParseJson.append("\"anio_mes_ganancias\": [");
        for (Map.Entry<String, Double> item : mesesGanacias.entrySet()) {
            ParseJson.append("{");
            ParseJson.append("\"Fecha-Mes\": \"").append(item.getKey()).append("\",");
            ParseJson.append("\"ganancia\": ").append(item.getValue());
            ParseJson.append("},");
        }
        removeLastComma(ParseJson);
        ParseJson.append("],\n");
    
        // Productos sin pedidos
        ParseJson.append("\"p_sin_pedidos\": [");
        for (StringBuilder item : L_productos_null) {
            ParseJson.append("{");
            ParseJson.append("\"nombre\": \"").append(item.toString()).append("\"");
            ParseJson.append("},");
        }
        removeLastComma(ParseJson);
        ParseJson.append("],\n");
    
        // Productos con stock menor a 5
        ParseJson.append("\"p_stock_menor_cinco\": [");
        for (Producto_Stock item : L_productos_M5) {
            ParseJson.append("{");
            ParseJson.append("\"id\": ").append(item.getStock()).append(",");
            ParseJson.append("\"nombre\": \"").append(item.getNombre_producto()).append("\",");
            ParseJson.append("\"stock\": ").append(item.getStock());
            ParseJson.append("},");
        }
        removeLastComma(ParseJson);
        ParseJson.append("],\n");
    
        // Ganancias totales
        ParseJson.append("\"ganancias_total\": {");
        ParseJson.append("\"ganancias\": ").append(ganancias);
        ParseJson.append("},\n");
    
        // Usuarios con más pedidos
        ParseJson.append("\"U_mas_pedidos\": [");
        for (Usuario_Pedidos item : usuario_p) {
            ParseJson.append("{");
            ParseJson.append("\"id\": ").append(item.getId_usuario()).append(",");
            ParseJson.append("\"nombre\": \"").append(item.getNombre_usuario()).append("\",");
            ParseJson.append("\"pedidos\": ").append(item.getCantidadPedidos());
            ParseJson.append("},");
        }
        removeLastComma(ParseJson);
        ParseJson.append("]\n");
    
        ParseJson.append("}");
    
        return ParseJson;
    }
    


}
