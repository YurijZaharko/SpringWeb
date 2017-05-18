package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
@Table(indexes = {@Index(columnList = "stringValue")})
public class ValueOfStringProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String stringValue;

    @OneToMany(mappedBy = "valueOfStringProperties")
    private List<PropertyAndValueString> propertyAndValueStrings = new ArrayList<>();

    public ValueOfStringProperties() {}

    public ValueOfStringProperties(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public List<PropertyAndValueString> getPropertyAndValueStrings() {
        return propertyAndValueStrings;
    }

    public void setPropertyAndValueStrings(List<PropertyAndValueString> propertyAndValueStrings) {
        this.propertyAndValueStrings = propertyAndValueStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValueOfStringProperties)) return false;

        ValueOfStringProperties that = (ValueOfStringProperties) o;

        return stringValue != null ? stringValue.equals(that.stringValue) : that.stringValue == null;
    }

    @Override
    public int hashCode() {
        return stringValue != null ? stringValue.hashCode() : 0;
    }
}
