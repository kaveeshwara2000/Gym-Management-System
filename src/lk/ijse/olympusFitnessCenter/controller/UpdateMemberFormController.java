package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import lk.ijse.olympusFitnessCenter.model.MemberModel;
import lk.ijse.olympusFitnessCenter.to.Member;

import java.sql.SQLException;

public class UpdateMemberFormController {

    public JFXRadioButton rbMale;
    public JFXRadioButton rbFemale;
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtNIC;

    @FXML
    private DatePicker dpDOB;

    @FXML
    private TextField txtId;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private DatePicker dpJoinDate;

    @FXML
    private JFXButton btnClose;

    @FXML
    private ToggleGroup Gender;

    @FXML
    void btnCloseOnAction(ActionEvent event) {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String contactNo = txtContact.getText();
        String joinDate = String.valueOf(dpJoinDate.getValue());
        String NIC = txtNIC.getText();
        String DOB = String.valueOf(dpDOB.getValue());
        String address = txtAddress.getText();
        String gender = null;
        if(rbMale.isSelected()){
            gender = "Male";
        }else if(rbFemale.isSelected()){
            gender = "Female";
        }

        Member member = new Member(id,name,contactNo,joinDate,NIC,DOB,address,gender);

        try {
            boolean update =  MemberModel.updateMember(member);

            if (update){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated !!!");
                alert.show();
            }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong !!!");
                    alert.show();
                }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

}
