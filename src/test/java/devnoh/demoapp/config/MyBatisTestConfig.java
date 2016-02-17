package devnoh.demoapp.config;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.springframework.core.io.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.transaction.annotation.*;

import javax.sql.*;

@Configuration
@EnableTransactionManagement
@ComponentScan({"devnoh.demoapp.dao"})
@PropertySource(value = {"classpath:application-test.properties"})
public class MyBatisTestConfig {

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
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