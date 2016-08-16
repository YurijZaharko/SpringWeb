package proj.dao.implementation;

import proj.dao.CountryDao;
import proj.entity.Country;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class CountryDaoImplementation extends GenericDaoImplementation<Country, Integer> implements CountryDao{
    public CountryDaoImplementation(Class<Country> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
