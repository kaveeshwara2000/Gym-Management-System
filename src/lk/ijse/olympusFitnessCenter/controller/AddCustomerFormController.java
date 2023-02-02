package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class AddCustomerFormController {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblContact;

    @FXML
    private JFXButton btnClose;

    public void btnAddOnAction(javafx.event.ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION," Successfully Added !!!");
        alert.show();
    }

    public void btnCloseOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
