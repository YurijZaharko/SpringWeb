package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class PropertyAndValueInteger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "propertyAndValueInteger")
    private List<Product> products = new ArrayList<>();

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

    public PropertyAndValueInteger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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


}
