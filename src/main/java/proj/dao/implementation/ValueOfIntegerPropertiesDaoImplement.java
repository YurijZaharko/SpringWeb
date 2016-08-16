package proj.dao.implementation;

import proj.dao.ValueOfIntegerPropertiesDao;
import proj.entity.ValueOfIntegerProperties;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class ValueOfIntegerPropertiesDaoImplement extends GenericDaoImplementation<ValueOfIntegerProperties, Integer> implements ValueOfIntegerPropertiesDao{
    public ValueOfIntegerPropertiesDaoImplement(Class<ValueOfIntegerProperties> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
