package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXButton btnClose;
    public ImageView imgClose;
    public ImageView pane;
    @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private Label lblLogin;


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtLogin.getText();
        String password = txtPassword.getText();

        if (userName.equals("admin")){
            if(password.equals("admin123")){
                Stage window = (Stage)pane.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/AdminDashboardForm.fxml"))));
                window.centerOnScreen();
            }else{
                lblLogin.setVisible(true);
            }

        }else if(password.equals("1234")){
            Stage window = (Stage)pane.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/ReceptionistDashboardForm.fxml"))));
            window.centerOnScreen();
        }else{
            lblLogin.setVisible(true);
        }



    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

}
