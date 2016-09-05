package proj.service.implementation.editor;

import proj.entity.StringProperties;
import proj.service.StringPropertiesService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SCIP on 04.09.2016.
 */
public class StringPropertiesEditor extends PropertyEditorSupport {
    private final StringPropertiesService stringPropertiesService;

    public StringPropertiesEditor(StringPropertiesService stringPropertiesService) {
        this.stringPropertiesService = stringPropertiesService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        StringProperties stringProperties = stringPropertiesService.findById(Integer.valueOf(text));
        setValue(stringProperties);
    }
}
