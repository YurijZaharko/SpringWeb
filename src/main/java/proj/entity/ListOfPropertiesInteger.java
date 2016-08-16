package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class ListOfPropertiesInteger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany
    @JoinTable(name = "listOfPropertiesInteger_integerProperties", joinColumns =
    @JoinColumn(name = "fk_listOfPropertiesInteger"), inverseJoinColumns =
    @JoinColumn(name = "fk_integerProperties"))
    private List<IntegerProperties> integerPropertiesList = new ArrayList<IntegerProperties>();

    public ListOfPropertiesInteger() {
    }

    public ListOfPropertiesInteger(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<IntegerProperties> getIntegerPropertiesList() {
        return integerPropertiesList;
    }

    public void setIntegerPropertiesList(List<IntegerProperties> integerPropertiesList) {
        this.integerPropertiesList = integerPropertiesList;
    }
}
