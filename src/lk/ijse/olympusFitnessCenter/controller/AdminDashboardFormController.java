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
import lk.ijse.olympusFitnessCenter.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminDashboardFormController {
    public JFXButton btnClose;
    public JFXButton btnLogout;
    public AnchorPane pane;
    public Label lblCurrentDate;
    public JFXButton btnMembers;
    public AnchorPane centerPane;
    public BorderPane fullPane;
    public JFXButton btnSales;
    public JFXButton btnTrainers;
    public JFXButton btnEmployees;
    public JFXButton btnSuppliers;
    public JFXButton btnStock;
    public JFXButton btnReports;
    public Label lblMembers;
    public Label lblEmployees;
    public Label lblTrainers;

    public void initialize() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
        String dateNow = sdf.format(new Date());
        lblCurrentDate.setText(dateNow);
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnLogoutClickOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) pane.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/LoginForm.fxml"))));
        window.centerOnScreen();
    }

    public void btnMembersOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/MemberMainForm.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(load);
        fullPane.setCenter(load);

    }

    public void btnSalesOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/SalesMainForm.fxml"));
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

    public void btnEmployeesOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/EmployeeMainForm.fxml"));
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

    public void btnReportsOnAction(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/olympusFitnessCenter/report/report.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }
}
