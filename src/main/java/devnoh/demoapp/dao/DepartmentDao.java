package devnoh.demoapp.dao;

import devnoh.demoapp.model.*;

import java.util.*;

public interface DepartmentDao {

    Department insertDepartment(Department deptartment);

    Department updateDepartment(Department deptartment);

    void deleteDepartment(int deptNo);

    Department getDepartment(int deptNo);

    List<Department> getAllDepartments();

}
