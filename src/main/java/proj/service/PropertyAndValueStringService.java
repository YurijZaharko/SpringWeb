package proj.service;

import proj.entity.PropertyAndValueString;

/**
 * Created by SCIP on 19.08.2016.
 */
public interface PropertyAndValueStringService {

    void save();

    PropertyAndValueString findById(int id);

    PropertyAndValueString findByIdWithValue(int id);
}
