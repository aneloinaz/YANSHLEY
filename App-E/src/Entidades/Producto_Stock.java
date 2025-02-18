package Entidades;

public class Producto_Stock {
    private int id_Producto;
    private String nombre_producto;
    private int stock;
    

    public Producto_Stock(){};

    public Producto_Stock(int id_producto, String nombre_producto, int stock) {
        this.id_Producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.stock= stock;
    }
    public int getId_producto() {
        return id_Producto;
    }
    public String getNombre_producto() {
        return nombre_producto;
    }
   public int getStock(){
    return stock;
   } 
}
