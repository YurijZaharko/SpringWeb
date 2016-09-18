package proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.entity.Brand;
import proj.form.Filter.BrandFilterForm;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */

public interface BrandService {
    void save(String name);
    Brand findByName(String name);
    Brand findById(int id);
    void delete(int id);
    List<Brand> findAll();

    void save(Brand brand);

    Page<Brand> findAll(Pageable pageable, BrandFilterForm brandFilterForm);
}
