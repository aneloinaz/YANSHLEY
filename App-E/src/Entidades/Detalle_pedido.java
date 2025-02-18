package Entidades;

public class Detalle_pedido {
    private int id_detalle;
    private int id_pedido;
    private int id_producto;
    private double precio;
    private int cantidad;

//    consultar
    public Detalle_pedido(int id_detalle, int id_pedido, int id_producto, double precio, int cantidad) {
        this.id_detalle = id_detalle;
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
//    insertar

    public Detalle_pedido(int id_pedido, int id_producto, double precio, int cantidad) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
