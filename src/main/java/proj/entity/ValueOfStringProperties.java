package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class ValueOfStringProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String stringValue;

    @ManyToMany
    @JoinTable(name = "valueOfStringProperties_product", joinColumns =
    @JoinColumn(name = "fk_valueOfStringProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_product"))
    private List<Product> productList = new ArrayList<Product>();

    @ManyToMany
    @JoinTable(name = "valueOfStringProperties_stringProperties", joinColumns =
    @JoinColumn(name = "fk_valueOfStringProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_stringProperties"))
    private List<StringProperties> stringPropertiesList = new ArrayList<StringProperties>();

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<StringProperties> getStringPropertiesList() {
        return stringPropertiesList;
    }

    public void setStringPropertiesList(List<StringProperties> stringPropertiesList) {
        this.stringPropertiesList = stringPropertiesList;
    }
}
