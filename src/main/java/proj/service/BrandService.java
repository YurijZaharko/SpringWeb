package proj.service;

import proj.entity.Brand;

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
}
