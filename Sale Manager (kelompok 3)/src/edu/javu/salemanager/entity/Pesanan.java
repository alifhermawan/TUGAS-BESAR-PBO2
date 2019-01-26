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
public class Pesanan {

    private Integer ip;
    private String tipePesanan;
    private String hargaPesanan;
    private String ukuranPesanan;
    private String jumlahPesanan;

    public Pesanan(){
    
    }

    public Pesanan(String tipePesanan, String hargaPesanan, String ukuranPesanan, String jumlahPesanan) {
        this.tipePesanan = tipePesanan;
        this.hargaPesanan = hargaPesanan;
        this.ukuranPesanan = ukuranPesanan;
        this.jumlahPesanan = jumlahPesanan;
    }
    
    
    public Integer getIp() {
        return ip;
    }

    public void setIp(Integer ip) {
        this.ip = ip;
    }

    public String getTipePesanan() {
        return tipePesanan;
    }

    public void setTipePesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
    }

    public String getHargaPesanan() {
        return hargaPesanan;
    }

    public void setHargaPesanan(String hargaPesanan) {
        this.hargaPesanan = hargaPesanan;
    }

    public String getUkuranPesanan() {
        return ukuranPesanan;
    }

    public void setUkuranPesanan(String ukuranPesanan) {
        this.ukuranPesanan = ukuranPesanan;
    }

    public String getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(String jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.ip);
        hash = 23 * hash + Objects.hashCode(this.tipePesanan);
        hash = 23 * hash + Objects.hashCode(this.hargaPesanan);
        hash = 23 * hash + Objects.hashCode(this.ukuranPesanan);
        hash = 23 * hash + Objects.hashCode(this.jumlahPesanan);
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
        final Pesanan other = (Pesanan) obj;
        if (!Objects.equals(this.tipePesanan, other.tipePesanan)) {
            return false;
        }
        if (!Objects.equals(this.hargaPesanan, other.hargaPesanan)) {
            return false;
        }
        if (!Objects.equals(this.ukuranPesanan, other.ukuranPesanan)) {
            return false;
        }
        if (!Objects.equals(this.jumlahPesanan, other.jumlahPesanan)) {
            return false;
        }
        if (!Objects.equals(this.ip, other.ip)) {
            return false;
        }
        return true;
    }
    

}
