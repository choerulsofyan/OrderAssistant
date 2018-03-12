/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.tablemapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author TheFighter
 */
public class pelangganMapper {
    private final SimpleStringProperty idPelanggan;
    private final SimpleStringProperty nama;
    private final SimpleStringProperty jenisKelamin;
    private final SimpleStringProperty alamat;
    private final SimpleStringProperty noTelepon;

    public pelangganMapper(
            String idPelanggan, 
            String nama, 
            String jenisKelamin, 
            String alamat,
            String noTelepon
    ) {
        this.idPelanggan = new SimpleStringProperty(idPelanggan);
        this.nama = new SimpleStringProperty(nama);
        this.jenisKelamin = new SimpleStringProperty(jenisKelamin);
        this.alamat = new SimpleStringProperty(alamat);
        this.noTelepon = new SimpleStringProperty(noTelepon);
    }
    
    public String getIdPelanggan() {
        return idPelanggan.get();
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan.set(idPelanggan);
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getJenisKelamin() {
        return jenisKelamin.get();
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin.set(jenisKelamin);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }
    
    public String getNoTelepon() {
        return noTelepon.get();
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon.set(noTelepon);
    }
}
