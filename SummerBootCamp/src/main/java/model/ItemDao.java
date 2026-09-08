package model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDao {

    public ArrayList<Emp> findAll() {

        String sql =
                "SELECT EMPNO, ENAME, JOB "
                        + "FROM EMP "
                        + "ORDER BY EMPNO";

        ArrayList<Emp> empList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
                DbConfig.URL,
                DbConfig.USER,
                DbConfig.PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Emp emp = new Emp();
                emp.setEmpNo(resultSet.getInt("EMPNO"));
                emp.setEName(resultSet.getString("ENAME"));
                emp.setJob(resultSet.getString("JOB"));

                empList.add(emp);
            }


        } catch (SQLException e) {
            System.out.println("SELECT 実行時にエラーが発生しました");
            System.out.println(e.getMessage());
        }

        return empList;
    }
}

