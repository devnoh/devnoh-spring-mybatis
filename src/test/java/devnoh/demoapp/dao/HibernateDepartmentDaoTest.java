package devnoh.demoapp.dao;

import devnoh.demoapp.model.*;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class HibernateDepartmentDaoTest extends AbstractDaoTest {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
        logger.debug("getDataSet... dept.xml");
        IDataSet dataSet = new XmlDataSet(this.getClass().getClassLoader().getResourceAsStream("dept.xml"));
        return dataSet;
    }

    @Test
    public void testGetAll() {
        logger.debug("testGetAll...");
        List<Department> depts = departmentDao.getAll();
        Assert.assertEquals(4, depts.size());
    }

    @Test
    public void testGet() {
        logger.debug("testGet...");
        Department dept = departmentDao.get(10);
        Assert.assertNotNull(dept);
        Assert.assertEquals(10, (long)dept.getDeptNo());
        Assert.assertEquals("ACCOUNTING", dept.getName());
        Assert.assertEquals("NEW YORK", dept.getLocation());
        Assert.assertNull(departmentDao.get(50));
    }

    @Test
    public void testInsert() {
        logger.debug("testInsert...");
        Department dept = new Department();
        dept.setDeptNo(50);
        dept.setName("IT");
        dept.setLocation("CERRITOS");
        dept = departmentDao.insert(dept);
        logger.debug(dept);
        Assert.assertTrue(dept.getDeptNo() == 50);
        List<Department> depts = departmentDao.getAll();
        Assert.assertEquals(5, depts.size());
    }

    @Test
    public void testUpdate() {
        logger.debug("testUpdate...");
        Department dept = departmentDao.get(10);
        dept.setName("IT");
        dept.setLocation("CERRITOS");
        departmentDao.update(dept);
        logger.debug(dept);
        Department dept2 = departmentDao.get(10);
        Assert.assertEquals("IT", dept2.getName());
        Assert.assertEquals("CERRITOS", dept2.getLocation());
    }

    @Test
    public void testDelete() {
        logger.debug("testDelete...");
        departmentDao.delete(10);
        Assert.assertNull(departmentDao.get(10));
        List<Department> depts = departmentDao.getAll();
        Assert.assertEquals(3, depts.size());
    }
}
