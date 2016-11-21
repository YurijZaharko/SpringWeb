package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import proj.entity.Product;
import proj.entity.PropertyAndValueString;
import proj.entity.StringProperties;
import proj.entity.ValueOfStringProperties;
import proj.form.Filter.CategoryFilterForm;
import proj.form.PropertyAndValueStringsForm;
import proj.repository.CategoryRepository;
import proj.repository.ProductRepository;
import proj.repository.PropertyAndValueStringRepository;
import proj.repository.StringPropertiesRepository;
import proj.service.StringPropertiesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class StringPropertiesImplement implements StringPropertiesService {
    @Autowired
    StringPropertiesRepository stringPropertiesRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PropertyAndValueStringRepository propertyAndValueStringRepository;

    @Autowired
    ProductRepository productRepository;

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
        List<StringProperties> stringPropertiesList = stringPropertiesRepository.findByProductId(id);
        for (StringProperties sp : stringPropertiesList) {
            List<PropertyAndValueString> propertyAndValueStrings =  sp.getPropertyAndValueStrings();
            if (!propertyAndValueStrings.isEmpty()){
                int propId = propertyAndValueStrings.get(0).getId();
                PropertyAndValueString propertyAndValueStringList = propertyAndValueStringRepository.findByIdWithValue(propId);
                propertyAndValueStrings.set(0, propertyAndValueStringList);
            }
        }
        return stringPropertiesList;
    }

    @Override
    public List<StringProperties> findStringPropertiesByProductId(int id) {
        return stringPropertiesRepository.findStringPropertiesByProductId(id);
    }

    @Override
    public PropertyAndValueStringsForm findForForm(int id) {


        return null;
    }

    @Override
    public PropertyAndValueStringsForm findForFormMap(int id) {
        PropertyAndValueStringsForm propertyAndValueStringsForm = new PropertyAndValueStringsForm();

        propertyAndValueStringsForm.setId(id);

        Product product = productRepository.findById(id);
        propertyAndValueStringsForm.setName(product.getProductName());
        propertyAndValueStringsForm.setPartNumber(product.getPartNumber());

        Map<StringProperties, ValueOfStringProperties> propertyAndValue = propertyAndValueStringsForm.getPropertyAndValue();

        List<StringProperties> stringPropertiesList = stringPropertiesRepository.findByProductId(id);
        for (StringProperties stringProperty: stringPropertiesList) {
            if (!stringProperty.getPropertyAndValueStrings().isEmpty()) {
                PropertyAndValueString propertyAndValueString = stringProperty.getPropertyAndValueStrings().get(0);

                int propertyAndValueStringID = propertyAndValueString.getId();
                PropertyAndValueString propertyAndValueStringTemp = propertyAndValueStringRepository.findByIdWithValue(propertyAndValueStringID);

                ValueOfStringProperties valueOfStringProperties = propertyAndValueStringTemp.getValueOfStringPropertiesList().get(0);
                propertyAndValue.put(stringProperty, valueOfStringProperties);

            }else {
                propertyAndValue.put(stringProperty, null);
            }
        }
        return propertyAndValueStringsForm;
    }


}
