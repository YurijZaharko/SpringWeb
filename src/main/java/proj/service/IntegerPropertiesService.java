package proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.entity.IntegerProperties;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */
public interface IntegerPropertiesService {
    void save(String name);
    IntegerProperties findByName(String name);
    void delete(String name);
    List<IntegerProperties> findAll();

    void deleteById(int id);

    IntegerProperties findById(int id);

    void save(IntegerProperties integerProperties);

    Page<IntegerProperties> findAll(Pageable pageable);
}
