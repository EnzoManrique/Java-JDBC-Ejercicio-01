/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class TiendaServicio {
    
    public static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public static void Menu()throws Exception{
        System.out.println("\nMenú:"
                + "\n1- Listar el nombre de todos los productos"
                + "\n2- Listar el nombre y precio de todos los productos"
                + "\n3- Listar aquellos productos con un precio entre 120 y 202"
                + "\n4- Listar todos los portátiles de la tabla productos"
                + "\n5- Listar el nombre y precio del producto más barato"
                + "\n6- Ingresar un producto a la base de datos"
                + "\n7- Ingresar un fabricante a la base de datos"
                + "\n8- Editar un producto"
                + "\n9- Salir del programa");
        System.out.print("Opción: ");
        String op = leer.next();
        
        try {
            switch (op) {
            case "1":
                ProductoServicio.MostrarNombreDeProductos();
                Menu();
                break;
            case "2":
                ProductoServicio.MostrarNombreYPrecioDeProductos();
                Menu();
                break;
            case "3":
                ProductoServicio.MostrarProductosEntre120Y202();
                Menu();
                break;
            case "4":
                ProductoServicio.MostrarPortatiles();
                Menu();
                break;
            case "5":
                ProductoServicio.MostrarProductoMasBarato();
                Menu();
                break;
            case "6":
                ProductoServicio.ingresarProducto();
                Menu();
                break;
            case "7":
                FabricanteServicio.ingresarFabricante();
                Menu();
                break;
            case "8":
                ProductoServicio.modificarProducto();
                Menu();
                break;
            case "9":
                System.out.println("\nHasta luego.");
                break;
            default:
                System.out.println("\nOpción no valida.");
                Menu();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
