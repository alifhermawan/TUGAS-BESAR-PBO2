/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.model;

import edu.javu.salemanager.entity.Pesanan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TabelPesananModel extends AbstractTableModel {

    private List<Pesanan> list = new ArrayList<Pesanan>();

    public void setList(List<Pesanan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {

        return list.size();
    }

    @Override
    public int getColumnCount() {

        return 5;
    }

    public boolean add(Pesanan e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Pesanan get(int index) {
        return list.get(index);
    }

    public Pesanan set(int index, Pesanan element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }

    }

    public Pesanan remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "TIPE SEPATU";
            case 2:
                return "HARGA SEPATU";
            case 3:
                return "UKURAN SEPATU";
            case 4:
                return "JUMLAH PESANAN";
            default:
                return null;
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIp();
            case 1:
                return list.get(rowIndex).getTipePesanan();
            case 2:
                return list.get(rowIndex).getHargaPesanan();
            case 3:
                return list.get(rowIndex).getUkuranPesanan();
            case 4:
                return list.get(rowIndex).getJumlahPesanan();
            default:
                return null;

        }
    }

}
