package lk.ijse.olympusFitnessCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.olympusFitnessCenter.model.CustomerModel;
import lk.ijse.olympusFitnessCenter.model.ItemModel;
import lk.ijse.olympusFitnessCenter.to.Customer;
import lk.ijse.olympusFitnessCenter.to.Item;
import lk.ijse.olympusFitnessCenter.to.SaleDetails;
import lk.ijse.olympusFitnessCenter.to.tm.CustomerTM;
import lk.ijse.olympusFitnessCenter.to.tm.SalesTM;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Optional;

public class SalesMainFormController {

    public TableView <CustomerTM> tblCustomer;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colUpdate;
    public TableColumn colDelete;
    public TableView<SalesTM> tblOrder;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQuantity;
    public TableColumn colTotal;
    public TableColumn colRemove;
    public ToggleGroup payment;
    public JFXTextField txtQty1;
    public Label lblBalance;
    public JFXButton btnPlaceOrder;
    public JFXRadioButton cmbCash;
    public JFXRadioButton cmbCard;
    public JFXTextField txtCusId;
    public Label lblMemberID;
    public JFXTextField txtCash;
    @FXML
    private ComboBox<String> cmbCusId;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private ComboBox<String> cmbItem;

    @FXML
    private JFXTextField txtItem;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblAqty;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private JFXButton btnAddToTable;
    private ObservableList<SalesTM> observableList = FXCollections.observableArrayList();
    private ObservableList<CustomerTM> observableList1 = FXCollections.observableArrayList();
    double tot;
    @FXML
    private Label lblTotal;
    public void initialize() {
        loadComboItem();

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));


        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Contact_No"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

    }

    private void loadComboItem() {
        try {
            ArrayList<Item> items = ItemModel.getAllMembers();
            String[] ids;
            if (items.size() != 0) {
                ids = new String[items.size()];
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = items.get(i).getCode();
                }
                cmbItem.getItems().addAll(ids);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        try {
            ArrayList<Customer> customers = CustomerModel.getAllCustomers();
            String[] ids;
            if (customers.size() != 0) {
                ids = new String[customers.size()];
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = customers.get(i).getCus_Id();
                }
                cmbCusId.getItems().addAll(ids);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnAddOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/olympusFitnessCenter/view/AddCustomerForm.fxml"))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void btnAddToTableOnAction(ActionEvent actionEvent) {
        String value = cmbItem.getValue();
        String description = lblDescription.getText();
        double price = Double.parseDouble(lblUnitPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        double total = price * qty;

        Button remove = new Button("Remove");
        remove.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                SalesTM tm = tblOrder.getSelectionModel().getSelectedItem();
                tblOrder.getItems().removeAll(tm);
                tblOrder.refresh();
            }
            tot = 0;
            for (int i = 0; i < tblOrder.getItems().size(); i++) {
                tot += (Double) colTotal.getCellData(i);
            }
            lblTotal.setText(String.valueOf(tot));
        });
        observableList.add(new SalesTM(value, description, price, qty, total, remove));
        tblOrder.setItems(observableList);
        tot = 0;
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            tot += (Double) colTotal.getCellData(i);
        }
        lblTotal.setText(String.valueOf(tot));
    }

    public void btnPlaceOrderOnAction(javafx.event.ActionEvent actionEvent) {
        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION," Successful !!!");
        alert1.show();
        ArrayList<SaleDetails> orderDetails=new ArrayList<>();
        String date,time;
        Long millis=System.currentTimeMillis();
        java.sql.Date date1=new java.sql.Date(millis);
        date= String.valueOf(date1);

        Time time1=new Time(millis);
        time= String.valueOf(time1);
        String type;
        if (cmbCash.equals("Cash")) {
            type=cmbCash.getText();
        }else {
            type=cmbCard.getText();
        }
        String tot=lblTotal.getText();

        for (int i= 0; i < tblOrder.getItems().size(); i++) {
            SalesTM salesTM=observableList.get(i);
            orderDetails.add(new SaleDetails(salesTM.getCode(),salesTM.getDescription(),salesTM.getPrice(),salesTM.getQty(),salesTM.getTotal()));
        }
        try {
            boolean update = ItemModel.update(orderDetails, date, time, tot, type, txtCusId);
            if (update){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION," Successfully Added !!!");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtItemOnAction(ActionEvent actionEvent) {

        try {
            Item items = ItemModel.getSelectedItem(cmbItem.getValue());
            if (items != null) {
                lblDescription.setText(items.getDescription());
                lblAqty.setText(String.valueOf(items.getQty()));
                lblUnitPrice.setText(String.valueOf(items.getPrice()));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cmbItemOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtItem.setText(cmbItem.getValue());

        Item items = ItemModel.getSelectedItem(cmbItem.getValue());
        lblDescription.setText(items.getDescription());
        lblAqty.setText(String.valueOf(items.getQty()));
        lblUnitPrice.setText(String.valueOf(items.getPrice()));
    }

    public void cmbCustomersId(ActionEvent actionEvent) {
        txtCusId.setText(cmbCusId.getValue());
    }

    public void txtCustomerId(ActionEvent actionEvent) {
        Customer customer=null;
        try {
             customer = CustomerModel.getSelectedCustomer(txtCusId.getText());


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }



        Button remove = new Button("Delete");
        remove.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                CustomerTM tm = tblCustomer.getSelectionModel().getSelectedItem();
                tblCustomer.getItems().removeAll(tm);
                tblCustomer.refresh();
            }
        });
        observableList1.add(new CustomerTM(txtCusId.getText(),customer.getName(),customer.getContact_No(),remove));
        tblCustomer.setItems(observableList1);
    }

    public void txtCashOnAction(ActionEvent actionEvent) {
        double total = Double.parseDouble(lblTotal.getText());
        double cash = Double.parseDouble(txtCash.getText());
        double balance = cash-total;

        lblBalance.setText(String.valueOf(balance));
    }
}
