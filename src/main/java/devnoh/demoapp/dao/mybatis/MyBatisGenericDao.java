package devnoh.demoapp.dao.mybatis;

import devnoh.demoapp.dao.*;
import org.apache.ibatis.session.*;
import org.mybatis.spring.support.*;
import org.springframework.beans.factory.annotation.*;

import java.io.*;
import java.util.*;

public class MyBatisGenericDao<T, PK extends Serializable> extends SqlSessionDaoSupport implements GenericDao<T, PK> {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<T> getAll() {
        return getSqlSession().selectList(this.getClass().getName() + ".getAll");
    }

    public T get(PK id) {
        return (T) getSqlSession().selectOne(this.getClass().getName() + ".get", id);
    }

    public T insert(T entity) {
        getSqlSession().insert(this.getClass().getName() + ".insert", entity);
        return entity;
    }

    public T update(T entity) {
        getSqlSession().insert(this.getClass().getName() + ".update", entity);
        return entity;
    }

    public void delete(PK id) {
        getSqlSession().insert(this.getClass().getName() + ".delete", id);
    }

    public boolean exists(PK id) {
        return get(id) != null;
    }
}
