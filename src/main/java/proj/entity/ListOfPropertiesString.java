package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class ListOfPropertiesString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany
    @JoinTable(name = "listOfPropertiesString_stringProperties", joinColumns =
    @JoinColumn(name = "fk_listOfPropertiesString"), inverseJoinColumns =
    @JoinColumn(name = "fk_stringProperties"))
    private List<StringProperties> stringPropertiesList = new ArrayList<StringProperties>();

    public ListOfPropertiesString() {
    }

    public ListOfPropertiesString(Category category) {
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

    public List<StringProperties> getStringPropertiesList() {
        return stringPropertiesList;
    }

    public void setStringPropertiesList(List<StringProperties> stringPropertiesList) {
        this.stringPropertiesList = stringPropertiesList;
    }
}
