package io.helidon.empdept.mono.mp.persistence;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@Entity
@Table(name = "DEPARTMENTS", schema = "HR")
public class Department {
    private long departmentId;
    private String departmentName;
    private Collection<Employee> employeesByDepartmentId;
    private long totalSalary = 0;

    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false, precision = 0)
    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName);
    }

    @JsonbTransient
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "departmentsByDepartmentId")
    public Collection<Employee> getEmployeesByDepartmentId() {
        return employeesByDepartmentId;
    }

    public void setEmployeesByDepartmentId(Collection<Employee> employeesByDepartmentId) {
        this.employeesByDepartmentId = employeesByDepartmentId;
    }
    @Transient
    public long getTotalSalary(){
        totalSalary = 0;
        // stream
        totalSalary = employeesByDepartmentId.stream()
                .mapToLong(e -> e.getSalary())
                .sum();

        return totalSalary;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
               // ", employeesByDepartmentId=" + employeesByDepartmentId +
                '}';
    }
}
