package penjualan.view;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.commons.collections.map.HashedMap;
import penjualan.helper.AlertMaker;
import penjualan.helper.Util;
import penjualan.koneksi.koneksi;

public class MainMenuController implements Initializable {

    @FXML
    private Menu menuHome;
    @FXML
    private Menu menuMaster;
    @FXML
    private MenuItem menuMasterPelanggan;
    @FXML
    private MenuItem menuMasterBarang;
    @FXML
    private Menu menuTransaksi;
    @FXML
    private MenuItem menuTransaksiPembelian;
    @FXML
    private MenuItem menuTransaksiPenjualan;
    @FXML
    private Menu menuLaporan;
    @FXML
    private MenuItem menuLaporanBarang;
    @FXML
    private MenuItem menuLaporanPelanggan;
    @FXML
    private MenuItem menuLaporanTransaksi;
    @FXML
    private Menu menuHelp;
    @FXML
    private Menu menuLogout;
    @FXML
    private StackPane rootPane;
    @FXML
    private VBox childPane;
    @FXML
    private VBox contentPane;
    @FXML
    private ImageView imgLogout;
    @FXML
    private MenuItem menuLaporanTransaksi1;
    @FXML
    private MenuItem menuLaporanTransaksi11;
    @FXML
    private MenuItem MenuHelp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            contentPane.getChildren().clear();
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/penjualan/view/Home.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void showMessageDialog(String title, String message)
    {
        JFXButton button = new JFXButton("Okay");
        AlertMaker.showMessageDialog(rootPane, childPane, Arrays.asList(button), title, message);
    }
    
    @FXML
    private void loadHome(ActionEvent event) {
        try {
            contentPane.getChildren().clear();
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/penjualan/view/Home.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void loadMenuMasterPelanggan(ActionEvent event) {
        try {
            contentPane.getChildren().clear();
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/penjualan/view/MasterPelanggan.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadMenuMasterBarang(ActionEvent event) {
        try {
            contentPane.getChildren().clear();
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/penjualan/view/MasterBarang.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadMenuTransaksiPembelian(ActionEvent event) {
        try {
            contentPane.getChildren().clear();
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/penjualan/view/TransaksiPembelian.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadMenuTransaksiPenjualan(ActionEvent event) {
        try {
            contentPane.getChildren().clear();
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/penjualan/view/TransaksiPenjualan.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadMenuLaporanBarang(ActionEvent event) {
        String path = "src/penjualan/reports/Barang.jasper";
        AnchorPane reportContainer = Util.getReportContainer(path);
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(reportContainer);
    }

    @FXML
    private void loadMenuLaporanPelanggan(ActionEvent event) {
        String path = "src/penjualan/reports/Pelanggan.jasper";
        AnchorPane reportContainer = Util.getReportContainer(path);
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(reportContainer);
    }

    @FXML
    private void LoadMenuLaporanTransaksi(ActionEvent event) {
        String path = "src/penjualan/reports/TransaksiPenjualan.jasper";
        AnchorPane reportContainer = Util.getReportContainer(path);
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(reportContainer);
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        ((Stage)rootPane.getScene().getWindow()).close();
        
        try {
                Parent parent = FXMLLoader.load(getClass().getResource("/penjualan/view/Login.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("PT. Anugrah Jaya");
                stage.setScene(new Scene(parent));
                stage.show();
            
                Util.setStageIcon(stage);
            
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }

    @FXML
    private void LoadMenuLaporanBarangYangDipasarkan(ActionEvent event) {
        String path = "src/penjualan/reports/BarangYangDipasarkan.jasper";
        AnchorPane reportContainer = Util.getReportContainer(path);
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(reportContainer);
    }

    @FXML
    private void LoadMenuLaporanBarangPalingBanyakDibeli(ActionEvent event) {
        String path = "src/penjualan/reports/BarangLakuTahunan.jasper";
        AnchorPane reportContainer = Util.getReportContainer(path);
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(reportContainer);
    }

    @FXML
    private void handleHelp(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/penjualan/view/Help.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            // stage.initModality(Modality.APPLICATION_MODAL);
            // stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Help");
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
