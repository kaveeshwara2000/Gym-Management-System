package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.olympusFitnessCenter.model.MeasurementsModel;
import lk.ijse.olympusFitnessCenter.model.MemberModel;
import lk.ijse.olympusFitnessCenter.to.Measurements;
import lk.ijse.olympusFitnessCenter.to.Member;
import lk.ijse.olympusFitnessCenter.to.tm.MemberTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberMainFormController {
    public JFXButton btnAdd;
    public JFXButton btnAddToTable;
    public Label lblUnitPrice;
    public TableView tblOrder;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colRemove2;
    public Label lblTotal;
    public JFXButton btnMark;
    public TableView tblAttendance;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colJoinedDate;
    public TableColumn colNic;
    public TableColumn colAge;
    public TableColumn colAddress;
    public TableColumn colGender;
    public TableColumn colUpdate;
    public TableColumn colRemove;
    public ComboBox cmbId;
    public TableView<MemberTM> tblMember;
    public TextField txtHeight;
    public TextField txtWeight;
    public TextField txtChest;
    public TextField txtArm;
    public TextField txtWaist;
    public JFXButton btnSet;
    public Label lblBMI;
    public JFXButton btnOk;
    public JFXTextField txtId;
    public JFXButton btnReload;
    public Label lblMemberID;
    public ComboBox cmbCode;
    public JFXTextField txtCode;
    public Label lblDescription;

    {
        try {
            memberArrayList = MemberModel.getAllMembers();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initialize() {
        loadCombo();

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("updateButton"));
        colRemove.setCellValueFactory(new PropertyValueFactory<>("deleteButton"));

        loadAllData();
    }


    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/AddMemberForm.fxml"))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void btnAddToTableOnAction(ActionEvent actionEvent) {

    }

    public void btnMarkOnAction(ActionEvent actionEvent) {

    }


    private void loadCombo() {
        try {
            ArrayList<Member> members = MemberModel.getAllMembers();
            String[] ids;
            if (members.size() != 0) {
                ids = new String[members.size()];
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = members.get(i).getId();
                }
                cmbId.getItems().addAll(ids);
            }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
        lblMemberID.setVisible(false);
        String value = String.valueOf(cmbId.getValue());
        try {
            Member selectedMember = MemberModel.getSelectedMember(value);
            loadSelectedData(selectedMember);
            txtId.setText(value);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        try {
            Measurements selectedMember = MeasurementsModel.getSelectedMember(value);
            txtHeight.setText(String.valueOf(selectedMember.getHeight()));
            txtWeight.setText(String.valueOf(selectedMember.getWeight()));
            txtChest.setText(String.valueOf(selectedMember.getChest()));
            txtArm.setText(String.valueOf(selectedMember.getArm()));
            txtWaist.setText(String.valueOf(selectedMember.getWaist()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        calculateBMI();

    }

    private void loadSelectedData(Member selectedMember) {
        tblMember.getItems().clear();
        Button delete = new Button("Delete");
        Button update = new Button("Update");


        update.setOnAction((event -> {
            MemberTM tm = tblMember.getSelectionModel().getSelectedItem();
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/UpdateMemberForm.fxml"))));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }));

        delete.setOnAction((event -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                MemberTM tm = tblMember.getSelectionModel().getSelectedItem();
                Member member = new Member();
                member.setId(tm.getId());
                try {
                    boolean deleteMember = MemberModel.deleteMember(member);
                    if (deleteMember) {
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted !!!");
                        alert1.show();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                tblMember.getItems().removeAll(tm);
            }
        }));


        MemberTM memberTm = new MemberTM(selectedMember.getId(), selectedMember.getName(), selectedMember.getContactNo(), selectedMember.getJoinDate(), selectedMember.getNIC(), selectedMember.getDOB(), selectedMember.getAddress(), selectedMember.getGender(), delete, update);
        observableList.add(memberTm);
        tblMember.setItems(observableList);

    }

    ArrayList<Member> memberArrayList;
    ObservableList<MemberTM> observableList = FXCollections.observableArrayList();

    private void loadAllData() {
        for (Member m : memberArrayList) {
            Button delete = new Button("Delete");
            Button update = new Button("Update");

            update.setOnAction((event -> {
                MemberTM tm = tblMember.getSelectionModel().getSelectedItem();
                Stage stage = new Stage();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/UpdateMemberForm.fxml"))));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }));

            delete.setOnAction((event -> {
                ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure, You want to delete ?", ok, no);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.orElse(no) == ok) {
                    MemberTM tm = tblMember.getSelectionModel().getSelectedItem();
                    Member member = new Member();
                    member.setId(tm.getId());
                    try {
                        boolean deleteMember = MemberModel.deleteMember(member);
                        if (deleteMember) {
                            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted !!!");
                            alert1.show();
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    tblMember.getItems().removeAll(tm);
                }
            }));


            MemberTM memberTm = new MemberTM(m.getId(), m.getName(), m.getContactNo(), m.getJoinDate(), m.getNIC(), m.getDOB(), m.getAddress(), m.getGender(), delete, update);
            observableList.add(memberTm);
            tblMember.setItems(observableList);
        }
    }

    public void btnSetOnAction(ActionEvent actionEvent) {
        String id = String.valueOf(cmbId.getValue());
        double height = Double.parseDouble(txtHeight.getText());
        double weight = Double.parseDouble(txtWeight.getText());
        double chest = Double.parseDouble(txtChest.getText());
        double arm = Double.parseDouble(txtArm.getText());
        double waist = Double.parseDouble(txtWaist.getText());

        Measurements measurements = new Measurements(id,height,weight,chest, arm,waist);
        try {
            boolean update = MeasurementsModel.update(measurements);
            if (update){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated !!!");
                alert.show();
            }else{
                boolean add = MeasurementsModel.add(measurements);
                if (add){
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated !!!");
                    alert.show();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong !!!");
                    alert.show();
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        calculateBMI();
    }

    public void calculateBMI(){
        double height = Double.parseDouble(txtHeight.getText());
        double weight = Double.parseDouble(txtWeight.getText());
        double bmi;
        height /= 100;
        double height2 = height *height;
        bmi = weight/height2;
        lblBMI.setText(String.valueOf(bmi));

        if (bmi>25){
            lblBMI.setStyle("-fx-text-fill: red");
        }else if (bmi<18.5){
            lblBMI.setStyle("-fx-text-fill: pink");
        }else{
            lblBMI.setStyle("-fx-text-fill: green");
        }
        lblBMI.setText(String.valueOf(bmi));
    }

    public void btnOkOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.ERROR," Something went wrong !!!");
        alert.show();
    }

    public void txtIdOnAction(ActionEvent actionEvent) {


    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        tblMember.getItems().clear();
        loadAllData();
    }

    public void cmbCodeOnAction(ActionEvent actionEvent) {

    }

    public void txtCodeOnAction(ActionEvent actionEvent) {
    }

    public void txtIdKeyReleased(KeyEvent keyEvent) {
        validation();
    }
    public void validation(){
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
