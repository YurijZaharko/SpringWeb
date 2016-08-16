package proj.dao.implementation;

import proj.entity.ListOfPropertiesString;

import javax.persistence.EntityManager;

/**
 * Created by SCIP on 31.07.2016.
 */
public class ListOfPropertiesStringDaoImplementation extends GenericDaoImplementation<ListOfPropertiesString,Integer> {
    protected ListOfPropertiesStringDaoImplementation(Class<ListOfPropertiesString> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
