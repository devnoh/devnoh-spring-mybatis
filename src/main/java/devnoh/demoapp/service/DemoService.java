package devnoh.demoapp.service;

import devnoh.demoapp.model.*;

import java.util.*;

public interface DemoService {

    //
    // Department
    //

    Department insertDepartment(Department deptartment);

    Department updateDepartment(Department deptartment);

    void deleteDepartment(int deptNo);

    Department getDepartment(int deptNo);

    List<Department> getAllDepartments();

    //
    // Employee
    //

    Employee insertEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int empNo);

    Employee getEmployee(int empNo);

    List<Employee> getAllEmployees();

    List<Employee> findEmployeesByDeptNo(int deptNo);

}
