package proj.service.implementation.editor;

import proj.entity.Product;
import proj.service.ProductService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SCIP on 03.09.2016.
 */
public class ProductEditor extends PropertyEditorSupport {
    private final ProductService productService;

    public ProductEditor(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Product product = productService.findById(Integer.valueOf(text));
        setValue(product);
    }
}
