package proj.dao.implementation;

import proj.dao.StringPropertiesDao;
import proj.entity.StringProperties;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class StringPropertiesDaoImplementation extends GenericDaoImplementation<StringProperties, Integer> implements StringPropertiesDao {
    public StringPropertiesDaoImplementation(Class<StringProperties> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
