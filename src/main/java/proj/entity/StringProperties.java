package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class StringProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String propertyName;

    @ManyToMany
    @JoinTable(name = "listOfPropertiesString_stringProperties", joinColumns =
    @JoinColumn(name = "fk_stringProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_listOfPropertiesString"))
    private List<ListOfPropertiesString> listOfPropertiesStrings = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "valueOfStringProperties_stringProperties", joinColumns =
    @JoinColumn(name = "fk_stringProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_valueOfStringProperties"))
    private List<ValueOfStringProperties> valueOfStringPropertiesList = new ArrayList<>();

    public StringProperties() {
    }

    public StringProperties(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public List<ListOfPropertiesString> getListOfPropertiesStrings() {
        return listOfPropertiesStrings;
    }

    public void setListOfPropertiesStrings(List<ListOfPropertiesString> listOfPropertiesStrings) {
        this.listOfPropertiesStrings = listOfPropertiesStrings;
    }

    public List<ValueOfStringProperties> getValueOfStringPropertiesList() {
        return valueOfStringPropertiesList;
    }

    public void setValueOfStringPropertiesList(List<ValueOfStringProperties> valueOfStringPropertiesList) {
        this.valueOfStringPropertiesList = valueOfStringPropertiesList;
    }
}
