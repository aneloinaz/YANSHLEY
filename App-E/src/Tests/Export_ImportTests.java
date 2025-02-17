package Tests;

import Gestion.Cargar_CSV;
import Gestion.Exportar_JSON;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class Export_ImportTests {
    @Test
    public void Export()throws Exception{
        Exportar_JSON ex = new Exportar_JSON();
        Assert.assertTrue(ex.Export());
    }
    @Test
    public void Import()throws Exception{
        Cargar_CSV c = new Cargar_CSV();
        assertTrue(c.Cargar_Productos());
    }
}
