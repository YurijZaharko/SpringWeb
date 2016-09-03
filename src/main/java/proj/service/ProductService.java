package proj.service;

import proj.entity.Product;
import proj.form.ProductForm;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by SC on 28.08.2016.
 */
public interface ProductService {
    void save(ProductForm productForm);

    Product findById(int id);

    Product findByName(String name);

    Product findByPartNumber(String partNumber);

    void delete(int id);

    List<Product> findAll();

    ProductForm findForForm(int id);
}
