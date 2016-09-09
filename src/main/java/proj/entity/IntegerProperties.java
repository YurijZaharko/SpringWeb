package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
@Table(indexes = {@Index(columnList = "name")})
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<ListOfPropertyAndValueInteger> getListOfPropertyAndValueInteger() {
        return listOfPropertyAndValueInteger;
    }

    public void setListOfPropertyAndValueInteger(List<ListOfPropertyAndValueInteger> listOfPropertyAndValueInteger) {
        this.listOfPropertyAndValueInteger = listOfPropertyAndValueInteger;
    }
}
