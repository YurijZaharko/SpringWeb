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

    @ManyToMany
    @JoinTable(name = "PropertyAndValueString_ValueOfStringProperties", joinColumns =
    @JoinColumn(name = "fk_ValueOfStringProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_PropertyAndValueString"))
    private List<PropertyAndValueString> propertyAndValueStrings = new ArrayList<>();

    public ValueOfStringProperties() {
    }

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
}
