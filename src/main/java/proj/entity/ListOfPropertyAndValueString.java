package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class ListOfPropertyAndValueString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "ProductProperty_ListOfPropertyAndValueString", joinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueString"), inverseJoinColumns =
    @JoinColumn(name = "fk_ProductProperty"))
    private List<ProductProperty> productProperties = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ListOfPropertyAndValueString_StringProperties", joinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueString"), inverseJoinColumns =
    @JoinColumn(name = "fk_StringProperties"))
    private List<StringProperties> stringPropertiesList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ListOfPropertyAndValueString_ValueOfStringProperties", joinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueString"), inverseJoinColumns =
    @JoinColumn(name = "fk_ValueOfStringProperties"))
    private List<ValueOfStringProperties> valueOfStringPropertiesList = new ArrayList<>();

    public ListOfPropertyAndValueString() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductProperty> getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(List<ProductProperty> productProperties) {
        this.productProperties = productProperties;
    }

    public List<StringProperties> getStringPropertiesList() {
        return stringPropertiesList;
    }

    public void setStringPropertiesList(List<StringProperties> stringPropertiesList) {
        this.stringPropertiesList = stringPropertiesList;
    }

    public List<ValueOfStringProperties> getValueOfStringPropertiesList() {
        return valueOfStringPropertiesList;
    }

    public void setValueOfStringPropertiesList(List<ValueOfStringProperties> valueOfStringPropertiesList) {
        this.valueOfStringPropertiesList = valueOfStringPropertiesList;
    }

    @Override
    public String toString() {
        return "ListOfPropertyAndValueString{" +
                "id=" + id +
                ", productProperties=" + productProperties +
                ", stringPropertiesList=" + stringPropertiesList +
                ", valueOfStringPropertiesList=" + valueOfStringPropertiesList +
                '}';
    }
}
