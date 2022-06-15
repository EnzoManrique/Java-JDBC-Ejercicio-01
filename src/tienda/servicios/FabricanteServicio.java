/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.excepciones.FabricanteException;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Walter
 */
public class FabricanteServicio {

    private static FabricanteDAO dao = new FabricanteDAO();
    
    public static Fabricante buscarFabricantePorId(Integer id) throws Exception{
        
        try {
            if (id == null) {
                throw new Exception("Debe indicar el id");
            }
            
            Fabricante fabricante = dao.buscarFabricantePorId(id);
            return fabricante;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void ingresarFabricante() throws Exception {
        
        try {
            System.out.print("\nIngrese el nombre del fabricante: ");
            String nombre = TiendaServicio.leer.next();
        
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public static Fabricante seleccionarFabricante() throws Exception{
        Fabricante fabricante = null;
        Collection<Fabricante> fabricantes = listarFabricantes();
        
        try {
            System.out.println("\nElija un código de fabricante:");
            mostrarFabricantes();
            System.out.print("Código: ");
            String aux = TiendaServicio.leer.next();
            int respuesta = Integer.parseInt(aux);
            
            if(respuesta>fabricantes.size() | respuesta<0){
                throw new FabricanteException("Ese código de fabricante no existe.");
            }
            
            for (Fabricante fa : fabricantes) {
                if(fa.getCodigo()== respuesta){
                    fabricante = fa;
                }
            }
            return fabricante;
        } catch (NumberFormatException e){
            System.out.println("Ingreso no valido, intenta de vuelta.");
            return fabricante=seleccionarFabricante();
        } catch (FabricanteException e){
            e.getMessage();
            return fabricante=seleccionarFabricante();
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Collection<Fabricante> listarFabricantes() throws Exception {
        
        try {
            Collection<Fabricante> fabricantes = dao.listarFabricantes();
            return fabricantes;        
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void mostrarFabricantes() throws Exception{
        
        try {
            Collection<Fabricante> fabricantes = listarFabricantes();
            
            if (fabricantes == null) {
                throw new Exception("No existen fabricantes para imprimir.");
            }else {
                System.out.println("");
                for (Fabricante fabricante : fabricantes) {
                    System.out.println(fabricante);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
