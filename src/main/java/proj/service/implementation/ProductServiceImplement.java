package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Brand;
import proj.entity.Product;
import proj.entity.ProductProperty;
import proj.form.ProductForm;
import proj.repository.*;
import proj.service.BrandService;
import proj.service.CategoryService;
import proj.service.CountryService;
import proj.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by SC on 28.08.2016.
 */
@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductPropertyRepository productPropertyRepository;

//    @Override
//    public void save(BigDecimal price, String name, String partNumber, int brandId, int countryId, int categoryId) {
//        if (productRepository.findByProductName(name) == null && productRepository.findByPartNumber(partNumber) == null){
//            Product product = new Product(price, name, partNumber);
//            product.setBrand(brandService.findById(brandId));
//            product.setCountry(countryService.findById(categoryId));
//            product.setCategory(categoryService.findById(categoryId));
//            productRepository.save(product);
//        }
//    }


    @Override
    public void save(ProductForm productForm) {
        Product product = new Product();
        product.setPrice(new BigDecimal(productForm.getPrice()));
        product.setProductName(productForm.getProductName());
        product.setPartNumber(productForm.getPartNumber());
        product.setCategory(productForm.getCategory());
        product.setBrand(productForm.getBrand());
        product.setCountry(productForm.getCountry());
//        product.setCategory(categoryRepository.findById(Integer.valueOf(productForm.getCategory().getName())));
//        product.setBrand(brandRepository.findById(Integer.valueOf(productForm.getBrand().getName())));
//        product.setCountry(countryRepository.findById(Integer.valueOf(productForm.getCountry().getName())));
        product.setProductProperty(productForm.getProductProperty());
        product.setId(productForm.getId());
//        brandRepository.save(productForm.getBrand());
//        categoryRepository.save(productForm.getCategory());
//        countryRepository.save(productForm.getCountry());
//        productPropertyRepository.save(product.getProductProperty());
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByProductName(name);
    }

    @Override
    public Product findByPartNumber(String partNumber) {
        return productRepository.findByPartNumber(partNumber);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductForm findForForm(int id) {
        Product product = productRepository.findByIdInitAll(id);
        ProductForm productForm = new ProductForm();
        productForm.setPrice(product.getPrice().toString());
        productForm.setProductName(product.getProductName());
        productForm.setPartNumber(product.getPartNumber());
        productForm.setCategory(product.getCategory());
        productForm.setBrand(product.getBrand());
        productForm.setCountry(product.getCountry());
        productForm.setProductProperty(product.getProductProperty());
        return productForm;
    }


}
