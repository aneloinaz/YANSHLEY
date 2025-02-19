package Tests;

import Gestion.Cargar_CSV;
import Gestion.Exportar_JSON;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class Export_ImportTests {
    @Test
public void Export_Test() throws Exception {
    // Crear una instancia de la clase Exportar_JSON
    Exportar_JSON exportarJson = new Exportar_JSON();
    
    // Llamar al método Export_Product
    Boolean result = exportarJson.Export_Product();
    
    // Verificar si el resultado es true, lo que significa que el archivo se exportó correctamente
    Assert.assertTrue("El archivo JSON no fue exportado correctamente.", result);
    
    // Verificar si el archivo realmente fue creado
    File file = new File("src/JSON/productos.JSON");
    Assert.assertTrue("El archivo productos.JSON no existe.", file.exists());
    
    // Limpiar el archivo después del test
    if (file.exists()) {
        file.delete();
    }
}

    @Test //!!!!!!  NO TOCAAAAAAR
    public void Import()throws Exception{
        Cargar_CSV c = new Cargar_CSV();
        assertTrue(c.Cargar_Productos());
    }
    @Test
public void Export_statsTest() throws Exception {
    // Crear una instancia de la clase Exportar_JSON
    Exportar_JSON exportarJson = new Exportar_JSON();
    
    // Llamar al método Export_Stats
    Boolean result = exportarJson.Export_Stats();
    
    // Verificar si el resultado es true, lo que significa que el archivo fue exportado correctamente
    Assert.assertTrue("El archivo estadisticas.JSON no fue exportado correctamente.", result);
    
    // Verificar si el archivo realmente fue creado
    File file = new File("src/JSON/estadisticas.JSON");
    Assert.assertTrue("El archivo estadisticas.JSON no existe.", file.exists());
    
    // Limpiar el archivo después del test
    if (file.exists()) {
        file.delete();
    }
}

}
