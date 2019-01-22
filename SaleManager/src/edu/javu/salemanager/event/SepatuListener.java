/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.event;

import edu.javu.salemanager.entity.Sepatu;
import edu.javu.salemanager.model.SepatuModel;

/**
 *
 * @author user
 */
public interface SepatuListener {
    
    public void onChange(SepatuModel model);
    
    public void onInsert(Sepatu sepatu);
    
    public void onDelete();
    
    public void onUpdate(Sepatu sepatu);



    
}
