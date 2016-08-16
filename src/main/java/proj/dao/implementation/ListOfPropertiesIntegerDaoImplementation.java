package proj.dao.implementation;

import proj.dao.ListOfPropertiesIntegerDao;
import proj.entity.ListOfPropertiesInteger;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class ListOfPropertiesIntegerDaoImplementation extends GenericDaoImplementation<ListOfPropertiesInteger, Integer>  implements ListOfPropertiesIntegerDao {
    protected ListOfPropertiesIntegerDaoImplementation(Class<ListOfPropertiesInteger> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
