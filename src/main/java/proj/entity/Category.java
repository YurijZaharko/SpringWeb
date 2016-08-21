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

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentId;

    @OneToMany
    private List<Category> categoryChild = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<Product>();

    @ManyToMany
    @JoinTable(name = "Category_IntegerProperties", joinColumns =
    @JoinColumn(name = "fk_Category"), inverseJoinColumns =
    @JoinColumn(name = "fk_IntegerProperties"))
    private List<IntegerProperties> integerPropertiesList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Category_StringProperties",joinColumns =
    @JoinColumn(name = "fk_Category"), inverseJoinColumns =
    @JoinColumn(name = "fk_StringProperties"))
    private List<StringProperties> stringPropertiesList = new ArrayList<>();

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

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentId() {
        return parentId;
    }

    public void setParentId(Category parentId) {
        this.parentId = parentId;
    }

    public List<Category> getCategoryChild() {
        return categoryChild;
    }

    public void setCategoryChild(List<Category> categoryChild) {
        this.categoryChild = categoryChild;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<IntegerProperties> getIntegerPropertiesList() {
        return integerPropertiesList;
    }

    public void setIntegerPropertiesList(List<IntegerProperties> integerPropertiesList) {
        this.integerPropertiesList = integerPropertiesList;
    }

    public List<StringProperties> getStringPropertiesList() {
        return stringPropertiesList;
    }

    public void setStringPropertiesList(List<StringProperties> stringPropertiesList) {
        this.stringPropertiesList = stringPropertiesList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", categoryChild=" + categoryChild +
                ", productList=" + productList +
                ", integerPropertiesList=" + integerPropertiesList +
                ", stringPropertiesList=" + stringPropertiesList +
                '}';
    }
}
