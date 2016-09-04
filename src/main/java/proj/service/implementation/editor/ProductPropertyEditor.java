package proj.service.implementation.editor;

import proj.entity.ProductProperty;
import proj.service.ProductPropertyService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SC on 04.09.2016.
 */
public class ProductPropertyEditor extends PropertyEditorSupport {
    private final ProductPropertyService productPropertyService;

    public ProductPropertyEditor(ProductPropertyService productPropertyService) {
        this.productPropertyService = productPropertyService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ProductProperty productProperty = productPropertyService.findById(Integer.valueOf(text));
        setValue(productProperty);
    }
}
