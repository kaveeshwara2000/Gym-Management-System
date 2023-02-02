package lk.ijse.olympusFitnessCenter.model;

import lk.ijse.olympusFitnessCenter.db.DBConnection;
import lk.ijse.olympusFitnessCenter.to.Member;
import lk.ijse.olympusFitnessCenter.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberModel {
    public static ArrayList<Member> getAllMembers() throws SQLException, ClassNotFoundException {
        ArrayList<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM member";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Member member = new Member(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8));

            members.add(member);
        }
        return members;
    }

    public static Member getSelectedMember(String value) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM member WHERE M_Id = ?";
        ResultSet resultSet = CrudUtil.execute(sql, value);

        if (resultSet.next()) {
            return new Member(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        }
        return null;
    }

    public static boolean deleteMember(Member member) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM member WHERE M_Id = ?";
        boolean result = CrudUtil.execute(sql,member.getId());
        if(result){
            return true;
        }
        return false;
    }

    public static boolean updateMember(Member member) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE member SET Name = ?, Contact_No = ?, Join_Date = ?, NIC = ?, DOB = ?, Address = ?, Gender = ? WHERE M_Id = ?";
        boolean result = CrudUtil.execute(sql,member.getName(),member.getContactNo(),member.getJoinDate(),member.getNIC(),member.getDOB(),member.getAddress(),member.getGender(),member.getId());
        if(result){
            return true;
        }
        return false;
    }
}
