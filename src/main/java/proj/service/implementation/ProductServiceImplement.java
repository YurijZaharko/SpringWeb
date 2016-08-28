package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.Product;
import proj.repository.ProductRepository;
import proj.service.BrandService;
import proj.service.CategoryService;
import proj.service.CountryService;
import proj.service.ProductService;

import java.util.List;

/**
 * Created by SC on 28.08.2016.
 */
@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    BrandService brandService;
    @Autowired
    CountryService countryService;
    @Autowired
    CategoryService categoryService;

    @Override
    public void save(int price, String name, String partNumber,int brandId, int countryId, int categoryId) {
        if (productRepository.findByProductName(name) == null && productRepository.findByPartNumber(partNumber) == null){
            Product product = new Product(price, name, partNumber);
            product.setBrand(brandService.findById(brandId));
            product.setCountry(countryService.findById(categoryId));
            product.setCategory(categoryService.findById(categoryId));
            productRepository.save(product);
        }
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
}
