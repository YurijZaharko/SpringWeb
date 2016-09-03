package proj.service;

import proj.entity.ProductProperty;
import proj.entity.StringProperties;

import java.util.List;

/**
 * Created by SCIP on 19.08.2016.
 */
public interface ProductPropertyService {
    void save(int productId);
    ProductProperty findById(int id);
    void delete(int id);
    List<ProductProperty> findAll();
}
