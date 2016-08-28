package proj.service;

import proj.entity.Product;

import java.util.List;

/**
 * Created by SC on 28.08.2016.
 */
public interface ProductService {
    void save(int price, String productName, String partNumber,int brandId, int countryId, int categoryId);
    Product findByName(String name);
    Product findByPartNumber(String partNumber);
    void delete(int id);
    List<Product> findAll();
}
