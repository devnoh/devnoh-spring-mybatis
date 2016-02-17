package devnoh.demoapp.dao.mybatis;

import devnoh.demoapp.dao.*;
import devnoh.demoapp.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("employeeDao")
public class MyBatisEmployeeDao extends BaseSqlSessionDaoSupport implements EmployeeDao {

    public Employee insertEmployee(Employee employee) {
        getSqlSession().insert("devnoh.demoapp.dao.mybatis.MyBatisEmployeeDao.insertEmployee", employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        getSqlSession().update("devnoh.demoapp.dao.mybatis.MyBatisEmployeeDao.updateEmployee", employee);
        return employee;
    }

    public void deleteEmployee(int empNo) {
        getSqlSession().delete("devnoh.demoapp.dao.mybatis.MyBatisEmployeeDao.deleteEmployee", empNo);
    }

    public Employee getEmployee(int empNo) {
        return (Employee) getSqlSession().selectOne("devnoh.demoapp.dao.mybatis.MyBatisEmployeeDao.getEmployee", empNo);
    }

    public List<Employee> getAllEmployees() {
        return getSqlSession().selectList("devnoh.demoapp.dao.mybatis.MyBatisEmployeeDao.getAllEmployees");
    }

    public List<Employee> findEmployeesByDeptNo(int deptNo) {
        return getSqlSession().selectList("devnoh.demoapp.dao.mybatis.MyBatisEmployeeDao.findEmployeesByDeptNo", deptNo);
    }
}
