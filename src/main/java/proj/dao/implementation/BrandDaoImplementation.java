package proj.dao.implementation;

import proj.dao.BrandDao;
import proj.entity.Brand;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class BrandDaoImplementation extends GenericDaoImplementation<Brand, Integer> implements BrandDao{
    public BrandDaoImplementation(Class<Brand> entityClass, EntityManager entityManager) {
        super(Brand.class, entityManager);
    }
}
