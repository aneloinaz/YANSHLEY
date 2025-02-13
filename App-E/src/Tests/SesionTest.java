package Tests;

import Gestion.Gestion_Acceso;
import org.junit.Assert;
import org.junit.Test;

public class SesionTest {
    static Gestion_Acceso login = new Gestion_Acceso();
//    Usuario valido
    @Test
    public void test_UsuarioValido()throws Exception{
        String email = "ikerb@email.com";
        String password = "14e1b600b1fd579f47433b88e8d85291";
        Assert.assertEquals(true,login.Sesion(email, password));
    }
//    email incorrecto
    @Test
    public void test_EmailIncorrecto()throws Exception{
        String email = "ikerb@email.comx";
        String password = "14e1b600b1fd579f47433b88e8d85291x";
        Assert.assertFalse(login.Sesion(email,password));
    }
//    Contraseña invalida
    @Test
    public void test_ContraseñaInvalida()throws Exception{
        String email = "ikerb@email.com";
        String password = "14e1b600b1fd5";
        Assert.assertFalse(login.Sesion(email,password));
    }
}
