package io.helidon.empdept.mono.mp;

import io.helidon.empdept.mono.mp.persistence.Department;
import io.helidon.empdept.mono.mp.persistence.EmpDeptManager;
import io.helidon.empdept.mono.mp.persistence.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestJPA {

    private static EmpDeptManager edMgr = new EmpDeptManager();

    public static void main(String[] args) {

        System.out.println("All Emps " + edMgr.getAllEmployees());

        System.out.println("Emp by id " + edMgr.getEmployeeById("100"));

        Department dept1 = edMgr.getDepartmentById("60");
        Employee  newEmp = new Employee(1023, "h", "t", "hst11", "415", Date.valueOf(LocalDate.now()), 1200L, .1, "AC_MGR", dept1);
        newEmp.setDepartmentsByDepartmentId(dept1);
        System.out.println("Save " + edMgr.saveEmployee(newEmp));

        newEmp.setFirstName("Demo");
        System.out.println("Update " + edMgr.updateEmployee(newEmp));

        System.out.println("Delete Emp ");
        edMgr.deleteEmployee(newEmp);

        System.out.println("Departments " + edMgr.getDepartments());

        System.out.println("Department by Id" + edMgr.getDepartmentById("60"));

        System.out.println("Dept Salary "+ edMgr.getSalaryByDepartment("60"));

        System.out.println("Employees for Department " + edMgr.getEmployeesByDepartment("60"));



/*


h)

i)


 */

    }
}
