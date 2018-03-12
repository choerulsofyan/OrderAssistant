package penjualan.helper;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.commons.collections.map.HashedMap;
import penjualan.koneksi.koneksi;

public class Util {
    
    private static final String IMAGE_LOC = "/resources/transaksi-penjualan.png";
    
    public static void setStageIcon(Stage stage)
    {
        stage.getIcons().add(new Image(IMAGE_LOC));
    }
    
    public static void loadWindow(URL loc, String title, Stage parentStage)
    {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
            setStageIcon(stage);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public static AnchorPane getReportContainer(String path){
        AnchorPane container = new AnchorPane();
        
        try {
            HashedMap params = new HashedMap();
            JasperPrint print = JasperFillManager.fillReport(path, params, koneksi.getConnection());

            JRViewer lihat = new JRViewer(print);
            SwingNode node = new SwingNode();
            node.setContent(lihat);
            
            container.setPadding(new Insets(20, 20, 20, 20));
            container.setMinSize(Region.USE_COMPUTED_SIZE, 670);
            container.setTopAnchor(node, 0.0);
            container.setRightAnchor(node, 0.0);
            container.setBottomAnchor(node, 0.0);
            container.setLeftAnchor(node, 0.0);
            container.getChildren().add(node);
            
        } catch (JRException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return container;
    }
}
