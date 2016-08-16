package proj.service;

import proj.entity.ValueOfIntegerProperties;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
public interface ValueOfIntegerPropertiesService {
    void save(Integer integerValue);
    ValueOfIntegerProperties findByIntegerValue(Integer integerValue);
    void delete(Integer integerValue);
    List<ValueOfIntegerProperties> findAll();
}
