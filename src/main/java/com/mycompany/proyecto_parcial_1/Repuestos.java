package com.mycompany.proyecto_parcial_1;

public abstract class Repuestos {
    
    private static int siguienteCodigo = 1001; // Esto es un contador para que no existan codigos repetidos
    
    private int codigo;
    private String producto;
    protected String categoria; 
    private double precio;
    private int stock;
    
    private static final int stockMinimo = 5; 
    
    public  Repuestos(String producto, String categoria, double precio, int stock) {
        this.codigo = siguienteCodigo++;
        this.producto = producto;
        this.categoria = categoria;
        setPrecio(precio);
        setStock(stock);
    }
    public  Repuestos(String producto, double precio, int stock) {
        this.codigo = siguienteCodigo++;
        this.producto = producto;
        this.categoria = "Miscelaneo";
        setPrecio(precio);
        setStock(stock);
    }

    public int getCodigo() {
        return this.codigo;
    }
    
    public String getProducto() {
        return producto;
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
    
    public int getStockMinimo() {
        return stockMinimo;
    }

    
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {    
            System.out.println("Error: Precio invalido.");
}
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Error: Stock invalido");
        }
    }
    
    public boolean ingresarStock(int cantidad){
        if (cantidad  > 0){
            this.stock = stock + cantidad;
            return true;
        }
        return false;
    }
    
    public boolean retirarStock(int cantidad){
        if (cantidad > 0 && cantidad <= stock) {
            this.stock = stock - cantidad;
            return true;
        }
        return false;
    } 
    
    public abstract String getTipo();

    public void mostrarInfo() {
        System.out.println("-----------------------------");
        System.out.print(" | Codigo: " + this.codigo);
        System.out.print(" | Nombre: " + this.producto);
        System.out.print(" | Categoria: " + this.categoria);
        System.out.print(" | Tipo: " + getTipo());
        System.out.print(" | Precio: $" + this.precio);
        System.out.print(" | Stock: " + this.stock );
        System.out.println();
        
    }
}
