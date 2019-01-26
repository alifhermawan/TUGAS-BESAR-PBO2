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
public class PesananException extends Exception {

    /**
     * Creates a new instance of <code>PesananException</code> without detail
     * message.
     */
    public PesananException() {
    }

    /**
     * Constructs an instance of <code>PesananException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PesananException(String msg) {
        super(msg);
    }
}
