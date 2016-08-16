package proj.dao.implementation;

import proj.dao.GenericDao;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
public abstract class GenericDaoImplementation<E, ID> implements GenericDao<E, ID> {
    private final EntityManager entityManager;
    private final Class<E> entityClass;

    protected GenericDaoImplementation(Class<E> entityClass,EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    public void save(E entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(E entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public E find(ID id) {
        E entity = entityManager.find(entityClass, id);
        return entity;

    }

    public List findAll() {
        List<E> list = entityManager.createQuery(entityManager.getCriteriaBuilder().createQuery(entityClass)).getResultList();
        return list;
    }
}
