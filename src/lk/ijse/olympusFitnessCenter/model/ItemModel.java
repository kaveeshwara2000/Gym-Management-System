package lk.ijse.olympusFitnessCenter.model;

import com.jfoenix.controls.JFXTextField;
import lk.ijse.olympusFitnessCenter.db.DBConnection;
import lk.ijse.olympusFitnessCenter.to.Item;
import lk.ijse.olympusFitnessCenter.to.SaleDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static ArrayList<Item> getAllMembers() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM item";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Item item = new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );

            items.add(item);
        }
        return items;
    }

    public static Item getSelectedItem(String value) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item WHERE Code=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setObject(1,value);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Item item = new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
            return item;
        }

        return null;
    }
//date,time,tot,type,txtCusId
    public static boolean update(ArrayList<SaleDetails> orderDetails, String date, String time, String tot, String type, JFXTextField txtCusId) throws SQLException, ClassNotFoundException {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        try{
            int count=0;
            for (int i = 0; i < orderDetails.size(); i++) {
                PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("update item set Available_Qty=Available_Qty-? where code=?");
                statement.setObject(1,orderDetails.get(i).getQty());
                statement.setObject(2,orderDetails.get(i).getCode());
                statement.executeUpdate();
                count++;
            }
            if (count==orderDetails.size()){
                boolean orderDetails1 = orderDetails(orderDetails, date, time);
                if (orderDetails1) {
                    boolean addPayment = addPayment(txtCusId, date, type, tot);
                    if (addPayment) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }




    }

    private static boolean addPayment(JFXTextField txtCusId, String date, String type, String tot) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("insert into payment values (?,?,?,?,?)");
        statement.setObject(1,txtCusId);
        statement.setObject(2,txtCusId);
        statement.setObject(3,date);
        statement.setObject(4,type);
        statement.setObject(5,tot);
        int executeUpdate = statement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    private static boolean orderDetails(ArrayList<SaleDetails> orderDetails, String date, String time) throws SQLException, ClassNotFoundException {
        int count=0;
        for (int i = 0; i < orderDetails.size(); i++) {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("insert into sale_details values (?,?,?,?,?,?)");
            statement.setObject(1,orderDetails.get(i).getCode());
            statement.setObject(2,orderDetails.get(i).getCode());
            statement.setObject(3,orderDetails.get(i).getDescription());
            statement.setObject(4,orderDetails.get(i).getTotal());
            statement.setObject(5,date);
            statement.setObject(6,time);
            statement.executeUpdate();
            count++;
        }
        if (count==orderDetails.size()){
            return true;
        }
        return false;
    }
}
