package devnoh.demoapp.model;

import java.io.*;
import java.util.*;

public class Department extends BaseObject {

    private Integer deptNo;
    private String name;
    private String location;
    private Integer empCount;
    public List<Employee> employees = new ArrayList<Employee>();

    public Department() {
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Integer empCount) {
        this.empCount = empCount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return deptNo == that.deptNo;
    }

    @Override
    public int hashCode() {
        int result = deptNo.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptNo=" + deptNo +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", empCount='" + empCount + '\'' +
                '}';
    }
}
