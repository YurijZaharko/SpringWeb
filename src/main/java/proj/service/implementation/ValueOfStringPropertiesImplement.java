package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.ValueOfStringProperties;
import proj.repository.ValueOfStringPropertiesRepository;
import proj.service.ValueOfStringPropertiesService;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class ValueOfStringPropertiesImplement implements ValueOfStringPropertiesService{

    @Autowired
    ValueOfStringPropertiesRepository valueOfStringPropertiesRepository;
    @Override
    public void save(String stringValue) {
        valueOfStringPropertiesRepository.save(new ValueOfStringProperties(stringValue));
    }

    @Override
    public ValueOfStringProperties findByStringValue(String stringValue) {
        return valueOfStringPropertiesRepository.findByStringValue(stringValue);
    }

    @Override
    public void delete(String stringValue) {


    }

    @Override
    public List<ValueOfStringProperties> findAll() {
        return valueOfStringPropertiesRepository.findAll();
    }
}
