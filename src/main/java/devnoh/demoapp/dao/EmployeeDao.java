package devnoh.demoapp.dao;

import devnoh.demoapp.model.*;

import java.util.*;

public interface EmployeeDao  {

    Employee insertEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int empNo);

    Employee getEmployee(int empNo);

    List<Employee> getAllEmployees();

    List<Employee> findEmployeesByDeptNo(int deptNo);

}
