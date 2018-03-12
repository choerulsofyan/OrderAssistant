/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.implement;
import penjualan.entity.barang;
import penjualan.interfc.barangInterfc;
import penjualan.koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import penjualan.tablemapper.barangMapper;

/**
 *
 * @author choerul.sofyan
 */
public class barangImplement implements barangInterfc {
    public barang insert(barang o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("INSERT INTO BARANG VALUES (?,?,?,?)");
        st.setString(1, o.getKodeBarang());
        st.setString(2, o.getNamaBarang());
        st.setString(3, o.getHarga());
        st.setString(4, o.getJumlah());
        st.executeUpdate();
        return o;
    }
    
    public void update(barang o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("UPDATE BARANG SET nama_barang = ?, stok_barang = ?, harga = ? WHERE kode_barang = ?");
        st.setString(1, o.getNamaBarang());
        st.setString(2, o.getJumlah());
        st.setString(3, o.getHarga());
        st.setString(4, o.getKodeBarang());
        st.executeUpdate();
    }
    
    public void delete(String kode_barang) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("DELETE FROM BARANG WHERE kode_barang = ?");
        st.setString(1, kode_barang);
        st.executeUpdate();
    }
    
    public List<barang> getAll() throws SQLException {
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang");
        List<barang>list = new ArrayList<barang>();
        
        while(rs.next()){
            barang brg = new barang();
            brg.setKodeBarang(rs.getString("kode_barang"));
            brg.setNamaBarang(rs.getString("nama_barang"));
            brg.setJumlah(rs.getString("stok_barang"));
            brg.setHarga(rs.getString("harga"));
            list.add(brg);
        }
        return list;
    }
    
    public ObservableList<barang> listBarang() throws SQLException {
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang");
        ObservableList<barang> dataBarang = FXCollections.observableArrayList();
        
        while(rs.next()){
            barang brg = new barang();
            brg.setKodeBarang(rs.getString("kode_barang"));
            brg.setNamaBarang(rs.getString("nama_barang"));
            brg.setJumlah(rs.getString("stok_barang"));
            brg.setHarga(rs.getString("harga"));
            dataBarang.add(brg);
        }
        return dataBarang;
    }
    
    public ObservableList<barangMapper> getData() throws SQLException{
        ObservableList<barangMapper> data = FXCollections.observableArrayList();
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang");
        
        while(rs.next()){
            data.add(new barangMapper(
                    rs.getString("kode_barang"), 
                    rs.getString("nama_barang"), 
                    rs.getString("stok_barang"), 
                    rs.getString("harga")
            ));
        }
        
        return data;
    }
    
    /*public ObservableList<barangMapper> getWhere(String kodeBarang) throws SQLException{
        ObservableList<barangMapper> data = FXCollections.observableArrayList();
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang WHERE kode_barang = '" + kodeBarang + "'");
        
        while(rs.next()){
            data.add(new barangMapper(
                    rs.getString("kode_barang"), 
                    rs.getString("nama_barang"), 
                    rs.getString("stok_barang"), 
                    rs.getString("harga")
            ));
        }
        
        return data;
    }*/
    
    public Object[] getWhere(String kodeBarang) throws SQLException{
        Object data[] = new Object[4];
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang WHERE kode_barang = '" + kodeBarang + "'");
        
        while(rs.next()){
            data[0] = rs.getString("kode_barang");
            data[1] = rs.getString("nama_barang");
            data[2] = rs.getString("stok_barang");
            data[3] = rs.getString("harga");
        }
        
        return data;
    }
}
