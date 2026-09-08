import model.Emp;
import model.ItemDao;

import java.util.ArrayList;

public class AppMain {
    public static void main(String[] args) {

        ItemDao itemDao = new ItemDao();
        ArrayList<Emp> empList = itemDao.findAll();

        for (Emp emp : empList) {
            System.out.printf(
                    "EMPNO: %d, ENAME: %s, JOB: %s\n",
                    emp.getEmpNo(),
                    emp.getEName(),
                    emp.getJob());
        }
    }
}
