package proj.service;

import proj.entity.ValueOfStringProperties;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
public interface ValueOfStringPropertiesService {
    void save(String stringValue);

    void save(ValueOfStringProperties valueOfStringProperties);

    ValueOfStringProperties findByStringValue(String stringValue);

    ValueOfStringProperties findById(int id);

    void delete(String stringValue);

    List<ValueOfStringProperties> findAll();
}
