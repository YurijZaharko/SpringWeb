package proj.dao.implementation;

import proj.dao.ProductDao;
import proj.entity.Product;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class ProductDaoImplementation extends GenericDaoImplementation<Product, Integer> implements ProductDao{
    public ProductDaoImplementation(Class<Product> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
