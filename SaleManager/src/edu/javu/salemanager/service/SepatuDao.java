/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.service;

import edu.javu.salemanager.entity.Sepatu;
import edu.javu.salemanager.error.SepatuException;
import java.util.List;

/**
 *
 * @author user
 */
public interface SepatuDao {
    
    public void insertSepatu(Sepatu sepatu) throws SepatuException;
     public void updateSepatu(Sepatu sepatu) throws SepatuException;
      public void deleteSepatu(Integer id) throws SepatuException;
       public Sepatu getSepatu(Integer id) throws SepatuException;
        public List<Sepatu> selectAllSepatu()  throws SepatuException;
    
}
