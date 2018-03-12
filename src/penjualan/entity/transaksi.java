/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.entity;

/**
 *
 * @author choerul.sofyan
 */
public class transaksi {
    private String tanggal, noFaktur;
    private Object itemData[][];

    public Object[][] getItemData() {
        return itemData;
    }

    public void setItemData(Object[][] itemData) {
        this.itemData = itemData;
    }
    
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNoFaktur() {
        return noFaktur;
    }

    public void setNoFaktur(String noFaktur) {
        this.noFaktur = noFaktur;
    }
    
}
