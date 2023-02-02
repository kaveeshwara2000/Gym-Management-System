package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceptionistDashboardFormController {
    public AnchorPane pane;
    public BorderPane fullPane;
    public JFXButton btnMembers;
    public JFXButton btnTrainers;
    public JFXButton btnSuppliers;
    public JFXButton btnStock;
    public JFXButton btnSales;
    public Label lblCurrentDate;
    public AnchorPane centerPane;
    public Label lblMembers;
    public Label lblEmployees;
    public Label lblTrainers;
    public JFXButton btnLogout;
    public JFXButton btnClose;

    public void initialize(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
        String dateNow = sdf.format(new Date());
        lblCurrentDate.setText(dateNow);
    }

    public void btnMembersOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/MemberMainForm.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(load);
        fullPane.setCenter(load);

    }

    public void btnTrainersOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/TrainerMainForm.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(load);
        fullPane.setCenter(load);
    }

    public void btnSuppliersOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/SupplierMainForm.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(load);
        fullPane.setCenter(load);
    }

    public void btnStockOnAction(ActionEvent actionEvent) {
    }

    public void btnSalesOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/SalesMainForm.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(load);
        fullPane.setCenter(load);
    }

    public void btnLogoutClickOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)pane.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/LoginForm.fxml"))));
        window.centerOnScreen();
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
