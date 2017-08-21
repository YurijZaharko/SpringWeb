package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.entity.*;
import proj.form.Filter.CategoryFilterForm;
import proj.form.Filter.StringPropertiesFilterForm;
import proj.form.PropertyAndValueStringsForm;
import proj.repository.*;
import proj.service.StringPropertiesService;
import proj.service.implementation.specification.StringPropertyFilterAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class StringPropertiesImplement implements StringPropertiesService {
    @Autowired
    private StringPropertiesRepository stringPropertiesRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PropertyAndValueStringRepository propertyAndValueStringRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ValueOfStringPropertiesRepository valueOfStringPropertiesRepository;

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

        Product product = productRepository.findByIdJoinCategory(id);
        propertyAndValueStringsForm.setName(product.getProductName());
        propertyAndValueStringsForm.setPartNumber(product.getPartNumber());

        List<PropertyAndValueString> propertyAndValueStringList = propertyAndValueStringsForm.getPropertyAndValueStringList();

        propertyAndValueStringList = propertyAndValueStringRepository.findByCategoryId(product.getCategory().getId());
        propertyAndValueStringsForm.setPropertyAndValueStringList(propertyAndValueStringList);
//        List<StringProperties> stringPropertiesList = stringPropertiesRepository.findByProductId(id);
//        for (StringProperties stringProperty: stringPropertiesList) {
//            if (!stringProperty.getPropertyAndValueStrings().isEmpty()) {
//                PropertyAndValueString propertyAndValueString = stringProperty.getPropertyAndValueStrings().get(0);
//
//                int propertyAndValueStringID = propertyAndValueString.getId();
//                PropertyAndValueString propertyAndValueStringTemp = propertyAndValueStringRepository.findByIdWithValue(propertyAndValueStringID);
//
//                ValueOfStringProperties valueOfStringProperties = propertyAndValueStringTemp.getValueOfStringProperties();
//                propertyAndValue.put(stringProperty, valueOfStringProperties);
//            }else {
//                propertyAndValue.put(stringProperty, null);
//            }
//        }
        return propertyAndValueStringsForm;
    }

    @Override
    public void saveValueFromForm(PropertyAndValueStringsForm propertyAndValueStringsForm) {
//        Map<StringProperties, ValueOfStringProperties> propertyAndValue = propertyAndValueStringsForm.getPropertyAndValue();
//        for (Map.Entry<StringProperties, ValueOfStringProperties> entry: propertyAndValue.entrySet()) {
//            if(null != entry.getValue()){
//                String stringValue = entry.getValue().getStringValue();
//                ValueOfStringProperties valueOfStringProperties = valueOfStringPropertiesRepository.findByStringValue(stringValue);
//                if (null != valueOfStringProperties){
//                    valueOfStringProperties = new ValueOfStringProperties();
//                    valueOfStringProperties.setStringValue(stringValue);
//                    StringProperties stringProperties = stringPropertiesRepository.findById(entry.getKey().getId());
//                    PropertyAndValueString propertyAndValueString = new PropertyAndValueString();
//                    propertyAndValueString.getProducts().add(productRepository.findById(propertyAndValueStringsForm.getId()));
//                    propertyAndValueString.setStringProperties(stringProperties);
//                    propertyAndValueString.setValueOfStringProperties(valueOfStringProperties);
//                    propertyAndValueStringRepository.save(propertyAndValueString);
//                }
//            }
//        }
    }

    @Override
    public Page<StringProperties> findAll(Pageable pageable, StringPropertiesFilterForm stringPropertiesFilterForm) {
        return stringPropertiesRepository.findAll(new StringPropertyFilterAdapter(stringPropertiesFilterForm), pageable);
    }

    @Override
    public Map<Integer, List<Integer>> findPropertyAndValueByCategoryId(int id) {
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        List<Integer> resultValueOfStringPropertiesIds = new ArrayList<>();
        List<StringProperties> stringPropertiesList = stringPropertiesRepository.findByCategoryId(id);
        List<ValueOfStringProperties> valueOfStringPropertiesList = new ArrayList<>();

        for (StringProperties stringProperty: stringPropertiesList) {
            valueOfStringPropertiesList.clear();
            valueOfStringPropertiesList = valueOfStringPropertiesRepository.findValueOfStringPropertiesByStringPropertiesId(stringProperty.getId());
            if (!valueOfStringPropertiesList.isEmpty()){
                for (ValueOfStringProperties valueOfStringProperty: valueOfStringPropertiesList) {
                    resultValueOfStringPropertiesIds.add(valueOfStringProperty.getId());
                }
            }
            resultMap.put(stringProperty.getId(), resultValueOfStringPropertiesIds);
        }
        return resultMap;
    }


}
