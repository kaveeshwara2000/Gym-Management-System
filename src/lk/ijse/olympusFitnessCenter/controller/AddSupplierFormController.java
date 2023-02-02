package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddSupplierFormController {
    public TextField txtSupName;
    public TextField txtSupContact;
    public TextField txtSupCategory;
    public TextField txtSupId;
    public JFXButton btnAdd;
    public Label lblSupId;
    public Label lblSupName;
    public Label lblSupContact;

    public void btnAddOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION," Successfully Added !!!");
        alert.show();
    }
}
