package io.helidon.empdept.mono.mp.persistence;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
@Entity
@Table(name = "EMPLOYEES", schema = "HR")
public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Long salary;
    private Double commissionPct;
    private String jobId;
   // private Long departmentId;
    private Department departmentsByDepartmentId;

    public Employee(long employeeId, String firstName, String lastName, String email, String phoneNumber,
                    Date hireDate, Long salary, Double commissionPct,  String jobId, Department departmentsByDepartmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
       // System.out.println("COmm pct = " + commissionPct);
        this.jobId = jobId;
       // this.departmentId = departmentId;
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    public Employee() {
    }

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "HIRE_DATE", nullable = false)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "SALARY", nullable = true, precision = 2)
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "COMMISSION_PCT", nullable = true, precision = 2)
    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Basic
    @Column(name = "JOB_ID", nullable = true, precision = 2)
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /*    //@Basic
    //@Column(name = "DEPARTMENT_ID", nullable = true, precision = 0)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(commissionPct, employee.commissionPct);

    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct);
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", table = "EMPLOYEES")
    public Department getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(Department departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    @Override
    public String toString() {
        long deptId = departmentsByDepartmentId ==null ? 0: departmentsByDepartmentId.getDepartmentId();
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", dept id = " + deptId +
                //", departmentsByDepartmentId=" + departmentsByDepartmentId.getDepartmentName() +
                '}';
    }
}
