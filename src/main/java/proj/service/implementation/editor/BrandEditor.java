package proj.service.implementation.editor;

import proj.entity.Brand;
import proj.service.BrandService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SC on 04.09.2016.
 */
public class BrandEditor extends PropertyEditorSupport{
    private final BrandService brandService;

    public BrandEditor(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Brand brand = brandService.findById(Integer.valueOf(text));
        setValue(brand);
    }
}
