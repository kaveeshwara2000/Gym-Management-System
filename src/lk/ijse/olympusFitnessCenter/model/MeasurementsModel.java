package lk.ijse.olympusFitnessCenter.model;

import lk.ijse.olympusFitnessCenter.to.Measurements;
import lk.ijse.olympusFitnessCenter.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MeasurementsModel {
    public static Measurements getSelectedMember(String value) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM body_measurements WHERE M_Id = ?";
        ResultSet resultSet = CrudUtil.execute(sql, value);

        if (resultSet.next()) {
            return new Measurements(
                    resultSet.getDouble(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6)

            );
        }
        return new Measurements(0,0,0,0,0);
    }

    public static boolean update(Measurements measurements) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE body_measurements SET Height = ?, Weight = ?, Chest = ?, Arm = ?, Waist = ? WHERE M_Id = ?";
        boolean resultSet = CrudUtil.execute(sql,measurements.getHeight(),measurements.getWeight(),measurements.getChest(),measurements.getArm(),measurements.getWaist(),measurements.getId());
        if (resultSet){
            return true;
        }
        return false;
    }

    public static boolean add(Measurements measurements) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO body_measurements VALUES(?,?,?,?,?,?)";
        boolean resultSet = CrudUtil.execute(sql,measurements.getId(),measurements.getHeight(),measurements.getWeight(),measurements.getChest(),measurements.getArm(),measurements.getWaist());
        if (resultSet){
            return true;
        }
        return false;
    }
}
