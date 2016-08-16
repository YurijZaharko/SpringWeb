package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.ValueOfIntegerProperties;
import proj.repository.ValueOfIntegerPropertiesRepository;
import proj.service.ValueOfIntegerPropertiesService;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class ValueOfIntegerPropertiesImplement implements ValueOfIntegerPropertiesService {
    @Autowired
    ValueOfIntegerPropertiesRepository valueOfIntegerPropertiesRepository;
    @Override
    public void save(Integer integerValue) {
        valueOfIntegerPropertiesRepository.save(new ValueOfIntegerProperties(integerValue));
    }

    @Override
    public ValueOfIntegerProperties findByIntegerValue(Integer integerValue) {
        return valueOfIntegerPropertiesRepository.findOne(integerValue);
    }

    @Override
    public void delete(Integer integerValue) {

    }

    @Override
    public List<ValueOfIntegerProperties> findAll() {
        return null;
    }
}
