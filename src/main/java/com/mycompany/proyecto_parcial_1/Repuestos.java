package com.mycompany.proyecto_parcial_1;
import java.util.Random;


public class Repuestos {
    //Atributos de la clase de los repuestos encapsulados
    private int codigo;
    private String producto;
    private String categoria; 
    private double precio;
    private int stock;
    public final int stockMinimo = 5;
    private Random ran = new Random();
    // Constructor 
    public  Repuestos(String producto, String categoria, double precio, int stock) {
        this.codigo = ran.nextInt(0001,9999);
        this.categoria = categoria;
        this.producto = producto;
        setPrecio(precio);
        setStock(stock);
    }

    // Métodos Getters para consultar estados
    public int getCodigo() {
        return this.codigo;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public String getProducto() {
        return producto;
    }
    

    // Métodos Setters con validaciones para que no existan problemas con introducir valores nada que ver al programa y salte error por consiguiente
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: El precio no puede ser negativo.");
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Error: El stock no puede ser un valor menor a cero.");
        }
    }

    // Método para mostrar por pantalla la información del repuesto (codigo, categoria, precio y stock en existencia)
    public void mostrarInfo() {
        System.out.println("Código: " + this.codigo + " | Nombre: " + this.producto + " | Categoría: " + this.categoria + " | Precio: $" + this.precio + " | Stock: " + this.stock);
    }
}
