package Entidades;

import java.util.Date;

public class Producto {
    private String nombre;
    private int id_producto;
    private String descripcion;
    private double precio;
    private int stock;
    private Date fecha_cracion;
    private String imagen;
    private int id_categoria;

//    consultar
    public Producto(String nombre, int id_producto, String descripcion, double precio, int stock, Date fecha_cracion, String imagen, int id_categoria) {
        this.nombre = nombre;
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fecha_cracion = fecha_cracion;
        this.imagen = imagen;
        this.id_categoria = id_categoria;
    }
// insertar
    public Producto(String nombre, String descripcion, double precio, int stock, Date fecha_cracion, String imagen, int id_categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fecha_cracion = fecha_cracion;
        this.imagen = imagen;
        this.id_categoria = id_categoria;
    }
//setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_producto() {
        return id_producto;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha_cracion() {
        return fecha_cracion;
    }

    public void setFecha_cracion(Date fecha_cracion) {
        this.fecha_cracion = fecha_cracion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

}
