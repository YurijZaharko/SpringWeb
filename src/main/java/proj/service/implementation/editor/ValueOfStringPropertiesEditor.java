package proj.service.implementation.editor;

import proj.entity.ValueOfStringProperties;
import proj.service.ValueOfStringPropertiesService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SC on 06.10.2016.
 */
public class ValueOfStringPropertiesEditor extends PropertyEditorSupport {
    private final ValueOfStringPropertiesService valueOfStringPropertiesService;

    public ValueOfStringPropertiesEditor(ValueOfStringPropertiesService valueOfStringPropertiesService) {
        this.valueOfStringPropertiesService = valueOfStringPropertiesService;
    }


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ValueOfStringProperties valueOfStringProperties = valueOfStringPropertiesService.findById(Integer.valueOf(text));
        setValue(valueOfStringProperties);
    }
}
