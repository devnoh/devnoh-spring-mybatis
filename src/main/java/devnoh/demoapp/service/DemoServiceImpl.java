package devnoh.demoapp.service;

import devnoh.demoapp.dao.*;
import devnoh.demoapp.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service("demoService")
@Transactional
public class DemoServiceImpl implements DemoService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //
    // Department
    //

    public Department insertDepartment(Department deptartment) {
        return departmentDao.insertDepartment(deptartment);
    }

    public Department updateDepartment(Department deptartment) {
        return departmentDao.updateDepartment(deptartment);
    }

    public void deleteDepartment(int deptNo) {
        departmentDao.deleteDepartment(deptNo);
    }

    public Department getDepartment(int deptNo) {
        return departmentDao.getDepartment(deptNo);
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    //
    // Employee
    //

    public Employee insertEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int empNo) {
        employeeDao.deleteEmployee(empNo);
    }

    public Employee getEmployee(int empNo) {
        return employeeDao.getEmployee(empNo);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public List<Employee> findEmployeesByDeptNo(int deptNo) {
        return employeeDao.findEmployeesByDeptNo(deptNo);
    }
}
