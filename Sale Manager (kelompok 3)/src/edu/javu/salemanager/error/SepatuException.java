/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.error;

/**
 *
 * @author user
 */
public class SepatuException extends Exception {

    /**
     * Creates a new instance of <code>SepatuException</code> without detail
     * message.
     */
    public SepatuException() {
    }

    /**
     * Constructs an instance of <code>SepatuException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SepatuException(String msg) {
        super(msg);
    }
}
