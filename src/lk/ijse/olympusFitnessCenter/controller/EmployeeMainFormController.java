package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeMainFormController {
    public JFXButton btnAdd;
    public TableView tblEmployee;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colJoinedDate;
    public TableColumn colNic;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colUpdate;
    public TableColumn colRemove;
    public TableColumn colJobRole;
    public TableView tblAttendance;
    public TableColumn colDate;
    public TableColumn colTime;
    public JFXButton btnMark;
    public ComboBox cmbId;
    public JFXTextField txtId;
    public JFXButton btnReload;
    public Label lblMemberID;

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/AddEmployeeForm.fxml"))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void btnMarkOnAction(ActionEvent actionEvent) {
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
        lblMemberID.setVisible(false);
    }

    public void txtIdOnAction(ActionEvent actionEvent) {
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
    }

    public void txtIdKeyReleased(KeyEvent keyEvent) {

            Pattern pattern = Pattern.compile("(M)([0-9]{1})([0-9]{0,})");
            Matcher matcher = pattern.matcher(txtId.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches){
                lblMemberID.setVisible(true);
            }else {
                lblMemberID.setVisible(false);
            }
    }
}
