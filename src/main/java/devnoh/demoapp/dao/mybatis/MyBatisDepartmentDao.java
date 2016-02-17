package devnoh.demoapp.dao.mybatis;

import devnoh.demoapp.dao.*;
import devnoh.demoapp.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("departmentDao")
public class MyBatisDepartmentDao extends BaseSqlSessionDaoSupport implements DepartmentDao {

    public Department insertDepartment(Department deptartment) {
        getSqlSession().insert("devnoh.demoapp.dao.mybatis.MyBatisDepartmentDao.insertDepartment", deptartment);
        return deptartment;
    }

    public Department updateDepartment(Department deptartment) {
        getSqlSession().update("devnoh.demoapp.dao.mybatis.MyBatisDepartmentDao.updateDepartment", deptartment);
        return  deptartment;
    }

    public void deleteDepartment(int deptNo) {
        getSqlSession().delete("devnoh.demoapp.dao.mybatis.MyBatisDepartmentDao.deleteDepartment", deptNo);
    }

    public Department getDepartment(int deptNo) {
        return (Department) getSqlSession().selectOne("devnoh.demoapp.dao.mybatis.MyBatisDepartmentDao.getDepartment", deptNo);
    }

    public List<Department> getAllDepartments() {
        return getSqlSession().selectList("devnoh.demoapp.dao.mybatis.MyBatisDepartmentDao.getAllDepartments");
    }
}
