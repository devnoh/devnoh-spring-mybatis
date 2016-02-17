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
        return departmentDao.insert(deptartment);
    }

    public Department updateDepartment(Department deptartment) {
        return departmentDao.update(deptartment);
    }

    public void deleteDepartment(int deptNo) {
        departmentDao.delete(deptNo);
    }

    public Department getDepartment(int deptNo) {
        return departmentDao.get(deptNo);
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAll();
    }

    //
    // Employee
    //

    public Employee insertEmployee(Employee employee) {
        return employeeDao.insert(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }

    public void deleteEmployee(int empNo) {
        employeeDao.delete(empNo);
    }

    public Employee getEmployee(int empNo) {
        return employeeDao.get(empNo);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    public List<Employee> findEmployeesByDeptNo(int deptNo) {
        return employeeDao.findEmployeesByDeptNo(deptNo);
    }
}
