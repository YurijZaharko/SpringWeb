//package proj.service.implementation;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import proj.entity.Product;
//import proj.entity.ProductProperty;
//import proj.entity.StringProperties;
//import proj.repository.ProductPropertyRepository;
//import proj.repository.ProductRepository;
//import proj.service.ProductPropertyService;
//import proj.service.ProductService;
//
//import java.util.List;
//
///**
// * Created by SCIP on 19.08.2016.
// */
//@Service
//public class ProductPropertyImplement implements ProductPropertyService {
//
//    @Autowired
//    private ProductPropertyRepository productPropertyRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public void save(int productId) {
//        ProductProperty productProperty = new ProductProperty();
//        productProperty.getProductList().add(productRepository.findById(productId));
//        productPropertyRepository.save(productProperty);
//    }
//
//    @Override
//    public ProductProperty findById(int id) {
//        return productPropertyRepository.findById(id);
//    }
//
//    @Override
//    public void delete(int id) {
//        productPropertyRepository.deleteById(id);
//    }
//
//    @Override
//    public List<ProductProperty> findAll() {
//        return productPropertyRepository.findAll();
//    }
//}
