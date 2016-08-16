package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class IntegerProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "listOfPropertiesInteger_integerProperties", joinColumns =
    @JoinColumn(name = "fk_integerProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_listOfPropertiesInteger"))
    private List<ListOfPropertiesInteger> listOfPropertiesIntegers = new ArrayList<ListOfPropertiesInteger>();

    @ManyToMany
    @JoinTable(name = "integerProperties_valueOfIntegerProperties", joinColumns =
    @JoinColumn(name = "integerProperties"), inverseJoinColumns =
    @JoinColumn(name = "valueOfIntegerProperties"))
    private List<ValueOfIntegerProperties> valueOfIntegerPropertiesList = new ArrayList<ValueOfIntegerProperties>();

    public IntegerProperties() {
    }

    public IntegerProperties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String propertyName) {
        this.name = propertyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ListOfPropertiesInteger> getListOfPropertiesIntegers() {
        return listOfPropertiesIntegers;
    }

    public void setListOfPropertiesIntegers(List<ListOfPropertiesInteger> listOfPropertiesIntegers) {
        this.listOfPropertiesIntegers = listOfPropertiesIntegers;
    }

    public List<ValueOfIntegerProperties> getValueOfIntegerPropertiesList() {
        return valueOfIntegerPropertiesList;
    }

    public void setValueOfIntegerPropertiesList(List<ValueOfIntegerProperties> valueOfIntegerPropertiesList) {
        this.valueOfIntegerPropertiesList = valueOfIntegerPropertiesList;
    }
}
