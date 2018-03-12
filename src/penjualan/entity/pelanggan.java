package penjualan.entity;

/**
 *
 * @author choerul.sofyan
 */
public class pelanggan {
    private int id_pelanggan;
    private String nama, jenisKelamin, alamat, noTelepon;
    String idPelangganStr = String.valueOf(id_pelanggan);
    
    public String getIdPelanggan() {
        return idPelangganStr;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelangganStr = idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
