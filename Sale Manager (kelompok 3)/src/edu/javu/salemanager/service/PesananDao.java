/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.service;

import edu.javu.salemanager.entity.Pesanan;
import edu.javu.salemanager.error.PesananException;
import java.util.List;

/**
 *
 * @author user
 */
public interface PesananDao {
    
    public void insertPesanan(Pesanan pesanan) throws PesananException;
    
    public void updatePesanan(Pesanan pesanan) throws PesananException;
    
    public void deletePesanan(Integer ip) throws PesananException;
    
    public Pesanan getPesanan(Integer ip) throws PesananException;
    
    public List<Pesanan> selectAllPesanan() throws PesananException;
    
}
