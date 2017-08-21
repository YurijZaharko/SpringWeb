package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class PropertyAndValueString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "propertyAndValueString")
    private List<Product> products = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PropertyAndValueString_StringProperties", joinColumns =
    @JoinColumn(name = "fk_PropertyAndValueString"), inverseJoinColumns =
    @JoinColumn(name = "fk_StringProperties"))
    private List<StringProperties> stringPropertiesList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PropertyAndValueString_ValueOfStringProperties", joinColumns =
    @JoinColumn(name = "fk_PropertyAndValueString"), inverseJoinColumns =
    @JoinColumn(name = "fk_ValueOfStringProperties"))
    private List<ValueOfStringProperties> valueOfStringPropertiesList = new ArrayList<>();

    public PropertyAndValueString() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
