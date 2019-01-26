/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.event;

import edu.javu.salemanager.entity.Pesanan;
import edu.javu.salemanager.model.PesananModel;

/**
 *
 * @author user
 */
public interface PesananListener {
    
    public void onChange(PesananModel model);
    public void onInsert(Pesanan pesanan);
    public void onDeleteP();
    public void onUpdate(Pesanan pesanan);
    
}
