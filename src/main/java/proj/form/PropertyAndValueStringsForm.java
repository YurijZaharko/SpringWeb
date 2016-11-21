package proj.form;

import proj.entity.StringProperties;
import proj.entity.ValueOfStringProperties;

import java.util.*;

/**
 * Created by SCIP on 30.10.2016.
 */
public class PropertyAndValueStringsForm {
    private int id;

    private String name;

    private String partNumber;

    private Map<StringProperties, ValueOfStringProperties> propertyAndValue = new HashMap<>();

    public PropertyAndValueStringsForm() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Map<StringProperties, ValueOfStringProperties> getPropertyAndValue() {
        return propertyAndValue;
    }

    public void setPropertyAndValue(Map<StringProperties, ValueOfStringProperties> propertyAndValue) {
        this.propertyAndValue = propertyAndValue;
    }
}
