/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.model;

import edu.javu.salemanager.database.SaleManagerDatabase;
import edu.javu.salemanager.entity.Pesanan;
import edu.javu.salemanager.error.PesananException;
import edu.javu.salemanager.event.PesananListener;
import edu.javu.salemanager.service.PesananDao;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class PesananModel {

    private int ip;
    private String tipePesanan;
    private String hargaPesanan;
    private String ukuranPesanan;
    private String jumlahPesanan;

    private PesananListener listener;

    public PesananListener getListener() {
        return listener;
    }

    public void setListener(PesananListener listener) {
        this.listener = listener;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
        fireOnChange();
    }

    public String getTipePesanan() {
        return tipePesanan;
    }

    public void setTipePesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
        fireOnChange();
    }

    public String getHargaPesanan() {
        return hargaPesanan;
    }

    public void setHargaPesanan(String hargaPesanan) {
        this.hargaPesanan = hargaPesanan;
        fireOnChange();
    }

    public String getUkuranPesanan() {
        return ukuranPesanan;
    }

    public void setUkuranPesanan(String ukuranPesanan) {
        this.ukuranPesanan = ukuranPesanan;
        fireOnChange();
    }

    public String getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(String jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Pesanan pesanan) {
        if (listener != null) {
            listener.onInsert(pesanan);
        }

    }

    protected void fireOnUpdate(Pesanan pesanan) {
        if (listener != null) {
            listener.onUpdate(pesanan);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDeleteP();
        }

    }

    public void insertPesanan() throws SQLException, PesananException {

        PesananDao dao = SaleManagerDatabase.getPesananDao();
        Pesanan pesanan = new Pesanan();

        pesanan.setTipePesanan(tipePesanan);
        pesanan.setHargaPesanan(hargaPesanan);
        pesanan.setUkuranPesanan(ukuranPesanan);
        pesanan.setJumlahPesanan(jumlahPesanan);

        dao.insertPesanan(pesanan);
        fireOnInsert(pesanan);

    }

    public void updatePesanan() throws SQLException, PesananException {

        PesananDao dao = SaleManagerDatabase.getPesananDao();
        Pesanan pesanan = new Pesanan();

        pesanan.setTipePesanan(tipePesanan);
        pesanan.setHargaPesanan(hargaPesanan);
        pesanan.setUkuranPesanan(ukuranPesanan);
        pesanan.setJumlahPesanan(jumlahPesanan);
        pesanan.setIp(ip);

        dao.updatePesanan(pesanan);
        fireOnUpdate(pesanan);

    }

    public void deletePesanan() throws SQLException, PesananException {

        PesananDao dao = SaleManagerDatabase.getPesananDao();
        
        dao.deletePesanan(ip);
        fireOnDelete();

    }
    public void resetPesanan(){
        setIp(0);
        setTipePesanan("");
        setHargaPesanan("");
        setUkuranPesanan("");
        setJumlahPesanan("");
    }
}
