/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.controller;

import edu.javu.salemanager.model.SepatuModel;
import edu.javu.salemanager.view.SepatuView;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SepatuController {

    private SepatuModel model;

    public void setModel(SepatuModel model) {
        this.model = model;
    }

    public void resetSepatu(SepatuView view) {
        model.resetSepatu();
    }

    public void insertSepatu(SepatuView view) {

        String tipeSepatu = view.getTxtTipe().getText();
        String hargaSepatu = view.getTxtHarga().getText();
        String stokSepatu = view.getTxtStok().getText();
        String ukuranSepatu = view.getTxtUkuran().getText();

        if (tipeSepatu.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Kosong");
        } else if (tipeSepatu.length() > 25) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (hargaSepatu.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Sepatu Tidak Boleh Kosong");
        } else if (hargaSepatu.length() > 25) {
            JOptionPane.showMessageDialog(view, "Harga Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (stokSepatu.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Stok Sepatu Tidak Boleh Kosong");
        } else if (stokSepatu.length() > 25) {
            JOptionPane.showMessageDialog(view, "Stok Sepatu Tidak Boleh Lebih Dari 5 Karakter");
        } else if (ukuranSepatu.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Ukuran Sepatu Tidak Boleh Kosong");
        } else if (ukuranSepatu.length() > 25) {
            JOptionPane.showMessageDialog(view, "Ukuran Sepatu Tidak Boleh Lebih Dari 20 Karakter");
        } else {

            model.setTipeSepatu(tipeSepatu);
            model.setHargaSepatu(hargaSepatu);
            model.setStokSepatu(stokSepatu);
            model.setUkuranSepatu(ukuranSepatu);

            try {
                model.insertSepatu();
                JOptionPane.showMessageDialog(view, "Sepatu Berhasil Ditambahkan");
                model.resetSepatu();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan ", throwable.getMessage()});
            }
        }

    }

    public void updateSepatu(SepatuView view) {

        if (view.getTabelEdit().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang Akan Di Ubah");
            return;
        }

        Integer id1 = Integer.parseInt(view.getTxtId1().getText());

        String tipeSepatu1 = view.getTxtTipe1().getText();
        String hargaSepatu1 = view.getTxtHarga1().getText();
        String stokSepatu1 = view.getTxtStok1().getText();
        String ukuranSepatu1 = view.getTxtUkuran1().getText();

        if (tipeSepatu1.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Kosong");
        } else if (tipeSepatu1.length() > 25) {
            JOptionPane.showMessageDialog(view, "Tipe Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (hargaSepatu1.length() > 25) {
            JOptionPane.showMessageDialog(view, "Harga Sepatu Tidak Boleh Lebih Dari 25 Karakter");
        } else if (stokSepatu1.length() > 25) {
            JOptionPane.showMessageDialog(view, "Stok Sepatu Tidak Boleh Lebih Dari 5 Karakter");
        } else if (ukuranSepatu1.length() > 25) {
            JOptionPane.showMessageDialog(view, "Ukuran Sepatu Tidak Boleh Lebih Dari 20 Karakter");
        } else {
            model.setId(id1);
            model.setTipeSepatu(tipeSepatu1);
            model.setHargaSepatu(hargaSepatu1);
            model.setStokSepatu(stokSepatu1);
            model.setUkuranSepatu(ukuranSepatu1);

            try {
                model.updateSepatu();
                JOptionPane.showMessageDialog(view, "Sepatu Berhasil Di Ubah");
                model.resetSepatu();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan ", throwable.getMessage()});
            }
        }

    }

    public void deleteSepatu(SepatuView view) {
        if (view.getTabelEdit().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang Akan Di Hapus");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);

            try {
                model.deleteSepatu();
                JOptionPane.showMessageDialog(view, "Sepatu Berhasil Di Hapus");
                model.resetSepatu();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
}
