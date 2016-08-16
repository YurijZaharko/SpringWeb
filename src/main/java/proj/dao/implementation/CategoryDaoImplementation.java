package proj.dao.implementation;

import proj.dao.CategoryDao;
import proj.entity.Category;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class CategoryDaoImplementation extends GenericDaoImplementation<Category, Integer> implements CategoryDao {
    public CategoryDaoImplementation(Class<Category> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
