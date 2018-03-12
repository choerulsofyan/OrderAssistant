/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.entity;

import javafx.collections.ObservableList;

/**
 *
 * @author choerul.sofyan
 */
public class barang {
    private String kode_barang, nama_barang;
    private int stok_barang;
    private double harga_barang;
    
    private String jml = String.valueOf(stok_barang);
    private String hrg = String.valueOf(harga_barang);
    
    public String getKodeBarang(){
        return kode_barang;
    }
    
    public void setKodeBarang(String kodeBarang) {
        this.kode_barang = kodeBarang;
    }
    
    public String getNamaBarang() {
        return nama_barang;
    }

    public void setNamaBarang(String namaBarang) {
        this.nama_barang = namaBarang;
    }

    public String getJumlah() {
        return jml;
    }

    public void setJumlah(String jumlah) {
        this.jml = jumlah;
    }

    public String getHarga() {
        return hrg;
    }

    public void setHarga(String harga) {
        this.hrg = harga;
    }
}
