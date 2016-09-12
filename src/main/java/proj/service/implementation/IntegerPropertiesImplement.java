package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.entity.IntegerProperties;
import proj.repository.IntegerPropertiesRepository;
import proj.service.IntegerPropertiesService;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */
@Service
public class IntegerPropertiesImplement implements IntegerPropertiesService {
    @Autowired
    IntegerPropertiesRepository integerPropertiesRepository;

    @Override
    public void save(String name) {
        integerPropertiesRepository.save(new IntegerProperties(name));
    }

    @Override
    public IntegerProperties findByName(String name) {
        return integerPropertiesRepository.findByName(name);
    }

    @Override
    public void delete(String name) {
        integerPropertiesRepository.deleteByName(name);
    }

    @Override
    public List<IntegerProperties> findAll() {
        return integerPropertiesRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        integerPropertiesRepository.delete(id);
    }

    @Override
    public IntegerProperties findById(int id) {
        return integerPropertiesRepository.findOne(id);
    }

    @Override
    public void save(IntegerProperties integerProperties) {
        integerPropertiesRepository.save(integerProperties);
    }


}
