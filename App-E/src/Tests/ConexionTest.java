package Tests;

import Gestion.ConexionBD;
import org.junit.Assert;
import org.junit.Test;
public class ConexionTest {
    @Test
    public void testConection()throws Exception {
        ConexionBD conn = new ConexionBD();
        Assert.assertNotNull(conn.conectar());
    }
}
