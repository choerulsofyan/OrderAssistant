/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import penjualan.entity.pelanggan;
import penjualan.helper.AlertMaker;
import penjualan.implement.pelangganImplement;
import penjualan.interfc.pelangganInterfc;
import penjualan.tablemapper.pelangganMapper;

/**
 * FXML Controller class
 *
 * @author TheFighter
 */
public class MasterPelangganController implements Initializable {
    
    @FXML
    private JFXButton btnHapus;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnTambah;
    @FXML
    private JFXButton btnClear;
    @FXML
    private TableView<pelangganMapper> tblPelanggan;
    @FXML
    private TableColumn<pelangganMapper, String> colIdPelanggan;
    @FXML
    private TableColumn<pelangganMapper, String> colNama;
    @FXML
    private TableColumn<pelangganMapper, String> colJenisKelamin;
    @FXML
    private TableColumn<pelangganMapper, String> colAlamat;
    @FXML
    private TableColumn<pelangganMapper, String> colTelepon;
    @FXML
    private JFXTextField txtNama;
    @FXML
    private JFXTextField txtIdPelanggan;
    @FXML
    private JFXTextArea txtAlamat;
    @FXML
    private JFXTextField txtNoTelepon;
    @FXML
    private JFXRadioButton rdPria;
    @FXML
    private ToggleGroup jenisKelamin;
    @FXML
    private JFXRadioButton rdWanita;
    
    ObservableList<pelangganMapper> tableItems;
    pelangganInterfc plgServis;
    @FXML
    private StackPane wrapper;
    @FXML
    private AnchorPane child;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kosongkanText();
        isiTabel();
    }    


    @FXML
    private void btnHapusHandler(ActionEvent event) {
        
        plgServis = new pelangganImplement();
        
        String idPelanggan = txtIdPelanggan.getText();
        try {          
            plgServis.delete(idPelanggan);
            
            JFXButton buttonOkay = new JFXButton("Okay");
            buttonOkay.setButtonType(JFXButton.ButtonType.RAISED);
            AlertMaker.showConfirmationDialog(wrapper, child, Arrays.asList(buttonOkay), "Informasi", "Data pelanggan berhasil dihapus"); 
        } catch (Exception e) {
            Logger.getLogger(MasterPelangganController.class.getName()).log(Level.SEVERE, null, e);
//            JFXButton button = new JFXButton("Okay");
//            AlertMaker.showMessageDialog(wrapper, child, Arrays.asList(button), "Error", "Data pelanggan gagal diubah");
        }

        this.statusAwal();
    }

    @FXML
    private void btnUpdateHandler(ActionEvent event) {
        try {
            plgServis = new pelangganImplement();
            RadioButton opsiJenisKelamin = (RadioButton) jenisKelamin.getSelectedToggle();
            
            pelanggan plg = new pelanggan();
            plg.setIdPelanggan(txtIdPelanggan.getText());
            plg.setNama(txtNama.getText());
            plg.setJenisKelamin(opsiJenisKelamin.getText());
            plg.setAlamat(txtAlamat.getText());
            plg.setNoTelepon(txtNoTelepon.getText());
            plgServis.update(plg);
            
            JFXButton button = new JFXButton("Okay");
            AlertMaker.showMessageDialog(wrapper, child, Arrays.asList(button), "Informasi", "Data pelanggan berhasil diubah");
            this.statusAwal();
        } catch (Exception e) {
            Logger.getLogger(MasterPelangganController.class.getName()).log(Level.SEVERE, null, e);
            JFXButton button = new JFXButton("Okay");
            AlertMaker.showMessageDialog(wrapper, child, Arrays.asList(button), "Error", "Data pelanggan gagal diubah");
        }
    }

    @FXML
    private void btnTambahHandler(ActionEvent event) {
        
//        if (jenisKelamin.getSelectedToggle() != null) {
//            RadioButton button = (RadioButton) jenisKelamin.getSelectedToggle();
//            System.out.println(button.getText());
//        }
        
        
        try {
            plgServis = new pelangganImplement();
            pelanggan plg = new pelanggan();
            RadioButton opsiJenisKelamin = (RadioButton) jenisKelamin.getSelectedToggle();
            
            plg.setIdPelanggan(txtIdPelanggan.getText());
            plg.setNama(txtNama.getText());
            plg.setJenisKelamin(opsiJenisKelamin.getText());
            plg.setAlamat(txtAlamat.getText());
            plg.setNoTelepon(txtNoTelepon.getText());
            plgServis.insert(plg);
            
            JFXButton button = new JFXButton("Okay");
            AlertMaker.showMessageDialog(wrapper, child, Arrays.asList(button), "Informasi", "Data pelanggan berhasil disimpan");
            this.statusAwal();
            
        } catch (SQLException ex) {
            Logger.getLogger(MasterPelangganController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnClearHandler(ActionEvent event) {
        kosongkanText();
    }

    @FXML
    private void tblPelangganClickHandler(MouseEvent event) {
        if (event.getClickCount() == 2) {
            txtIdPelanggan.setText(String.valueOf(tblPelanggan.getSelectionModel().getSelectedItem().getIdPelanggan()));
            txtNama.setText(tblPelanggan.getSelectionModel().getSelectedItem().getNama());
            txtAlamat.setText(tblPelanggan.getSelectionModel().getSelectedItem().getAlamat());
            txtNoTelepon.setText(tblPelanggan.getSelectionModel().getSelectedItem().getNoTelepon());
            
            String opsiJenisKelamin = tblPelanggan.getSelectionModel().getSelectedItem().getJenisKelamin();
            if (opsiJenisKelamin.equals("Pria")) {
                rdPria.setSelected(true);
            } else if (opsiJenisKelamin.equals("Wanita")) {
                rdWanita.setSelected(true);
            } 
        }
    }
    
    void kosongkanText()
    {
        txtIdPelanggan.setText("");
        txtNama.setText("");
        jenisKelamin.selectToggle(null);
        txtAlamat.setText("");
        txtNoTelepon.setText("");
    }
    
    void isiTabel()
    {
        PropertyValueFactory<pelangganMapper, String> idPelangganProperty = new PropertyValueFactory<>("idPelanggan");
        PropertyValueFactory<pelangganMapper, String> namaProperty = new PropertyValueFactory<>("nama");
        PropertyValueFactory<pelangganMapper, String> jenisKelaminProperty = new PropertyValueFactory<>("jenisKelamin");
        PropertyValueFactory<pelangganMapper, String> alamatProperty = new PropertyValueFactory<>("alamat");
        PropertyValueFactory<pelangganMapper, String> noTeleponProperty = new PropertyValueFactory<>("noTelepon");
        
        colIdPelanggan.setCellValueFactory(idPelangganProperty);
        colNama.setCellValueFactory(namaProperty);
        colJenisKelamin.setCellValueFactory(jenisKelaminProperty);
        colAlamat.setCellValueFactory(alamatProperty);
        colTelepon.setCellValueFactory(noTeleponProperty);
        
        pelangganImplement data = new pelangganImplement();
        
        try {
            tableItems = data.getData();
            tblPelanggan.setItems(tableItems);
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
