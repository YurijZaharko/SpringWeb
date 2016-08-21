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
    @JoinTable(name = "ListOfPropertyAndValueInteger_ValueOfIntegerProperties", joinColumns =
    @JoinColumn(name = "fk_ValueOfIntegerProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueInteger"))
    private List<ListOfPropertyAndValueInteger> listOfPropertyAndValueInteger = new ArrayList<>();

    public ValueOfIntegerProperties() {
    }

    public ValueOfIntegerProperties(Integer integerValue) {

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

    public List<ListOfPropertyAndValueInteger> getListOfPropertyAndValueInteger() {
        return listOfPropertyAndValueInteger;
    }

    public void setListOfPropertyAndValueInteger(List<ListOfPropertyAndValueInteger> listOfPropertyAndValueInteger) {
        this.listOfPropertyAndValueInteger = listOfPropertyAndValueInteger;
    }

    @Override
    public String toString() {
        return "ValueOfIntegerProperties{" +
                "id=" + id +
                ", value=" + value +
                ", listOfPropertyAndValueInteger=" + listOfPropertyAndValueInteger +
                '}';
    }
}
