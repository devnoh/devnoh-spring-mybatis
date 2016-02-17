package devnoh.demoapp.dao;

import devnoh.demoapp.model.*;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.*;
import org.joda.time.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class HibernateEmployeeDaoTest extends AbstractDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet[] datasets = new IDataSet[]{
                new XmlDataSet(this.getClass().getClassLoader().getResourceAsStream("dept.xml")),
                new XmlDataSet(this.getClass().getClassLoader().getResourceAsStream("emp.xml"))
        };
        return new CompositeDataSet(datasets);
    }

    @Test
    public void testGetAll() {
        logger.debug("testGetAll...");
        List<Employee> emps = employeeDao.getAllEmployees();
        Assert.assertEquals(emps.size(), 14);
    }

    @Test
    public void testGet() {
        logger.debug("testGet...");
        Employee emp = employeeDao.getEmployee(7369);
        Assert.assertNotNull(emp);
        Assert.assertEquals(7369, (int) emp.getEmpNo());
        Assert.assertEquals("SMITH", emp.getName());
        Assert.assertEquals("CLERK", emp.getJob());
        Assert.assertEquals(7902, (int) emp.getMgrNo());
        Assert.assertEquals(new DateTime(1980, 12, 17, 0, 0, 0).toDate().getTime(), emp.getHireDate().getTime());
        Assert.assertEquals(800d, emp.getSalary(), 0);
        Assert.assertNull(emp.getCommission());
        Assert.assertEquals(20, (int) emp.getDepartment().getDeptNo());
        Assert.assertNull(employeeDao.getEmployee(9900));
    }

    @Test
    public void testInsert() {
        logger.debug("testInsert...");
        Employee emp = new Employee();
        emp.setEmpNo(9001);
        emp.setName("SEHWAN");
        emp.setJob("DEVELOPER");
        emp.setSalary(1000d);
        emp = employeeDao.insertEmployee(emp);
        logger.debug(emp);
        Assert.assertTrue(emp.getEmpNo() == 9001);
        List<Employee> emps = employeeDao.getAllEmployees();
        Assert.assertEquals(15, emps.size());
    }

    @Test
    public void testUpdate() {
        logger.debug("testUpdate...");
        Employee emp = employeeDao.getEmployee(7369);
        emp.setName("SEHWAN");
        emp.setJob("DEVELOPER");
        emp.setSalary(1000d);
        employeeDao.updateEmployee(emp);
        logger.debug(emp);
        Employee emp2 = employeeDao.getEmployee(7369);
        Assert.assertEquals("SEHWAN", emp2.getName());
        Assert.assertEquals("DEVELOPER", emp2.getJob());
        Assert.assertTrue(1000d == emp2.getSalary());
    }

    @Test
    public void testDelete() {
        logger.debug("testDelete...");
        employeeDao.deleteEmployee(7369);
        Assert.assertNull(employeeDao.getEmployee(7369));
        List<Employee> emps = employeeDao.getAllEmployees();
        Assert.assertEquals(13, emps.size());
    }

    @Test
    public void testFindEmployeesByDeptNo() {
        logger.debug("testFindEmployeesByDeptNo...");
        List<Employee> emps = employeeDao.findEmployeesByDeptNo(10);
        Assert.assertEquals(3, emps.size());
    }
}
