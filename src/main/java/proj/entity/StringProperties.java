package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
@Table(indexes = {@Index(columnList = "propertyName")})
public class StringProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String propertyName;

    @ManyToMany
    @JoinTable(name = "Category_StringProperties",joinColumns =
    @JoinColumn(name = "fk_Category"), inverseJoinColumns =
    @JoinColumn(name = "fk_StringProperties"))
    private List<Category> categoryList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ListOfPropertyAndValueString_StringProperties", joinColumns =
    @JoinColumn(name = "fk_StringProperties"), inverseJoinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueString"))
    private List<ListOfPropertyAndValueString> listOfPropertyAndValueStrings = new ArrayList<>();

    public StringProperties() {
    }

    public StringProperties(String name) {

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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<ListOfPropertyAndValueString> getListOfPropertyAndValueStrings() {
        return listOfPropertyAndValueStrings;
    }

    public void setListOfPropertyAndValueStrings(List<ListOfPropertyAndValueString> listOfPropertyAndValueStrings) {
        this.listOfPropertyAndValueStrings = listOfPropertyAndValueStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringProperties)) return false;

        StringProperties that = (StringProperties) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
