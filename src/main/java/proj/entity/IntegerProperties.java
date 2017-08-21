package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private List<PropertyAndValueInteger> propertyAndValueInteger = new ArrayList<>();

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

    public List<PropertyAndValueInteger> getPropertyAndValueInteger() {
        return propertyAndValueInteger;
    }

    public void setPropertyAndValueInteger(List<PropertyAndValueInteger> propertyAndValueInteger) {
        this.propertyAndValueInteger = propertyAndValueInteger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerProperties that = (IntegerProperties) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
