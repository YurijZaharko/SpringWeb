package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class ValueOfIntegerProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer value;

    @ManyToMany
    @JoinTable(name = "valueOfIntegerProperties_product", joinColumns =
    @JoinColumn(name = "valueOfIntegerProperties"), inverseJoinColumns =
    @JoinColumn(name = "product"))
    private List<Product> productList = new ArrayList<Product>();

    @ManyToMany
    @JoinTable(name = "integerProperties_valueOfIntegerProperties", joinColumns =
    @JoinColumn(name = "valueOfIntegerProperties"), inverseJoinColumns =
    @JoinColumn(name = "integerProperties"))
    private List<IntegerProperties> integerPropertiesList = new ArrayList<IntegerProperties>();

    public ValueOfIntegerProperties() {
    }

    public ValueOfIntegerProperties(Integer value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<IntegerProperties> getIntegerPropertiesList() {
        return integerPropertiesList;
    }

    public void setIntegerPropertiesList(List<IntegerProperties> integerPropertiesList) {
        this.integerPropertiesList = integerPropertiesList;
    }
}
