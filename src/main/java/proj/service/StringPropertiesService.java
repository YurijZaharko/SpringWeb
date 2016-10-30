package proj.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.StringProperties;
import proj.form.Filter.CategoryFilterForm;
import proj.form.PropertyAndValueStringsForm;

import java.util.List;

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

}
