import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Entidades.Categoria;
import Entidades.Producto;
import Gestion.Cargar_CSV;
import Gestion.Exportar_JSON;
import Gestion.Gestion_Acceso;
import Gestion.Gestion_Categoria;
import Gestion.Gestion_Productos;
public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Sesion();
        Clear();
        System.out.println("\nBIENVENIDO ADMIN!!");
        boolean value = false;

        while (!value) {
            System.out.println("\n*************************************************\n");
            System.out.println("\nELIGE UNA OPCIÓN: ");
            int option = Menu_Principal();
            int order = 0;
            switch (option) {
                case 1:
                while (true) {
                    System.out.println("SELECCIONA EL ORDEN EN EL QUE QUIERES QUE APAREZCAN: 1=precio, 2=stock ");
                    order = ValidacionEntero();
                    sc.nextLine();
                    if(order==1 || order==2){
                        break;
                    }else{
                        System.err.println("\nERROR: INGRESA UNA DE LAS OPCCIONES DISPONIBLES\n");
                    }
                }
                    
                    Option1(order);
                    value = SalirSN();
                    break;
                case 2:
                    System.out.println("SELECCIONA EL ID DE UNA CATEGORÍA: ");
                    int categoria = Mostrar_Categorias();
                    while (true) {
                        System.out.println("SELECCIONA EL ORDEN EN EL QUE QUIERES QUE APAREZCAN: 1=disponibilidad, 2=stock ");
                        order = ValidacionEntero();
                        sc.nextLine();
                        if(order==1 || order==2){
                            break;
                        }else{
                            System.err.println("\nERROR: INGRESA UNA DE LAS OPCCIONES DISPONIBLES\n");
                        }
                    }
                    
                    Option2(order,categoria);
                    value = SalirSN();
                    break;
                case 3:
                    System.out.println("INGRESA EL TERMINO DE BÚSQUEDA: ");
                    String termino = sc.nextLine();
                    while (true) {
                        System.out.println("SELECCIONA EL ORDEN EN EL QUE QUIERES QUE APAREZCAN: 1=disponibilidad, 2=stock ");
                        order = ValidacionEntero();
                        sc.nextLine();
                        if(order==1 || order==2){
                            break;
                        }else{
                            System.err.println("\nERROR: INGRESA UNA DE LAS OPCCIONES DISPONIBLES\n");
                        }
                    }
                    Option3(order,termino);
                    value = SalirSN();
                    break;
                case 4:
                    System.out.println("\n*************************************************\n");
                    System.out.println("AGREGA UN NUEVO PRODUCTO: ");
                    System.out.println("\n*************************************************\n");
                    Option4();
                    value = SalirSN();
                    break;
                case 5:
                    System.out.println("\n*************************************************\n");
                    System.out.println("ACTUALIZA UN PRODUCTO: ");
                    System.out.println("\n*************************************************\n");
                    System.out.print("INGRESA EL ID DEL PRODUCTO A MODIFICAR:  ");
                    int id = ValidacionEntero();
                    sc.nextLine();
                    Option5(id);
                    value = SalirSN();
                    break;
                case 6:
                    System.out.println("\n*************************************************\n");
                    System.out.println("ELIMINAR UN PRODUCTO ");
                    System.out.println("\n*************************************************\n");
                    System.out.println("INGRESA EL ID DEL PRODUCTO A ELIMINAR:   ");
                    int id_eliminar = ValidacionEntero();
                    sc.nextLine();
                    Option6(id_eliminar);
                    value = SalirSN();
                    break;
                case 7:
                    Option7();
                    value = SalirSN();
                    break;
                case 8:
                    Option8();
                    break;
                default:
                    System.err.println("\nINGRESA UNA OPCIÓN VALIDA\n");
                    break;
            }
        
        }
        
        
    }

public static void Sesion() throws Exception{
        System.out.println("\n----------------------------------------------------\n");
        Gestion_Acceso g = new Gestion_Acceso();
        boolean value = false;
        System.out.println("\nBIENVENIDO AL PANEL DE ADMINISTRACIÓN!");
        while (value!=true) {
            System.out.println("\nINGRESA TU CORREO");
            String email = sc.nextLine();
            System.out.println("\nINGRESA TU CONTRASEÑA");
            String password = sc.nextLine();      
            System.out.println("\n\n");  
            value = g.Sesion(email, password);
        }
        Clear();

    }
    
public static int Menu_Principal(){ 
        System.out.println("1: LISTAR TODOS LOS PRODUCTOS");
        System.out.println("2: LISTAR PRODUCTOS POR CATEGORIA");
        System.out.println("3: LISTAR PRODUCTOS POR TÉRMINOS DE BÚSQUEDA");
        System.out.println("4: AGREGAR PRODUCTOS");
        System.out.println("5: ACTUALIZAR PRODUCTOS EXISTENTES");
        System.out.println("6: ELIMINAR PRODUCTOS");
        System.out.println("7: EXPORTAR JSON");
        System.out.println("8: IMPORTAR CSV");
        System.out.println("\n");
        
        int option = ValidacionEntero();
        sc.nextLine();
        Clear();
        return option;
    }

public static int Mostrar_Categorias()throws Exception{
        Clear();
        Gestion_Categoria g = new Gestion_Categoria();
        List<Categoria> categorias = g.ListaCategorias();
        System.out.println("\n*************************************************\n");
        System.out.println("TODAS LAS CATEGORÍAS DISPONIBLES");
        System.out.println("\n--------------------------------------------------\n");
        for(Categoria cat : categorias){
            System.out.println(cat.toString());
            System.out.println("\n_____________________________________________\n");
        }
        System.out.println("\n");
        int option = ValidacionEntero();
        sc.nextLine();
        return option;
    }
    
public static void Option1(int order)throws Exception{
        Clear();
        boolean v = false;
        if(order==1){
            v = true;
        }
        Gestion_Productos g = new Gestion_Productos();
        List<Producto> productos = g.TraerProductos(v);
        System.out.println("\n*************************************************\n");
        System.out.println("LISTA DE TODOS LOS PRODUCTOS");
        System.out.println("\n*************************************************\n");
        for(Producto item : productos){
            System.out.println(item.toString());
            System.out.println("\n_____________________________________________\n");
        }
    }
    
public static void Option2(int order,int option)throws Exception{
    Clear();
    boolean v = true;
        if(order==1){
            v = true;
        }
        Gestion_Productos g = new Gestion_Productos();
        List<Producto> productos = g.TraerProductos(v,option);
        System.out.println("\n*************************************************\n");
        System.out.println("PRODUCTOS DE CATEGORÍA ID : "+option);
        System.out.println("\n*************************************************\n");
        for(Producto item : productos){
            System.out.println(item.toString());
            System.out.println("\n_____________________________________________\n");
        }
    }

public static void Option3(int order,String termino) throws Exception{
    Clear();
    boolean v = true;
        if(order==1){
            v = true;
        }
    Gestion_Productos g = new Gestion_Productos();
    List<Producto> productos = g.TraerProductos(v,termino);
    System.out.println("\n*************************************************\n");
    System.out.println("Coincidencias con: "+termino);

    System.out.println("\n*************************************************\n");
    for(Producto item : productos){
        System.out.println(item.toString());
        System.out.println("\n_____________________________________________\n");
    }
}

public static void Option4()throws Exception{
    Gestion_Productos g = new Gestion_Productos();
    
    System.out.print("INGRESA EL NOMBRE:   ");
    String nombre = sc.nextLine();
    System.out.print("INGRESA LA DESCRIPCIÓN:   ");
    String descripcion = sc.nextLine();
    System.out.print("INGRESA EL PRECIO:   ");
    Double precio = ValidacionDouble();
    sc.nextLine();
    System.out.print("INGRESA EL STOCK:   ");
    int stock = ValidacionEntero();
    sc.nextLine();
    System.out.print("INGRESA LA IMAGEN:   ");
    String imagen= sc.nextLine();
    System.out.print("INGRESA EL ID DE CATEGORÍA:   ");
    int id_categoria = ValidacionEntero();
    sc.nextLine();
    
    Producto producto = new Producto(nombre,descripcion,precio,stock,imagen,id_categoria);
    g.AgregarProducto(producto);
}

public static void Option5(int id)throws Exception{
    Clear();
    Gestion_Productos g = new Gestion_Productos();
   
    boolean validation = false;
    HashMap<String , Object> producto = new HashMap<>();

    while(!validation){
        System.out.println("SELECCIONA EL CAMPO QUE DESEAS MODIFICAR: ");
        System.out.println("1: NOMBRE ");
        System.out.println("2: DESCRIPCION ");
        System.out.println("3: PRECIO ");
        System.out.println("4: STOCK ");
        System.out.println("5: IMAGEN ");
        System.out.println("6: ID DE CATEGORIA ");
        int option = ValidacionEntero();
        sc.nextLine();
        int rs = 0;
        switch(option){
            case 1:
                System.out.println("INGRESA EL NUEVO NOMBRE ");
                String nombre = sc.nextLine();
                producto.put("nombre", nombre);
                do{
                    System.out.println("SELECCIONA = (1: actualizar, 2: Seguir Modificando) ");
                    rs = ValidacionEntero();
                    sc.nextLine();
                    validation = rs==1; 
                    if(rs!=1 && rs!=2){
                        System.err.println("\nERROR!!!!, INGRESA UNA OPCIÓN VALIDA\n");
                    }
                }while(rs!=1 && rs != 2);

                break;
            case 2:
                System.out.print("INGRESA LA DESCRIPCIÓN:   ");
                String descripcion = sc.nextLine();
                producto.put("descripcion", descripcion);
                do{
                    System.out.println("SELECCIONA = (1: actualizar, 2: Seguir Modificando) ");
                    rs = ValidacionEntero();
                    sc.nextLine();
                    validation = rs==1; 
                    if(rs!=1 && rs!=2){
                        System.err.println("\nERROR!!!!, INGRESA UNA OPCIÓN VALIDA\n");
                    }
                }while(rs!=1 && rs != 2);

                break;
            case 3:
                System.out.print("INGRESA EL PRECIO:   ");
                Double precio = sc.nextDouble();
                sc.nextLine();
                producto.put("precio", precio);
                do{
                    System.out.println("SELECCIONA = (1: actualizar, 2: Seguir Modificando) ");
                    rs = ValidacionEntero();
                    sc.nextLine();
                    validation = rs==1; 
                    if(rs!=1 && rs!=2){
                        System.err.println("\nERROR!!!!, INGRESA UNA OPCIÓN VALIDA\n");
                    }
                }while(rs!=1 && rs != 2);

                break;
            case 4:
                System.out.print("INGRESA EL STOCK:   ");
                int stock = ValidacionEntero();
                sc.nextLine();
                producto.put("stock", stock);
                do{
                    System.out.println("SELECCIONA = (1: actualizar, 2: Seguir Modificando) ");
                    rs = ValidacionEntero();
                    sc.nextLine();
                    validation = rs==1; 
                    if(rs!=1 && rs!=2){
                        System.err.println("\nERROR!!!!, INGRESA UNA OPCIÓN VALIDA\n");
                    }
                }while(rs!=1 && rs != 2);

                break;
            case 5:
                System.out.print("INGRESA LA IMAGEN:   ");
                String imagen= sc.nextLine();
                producto.put("imagen", imagen);
                do{
                    System.out.println("SELECCIONA = (1: actualizar, 2: Seguir Modificando) ");
                    rs = ValidacionEntero();
                    sc.nextLine();
                    validation = rs==1; 
                    if(rs!=1 && rs!=2){
                        System.err.println("\nERROR!!!!, INGRESA UNA OPCIÓN VALIDA\n");
                    }
                }while(rs!=1 && rs != 2);

                break;
            case 6:
                System.out.print("INGRESA EL ID DE CATEGORÍA:   ");
                int id_categoria = ValidacionEntero();
                sc.nextLine();
                producto.put("id_categoria", id_categoria);
                do{
                    System.out.println("SELECCIONA = (1: actualizar, 2: Seguir Modificando) ");
                    rs = ValidacionEntero();
                    sc.nextLine();
                    validation = rs==1; 
                    if(rs!=1 && rs!=2){
                        System.err.println("\nERROR!!!!, INGRESA UNA OPCIÓN VALIDA\n");
                    }
                }while(rs!=1 && rs != 2);

                break;
            default:
                System.err.println("\nINGRESA UNA OPCIÓN VALIDA\n");
                break;
        }
    }

    g.ModificarProducto(producto,id);
    
}

public static void Option6(int id)throws Exception{
    Clear();
    Gestion_Productos g = new Gestion_Productos();
    g.EliminarProducto(id);
}

public static void Option7()throws Exception{
    Clear();
    Exportar_JSON exp = new Exportar_JSON();
    int rs = 0;
    do{
        System.out.println("SELECCIONA EL TIPO DE FICHERO QUE DESEAS EXPORTAR:");
        System.out.println("1: PRODUCTOS");
        System.out.println("2: ESTADISTICAS");
        rs = ValidacionEntero();
        switch (rs) {
            case 1:
                exp.Export_Product();
                break;
            case 2:
                exp.Export_Stats();
                break;
            default:
                System.err.println("\nINGRESA UNA OPCIÓN VALIDA\n");
                break;
        }
    }while(rs!=1 && rs != 2);

    
}

public static void Option8()throws Exception{
    Cargar_CSV csv = new Cargar_CSV();
    csv.Cargar_Productos();
}

public static int ValidacionEntero(){
    while (true) {
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.err.println("\nERROR: INGRESA UN NÚMERO ENTERO VÁLIDO.\n");
            sc.nextLine();
        }
    }
}
public static double ValidacionDouble(){
    while (true) {
        try {
            return sc.nextDouble();
        } catch (Exception e) {
            System.err.println("\nERROR: INGRESA UN NÚMERO DECIMAL/ENTERO VÁLIDO.\n");
            sc.nextLine();
        }
    }
}
public static boolean SalirSN(){
    int o = 0;

    while (true) {
        System.out.println("\n*************************************************\n");
        System.out.println("OPCIÓN 1 = VOLVER AL PANEL DE ADMIN");
        System.out.println("OPCIÓN 2 = CERRAR SESIÓN");
        System.out.println("\n*************************************************\n");
        o = ValidacionEntero();
        if(o!=1 && o!=2){
            System.err.println("\nOpción incorrecta, elige solo las disponibles\n");
        }else{
            Clear();
            System.out.println(o == 27 ? "SESIÓN CERRADA" : "");
           break;
        }

    }
    return o!=1;
}

public static void Clear() {
    for (int i = 0; i < 50; i++) System.out.println();
}

}
