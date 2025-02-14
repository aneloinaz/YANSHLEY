package Tests;

import Gestion.Exportar_JSON;
import org.junit.Assert;
import org.junit.Test;

public class Export_ImportTests {
    @Test
    public void Export()throws Exception{
        Exportar_JSON ex = new Exportar_JSON();
        Assert.assertTrue(ex.Export());
    }

}
