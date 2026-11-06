package com.mycompany.proyecto_parcial_1;

public class RepuestosExclusivos extends Repuestos implements IVerificable {

    public RepuestosExclusivos(String producto, String categoria, double precio, int stock) {
        super(producto, categoria, precio, stock);
    }

    @Override
    public String getTipo(){
        return "Exclusivo";
    }
    
    @Override
    public boolean necesitaReposicion(){
        return getStock() <= getStockMinimo();
    } 
}
