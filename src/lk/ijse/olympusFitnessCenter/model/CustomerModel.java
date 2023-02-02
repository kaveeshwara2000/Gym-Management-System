package lk.ijse.olympusFitnessCenter.model;

import lk.ijse.olympusFitnessCenter.db.DBConnection;
import lk.ijse.olympusFitnessCenter.to.Customer;
import lk.ijse.olympusFitnessCenter.to.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
            ArrayList<Customer> customers = new ArrayList<>();
            String sql = "SELECT * FROM Customer";
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );

                customers.add(customer);
            }
            return customers;
    }

    public static Customer getSelectedCustomer(String text) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer WHERE Cus_Id=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setObject(1,text);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Customer customer = new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
            return customer;
        }

        return null;
    }
}
