package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import proj.entity.StringProperties;
import proj.form.Filter.CategoryFilterForm;
import proj.repository.CategoryRepository;
import proj.repository.StringPropertiesRepository;
import proj.service.StringPropertiesService;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class StringPropertiesImplement implements StringPropertiesService {
    @Autowired
    StringPropertiesRepository stringPropertiesRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save(String name) {
        stringPropertiesRepository.save(new StringProperties(name));
    }

    @Override
    public StringProperties findByPropertyName(String name) {
        return stringPropertiesRepository.findByPropertyName(name);
    }

    @Override
    public void delete(String name) {
        stringPropertiesRepository.deleteByName(name);
    }

    @Override
    public List<StringProperties> findAll() {
        return stringPropertiesRepository.findAll();
    }

    @Override
    public StringProperties findById(int id) {
        return stringPropertiesRepository.findById(id);
    }

    @Override
    public void save(StringProperties stringProperties) {
        stringPropertiesRepository.save(stringProperties);
    }

    @Override
    public void deleteById(int id) {
        stringPropertiesRepository.delete(id);
    }

    @Override
    public List<StringProperties> findByCategoryId(int id) {
        return stringPropertiesRepository.findByCategoryId(id);
    }

    @Override
    public List<StringProperties> findCategoryWithStringProperty(Pageable pageable, CategoryFilterForm categoryFilterForm, int id) {
        List<StringProperties> stringPropertiesList = categoryRepository.findByIdWithAllFetch(id).getStringPropertiesList();
        List<StringProperties> temp = stringPropertiesRepository.findAll();
        temp.removeAll(stringPropertiesList);
        return temp;
    }

    @Override
    public List<StringProperties> findByProductId(int id) {
//        stringPropertiesRepository.findByProductId(id);
        return null;
    }

}
