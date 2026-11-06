package com.mycompany.proyecto_parcial_1;

public class RepuestosRegular extends Repuestos implements IVerificable{

    public RepuestosRegular(String producto, String categoria, double precio, int stock) {
        super(producto, categoria, precio, stock);
    }
    public RepuestosRegular(String producto, double precio, int stock) {
        super(producto, precio, stock);
        this.categoria = "Miscelaneo";
    }
    
    

    @Override
    public String getTipo() {
        return "Regular";
    }
    
    @Override
    public boolean necesitaReposicion(){
        return getStock() <= getStockMinimo();
    }
}
