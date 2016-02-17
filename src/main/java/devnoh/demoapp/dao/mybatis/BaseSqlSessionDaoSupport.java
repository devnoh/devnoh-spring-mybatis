package devnoh.demoapp.dao.mybatis;

import org.apache.ibatis.session.*;
import org.mybatis.spring.*;
import org.mybatis.spring.support.*;
import org.springframework.beans.factory.annotation.*;

public class BaseSqlSessionDaoSupport extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
