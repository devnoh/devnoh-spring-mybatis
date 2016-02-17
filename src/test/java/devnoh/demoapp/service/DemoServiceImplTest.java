package devnoh.demoapp.service;

import devnoh.demoapp.config.*;
import devnoh.demoapp.dao.*;
import devnoh.demoapp.model.*;
import org.apache.logging.log4j.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import java.util.*;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {SpringTestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class) //@RunWith(MockitoJUnitRunner.class)
public class DemoServiceImplTest {

    protected Logger logger = LogManager.getLogger(getClass());

    @Mock
    DepartmentDao departmentDao;

    @Mock
    EmployeeDao employeeDao;

    @Mock
    Department department;

    @Mock
    Employee employee;

    @InjectMocks
    DemoServiceImpl demoService;

    @Spy
    List<Employee> employees  = new ArrayList<Employee>();

    @Spy
    List<Department> departments = new ArrayList<Department>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // departments
        Department dept = new Department();
        dept.setDeptNo(10);
        dept.setName("DEPT1");
        departments.add(dept);
        dept = new Department();
        dept.setDeptNo(20);
        dept.setName("DEPT2");
        departments.add(dept);

        // employees
        Employee emp = new Employee();
        emp.setEmpNo(9001);
        emp.setName("EMP1");
        emp.setDepartment(departments.get(0));
        employees.add(emp);
        emp = new Employee();
        emp.setEmpNo(9002);
        emp.setDepartment(departments.get(0));
        emp.setName("EMP2");
        employees.add(emp);
    }

    @Test
    public void testInsertDepartment() {
        logger.debug("testInsertDepartment...");
        Department dept = new Department();
        dept.setDeptNo(10);
        when(departmentDao.insertDepartment(dept)).thenReturn(dept);
        Assert.assertEquals(demoService.insertDepartment(dept), dept);
    }

    @Test
    public void testUpdateDepartment() {
        logger.debug("testUpdateDepartment...");
        Department dept = new Department();
        dept.setDeptNo(10);
        when(departmentDao.updateDepartment(dept)).thenReturn(dept);
        Assert.assertEquals(demoService.updateDepartment(dept), dept);
    }

    @Test
    public void testDeleteDepartment() {
        logger.debug("testDeleteDepartment...");
        doNothing().when(departmentDao).deleteDepartment(50);
        demoService.deleteDepartment(50);
        verify(departmentDao, atLeastOnce()).deleteDepartment(50);
    }

    @Test
    public void testGetDepartment() {
        logger.debug("testGetDepartment...");
        Department dept = new Department();
        dept.setDeptNo(10);
        when(departmentDao.getDepartment(anyInt())).thenReturn(dept);
        Assert.assertEquals(demoService.getDepartment(dept.getDeptNo()), dept);
    }

    @Test
    public void testGetAllDepartments() {
        logger.debug("testGetAllDepartments...");
        when(departmentDao.getAllDepartments()).thenReturn(departments);
        Assert.assertEquals(departments, demoService.getAllDepartments());
        verify(departmentDao, times(1)).getAllDepartments();
    }

    @Test
    public void testInsertEmployee() {
        logger.debug("testInsertEmployee...");
        Employee emp = new Employee();
        emp.setEmpNo(9000);
        when(employeeDao.insertEmployee(emp)).thenReturn(emp);
        Assert.assertEquals(emp, demoService.insertEmployee(emp));
    }

    @Test
    public void testUpdateEmployee() {
        logger.debug("testUpdateEmployee...");
        Employee emp = new Employee();
        emp.setEmpNo(9000);
        when(employeeDao.updateEmployee(emp)).thenReturn(emp);
        Assert.assertEquals(emp, demoService.updateEmployee(emp));
    }

    @Test
    public void testDeleteEmployee() {
        logger.debug("testDeleteEmployee...");
        doNothing().when(employeeDao).deleteEmployee(9000);
        demoService.deleteEmployee(9000);
        verify(employeeDao, atLeastOnce()).deleteEmployee(9000);
    }

    @Test
    public void testGetEmployee() {
        logger.debug("testGetEmployee...");
        Employee emp = new Employee();
        emp.setEmpNo(9000);
        when(employeeDao.getEmployee(anyInt())).thenReturn(emp);
        Assert.assertEquals(emp, demoService.getEmployee(emp.getEmpNo()));
    }

    @Test
    public void testGetAllEmployees() {
        logger.debug("testGetAllEmployees...");
        when(employeeDao.getAllEmployees()).thenReturn(employees);
        Assert.assertEquals(employees, demoService.getAllEmployees());
        verify(employeeDao, times(1)).getAllEmployees();
    }

    @Test
    public void testFindEmployeesByDeptNo() {
        logger.debug("testFindEmployeesByDeptNo...");
        when(employeeDao.findEmployeesByDeptNo(10)).thenReturn(employees);
        Assert.assertEquals(employees, demoService.findEmployeesByDeptNo(10));
        verify(employeeDao, times(1)).findEmployeesByDeptNo(10);
    }
}