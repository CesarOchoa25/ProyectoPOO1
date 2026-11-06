package com.mycompany.proyecto_parcial_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto_parcial_1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Crear el inventario de repuestos
        ArrayList<Repuestos> inventario = new ArrayList<>();

        // Crear el objeto del menu
        MenuInventario menu = new MenuInventario(inventario, entrada);

        // Ejecutar el menu
        menu.iniciar();

        // Ciera el Scanner
        entrada.close();
    }
}