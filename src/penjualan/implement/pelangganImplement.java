/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.implement;
import penjualan.entity.pelanggan;
import penjualan.koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import penjualan.interfc.pelangganInterfc;
import penjualan.tablemapper.pelangganMapper;

/**
 *
 * @author choerul.sofyan
 */
public class pelangganImplement implements pelangganInterfc {
    public pelanggan insert(pelanggan o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("INSERT INTO pelanggan VALUES (?,?,?,?,?)");
        st.setString(1, o.getIdPelanggan());
        st.setString(2, o.getNama());
        st.setString(3, o.getJenisKelamin());
        st.setString(4, o.getAlamat());
        st.setString(5, o.getNoTelepon());
        st.executeUpdate();
        return o;
    }
    
    public void update(pelanggan o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("UPDATE pelanggan SET nama = ?, jk= ?, alamat= ?, notlp= ? WHERE id_pelanggan = ?");
        st.setString(1, o.getNama());
        st.setString(2, o.getJenisKelamin());
        st.setString(3, o.getAlamat());
        st.setString(4, o.getNoTelepon());
        st.setString(5, o.getIdPelanggan());
        st.executeUpdate();
    }
    
    public void delete(String id_pelanggan) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("DELETE FROM pelanggan WHERE id_pelanggan = ?");
        st.setString(1, id_pelanggan);
        st.executeUpdate();
    }
    
    public List<pelanggan> getAll() throws SQLException {
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pelanggan");
        List<pelanggan>list = new ArrayList<pelanggan>();
        
        while(rs.next()){
            pelanggan plg = new pelanggan();
            plg.setIdPelanggan(rs.getString("id_pelanggan"));
            plg.setNama(rs.getString("nama"));
            plg.setJenisKelamin(rs.getString("jk"));
            plg.setAlamat(rs.getString("alamat"));
            plg.setNoTelepon(rs.getString("notlp"));
            list.add(plg);
        }
        return list;
    }
    
    public ObservableList<pelangganMapper> getData() throws SQLException{
        ObservableList<pelangganMapper> data = FXCollections.observableArrayList();
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pelanggan");
        
        while(rs.next()){
            data.add(new pelangganMapper(
                    rs.getString("id_pelanggan"), 
                    rs.getString("nama"), 
                    rs.getString("jk"), 
                    rs.getString("alamat"),
                    rs.getString("notlp")
            ));
        }
        
        return data;
    }
    
    public Object[] getWhere(String idPelanggan) throws SQLException{
        Object data[] = new Object[5];
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pelanggan WHERE id_pelanggan = '" + idPelanggan + "'");
        
        while(rs.next()){
            data[0] = rs.getString("id_pelanggan");
            data[1] = rs.getString("nama");
            data[2] = rs.getString("jk");
            data[3] = rs.getString("alamat");
            data[4] = rs.getString("notlp");
        }
        
        return data;
    }
}
