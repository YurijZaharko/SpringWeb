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
    @JoinTable(name = "Category_IntegerProperties", joinColumns =
    @JoinColumn(name = "fk_IntegerProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_Category"))
    private List<Category> categoryList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ListOfPropertyAndValueInteger_IntegerProperties", joinColumns =
    @JoinColumn(name = "fk_IntegerProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueInteger"))
    private List<ListOfPropertyAndValueInteger> listOfPropertyAndValueInteger = new ArrayList<>();

    public IntegerProperties() {
    }

    public IntegerProperties(String name) {
        this.name = name;
    }
}
