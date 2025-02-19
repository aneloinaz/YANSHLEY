package Entidades;

public class Usuario_Pedidos {
    private int id_usuario;
    private String nombre_usuario;
    private int cantidadPedidos;

    public Usuario_Pedidos(){};

    public Usuario_Pedidos(int id_usuario, String nombre_usuario, int cantidadPedidos) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.cantidadPedidos = cantidadPedidos;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
   public int getCantidadPedidos(){
    return cantidadPedidos;
   } 
}
