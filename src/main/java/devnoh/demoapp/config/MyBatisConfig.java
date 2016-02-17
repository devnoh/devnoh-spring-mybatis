package devnoh.demoapp.config;

import com.mchange.v2.c3p0.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.springframework.core.io.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.orm.hibernate4.*;
import org.springframework.transaction.annotation.*;

import javax.sql.*;
import java.beans.*;
import java.util.*;

@Configuration
@EnableTransactionManagement
@ComponentScan({"devnoh.demoapp.dao"})
@PropertySource(value = {"classpath:application.properties"})
public class MyBatisConfig {

    @Autowired
    private Environment env;

    /**
     * http://www.mchange.com/projects/c3p0/
     * @return a pooled data source
     */
    public DataSource dataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
            dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            dataSource.setUser(env.getProperty("jdbc.username"));
            dataSource.setPassword(env.getProperty("jdbc.password"));
            dataSource.setInitialPoolSize(Integer.valueOf(env.getProperty("jdbc.initialPoolSize")));
            dataSource.setAcquireIncrement(Integer.valueOf(env.getProperty("jdbc.acquireIncrement")));
            dataSource.setMinPoolSize(Integer.valueOf(env.getProperty("jdbc.minPoolSize")));
            dataSource.setMaxPoolSize(Integer.valueOf(env.getProperty("jdbc.maxPoolSize")));
            dataSource.setMaxIdleTime(Integer.valueOf(env.getProperty("jdbc.maxIdleTime")));
            dataSource.setMaxStatements(Integer.valueOf(env.getProperty("jdbc.maxStatements")));
            dataSource.setPreferredTestQuery(env.getProperty("jdbc.testQuery"));
            dataSource.setIdleConnectionTestPeriod(Integer.valueOf(env.getProperty("jdbc.testPeriod")));
            dataSource.setTestConnectionOnCheckin(Boolean.valueOf(env.getProperty("jdbc.testOnCheckin")));
            dataSource.setTestConnectionOnCheckout(Boolean.valueOf(env.getProperty("jdbc.testOnCheckout")));
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("devnoh.demoapp.model");
        sessionFactory.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
        return sessionFactory;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
