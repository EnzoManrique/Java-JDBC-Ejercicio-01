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
public class ProductoException extends Exception {

    /**
     * Creates a new instance of <code>ProductoException</code> without detail
     * message.
     */
    public ProductoException() {
    }

    /**
     * Constructs an instance of <code>ProductoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProductoException(String msg) {
        super(msg);
    }
}
