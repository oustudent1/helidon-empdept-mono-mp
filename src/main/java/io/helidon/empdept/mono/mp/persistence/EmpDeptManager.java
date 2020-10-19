package io.helidon.empdept.mono.mp.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class EmpDeptManager {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpDeptUnit");
    EntityManager em = emf.createEntityManager();

    public List<Employee> getAllEmployees() {
        // find all employees
        Query query = em.createQuery("select e from Employee e");
        return query.getResultList();
    }

    public Employee getEmployeeById(String id) {
        // find employee by id{

        return em.find(Employee.class, Long.parseLong("100"));
    }

    // save new Employee
    public Long saveEmployee(Employee newEmp) {
        em.getTransaction().begin();
        em.persist(newEmp);
        em.getTransaction().commit();
        newEmp = em.find(Employee.class, newEmp.getEmployeeId());
        return newEmp.getEmployeeId();
    }

    // Update emp
    public Employee updateEmployee(Employee newEmp) {
        em.getTransaction().begin();
        em.merge(newEmp);
        em.getTransaction().commit();
        return em.find(Employee.class, newEmp.getEmployeeId());
    }

    // Delete Emp
    public void deleteEmployee(Employee delEmp) {

        em.getTransaction().begin();
        em.remove(delEmp);
        em.getTransaction().commit();
    }

    // find all depts
    public List<Department> getDepartments() {
        Query query = em.createQuery("select d from Department d");
        return query.getResultList();
    }

    // find dept by id
    public Department getDepartmentById(String deptId) {

        return em.find(Department.class, Long.parseLong(deptId));
    }

    // Find and print all employees for a department by department id
    public List<Employee> getEmployeesByDepartment(String deptId) {

        return (List<Employee>) getDepartmentById(deptId).getEmployeesByDepartmentId();
    }

    // Find and print the sum of all the employee salaries for a department by department id.
    public Long getSalaryByDepartment(String deptId) {
    Department dept2 = em.find(Department.class, Long.parseLong(deptId));
        return dept2.getTotalSalary();
    }

}
