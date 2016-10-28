package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.PropertyAndValueInteger;
import proj.entity.PropertyAndValueString;
import proj.repository.PropertyAndValueStringRepository;
import proj.service.PropertyAndValueStringService;

import java.util.List;

/**
 * Created by SCIP on 19.08.2016.
 */
@Service
public class PropertyAndValueStringImplement implements PropertyAndValueStringService {
    @Autowired
    PropertyAndValueStringRepository propertyAndValueStringRepository;

    @Override
    public void save() {

    }

    @Override
    public PropertyAndValueInteger findByCategoryName(String name) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<PropertyAndValueInteger> findAll() {
        return null;
    }

    @Override
    public PropertyAndValueString findById(int id) {
        return propertyAndValueStringRepository.findById(id);
    }

    @Override
    public PropertyAndValueString findByIdWithValue(int id) {
        return propertyAndValueStringRepository.findByIdWithValue(id);
    }


}
