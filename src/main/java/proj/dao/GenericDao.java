package proj.dao;

import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
public interface GenericDao<E,ID> {
    void save(E entity);
    void update(E entity);
    void delete(E entity);
    E find(ID id);
    List<E> findAll();
}
