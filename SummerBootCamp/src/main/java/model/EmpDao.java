package model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    public List<Emp> findAll() throws SQLException {

        String sql =
                "SELECT EMPNO, ENAME, JOB "
                        + "FROM EMP "
                        + "ORDER BY EMPNO";

        List<Emp> empList = new ArrayList<>();

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
        }

        return empList;
    }
}

