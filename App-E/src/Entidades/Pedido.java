package Entidades;

import java.util.Date;

public class Pedido {
    private int id_pedido;
    private Date fecha_pedido;
    private double monto_total;
    private String estado;
    private int id_usuario;

    public Pedido(Date fecha_pedido, double monto_total, String estado, int id_usuario, int id_pedido) {
        this.fecha_pedido = fecha_pedido;
        this.monto_total = monto_total;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_pedido = id_pedido;
    }

    public Pedido(int id_pedido, Date fecha_pedido, double monto_total, String estado, int id_usuario) {
        this.id_pedido = id_pedido;
        this.fecha_pedido = fecha_pedido;
        this.monto_total = monto_total;
        this.estado = estado;
        this.id_usuario = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_pedido() {
        return id_pedido;
    }
}
