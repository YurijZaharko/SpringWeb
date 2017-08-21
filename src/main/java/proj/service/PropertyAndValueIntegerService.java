package proj.service;

import proj.entity.PropertyAndValueInteger;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
public interface PropertyAndValueIntegerService {
    void save();
    PropertyAndValueInteger findByCategoryName(String name);
    void delete(String name);
    List<PropertyAndValueInteger> findAll();
}
