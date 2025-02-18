package Gestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Entidades.Producto;

public class Cargar_CSV {
    public Boolean Cargar_Productos() {
        File fichero = new File("src/CSV/productos.CSV");
        List<String> filas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                filas.add(linea);
            }
            for(String item : filas ){
                String[] formatRow = item.split(",");  
                 GenerateProduct(formatRow);          
            }
            return true;  
         
        } catch (Exception e) {
            System.err.println("Error al Leer el CSV: " + e.getMessage());
            return false;
        }
    }

    public Boolean GenerateProduct(String[]formatRow)throws Exception{
        Producto producto = new Producto();
        
        Gestion_Productos g = new Gestion_Productos();
        String nombre = formatRow[0];
        String Descripcion = formatRow[1];
        double precio = Double.valueOf(formatRow[2]);
        int stock = Integer.valueOf(formatRow[3]);
        java.sql.Date fecha = java.sql.Date.valueOf(formatRow[4]);
        String image = formatRow[5];
        int id_categoria = Integer.valueOf(formatRow[6]);
        try{
            producto.setNombre(nombre);
            producto.setDescripcion(Descripcion);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setFecha_creacion(fecha);
            producto.setId_categoria(id_categoria);
            producto.setImagen(image);
            g.AgregarProducto(producto);
            return true;
        }catch(Exception e){
            System.out.println("Error al crear el producto");
            return false;
        }
    }
}
