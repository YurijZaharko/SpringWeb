package proj.service.implementation.editor;

import proj.entity.Country;
import proj.service.CountryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SC on 04.09.2016.
 */
public class CountryEditor extends PropertyEditorSupport{
    private final CountryService countryService;

    public CountryEditor(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Country country = countryService.findById(Integer.valueOf(text));
        setValue(country);
    }
}
