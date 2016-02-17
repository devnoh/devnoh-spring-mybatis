package devnoh.demoapp.dao.mybatis;

import devnoh.demoapp.dao.*;
import devnoh.demoapp.model.*;
import org.springframework.stereotype.*;

@Repository("departmentDao")
public class MyBatisDepartmentDao extends MyBatisGenericDao<Department, Integer> implements DepartmentDao {

}
