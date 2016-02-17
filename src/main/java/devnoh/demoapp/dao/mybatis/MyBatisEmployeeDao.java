package devnoh.demoapp.dao.mybatis;

import devnoh.demoapp.dao.*;
import devnoh.demoapp.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("employeeDao")
public class MyBatisEmployeeDao extends MyBatisGenericDao<Employee, Integer> implements EmployeeDao {

    public List<Employee> findEmployeesByDeptNo(int deptNo) {
        return getSqlSession().selectList("devnoh.demoapp.dao.mybatis.MyBatisEmployeeDao.findEmployeesByDeptNo", deptNo);
    }
}
