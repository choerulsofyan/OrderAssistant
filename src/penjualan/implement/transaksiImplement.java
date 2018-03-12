/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.implement;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import penjualan.koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import penjualan.entity.transaksi;
import penjualan.interfc.transaksiInterface;
import penjualan.tablemapper.barangMapper;
import penjualan.tablemapper.transaksiMapper;

/**
 *
 * @author choerul.sofyan
 */
public class transaksiImplement implements transaksiInterface{
    
    public transaksi insert(transaksi o) throws SQLException { 
        PreparedStatement st = koneksi.getConnection().prepareStatement("INSERT INTO penjualan VALUES (?,?)");
        st.setString(1, o.getNoFaktur());
        st.setString(2, o.getTanggal());
        
        System.out.println("nofaktur " + o.getNoFaktur());
        System.out.println("tanggal " + o.getTanggal());
        
        st.executeUpdate();
        return o;
    }
    
    public transaksi insertItem(transaksi o) throws SQLException {
        koneksi.getConnection().setAutoCommit(false);
        PreparedStatement st = koneksi.getConnection().prepareStatement("INSERT INTO detailjual VALUES (?,?,?)");
        
        int totalRows = o.getItemData().length;
        
        for(int i = 0; i < totalRows; i++)
        {
            st.setString(1, o.getNoFaktur());
            st.setString(2, (String) o.getItemData()[i][0]);
            st.setInt(3, (int) o.getItemData()[i][1]);
            st.addBatch();
        }
        st.executeBatch();
        koneksi.getConnection().commit();
        
        System.out.println("total affected : " + String.valueOf(totalRows));
        return o;
    }
    
    public int urutanDb() {
        Connection con = (Connection) koneksi.getConnection();
        int jml= 0;
        try {
            String sql = "SELECT COUNT(*) AS urutan FROM penjualan";
            Statement rs = (Statement) con.createStatement();
            ResultSet count = rs.executeQuery(sql);
            while (count.next()) {
                jml = count.getInt("urutan");
            }
            rs.close();
            count.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ++jml;
    }
    
    public ObservableList<String> viewKdBrg() throws SQLException{
        ObservableList<String> data = FXCollections.observableArrayList();
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT kode_barang, nama_barang FROM barang");
        
        String item;
        while(rs.next()){
            item = rs.getString("kode_barang") + " - " + rs.getString("nama_barang");
            data.add(item);
        }
        item = "";
        
        return data;
    }
    
    public ObservableList<String> viewIdPlg() throws SQLException {
        ObservableList<String> data = FXCollections.observableArrayList();
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT id_pelanggan, nama FROM pelanggan");
        
        String item;
        while(rs.next()){
            item = rs.getString("id_pelanggan") + " - " + rs.getString("nama");
            data.add(item);
        }
        item = "";
        
        return data;
    }
}
