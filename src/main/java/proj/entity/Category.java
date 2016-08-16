package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "parentId")
    private
    List<Category> childId = new ArrayList<Category>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentId;

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<Product>();

    @OneToMany(mappedBy = "category")
    private List<ListOfPropertiesString> listOfPropertiesStrings = new ArrayList<ListOfPropertiesString>();

    @OneToMany(mappedBy = "category")
    private List<ListOfPropertiesInteger> listOfPropertiesIntegers = new ArrayList<ListOfPropertiesInteger>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Category parentId) {
        this.name = name;
        this.parentId = parentId;
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

    public void setName(String categoryName) {
        this.name = categoryName;
    }

    public List<Category> getChildId() {
        return childId;
    }

    public void setChildId(List<Category> childId) {
        this.childId = childId;
    }

    public Category getParentId() {
        return parentId;
    }

    public void setParentId(Category parentId) {
        this.parentId = parentId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<ListOfPropertiesString> getListOfPropertiesStrings() {
        return listOfPropertiesStrings;
    }

    public void setListOfPropertiesStrings(List<ListOfPropertiesString> listOfPropertiesStrings) {
        this.listOfPropertiesStrings = listOfPropertiesStrings;
    }

    public List<ListOfPropertiesInteger> getListOfPropertiesIntegers() {
        return listOfPropertiesIntegers;
    }

    public void setListOfPropertiesIntegers(List<ListOfPropertiesInteger> listOfPropertiesIntegers) {
        this.listOfPropertiesIntegers = listOfPropertiesIntegers;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + name + '\'' +
                '}';
    }
}
