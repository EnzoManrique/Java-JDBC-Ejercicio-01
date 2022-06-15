/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

/**
 *
 * @author Walter
 */
public final class FabricanteDAO extends DAO {
    
    public Fabricante buscarFabricantePorId (Integer id) throws Exception {
        
        try {
            String sql = "SELECT * FROM fabricante WHERE codigo = '"+id+"'";
            
            consultarBase(sql);
            
            Fabricante fabricante = null;
            
            while (resultado.next()) {                
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconetarse();
            return fabricante;
        } catch (Exception e) {
            desconetarse();
            throw e;
        }
    }
    
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante.");
            }
            String sql = "INSERT INTO fabricante (nombre)"
                    + "VALUES ('"+fabricante.getNombre()+"');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconetarse();
        }
    }
    
    public Collection<Fabricante> listarFabricantes() throws Exception{
        try {
            String sql = "SELECT * FROM fabricante";
            consultarBase(sql);
            
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            
            while (resultado.next()) {    
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconetarse();
            return fabricantes;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
