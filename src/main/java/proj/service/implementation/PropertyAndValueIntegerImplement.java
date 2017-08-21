package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.PropertyAndValueInteger;
import proj.repository.CategoryRepository;
import proj.repository.PropertyAndValueIntegerRepository;
import proj.service.PropertyAndValueIntegerService;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class PropertyAndValueIntegerImplement implements PropertyAndValueIntegerService {
    @Autowired
    PropertyAndValueIntegerRepository propertyAndValueIntegerRepository;
    @Autowired
    CategoryRepository categoryRepository;

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
}
