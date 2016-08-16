package proj.service;

import proj.entity.StringProperties;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
public interface StringPropertiesService {
    void save(String name);
    StringProperties findByPropertyName(String name);
    void delete(String name);
    List<StringProperties> findAll();
}
