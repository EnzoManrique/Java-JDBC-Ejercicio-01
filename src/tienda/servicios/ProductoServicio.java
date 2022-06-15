/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.excepciones.ProductoException;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Walter
 */
public class ProductoServicio {

    private static ProductoDAO dao = new ProductoDAO();
        
    private static Collection<Producto> listarNombreDeProductos() throws Exception{
        
        try {
            Collection<Producto> productos = dao.listarNombreDeProductos();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void MostrarNombreDeProductos() throws Exception {
        
        try {
            Collection<Producto> productos = listarNombreDeProductos();
            
            if (productos.isEmpty()) {
                throw new ProductoException("No existen productos para imprimir.");
            }else {
                System.out.println("");
                for (Producto producto : productos) {
                    System.out.println(producto.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Collection<Producto> listarNombreYPrecioDeProductos() throws Exception{
        
        try {
            Collection<Producto> productos = dao.listarNombreYPrecioDeProductos();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void MostrarNombreYPrecioDeProductos() throws Exception {
        
        try {
            Collection<Producto> productos = listarNombreYPrecioDeProductos();
            
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir.");
            }else {
                System.out.println("");
                for (Producto producto : productos) {
                    System.out.println(producto.getNombre()+", "+producto.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Collection<Producto> listarProductosEntre120Y202() throws Exception{
        
        try {
            Collection<Producto> productos = dao.listarProductosEntre120Y202();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void MostrarProductosEntre120Y202() throws Exception {
        
        try {
            Collection<Producto> productos = listarProductosEntre120Y202();
            
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir.");
            }else {
                System.out.println("");
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Collection<Producto> listarPortatiles() throws Exception{
        
        try {
            Collection<Producto> productos = dao.listarPortatiles();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void MostrarPortatiles() throws Exception {
        
        try {
            Collection<Producto> productos = listarPortatiles();
            
            if (productos.isEmpty()) {
                throw new Exception("No existen portátiles para imprimir.");
            }else {
                System.out.println("");
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Producto listarProductoMasBarato() throws Exception{
        
        try {
            Producto producto = dao.listarProductoMasBarato();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void MostrarProductoMasBarato() throws Exception {
        
        try {
            Producto producto = listarProductoMasBarato();
            
            if (producto == null) {
                throw new Exception("No existen productos para imprimir.");
            }else {
                System.out.println("\n"+producto.getNombre()+", precio: $"+producto.getPrecio());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Collection<Producto> listarProductos() throws Exception{
        
        try {
            Collection<Producto> productos = dao.listarProductos();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void mostrarProductos() throws Exception {
        
        try {
            Collection<Producto> productos = listarProductos();
            
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir.");
            }else {
                System.out.println("");
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void ingresarProducto() throws Exception {
        try {
            System.out.print("\nIngrese el nombre del producto: ");
            String nombre = TiendaServicio.leer.next();
            System.out.print("Ingrese el precio: ");
            String aux = TiendaServicio.leer.next();
            aux=aux.replace(",", ".");
            double precio = Double.parseDouble(aux);
            Fabricante fabricante = FabricanteServicio.seleccionarFabricante();
        
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setFabricante(fabricante);
        
            dao.guardarProducto(producto);
        } catch (NumberFormatException e){
            throw new Exception("Ese valor no valido para un precio.");
        }catch (Exception e) {
            throw e;
        }
    }
    
    private static Producto seleccionarProducto()throws Exception{
        Producto producto = null;
        Collection<Producto> productos = listarProductos();
        
        try {
            System.out.println("Productos:");
            mostrarProductos();
            System.out.print("Elija un código de producto: ");
            String aux = TiendaServicio.leer.next();
            int respuesta = Integer.parseInt(aux);
            
            if(respuesta>productos.size() | respuesta<0){
                throw new ProductoException("Ese código de producto no existe.");
            }
            
            for (Producto pr : productos) {
                if(pr.getCodigo()== respuesta){
                    producto = pr;
                }
            }
            return producto;
        } catch (NumberFormatException e){
            System.out.println("Ingreso no valido, intenta de vuelta.");
            return producto=seleccionarProducto();
        } catch (ProductoException e){
            e.getMessage();
            return producto=seleccionarProducto();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void modificarProducto() throws Exception{
        Producto producto = seleccionarProducto();
        
        boolean continuar;
        do {            
            continuar = false;
            System.out.println("\nProducto seleccionado:");
            System.out.println(producto);
        
            System.out.println("\nSeleccione el dato a modificar:"
                    + "\n1- Nombre"
                    + "\n2- Precio"
                    + "\n3- Fabricante");
            System.out.print("Opción: ");
            String respuesta = TiendaServicio.leer.next();
            
            try {
                switch (respuesta) {
                    case "1":
                        modificarNombre(producto);
                        break;
                    case "2":
                        modificarPrecio(producto);
                        break;
                    case "3":
                        modificarFabricante(producto);
                        break;
                    default:
                        System.out.println("Opción no valida.");
                        continuar = true;
                }
            } catch (Exception e) {
                throw e;
            }
        } while (continuar);
    }
    
    private static void modificarNombre(Producto producto) throws Exception{
        
        System.out.println("\nProducto seleccionado:");
        System.out.println(producto);
        try {
            System.out.print("\nNuevo nombre: ");
            String nombre = TiendaServicio.leer.next();
            producto.setNombre(nombre);
            dao.modificarProductoNombre(producto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void modificarPrecio(Producto producto) throws Exception{
        
        System.out.println("\nProducto seleccionado:");
        System.out.println(producto);
        try {
            System.out.print("\nIngrese el nuevo precio: ");
            String aux = TiendaServicio.leer.next();
            aux=aux.replace(",", ".");
            double precio = Double.parseDouble(aux);
            producto.setPrecio(precio);
            dao.modificarProductoPrecio(producto);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Eso no es un precio valido.");
        } catch (Exception e){
            throw e;
        }
    }
    
    private static void modificarFabricante(Producto producto) throws Exception{
        
        System.out.println("\nProducto seleccionado:");
        System.out.println(producto);
        try {
            Fabricante fabricante = null;
            fabricante=FabricanteServicio.seleccionarFabricante();
            producto.setFabricante(fabricante);
            dao.modificarProductoFabricante(producto);
        } catch (Exception e) {
            throw e;
        }
    }
}