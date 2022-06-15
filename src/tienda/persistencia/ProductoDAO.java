/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteServicio;

/**
 *
 * @author Walter
 */
public final class ProductoDAO extends DAO {
    
    public ProductoDAO(){
    }
    
    public Collection<Producto> listarNombreDeProductos () throws Exception {
        
        try {
            String sql = "SELECT nombre FROM producto";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconetarse();
            return productos;
        } catch (Exception e) {
            desconetarse();
            throw e;
        }
    }
    
    public Collection<Producto> listarNombreYPrecioDeProductos () throws Exception {
        
        try {
            String sql = "SELECT nombre, precio FROM producto";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconetarse();
            return productos;
        } catch (Exception e) {
            desconetarse();
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosEntre120Y202 () throws Exception {
        
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                Integer idFabricante = resultado.getInt(4);
                Fabricante fabricante = FabricanteServicio.buscarFabricantePorId(idFabricante);
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            desconetarse();
            return productos;
        } catch (Exception e) {
            desconetarse();
            throw e;
        }
    }
    
    public Collection<Producto> listarPortatiles () throws Exception {
        
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE 'Portatil%'";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                Integer idFabricante = resultado.getInt(4);
                Fabricante fabricante = FabricanteServicio.buscarFabricantePorId(idFabricante);
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            desconetarse();
            return productos;
        } catch (Exception e) {
            desconetarse();
            throw e;
        }
    }
    
    public Producto listarProductoMasBarato () throws Exception {
        
        try {
            String sql = "SELECT nombre, precio "
                    + "FROM producto "
                    + "WHERE precio = (SELECT MIN(precio) FROM producto)";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            while (resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
            }
            desconetarse();
            return producto;
        } catch (Exception e) {
            desconetarse();
            throw e;
        }
    }
    
    public Collection<Producto> listarProductos() throws Exception {
        
        try {
            String sql = "SELECT * FROM producto";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                Integer idFabricante = resultado.getInt(4);
                Fabricante fabricante = FabricanteServicio.buscarFabricantePorId(idFabricante);
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            desconetarse();
            return productos;
        } catch (Exception e) {
            desconetarse();
            throw e;
        }
    }
    
    public void guardarProducto(Producto producto) throws Exception{
        
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto.");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ('"+producto.getNombre()+"', "+producto.getPrecio()+", "+producto.getFabricante().getCodigo()+");";
        
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconetarse();
        }
    }
    
    public void modificarProductoNombre(Producto producto) throws Exception{
        
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto.");
            }
            String sql = "UPDATE producto SET "
                    + "nombre = '"+producto.getNombre()+"' WHERE codigo="+producto.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconetarse();
        }
    }
    
    public void modificarProductoPrecio(Producto producto) throws Exception{
        
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto.");
            }
            String sql = "UPDATE producto SET "
                    + "precio = '"+producto.getPrecio()+"' WHERE codigo="+producto.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconetarse();
        }
    }
    
    public void modificarProductoFabricante(Producto producto) throws Exception{
        
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto.");
            }
            String sql = "UPDATE producto SET "
                    + "codigo_fabricante = '"+producto.getFabricante().getCodigo()+"' WHERE codigo="+producto.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconetarse();
        }
    }
    
}
