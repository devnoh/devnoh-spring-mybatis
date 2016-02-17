package devnoh.demoapp.dao;

import devnoh.demoapp.config.*;
import org.apache.logging.log4j.*;
import org.dbunit.database.*;
import org.dbunit.dataset.*;
import org.dbunit.operation.*;
import org.h2.tools.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import javax.sql.*;
import java.io.*;
import java.nio.charset.*;
import java.sql.*;

//@ContextConfiguration({"classpath:spring-context-test.xml"})
@ContextConfiguration(classes = {MyBatisTestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    protected Logger logger = LogManager.getLogger(getClass());

    @Autowired
    protected DataSource dataSource;

//    @BeforeClass
//    public static void createSchema() throws Exception {
//        RunScript.execute("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE", "sa", "",
//                "src/test/resources/schema.sql", Charset.defaultCharset(), false);
//    }

    @Before
    public void setUp() throws Exception {
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(dataSource);
        InputStream is = getClass().getResourceAsStream("/schema.sql");
        RunScript.execute(dbConn.getConnection(), new InputStreamReader(is));
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }

    protected abstract IDataSet getDataSet() throws Exception;
}
