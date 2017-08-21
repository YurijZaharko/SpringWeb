package proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.entity.StringProperties;
import proj.form.Filter.CategoryFilterForm;
import proj.form.Filter.StringPropertiesFilterForm;
import proj.form.PropertyAndValueStringsForm;

import java.util.List;
import java.util.Map;

/**
 * Created by SCIP on 12.08.2016.
 */
public interface StringPropertiesService {

    void save(String name);

    StringProperties findByPropertyName(String name);

    void delete(String name);

    List<StringProperties> findAll();

    StringProperties findById(int id);

    void save(StringProperties stringProperties);

    void deleteById(int id);

    List<StringProperties> findByCategoryId(int id);

    List<StringProperties> findCategoryWithStringProperty(Pageable pageable, CategoryFilterForm categoryFilterForm, int id);

    List<StringProperties> findByProductId(int id);

    List<StringProperties> findStringPropertiesByProductId(int id);

    PropertyAndValueStringsForm findForForm(int id);

    PropertyAndValueStringsForm findForFormMap(int id);

    Page<StringProperties> findAll(Pageable pageable, StringPropertiesFilterForm stringPropertiesFilterForm);

    Map<Integer, List<Integer>> findPropertyAndValueByCategoryId(int id);

    void saveValueFromForm(PropertyAndValueStringsForm propertyAndValueStringsForm);
}
