/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.model;

import edu.javu.salemanager.database.SaleManagerDatabase;
import edu.javu.salemanager.entity.Sepatu;
import edu.javu.salemanager.error.SepatuException;
import edu.javu.salemanager.event.SepatuListener;
import edu.javu.salemanager.service.SepatuDao;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class SepatuModel {

    private int id;
    private String tipeSepatu;
    private String hargaSepatu;
    private String stokSepatu;
    private String ukuranSepatu;

    private SepatuListener listener;

    public SepatuListener getListener() {
        return listener;
    }

    public void setListener(SepatuListener listener) {
        this.listener = listener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getTipeSepatu() {
        return tipeSepatu;

    }

    public void setTipeSepatu(String tipeSepatu) {
        this.tipeSepatu = tipeSepatu;
        fireOnChange();
    }

    public String getHargaSepatu() {
        return hargaSepatu;
    }

    public void setHargaSepatu(String hargaSepatu) {
        this.hargaSepatu = hargaSepatu;
        fireOnChange();
    }

    public String getStokSepatu() {
        return stokSepatu;
    }

    public void setStokSepatu(String stokSepatu) {
        this.stokSepatu = stokSepatu;
        fireOnChange();
    }

    public String getUkuranSepatu() {
        return ukuranSepatu;
    }

    public void setUkuranSepatu(String ukuranSepatu) {
        this.ukuranSepatu = ukuranSepatu;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Sepatu sepatu) {
        if (listener != null) {
            listener.onInsert(sepatu);
        }
    }

    protected void fireOnUpdate(Sepatu sepatu) {
        if (listener != null) {
            listener.onUpdate(sepatu);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertSepatu() throws SQLException, SepatuException {

        SepatuDao dao = SaleManagerDatabase.getSepatuDao();
        Sepatu sepatu = new Sepatu();
        sepatu.setTipeSepatu(tipeSepatu);
        sepatu.setHargaSepatu(hargaSepatu);
        sepatu.setStokSepatu(stokSepatu);
        sepatu.setUkuranSepatu(ukuranSepatu);

        dao.insertSepatu(sepatu);
        fireOnInsert(sepatu);
    }

    public void updateSepatu() throws SQLException, SepatuException {

        SepatuDao dao = SaleManagerDatabase.getSepatuDao();
        Sepatu sepatu = new Sepatu();
        sepatu.setTipeSepatu(tipeSepatu);
        sepatu.setHargaSepatu(hargaSepatu);
        sepatu.setStokSepatu(stokSepatu);
        sepatu.setUkuranSepatu(ukuranSepatu);
        sepatu.setId(id);

        dao.updateSepatu(sepatu);
        fireOnUpdate(sepatu);
    }

    public void deleteSepatu() throws SQLException, SepatuException {

        SepatuDao dao = SaleManagerDatabase.getSepatuDao();
        dao.deleteSepatu(id);
        fireOnDelete();
    }
    
    public void resetSepatu(){
        setId(0);
        setTipeSepatu("");
        setHargaSepatu("");
        setStokSepatu("");
        setUkuranSepatu("");
    }
}
