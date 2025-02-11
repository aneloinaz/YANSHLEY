package Gestion;

import Entidades.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class Gestion_Acceso{

    public boolean Sesion(String email, String password)throws Exception{
        try(  Connection connect = new ConexionBD().conectar(); ){
            String query = "SELECT pass FROM usuario WHERE correo_electronico = ?";
            CallableStatement cs = connect.prepareCall(query);
            cs.setString(1,email);
            ResultSet response = cs.executeQuery();
            if(response.next()){
                String pass = response.getString(1);
                if(!pass.equals(password)){
                    System.err.println("Contraseña invalida");
                    return false;
                }else{
                    System.out.println("Usuario Logeado, Sesión iniciada");
                    return true;
                }
            }else{
                System.err.println("Usuario no existe");
                return false;
            }
        }catch(Exception e){
            System.err.println("Error en la coneccion: "+e);
        }
        return false;
    }


    public Boolean registro(Usuario usuario) throws Exception{

        try( Connection connect = new ConexionBD().conectar();){
            String sql_string = "INSERT INTO usuario (nombre_usuario, pass, correo_electronico, nombre_completo, direccion, telf, fecha_registro, DNI) VALUES(?,?,?,?,?,?,?,?);";
            CallableStatement cs = connect.prepareCall(sql_string);
            cs.setString(1,usuario.getNombre_usuario());
            cs.setString(2, usuario.getPass());
            cs.setString(3, usuario.getCorreo_electronico());
            cs.setString(4, usuario.getNombre_completo());
            cs.setString(5, usuario.getDireccion());
            cs.setString(6, usuario.getTelf());
            cs.setDate(7, usuario.getFecha_registro());
            cs.setString(8,usuario.getDni());
            int response = cs.executeUpdate();
            return response > 0;
        }catch(Exception e){
            System.err.println("Error en la insercion: "+e);
        }
        return false;
    }
}
