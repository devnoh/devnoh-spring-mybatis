package devnoh.demoapp.dao;

import java.io.*;
import java.util.*;

public interface GenericDao<T, PK extends Serializable> {

    public List<T> getAll();

    public T get(PK id);

    public T insert(T entity);

    public T update(T entity);

    public void delete(PK id);

    public boolean exists(PK id);

}
