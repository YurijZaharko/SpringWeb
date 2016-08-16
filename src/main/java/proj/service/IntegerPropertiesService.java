package proj.service;

import proj.entity.IntegerProperties;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */
public interface IntegerPropertiesService {
    void save(String name);
    IntegerProperties findByName(String name);
    void delete(String name);
    List<IntegerProperties> findAll();
}
