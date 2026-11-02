package com.mycompany.proyecto_parcial_1;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Proyecto_parcial_1 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ArrayList<Repuestos> inventario = new ArrayList<>();

        int opcion = 67; //Valor placeholder para evitar errores de "No inicializado"

        do {
            System.out.println("\n===== INVENTARIO REPUESTOS =====");
            System.out.println("1. Registrar repuesto");
            System.out.println("2. Mostrar todos los repuestos");
            System.out.println("3. Buscar repuesto");
            System.out.println("4. Ingresar stock");
            System.out.println("5. Retirar stock");
            System.out.println("6. Calcular valor total del inventario");
            System.out.println("7. Mostrar repuestos con stock bajo");
            System.out.println("8. Salir");
            

            
            try {
                System.out.print("Seleccione una opcion: ");
                opcion = entrada.nextInt();}
            catch(InputMismatchException e){
            entrada.nextLine();
            System.out.println("---INGRESE UN NUMERO VALIDO---"); 
            continue;
            }
            entrada.nextLine();

            switch (opcion) {
                
                case 1:
                    System.out.println("\n--- REGISTRAR REPUESTO ---");

                    
                        System.out.print("Nombre del repuesto: ");
                        String producto = entrada.nextLine();

                        System.out.print("Categoria: ");
                        String categoria = entrada.nextLine();

                        System.out.print("Precio: ");
                        double precio = entrada.nextDouble();
                        entrada.nextLine();

                        System.out.print("Stock inicial: ");
                        int stock = entrada.nextInt();
                        entrada.nextLine();

                        if (categoria.isBlank() || producto.isBlank() || precio < 0 || stock < 0) {
                            System.out.println("Datos invalidos.");
                        } else {
                            Repuestos nuevo = new Repuestos(
                                    producto, categoria, precio, stock);

                            inventario.add(nuevo);
                            System.out.println("Repuesto registrado correctamente.");
                        }
                    
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE REPUESTOS ---");

                    if (inventario.isEmpty()) {
                        System.out.println("No hay repuestos registrados.");
                    } else {
                        for (Repuestos r : inventario) {
                            r.mostrarInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR REPUESTO ---");

                    System.out.print("Ingrese el codigo: ");
                    int codigoBuscar = entrada.nextInt();

                    boolean encontrado = false;

                    for (Repuestos r : inventario) {
                        if (r.getCodigo() ==  codigoBuscar) {
                            r.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Repuesto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- REPONER STOCK ---");

                    System.out.print("Codigo del repuesto: ");
                    int codigoReponer = entrada.nextInt();

                    boolean repuestoEncontrado = false;

                    for (Repuestos r : inventario) {
                        if (r.getCodigo() ==  codigoReponer) {

                            repuestoEncontrado = true;

                            System.out.print("Unidades a agregar: ");
                            int cantidad = entrada.nextInt();
                            entrada.nextLine();

                            if (cantidad > 0) {
                                r.setStock(r.getStock() + cantidad);
                                System.out.println("Stock actualizado.");
                            } else {
                                System.out.println("Cantidad invalida.");
                            }
                            break;
                        }
                    }

                    if (!repuestoEncontrado) {
                        System.out.println("Repuesto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- SALIDA DE STOCK ---");

                    System.out.print("Codigo del repuesto: ");
                    int codigoSalida = entrada.nextInt();

                    boolean encontradoSalida = false;

                    for (Repuestos r : inventario) {
                        if (r.getCodigo() == codigoSalida) {

                            encontradoSalida = true;

                            System.out.print("Cantidad a retirar: ");
                            int cantidad = entrada.nextInt();
                            entrada.nextLine();

                            if (cantidad <= 0) {
                                System.out.println("Cantidad invalida.");
                            } else if (cantidad > r.getStock()) {
                                System.out.println("Stock insuficiente.");
                            } else {
                                r.setStock(r.getStock() - cantidad);
                                System.out.println("Salida registrada.");
                            }
                            break;
                        }
                    }

                    if (!encontradoSalida) {
                        System.out.println("Repuesto no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- VALOR TOTAL DEL INVENTARIO ---");

                    double total = 0;

                    for (Repuestos r : inventario) {
                        total += r.getPrecio() * r.getStock();
                    }

                    System.out.println("Valor total: $" + total);
                    break;

                case 7:
                    System.out.println("\n--- REPUESTOS CON STOCK BAJO ---");

                   
                        boolean hayStockBajo = false;   
                        for (Repuestos r : inventario) {
                            if (r.getStock() <= r.stockMinimo) {
                                r.mostrarInfo();
                                hayStockBajo = true;
                            }
                        }

                        if (!hayStockBajo) {
                            System.out.println("No hay repuestos con stock bajo.");
                        }
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 8);

        entrada.close();
    }
}
