/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import penjualan.helper.Util;

/**
 * FXML Controller class
 *
 * @author Choerul
 */
public class LoginController implements Initializable {

   
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXTextField username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLoginHandler(ActionEvent event) {
        
        String uname = username.getText();
        String pass = password.getText();
        
        System.out.println(uname);
        System.out.println(pass);
        
        if (uname.equals("admin") && pass.equals("admin")){
            ((Stage)username.getScene().getWindow()).close();
            
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("/penjualan/view/MainMenu.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("PT. Anugrah Jaya");
                stage.setMaximized(true);
                stage.setScene(new Scene(parent));
                stage.show();
            
                Util.setStageIcon(stage);
            
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        } else {
            username.getStyleClass().add("wrong-credentials");
            password.getStyleClass().add("wrong-credentials");
        }
    }

    @FXML
    private void btnCancelHandler(ActionEvent event) {
        System.exit(0);
    }
    
}
