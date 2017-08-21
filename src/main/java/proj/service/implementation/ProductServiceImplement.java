package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.entity.Product;
import proj.form.Filter.ProductFilterForm;
import proj.form.ProductForm;
import proj.repository.BrandRepository;
import proj.repository.CategoryRepository;
import proj.repository.CountryRepository;
import proj.repository.ProductRepository;
import proj.service.FileWriter;
import proj.service.ProductService;
import proj.service.implementation.specification.ProductFilterAdapter;

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
    private FileWriter fileWriter;

    @Override
    public void save(ProductForm productForm) {
        Product product = new Product();
        product.setPrice(new BigDecimal(productForm.getPrice()));
        product.setProductName(productForm.getProductName());
        product.setPartNumber(productForm.getPartNumber());
        product.setCategory(productForm.getCategory());
        product.setBrand(productForm.getBrand());
        product.setCountry(productForm.getCountry());
        product.setPropertyAndValueString(productForm.getPropertyAndValueString());
        product.setId(productForm.getId());
        product.setPath(productForm.getPath());
        product.setVersion(productForm.getVersion());
        productRepository.saveAndFlush(product);
        String extension = fileWriter.write(FileWriter.Folder.PRODUCT, productForm.getFile(), product.getId());
        if (extension != null) {
            product.setVersion(productForm.getVersion() + 1);
            product.setPath(extension);
            productRepository.save(product);
        }

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
        productForm.setPropertyAndValueString(product.getPropertyAndValueString());
        productForm.setPath(product.getPath());
        productForm.setVersion(product.getVersion());
        return productForm;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable, ProductFilterForm productFilterForm) {
        return productRepository.findAll(new ProductFilterAdapter(productFilterForm), pageable);
    }
}
