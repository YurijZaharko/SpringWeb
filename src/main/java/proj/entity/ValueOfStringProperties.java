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
    @JoinTable(name = "ListOfPropertyAndValueString_ValueOfStringProperties", joinColumns =
    @JoinColumn(name = "fk_ValueOfStringProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueString"))
    private List<ListOfPropertyAndValueString> listOfPropertyAndValueStrings = new ArrayList<>();

    public ValueOfStringProperties() {
    }

    public ValueOfStringProperties(String stringValue) {

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

    public List<ListOfPropertyAndValueString> getListOfPropertyAndValueStrings() {
        return listOfPropertyAndValueStrings;
    }

    public void setListOfPropertyAndValueStrings(List<ListOfPropertyAndValueString> listOfPropertyAndValueStrings) {
        this.listOfPropertyAndValueStrings = listOfPropertyAndValueStrings;
    }
}
