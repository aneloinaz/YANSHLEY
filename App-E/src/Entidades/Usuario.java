package Entidades;


public class Usuario {
    private int id_usuario;
    private String  dni;
    private String nombre_usuario;
    private String correo_electronico;
    private String pass;
    private String telf;
    private String direccion;
    private String nombre_completo;
    private java.sql.Date fecha_registro;
    private String rol;

    public Usuario(){};
//    consultar
    public Usuario(int id_usuario, String dni, String nombre_usuario, String correo_electronico, String telf, String direccion, String nombre_completo, java.sql.Date fecha_registro, String rol) {
        this.id_usuario = id_usuario;
        this.dni = dni;
        this.nombre_usuario = nombre_usuario;
        this.correo_electronico = correo_electronico;
        this.telf = telf;
        this.direccion = direccion;
        this.nombre_completo = nombre_completo;
        this.fecha_registro =  fecha_registro;
        this.rol = rol;
    }
//    insertar

    public Usuario(String dni, String nombre_usuario, String correo_electronico, String pass, String telf, String direccion, String nombre_completo) {
        this.dni = dni;
        this.nombre_usuario = nombre_usuario;
        this.correo_electronico = correo_electronico;
        this.pass = pass;
        this.telf = telf;
        this.direccion = direccion;
        this.nombre_completo = nombre_completo;
        this.fecha_registro = new java.sql.Date(System.currentTimeMillis());
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public java.sql.Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(java.sql.Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
