package penjualan.tablemapper;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class transaksiMapper extends RecursiveTreeObject<transaksiMapper>  
{
//    private SimpleStringProperty tanggalTransaksi;
    private SimpleStringProperty noFaktur;
    private final SimpleStringProperty kodeBarang;
    private final SimpleStringProperty namaBarang;
    private final SimpleIntegerProperty harga;
    private final SimpleIntegerProperty jumlah;
    private final SimpleLongProperty subtotal;

    public transaksiMapper(String kodeBarang, String namaBarang, int harga, int jumlah, long subtotal) 
    {
        this.kodeBarang = new SimpleStringProperty(kodeBarang);
        this.namaBarang = new SimpleStringProperty(namaBarang);
        this.harga = new SimpleIntegerProperty(harga);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.subtotal = new SimpleLongProperty(subtotal);
    }
    
//    public String getTanggalTransaksi() {
//        return tanggalTransaksi.get();
//    }
    
    public String getNoFaktur() {
        return noFaktur.get();
    }

    public String getKodeBarang() {
        return kodeBarang.get();
    }

    public String getNamaBarang() {
        return namaBarang.get();
    }

    public int getHarga() {
        return harga.get();
    }

    public int getJumlah() {
        return jumlah.get();
    }

    public long getSubtotal() {
        return subtotal.get();
    }
    
//    public void setTanggalTransaksi(String tanggalTransaksi) {
//        this.tanggalTransaksi.set(tanggalTransaksi);
//    }
    
    public void setNoFaktur(String noFaktur) {
        this.noFaktur.set(noFaktur);
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang.set(kodeBarang);
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang.set(namaBarang);
    }

    public void setHarga(int harga) {
        this.harga.set(harga);
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }

    public void setSubtotal(long subtotal) {
        this.subtotal.set(subtotal);
    }
}
