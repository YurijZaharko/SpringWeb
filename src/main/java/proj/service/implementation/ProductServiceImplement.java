package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.entity.Product;
import proj.form.Filter.ProductFilterForm;
import proj.form.Filter.ProductFrontFilterForm;
import proj.form.ProductForm;
import proj.repository.CategoryRepository;
import proj.repository.ProductRepository;
import proj.service.FileWriter;
import proj.service.ProductService;
import proj.service.implementation.specification.ProductFilterAdapter;
import proj.service.implementation.specification.ProductFrontFilterAdapter;

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
//        product.setCategory(categoryRepository.findById(Integer.valueOf(productForm.getCategory().getName())));
//        product.setBrand(brandRepository.findById(Integer.valueOf(productForm.getBrand().getName())));
//        product.setCountry(countryRepository.findById(Integer.valueOf(productForm.getCountry().getName())));
//        product.setPropertyAndValueInteger(productForm.getPropertyAndValueInteger());
        product.setPropertyAndValueStringList(productForm.getPropertyAndValueStringList());
        product.setId(productForm.getId());
//        brandRepository.save(productForm.getBrand());
//        categoryRepository.save(productForm.getCategory());
//        countryRepository.save(productForm.getCountry());
//        productPropertyRepository.save(product.getProductProperty());

        product.setPath(productForm.getPath());
        product.setVersion(productForm.getVersion());
        productRepository.saveAndFlush(product);
        String extension = fileWriter.write(FileWriter.Folder.PRODUCT, productForm.getFile(), product.getId());
        if(extension!=null){
            product.setVersion(productForm.getVersion()+1);
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
        productForm.setPropertyAndValueStringList(product.getPropertyAndValueStringList());
        productForm.setPath(product.getPath());
        productForm.setVersion(product.getVersion());
        return productForm;
    }

    @Override
    public Page<Product> findAll(Pageable pageable, ProductFilterForm productFilterForm) {
        return productRepository.findAll(new ProductFilterAdapter(productFilterForm), pageable);
    }

    @Override
    public Page<Product> findProduct(Pageable pageable, ProductFrontFilterForm productFrontFilterForm) {
        return null;
    }

    @Override
    public Page<Product> findProductByCategoryId(Pageable pageable, ProductFrontFilterForm productFrontFilterForm, int id) {
        productFrontFilterForm.setCategoryId(id);
        productFrontFilterForm.setCategoryName(categoryRepository.findById(id).getName());
        return productRepository.findAll(new ProductFrontFilterAdapter(productFrontFilterForm), pageable);
    }

}
