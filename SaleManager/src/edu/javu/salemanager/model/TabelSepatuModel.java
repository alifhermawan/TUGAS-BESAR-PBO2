/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.model;

import edu.javu.salemanager.entity.Sepatu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TabelSepatuModel extends AbstractTableModel {

    private List<Sepatu> list = new ArrayList<>();

    public void setList(List<Sepatu> list) {
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

    public boolean add(Sepatu e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Sepatu get(int index) {
        return list.get(index);
    }

    public Sepatu set(int index, Sepatu element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }

    }

    public Sepatu remove(int index) {
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
                return "TIPESEPATU";
            case 2:
                return "HARGA SEPATU";
            case 3:
                return "STOKSEPATU";
            case 4:
                return "UKURANSEPATU";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getTipeSepatu();
            case 2:
                return list.get(rowIndex).getHargaSepatu();
            case 3:
                return list.get(rowIndex).getStokSepatu();
            case 4:
                return list.get(rowIndex).getUkuranSepatu();
            default:
                return null;
        }
    }

}
