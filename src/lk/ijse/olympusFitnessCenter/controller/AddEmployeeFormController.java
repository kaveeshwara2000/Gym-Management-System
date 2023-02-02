package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeFormController {
    public TextField txtName;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNIC;
    public TextField txtId;
    public JFXButton btnAdd;
    public DatePicker dpJoinDate;
    public TextField txtSalary;
    public ComboBox cmbJobRole;
    public JFXButton btnClose;

    public void btnAddOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION," Successfully Added !!!");
        alert.show();
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
