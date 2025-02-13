package Gestion;

import Entidades.Producto;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Exportar_JSON {
    public void Export()throws Exception{
        List<Producto> productosLista = new ArrayList<>();
        Gestion_Productos gestionProductos = new Gestion_Productos();
        productosLista = gestionProductos.TraerProductos();

        String json = "[\n"+productosLista.stream()
                .map(p -> String.format("  \"  "))


        try{
            Files.write(Paths.get("ProductosAll.json"),productosLista);

        }catch(Exception e){
            System.err.println("Error al crear Fichero: "+e);
        }
    }
}
