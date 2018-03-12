/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import penjualan.implement.barangImplement;
import penjualan.interfc.barangInterfc;
import penjualan.entity.barang;
import penjualan.helper.AlertMaker;
import penjualan.tablemapper.barangMapper;

/**
 * FXML Controller class
 *
 * @author TheFighter
 */
public class MasterBarangController implements Initializable {
    
    barangInterfc brgServis;
    
    @FXML
    private TableView<barangMapper> tblBarang;
    @FXML
    private TableColumn<barangMapper, String> colHarga;
    @FXML
    private TableColumn<barangMapper, String> colJumlah;
    @FXML
    private TableColumn<barangMapper, String> colKodeBarang;
    @FXML
    private TableColumn<barangMapper, String> colNamaBarang;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnTambah;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnHapus;
    @FXML
    private JFXTextField txtNamaBarang;
    @FXML
    private JFXTextField txtKodeBarang;
    @FXML
    private JFXTextField txtJumlah;
    @FXML
    private JFXTextField txtHarga; 
    private JFXTextField txtSearch;
    
    ObservableList<barangMapper> tableItems;
    private StackPane rootPane;
    private AnchorPane childPane;
    @FXML
    private VBox containerpane;
    @FXML
    private StackPane wrapper;
    @FXML
    private AnchorPane child;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        tblBarang.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  
        kosongkanText();
        isiTabel();
    }
    
    @FXML
    void tblBarangClickHandler(MouseEvent event) {
        if (event.getClickCount() == 2) {
            txtKodeBarang.setText(tblBarang.getSelectionModel().getSelectedItem().getKodeBarang());
            txtNamaBarang.setText(tblBarang.getSelectionModel().getSelectedItem().getNamaBarang());
            txtHarga.setText(tblBarang.getSelectionModel().getSelectedItem().getHargaBarang());
            txtJumlah.setText(tblBarang.getSelectionModel().getSelectedItem().getStokBarang());
        }
    }
    
    @FXML
    void btnClearHandler(ActionEvent event) {
        kosongkanText();
    }

    @FXML
    void btnTambahHandler(ActionEvent event) {
        try {
            brgServis = new barangImplement();
            
            barang brg = new barang();
            brg.setKodeBarang(txtKodeBarang.getText());
            brg.setNamaBarang(txtNamaBarang.getText());
            brg.setJumlah(txtJumlah.getText());
            brg.setHarga(txtHarga.getText());            
            brgServis.insert(brg);
            
            JFXButton button = new JFXButton("Okay");
            AlertMaker.showMessageDialog(wrapper, child, Arrays.asList(button), "Informasi", "Data barang berhasil disimpan");
            this.statusAwal();
            
        } catch (Exception e) {
            Logger.getLogger(MasterBarangController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);
        }
    }

    @FXML
    void btnUpdateHandler(ActionEvent event) {
        try {
            brgServis = new barangImplement();
            
            barang brg = new barang();
            brg.setKodeBarang(txtKodeBarang.getText());
            brg.setNamaBarang(txtNamaBarang.getText());
            brg.setJumlah(txtJumlah.getText());
            brg.setHarga(txtHarga.getText());
            brgServis.update(brg);
            
            JFXButton button = new JFXButton("Okay");
            AlertMaker.showMessageDialog(wrapper, child, Arrays.asList(button), "Informasi", "Data barang berhasil diupdate");
            this.statusAwal();
            
        } catch (Exception e) {
            Logger.getLogger(MasterBarangController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);
        }
    }

    @FXML
    void btnHapusHandler(ActionEvent event) {
        brgServis = new barangImplement();
        
        barang brg = new barang();
        String kodeBarang = txtKodeBarang.getText();
        
        try {
            brgServis.delete(kodeBarang);
        } catch (Exception e) {
            Logger.getLogger(MasterBarangController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);
        }
        
//        rootPane = new StackPane();
//        childPane = new AnchorPane();
//       
//        rootPane.getChildren().addAll(childPane);
//        containerpane.getChildren().add(rootPane);
//        
         JFXButton button = new JFXButton("Okay");
         AlertMaker.showMessageDialog(wrapper, child, Arrays.asList(button), "Informasi", "Data barang berhasil dihapus");
        this.statusAwal();
    }

    void btnKembaliHandler(ActionEvent event) {

    }
    
    void kosongkanText()
    {
        txtKodeBarang.setText("");
        txtNamaBarang.setText("");
        txtJumlah.setText("");
        txtHarga.setText("");
    }
    
    void isiTabel()
    {
        PropertyValueFactory<barangMapper, String> kodeBarangProperty = new PropertyValueFactory<>("kodeBarang");
        PropertyValueFactory<barangMapper, String> namaBarangProperty = new PropertyValueFactory<>("namaBarang");
        PropertyValueFactory<barangMapper, String> hargaBarangProperty = new PropertyValueFactory<>("hargaBarang");
        PropertyValueFactory<barangMapper, String> stokBarangProperty = new PropertyValueFactory<>("stokBarang");
        
        colKodeBarang.setCellValueFactory(kodeBarangProperty);
        colNamaBarang.setCellValueFactory(namaBarangProperty);
        colHarga.setCellValueFactory(hargaBarangProperty);
        colJumlah.setCellValueFactory(stokBarangProperty);
        
        barangImplement data = new barangImplement();
        
        try {
            tableItems = data.getData();
            tblBarang.setItems(tableItems);
        } catch (SQLException ex) {
            Logger.getLogger(MasterBarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void statusAwal()
    {
        kosongkanText();
        isiTabel();
    }
}
