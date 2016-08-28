package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 19.08.2016.
 */
@Entity
public class ProductProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "productProperty")
    private List<Product> productList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ProductProperty_ListOfPropertyAndValueInteger", joinColumns =
    @JoinColumn(name = "fk_ProductProperty"), inverseJoinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueInteger"))
    private List<ListOfPropertyAndValueInteger> listOfPropertyAndValueIntegers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ProductProperty_ListOfPropertyAndValueString", joinColumns =
    @JoinColumn(name = "fk_ProductProperty"), inverseJoinColumns =
    @JoinColumn(name = "fk_ListOfPropertyAndValueString"))
    private List<ListOfPropertyAndValueString> listOfPropertyAndValueStrings = new ArrayList<>();

    public ProductProperty() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<ListOfPropertyAndValueInteger> getListOfPropertyAndValueIntegers() {
        return listOfPropertyAndValueIntegers;
    }

    public void setListOfPropertyAndValueIntegers(List<ListOfPropertyAndValueInteger> listOfPropertyAndValueIntegers) {
        this.listOfPropertyAndValueIntegers = listOfPropertyAndValueIntegers;
    }

    public List<ListOfPropertyAndValueString> getListOfPropertyAndValueStrings() {
        return listOfPropertyAndValueStrings;
    }

    public void setListOfPropertyAndValueStrings(List<ListOfPropertyAndValueString> listOfPropertyAndValueStrings) {
        this.listOfPropertyAndValueStrings = listOfPropertyAndValueStrings;
    }


}
