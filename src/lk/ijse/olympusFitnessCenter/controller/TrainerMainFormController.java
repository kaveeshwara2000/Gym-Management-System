package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.olympusFitnessCenter.model.TrainerModel;
import lk.ijse.olympusFitnessCenter.to.Trainer;
import lk.ijse.olympusFitnessCenter.to.tm.MemberTM;
import lk.ijse.olympusFitnessCenter.to.tm.TrainerTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainerMainFormController {

    public TableView tblTrainer;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colJoinedDate;
    public TableColumn colNic;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colUpdate;
    public TableColumn colRemove;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableView tblAttendance;
    public JFXButton btnMark;
    public ComboBox cmbId;
    public JFXTextField txtId;
    public JFXButton btnReload;
    public Label lblMemberID;
    public Label lblTainerID;
    @FXML
    private JFXButton btnAdd;

    public void initialize(){
        loadCombo();

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("updateButton"));
        colRemove.setCellValueFactory(new PropertyValueFactory<>("deleteButton"));

       loadAllData();
    }

    private void loadCombo() {
        try {
            ArrayList<Trainer> trainers = TrainerModel.getAllTrainers();
            String[] ids;
            if (trainers.size() != 0) {
                ids = new String[trainers.size()];
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = trainers.get(i).getId();
                }
                cmbId.getItems().addAll(ids);
            }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }



    public void btnMarkOnAction(ActionEvent actionEvent) {

    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
        lblTainerID.setVisible(false);
        String value = String.valueOf(cmbId.getValue());
        try {
            Trainer selectedTrainer = TrainerModel.getSelectedTrainer(value);
            loadSelectedData(selectedTrainer);
            txtId.setText(value);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    private void loadSelectedData(Trainer selectedTrainer) {
        tblTrainer.getItems().clear();
        Button delete = new Button("Delete");
        Button update = new Button("Update");


        update.setOnAction((event -> {
            MemberTM tm = (MemberTM) tblTrainer.getSelectionModel().getSelectedItem();
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
                TrainerTM tm = (TrainerTM) tblTrainer.getSelectionModel().getSelectedItem();
                Trainer trainer = new Trainer();
                trainer.setId(tm.getId());
                try {
                    boolean deleteMember = TrainerModel.deleteTrainer(trainer);
                    if (deleteMember) {
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted !!!");
                        alert1.show();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                tblTrainer.getItems().removeAll(tm);
            }
        }));


        TrainerTM trainerTm = new TrainerTM(selectedTrainer.getId(), selectedTrainer.getName(), selectedTrainer.getContactNo(),selectedTrainer.getSalary(),selectedTrainer.getJoinDate(), selectedTrainer.getNIC(), selectedTrainer.getAddress(), delete, update);
        observableList.add(trainerTm);
        tblTrainer.setItems(observableList);

    }

    ArrayList<Trainer> trainerArrayList;
    {
        try {
            trainerArrayList=TrainerModel.getAllTrainers();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    ObservableList<TrainerTM> observableList = FXCollections.observableArrayList();

    private void loadAllData() {
//        System.out.println(trainerArrayList.size());
        for (Trainer t : trainerArrayList) {
            Button delete = new Button("Delete");
            Button update = new Button("Update");

            update.setOnAction((event -> {
                TrainerTM tm = (TrainerTM) tblTrainer.getSelectionModel().getSelectedItem();
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
                    TrainerTM tm = (TrainerTM) tblTrainer.getSelectionModel().getSelectedItem();
                    Trainer trainer = new Trainer();
                    trainer.setId(tm.getId());
                    try {
                        boolean deleteTrainer = TrainerModel.deleteTrainer(trainer);
                        if (deleteTrainer) {
                            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted !!!");
                            alert1.show();
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    tblTrainer.getItems().removeAll(tm);
                }
            }));


            TrainerTM trainerTm = new TrainerTM(t.getId(), t.getName(), t.getContactNo(),t.getSalary(), t.getJoinDate(), t.getNIC(), t.getAddress(), delete, update);
            observableList.add(trainerTm);
            tblTrainer.setItems(observableList);
        }
    }

    public void txtIdOnAction(ActionEvent actionEvent) {

    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        tblTrainer.getItems().clear();
        loadAllData();
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/AddEmployeeForm.fxml"))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void txtIdKeyRelease(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("(T)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtId.getText());

        boolean isMatches = matcher.matches();

        if (!isMatches){
            lblTainerID.setVisible(true);
        }else {
            lblTainerID.setVisible(false);
        }
    }
}
