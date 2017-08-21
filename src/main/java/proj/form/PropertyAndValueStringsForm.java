package proj.form;

import proj.entity.PropertyAndValueString;

import java.util.List;

/**
 * Created by SCIP on 30.10.2016.
 */
public class PropertyAndValueStringsForm {
    private int id;

    private String name;

    private String partNumber;

    private List<PropertyAndValueString> propertyAndValueStringList;

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

    public List<PropertyAndValueString> getPropertyAndValueStringList() {
        return propertyAndValueStringList;
    }

    public void setPropertyAndValueStringList(List<PropertyAndValueString> propertyAndValueStringList) {
        this.propertyAndValueStringList = propertyAndValueStringList;
    }
}
