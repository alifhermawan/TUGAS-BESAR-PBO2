/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.entity;
 
import java.util.Objects;

/**
 *
 * @author user
 */
public class Sepatu {
 
    private Integer id;
    private String tipeSepatu;
    private String hargaSepatu;
    private String stokSepatu;
    private String ukuranSepatu;
    
    public Sepatu(){
        
    }

    public Sepatu(String tipeSepatu, String hargaSepatu, String stokSepatu, String ukuranSepatu) {
        this.tipeSepatu = tipeSepatu;
        this.hargaSepatu = hargaSepatu;
        this.stokSepatu = stokSepatu;
        this.ukuranSepatu = ukuranSepatu;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipeSepatu() {
        return tipeSepatu;
    }

    public void setTipeSepatu(String tipeSepatu) {
        this.tipeSepatu = tipeSepatu;
    }

    public String getHargaSepatu() {
        return hargaSepatu;
    }

    public void setHargaSepatu(String hargaSepatu) {
        this.hargaSepatu = hargaSepatu;
    }

    public String getStokSepatu() {
        return stokSepatu;
    }

    public void setStokSepatu(String stokSepatu) {
        this.stokSepatu = stokSepatu;
    }

    public String getUkuranSepatu() {
        return ukuranSepatu;
    }

    public void setUkuranSepatu(String ukuranSepatu) {
        this.ukuranSepatu = ukuranSepatu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.tipeSepatu);
        hash = 59 * hash + Objects.hashCode(this.hargaSepatu);
        hash = 59 * hash + Objects.hashCode(this.stokSepatu);
        hash = 59 * hash + Objects.hashCode(this.ukuranSepatu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sepatu other = (Sepatu) obj;
        if (!Objects.equals(this.tipeSepatu, other.tipeSepatu)) {
            return false;
        }
        if (!Objects.equals(this.hargaSepatu, other.hargaSepatu)) {
            return false;
        }
        if (!Objects.equals(this.stokSepatu, other.stokSepatu)) {
            return false;
        }
        if (!Objects.equals(this.ukuranSepatu, other.ukuranSepatu)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
