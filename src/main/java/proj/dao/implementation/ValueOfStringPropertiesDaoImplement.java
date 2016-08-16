package proj.dao.implementation;

import proj.dao.ValueOfStringPropertiesDao;
import proj.entity.ValueOfStringProperties;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class ValueOfStringPropertiesDaoImplement extends GenericDaoImplementation<ValueOfStringProperties, Integer> implements ValueOfStringPropertiesDao {
    public ValueOfStringPropertiesDaoImplement(Class<ValueOfStringProperties> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
