package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class ListOfPropertyAndValueInteger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "ProductProperty_ListOfPropertyAndValueInteger", joinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueInteger"), inverseJoinColumns =
    @JoinColumn(name = "fk_ProductProperty"))
    private List<ProductProperty> productPropertyList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ListOfPropertyAndValueInteger_IntegerProperties", joinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueInteger"), inverseJoinColumns =
    @JoinColumn(name = "fk_IntegerProperties"))
    private List<IntegerProperties> integerPropertiesList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ListOfPropertyAndValueInteger_ValueOfIntegerProperties", joinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueInteger"), inverseJoinColumns =
    @JoinColumn(name = "fk_ValueOfIntegerProperties"))
    private List<ValueOfIntegerProperties> valueOfIntegerPropertiesList = new ArrayList<>();

    public ListOfPropertyAndValueInteger() {
    }

    public ListOfPropertyAndValueInteger(List<ProductProperty> productPropertyList, List<IntegerProperties> integerPropertiesList, List<ValueOfIntegerProperties> valueOfIntegerPropertiesList) {
        this.productPropertyList = productPropertyList;
        this.integerPropertiesList = integerPropertiesList;
        this.valueOfIntegerPropertiesList = valueOfIntegerPropertiesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductProperty> getProductPropertyList() {
        return productPropertyList;
    }

    public void setProductPropertyList(List<ProductProperty> productPropertyList) {
        this.productPropertyList = productPropertyList;
    }

    public List<IntegerProperties> getIntegerPropertiesList() {
        return integerPropertiesList;
    }

    public void setIntegerPropertiesList(List<IntegerProperties> integerPropertiesList) {
        this.integerPropertiesList = integerPropertiesList;
    }

    public List<ValueOfIntegerProperties> getValueOfIntegerPropertiesList() {
        return valueOfIntegerPropertiesList;
    }

    public void setValueOfIntegerPropertiesList(List<ValueOfIntegerProperties> valueOfIntegerPropertiesList) {
        this.valueOfIntegerPropertiesList = valueOfIntegerPropertiesList;
    }

    @Override
    public String toString() {
        return "ListOfPropertyAndValueInteger{" +
                "id=" + id +
                ", productPropertyList=" + productPropertyList +
                ", integerPropertiesList=" + integerPropertiesList +
                ", valueOfIntegerPropertiesList=" + valueOfIntegerPropertiesList +
                '}';
    }
}
