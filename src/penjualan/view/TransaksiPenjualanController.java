package penjualan.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import penjualan.entity.transaksi;
import penjualan.helper.AlertMaker;
import penjualan.implement.barangImplement;
import penjualan.implement.pelangganImplement;
import penjualan.implement.transaksiImplement;
import penjualan.interfc.transaksiInterface;
import penjualan.tablemapper.transaksiMapper;

public class TransaksiPenjualanController implements Initializable {

    private StackPane rootPane;

    private AnchorPane childPane;

    @FXML
    private JFXComboBox<String> cmbNamaPelanggan;

    @FXML
    private JFXTextArea txtAlamat;

    @FXML
    private JFXTextField txtNoTelpon;

    @FXML
    private JFXTextField txtNoFaktur;

    @FXML
    private JFXTextField txtTanggalTransaksi;

    @FXML
    private JFXButton btnTambahDataTransaksi;

    @FXML
    private JFXComboBox<String> cmbNamaBarang;

    @FXML
    private JFXTextField txtStokBarang;

    @FXML
    private JFXTextField txtHarga;

    @FXML
    private JFXTextField txtJumlahPembelian;

    @FXML
    private JFXButton btnSimpanKeKeranjang;

    @FXML
    private JFXButton btnHapus;

    @FXML
    private TableView<transaksiMapper> tblItem;

    @FXML
    private JFXTextField txtTotalPembayaran;

    @FXML
    private JFXButton btnSimpanTransaksi;
    
    @FXML
    private TableColumn<transaksiMapper, String> colKodeBarang;
    
    @FXML
    private TableColumn<transaksiMapper, String> colNamaBarang;
    
    @FXML
    private TableColumn<transaksiMapper, Integer> colHarga;
    
    @FXML
    private TableColumn<transaksiMapper, Integer> colJumlah;
    
    @FXML
    private TableColumn<transaksiMapper, Integer> colSubtotal;
    
    transaksiInterface trsServis;
    ObservableList<transaksiMapper> tableItems;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableItems = FXCollections.observableArrayList();
        
        try {
            setKodeBarang();
            setIdPelanggan();
            DateNow();
            genFak();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnTambahDataTransaksiHandler(ActionEvent event) {
        try {
            trsServis = new transaksiImplement();
            transaksi trs = new transaksi();
            trs.setNoFaktur(txtNoFaktur.getText());
            trs.setTanggal(txtTanggalTransaksi.getText());
            trsServis.insert(trs);
            //this.statusAwal();
            
//            JFXButton button = new JFXButton("Okay");
//            AlertMaker.showMessageDialog(rootPane, childPane, Arrays.asList(button), "Informasi", "Header transaksi penjualan berhasil disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
            
//            JFXButton button = new JFXButton("Okay");
//            AlertMaker.showMessageDialog(rootPane, childPane, Arrays.asList(button), "Error", "Header transaksi penjualan gagal disimpan");
        }
    }

    @FXML
    private void btnSimpanKeKeranjangHandler(ActionEvent event) {
        String kode = (String) cmbNamaBarang.getValue();
        String kodeFix = kode.substring(0,4);
        String namaBarang = kode.substring(7, kode.length() - 0);
        int harga = Integer.valueOf(txtHarga.getText());
        int jumlah = Integer.valueOf(txtJumlahPembelian.getText());
        long subTotal = harga * jumlah;
        
        PropertyValueFactory<transaksiMapper, String> prKodeBarang = new PropertyValueFactory<>("kodeBarang");
        PropertyValueFactory<transaksiMapper, String> prNamaBarang = new PropertyValueFactory<>("namaBarang");
        PropertyValueFactory<transaksiMapper, Integer> prHarga = new PropertyValueFactory<>("harga");
        PropertyValueFactory<transaksiMapper, Integer> prJumlah = new PropertyValueFactory<>("jumlah");
        PropertyValueFactory<transaksiMapper, Integer> prSubtotal = new PropertyValueFactory<>("subtotal");
        
        colKodeBarang.setCellValueFactory(prKodeBarang);
        colNamaBarang.setCellValueFactory(prNamaBarang);
        colHarga.setCellValueFactory(prHarga);
        colJumlah.setCellValueFactory(prJumlah);
        colSubtotal.setCellValueFactory(prSubtotal);
        
        tableItems.add(new transaksiMapper(kodeFix, namaBarang, harga, jumlah, subTotal));
        tblItem.setItems(tableItems);
        
        kosongkanDataBarang();
        hitungTotalBayar();
   
    }

    @FXML
    private void btnHapusHandler(ActionEvent event) {
//        kosongkanDataBarang();
//        kosongkanDataPelanggan();
        transaksiMapper tmp = tblItem.getSelectionModel().getSelectedItem();
        tableItems.remove(tmp);
        hitungTotalBayar();
    }

    @FXML
    private void btnSimpanTransaksiHandler(ActionEvent event) {
        try {
            trsServis = new transaksiImplement();
             
            int totalItem = tableItems.size();
            Object itemData[][] = new Object[totalItem][2];
            
            for (int count = 0; count < totalItem; count++) {
                transaksiMapper tmp = tableItems.get(count);
                itemData[count][0] = tmp.getKodeBarang();
                itemData[count][1] = tmp.getJumlah();
            }
            
            transaksi trs = new transaksi();
            trs.setNoFaktur(txtNoFaktur.getText());
            trs.setItemData(itemData);
            trsServis.insertItem(trs);
            
//            JFXButton button = new JFXButton("Okay");
//            AlertMaker.showMessageDialog(rootPane, childPane, Arrays.asList(button), "Informasi", "Detail transaksi penjualan berhasil disimpan");
            
            kosongkanDataPelanggan();
            kosongkanDataBarang();
            resetDataTransaksi();
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
//            JFXButton button = new JFXButton("Okay");
//            AlertMaker.showMessageDialog(rootPane, childPane, Arrays.asList(button), "Error", "Detail transaksi penjualan gagal disimpan");
        }
    }

    private void setKodeBarang() throws SQLException {
        transaksiImplement getKdBrg = new transaksiImplement();
        ObservableList<String> urutanArr = getKdBrg.viewKdBrg();
        cmbNamaBarang.setItems(urutanArr);
    }
    
    private void setIdPelanggan() throws SQLException {
        transaksiImplement getIdPlg = new transaksiImplement();
        ObservableList<String> urutanArr = getIdPlg.viewIdPlg();
        cmbNamaPelanggan.setItems(urutanArr);
        
        /*cmbNamaPelanggan.getItems().add("--PILIH--");
        for(Object o : urutanArr) {
            cmbNamaPelanggan.getItems().add((String) o);
        }*/
    }
    
    private void DateNow() {
        Date tglJual = new Date();
        SimpleDateFormat formatTgl = new SimpleDateFormat("yyyy-MM-dd");
        String dmy = formatTgl.format(tglJual);
        txtTanggalTransaksi.setText(dmy);
    }
    
    public void genFak(){
        transaksiImplement getUrutan = new transaksiImplement();
        int urutan = getUrutan.urutanDb();
        Calendar now = Calendar.getInstance();
        String kode_awal = "PO";
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        
        StringBuffer strValues = new StringBuffer();
        strValues.append(kode_awal);
        strValues.append("-");
        strValues.append(String.valueOf(year));
        strValues.append(String.valueOf(month));
        strValues.append(String.valueOf(day));
        strValues.append("-");
        strValues.append(String.valueOf(urutan));
        String result = strValues.toString();
        txtNoFaktur.setText(result);
    }
    
    private void kosongkanDataBarang(){
        txtJumlahPembelian.setText("");
        txtHarga.setText("");
        cmbNamaBarang.setValue("");
        txtStokBarang.setText("");
    }
    
    private void kosongkanDataPelanggan() {
        cmbNamaPelanggan.setValue("");
        txtAlamat.setText("");
        txtNoTelpon.setText("");
    }
    
    private void resetDataTransaksi() {
        genFak();
        DateNow();
        txtTotalPembayaran.setText("");
        tableItems.removeAll();
        tblItem.getItems().clear();
    }
    
    private void hitungTotalBayar(){
        int totalItem = tableItems.size();
        int totalBayar = 0;
        
        if (totalItem == 0){
            totalBayar = 0;
        } else {
            for (int i = 0; i < totalItem; i++) {
                transaksiMapper tmp = tableItems.get(i);
                int jumlahSubtotal = Integer.valueOf((String.valueOf(tmp.getSubtotal())));
                totalBayar += jumlahSubtotal;
            }
        }
        
        txtTotalPembayaran.setText(String.valueOf(totalBayar));
    }

    @FXML
    private void cmbNamaBarangHandler(ActionEvent event) {
        try {
            String kodeDanNamaBarang = cmbNamaBarang.getValue();
            String kodeBarang = kodeDanNamaBarang.substring(0,4);
            
            barangImplement brgServis = new barangImplement();
            Object dataBarang[] = brgServis.getWhere(kodeBarang);
            
            txtStokBarang.setText((String) dataBarang[2]);
            txtHarga.setText((String) dataBarang[3]);
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void cmbNamaPelangganHandler(ActionEvent event) {
        try {
            String IdDanNamaPelanggan = cmbNamaPelanggan.getValue();
            String idPelanggan = IdDanNamaPelanggan.substring(0,4);
            
            pelangganImplement plgServis = new pelangganImplement();
            Object dataPelanggan[] = plgServis.getWhere(idPelanggan);
            
            txtAlamat.setText((String) dataPelanggan[3]);
            txtNoTelpon.setText((String) dataPelanggan[4]);
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
