package Tests;

import Entidades.Usuario;
import Gestion.Gestion_Acceso;
import org.junit.Assert;
import org.junit.Test;

public class RegistroTest {
    @Test
    public void TestRegistro() throws Exception{
        Usuario usuario = new Usuario("DNIEjemplo","NombreFalso","CorreoFalso","PassFalsa","12345678","Direccion falsa","Nombre completo");
        Gestion_Acceso registro = new Gestion_Acceso();
        Assert.assertTrue(registro.registro(usuario));
    }
}
