/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.tablemapper;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author TheFighter
 */
public class barangMapper {
    private final SimpleStringProperty kodeBarang;
    private final SimpleStringProperty namaBarang;
    private final SimpleStringProperty stokBarang;
    private final SimpleStringProperty hargaBarang;

    public barangMapper(
            String kodeBarang, 
            String namaBarang, 
            String stokBarang, 
            String hargaBarang
    ) {
        this.kodeBarang = new SimpleStringProperty(kodeBarang);
        this.namaBarang = new SimpleStringProperty(namaBarang);
        this.stokBarang = new SimpleStringProperty(stokBarang);
        this.hargaBarang = new SimpleStringProperty(hargaBarang);
    }
    
    public String getKodeBarang() {
        return kodeBarang.get();
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang.set(kodeBarang);
    }

    public String getNamaBarang() {
        return namaBarang.get();
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang.set(namaBarang);
    }

    public String getStokBarang() {
        return stokBarang.get();
    }

    public void setStokBarang(String stokBarang) {
        this.stokBarang.set(stokBarang);
    }

    public String getHargaBarang() {
        return hargaBarang.get();
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang.set(hargaBarang);
    }
}
