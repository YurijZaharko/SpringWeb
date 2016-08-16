package proj.service;

import proj.entity.ValueOfStringProperties;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
public interface ValueOfStringPropertiesService {
    void save(String stringValue);
    ValueOfStringProperties findByStringValue(String stringValue);
    void delete(String stringValue);
    List<ValueOfStringProperties> findAll();
}
