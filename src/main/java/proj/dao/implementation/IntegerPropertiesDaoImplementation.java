package proj.dao.implementation;

import proj.dao.IntegerPropertiesDao;
import proj.entity.IntegerProperties;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class IntegerPropertiesDaoImplementation extends GenericDaoImplementation<IntegerProperties, Integer> implements IntegerPropertiesDao{
    public IntegerPropertiesDaoImplementation(Class<IntegerProperties> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
