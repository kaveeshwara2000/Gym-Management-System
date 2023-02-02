package lk.ijse.olympusFitnessCenter.model;

import lk.ijse.olympusFitnessCenter.db.DBConnection;
import lk.ijse.olympusFitnessCenter.to.Member;
import lk.ijse.olympusFitnessCenter.to.Trainer;
import lk.ijse.olympusFitnessCenter.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainerModel {
    public static Trainer getSelectedTrainer(String value) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM trainer WHERE T_Id = ?";
        ResultSet resultSet = CrudUtil.execute(sql, value);

        if (resultSet.next()) {
            return new Trainer(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        }
        return null;
    }

    public static boolean deleteTrainer(Trainer trainer) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM member WHERE T_Id = ?";
        boolean result = CrudUtil.execute(sql,trainer.getId());
        if(result){
            return true;
        }
        return false;
    }

    public static ArrayList<Trainer> getAllTrainers() throws SQLException, ClassNotFoundException {
        ArrayList<Trainer> trainers = new ArrayList<>();
        String sql = "SELECT * FROM trainer";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Trainer trainer = new Trainer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );

            trainers.add(trainer);
        }
        return trainers;
    }
}
