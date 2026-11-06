package com.mycompany.proyecto_parcial_1;

public class RepuestosRegular extends Repuestos implements IVerificable{

    public RepuestosRegular(String producto, String categoria, double precio, int stock) {
        super(producto, categoria, precio, stock);
    }

    @Override
    public void AjustarStock() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
}
