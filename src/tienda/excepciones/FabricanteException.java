/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.excepciones;

/**
 *
 * @author Walter
 */
public class FabricanteException extends Exception {

    /**
     * Creates a new instance of <code>FabricanteException</code> without detail
     * message.
     */
    public FabricanteException() {
    }

    /**
     * Constructs an instance of <code>FabricanteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FabricanteException(String msg) {
        super(msg);
    }
}
