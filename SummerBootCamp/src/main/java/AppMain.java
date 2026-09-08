import model.Emp;
import model.EmpDao;

import java.sql.SQLException;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        EmpDao empDao = new EmpDao();
        try {
            List<Emp> empList = empDao.findAll();

            for (Emp emp : empList) {
                System.out.printf(
                        "EMPNO: %d, ENAME: %s, JOB: %s\n",
                        emp.getEmpNo(),
                        emp.getEName(),
                        emp.getJob());
            }

        } catch (SQLException e){
            System.out.println("従業員情報の取得に失敗しました");
            System.out.println(e.getMessage());
        }
    }
}
