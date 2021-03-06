package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
@Table(indexes = {@Index(columnList = "name")})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private boolean rootCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentId;

    @OneToMany(mappedBy = "parentId")
    private List<Category> categoryChild = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();

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

    public boolean isRootCategory() {
        return rootCategory;
    }

    public void setRootCategory(boolean rootCategory) {
        this.rootCategory = rootCategory;
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

    public List<StringProperties> getStringPropertiesList() {
        return stringPropertiesList;
    }

    public void setStringPropertiesList(List<StringProperties> stringPropertiesList) {
        this.stringPropertiesList = stringPropertiesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
