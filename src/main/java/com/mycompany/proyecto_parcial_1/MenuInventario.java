
package com.mycompany.proyecto_parcial_1;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuInventario {

    private ArrayList<Repuestos> inventario;
    private Scanner entrada;

    public MenuInventario(ArrayList<Repuestos> inventario, Scanner entrada) {
        this.inventario = inventario;
        this.entrada = entrada;
    }

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n===== INVENTARIO DE REPUESTOS =====");
            System.out.println("1. Registrar repuesto");
            System.out.println("2. Mostrar todos los repuestos");
            System.out.println("3. Buscar repuesto por codigo");
            System.out.println("4. Agregar stock");
            System.out.println("5. Retirar stock");
            System.out.println("6. Calcular valor total del inventario");
            System.out.println("7. Mostrar repuestos con stock bajo");
            System.out.println("8. Salir");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1: {

                    System.out.println("\n--- REGISTRAR REPUESTO ---");

                    System.out.print("Nombre del repuesto: ");
                    String producto = entrada.nextLine().trim();

                    System.out.print("Categoria: ");
                    String categoria = entrada.nextLine().trim();

                    if (producto.isEmpty()) {
                        System.out.println("Nombre no puede estar vacio.");
                        break;
                    }

                    double precio = leerDouble("Precio: ");
                    int stock = leerEntero("Stock inicial: ");

                    if (precio < 0 || stock < 0) {
                        System.out.println("Precio y stock no pueden ser negativos.");
                        break;
                    }

                    int tipo = leerEntero("Tipo (1. Regular / 2. Exclusivo): ");

                    Repuestos nuevo;

                    if (tipo == 1) {
                        if (categoria.isEmpty()) {
                         nuevo = new RepuestosRegular(
                                producto, precio, stock);
                        }
                        else{
                        nuevo = new RepuestosRegular(
                                producto, categoria, precio, stock);
                        }
                        
                    } else if (tipo == 2) {
                        nuevo = new RepuestosExclusivos(
                                producto, categoria, precio, stock);
                    } else {
                        System.out.println("Tipo invalido.");
                        break;
                    }

                    inventario.add(nuevo);

                    System.out.println("Repuesto registrado correctamente.");
                    System.out.println("Codigo asignado: " + nuevo.getCodigo());

                    break;
                }


                case 2: {

                    System.out.println("\n--- LISTA DE REPUESTOS ---");

                    if (inventario.isEmpty()) {
                        System.out.println("No hay repuestos registrados.");
                    } else {
                        for (Repuestos repuesto : inventario) {
                            repuesto.mostrarInfo();
                        }
                    }

                    break;
                }

                case 3: {

                    System.out.println("\n--- BUSCAR REPUESTO ---");

                    int codigo = leerEntero("Codigo a buscar: ");

                    Repuestos encontrado = null;

                    for (Repuestos repuesto : inventario) {
                        if (repuesto.getCodigo() == codigo) {
                            encontrado = repuesto;
                            break;
                        }
                    }

                    if (encontrado == null) {
                        System.out.println("Repuesto no encontrado.");
                    } else {
                        encontrado.mostrarInfo();
                    }

                    break;
                }

                case 4: {

                    System.out.println("\n--- AGREGAR STOCK ---");

                    int codigo = leerEntero("Codigo del repuesto: ");

                    Repuestos encontrado = null;

                    for (Repuestos repuesto : inventario) {
                        if (repuesto.getCodigo() == codigo) {
                            encontrado = repuesto;
                            break;
                        }
                    }

                    if (encontrado == null) {
                        System.out.println("Repuesto no encontrado.");
                        break;
                    }

                    int cantidad = leerEntero("Cantidad a agregar: ");

                    if (encontrado.ingresarStock(cantidad)) {
                        System.out.println("Stock actualizado: "
                                + encontrado.getStock());
                    } else {
                        System.out.println("Cantidad invalida o demasiado grande.");
                    }

                    break;
                }

                case 5: {

                    System.out.println("\n--- RETIRAR STOCK ---");

                    int codigo = leerEntero("Codigo del repuesto: ");

                    Repuestos encontrado = null;

                    for (Repuestos repuesto : inventario) {
                        if (repuesto.getCodigo() == codigo) {
                            encontrado = repuesto;
                            break;
                        }
                    }

                    if (encontrado == null) {
                        System.out.println("Repuesto no encontrado.");
                        break;
                    }

                    int cantidad = leerEntero("Cantidad a retirar: ");

                    if (encontrado.retirarStock(cantidad)) {
                        System.out.println("Stock actualizado: "
                                + encontrado.getStock());
                    } else {
                        System.out.println("Cantidad invalida o stock insuficiente.");
                    }

                    break;
                }
                
                case 6: {

                    System.out.println("\n--- VALOR TOTAL DEL INVENTARIO ---");

                    double total = 0;

                    for (Repuestos repuesto : inventario) {
                        total += repuesto.getPrecio() * repuesto.getStock();
                    }

                    System.out.printf("Valor total del inventario: $%.2f%n", total);

                    break;
                }

                case 7: {

                    System.out.println("\n--- REPUESTOS CON STOCK BAJO ---");

                    boolean hayStockBajo = false;

                    for (Repuestos repuesto : inventario) {
                        if (((IVerificable) repuesto).necesitaReposicion()) {
                            repuesto.mostrarInfo();
                            hayStockBajo = true;
                        }
                    }

                    if (!hayStockBajo) {
                        System.out.println("No hay repuestos con stock bajo.");
                    }

                    break;
                }

                case 8: {

                    System.out.println("Saliendo del sistema...");
                    break;
                }
                default: {

                    System.out.println("Opcion invalida.");
                    break;
                }
            }

        } while (opcion != 8);
    }

    
    // Metodo adicional para leer enteros 
    
    private int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);
            String texto = entrada.nextLine();

            try {
                return Integer.parseInt(texto.trim());

            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    // Metodo adicional para leer decimales 
    
    private double leerDouble(String mensaje) {

        while (true) {

            System.out.print(mensaje);
            String texto = entrada.nextLine();

            try {
                double numero = Double.parseDouble(texto.trim());

                if (Double.isFinite(numero)) {
                    return numero;
                }

            } catch (NumberFormatException e) {
                // Si no es un numero, se vuelve a solicitar.
            }

            System.out.println("Ingrese un numero valido (use punto para decimales).");
        }
    }
}
