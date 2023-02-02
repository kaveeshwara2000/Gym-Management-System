package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.event.KeyEvent;

public class SupplierFormController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TableView<?> tblEmployee;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colUpdate;

    @FXML
    private TableColumn<?, ?> colRemove;

    @FXML
    private TableView<?> tblAttendance;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private JFXButton btnMark;

    @FXML
    private ComboBox<?> cmbId;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXButton btnReload;

    @FXML
    private Label lblMemberID;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnMarkOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void cmbIdOnAction(ActionEvent event) {

    }


    @FXML
    void txtIdOnAction(ActionEvent event) {

    }

    public void txtIdKeyReleased(javafx.scene.input.KeyEvent keyEvent) {
    }
}
