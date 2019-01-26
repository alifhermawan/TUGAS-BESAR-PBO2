/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.controller;

import edu.javu.salemanager.model.PesananModel;
import edu.javu.salemanager.view.SepatuView;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class PesananController {

    public PesananModel model1;

    public void setModel(PesananModel model) {
        this.model1 = model;
    }

    public void resetPesanan(SepatuView view) {
        model1.resetPesanan();

    }

    public void insertPesanan(SepatuView view) {

        String tipePesanan = view.getTxtTipePes().getText();
        String hargaPesanan = view.getTxtHargaPes().getText();
        String ukuranPesanan = view.getTxtUkuranPes().getText();
        String jumlahPesanan = view.getTxtJumlahPes().getText();

        if (tipePesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Kosong");
        } else if (tipePesanan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (hargaPesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Sepatu Tidak Boleh Kosong");
        } else if (hargaPesanan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Harga Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (ukuranPesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Ukuran Sepatu Tidak Boleh Kosong");
        } else if (tipePesanan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Ukuran Sepatu Tidak Boleh Lebih Dari 20 Karakter");
        } else if (jumlahPesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Jumlah Sepatu Tidak Boleh Kosong");
        } else if (jumlahPesanan.length() > 5) {
            JOptionPane.showMessageDialog(view, "Jumlah Sepatu Tidak Boleh Lebih Dari 5 Karakter");
        } else {
            model1.setTipePesanan(tipePesanan);
            model1.setHargaPesanan(hargaPesanan);
            model1.setUkuranPesanan(ukuranPesanan);
            model1.setJumlahPesanan(jumlahPesanan);

            try {
                model1.insertPesanan();
                JOptionPane.showMessageDialog(view, "Sepatu Pesanan Berhasil Ditambahkan");
                model1.resetPesanan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan ", throwable.getMessage()});
            }

        }

    }

    public void updatePesanan(SepatuView view) {

        if (view.getTabelPesanan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Data Yang Akan Diubah");
            return;
        }

        Integer ip = Integer.parseInt(view.getTxtIpPes().getText());

        String tipePesanan = view.getTxtTipePes().getText();
        String hargaPesanan = view.getTxtHargaPes().getText();
        String ukuranPesanan = view.getTxtUkuranPes().getText();
        String jumlahPesanan = view.getTxtJumlahPes().getText();

        if (tipePesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Kosong");
        } else if (tipePesanan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (hargaPesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Sepatu Tidak Boleh Kosong");
        } else if (hargaPesanan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Harga Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (ukuranPesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Ukuran Sepatu Tidak Boleh Kosong");
        } else if (tipePesanan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Ukuran Sepatu Tidak Boleh Lebih Dari 20 Karakter");
        } else if (jumlahPesanan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Jumlah Sepatu Tidak Boleh Kosong");
        } else if (jumlahPesanan.length() > 5) {
            JOptionPane.showMessageDialog(view, "Jumlah Sepatu Tidak Boleh Lebih Dari 5 Karakter");
        } else {
            model1.setIp(ip);
            model1.setTipePesanan(tipePesanan);
            model1.setHargaPesanan(hargaPesanan);
            model1.setUkuranPesanan(ukuranPesanan);
            model1.setJumlahPesanan(jumlahPesanan);

            try {
                model1.updatePesanan();
                JOptionPane.showMessageDialog(view, "Sepatu Pesanan Berhasil Diubah");
                model1.resetPesanan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan ", throwable.getMessage()});
            }

        }

    }

    public void deletePesanan(SepatuView view) {
        if (view.getTabelPesanan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Data Yang Akan Dihapus");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus?")==JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtIpPes().getText());
            model1.setIp(id);
            
            try {
                model1.deletePesanan();
                JOptionPane.showMessageDialog(view, "Sepatu Pesanan Berhasil Dihapus");
                model1.resetPesanan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan ", throwable.getMessage()});
            }
            
        }

    }

}
