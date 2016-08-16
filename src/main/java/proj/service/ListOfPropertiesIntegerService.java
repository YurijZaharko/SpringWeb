package proj.service;

import proj.entity.ListOfPropertiesInteger;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
public interface ListOfPropertiesIntegerService {
    void save(String name);
    ListOfPropertiesInteger findByCategoryName(String name);
    void delete(String name);
    List<ListOfPropertiesInteger> findAll();
}
