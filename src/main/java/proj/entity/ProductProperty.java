//package proj.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by SCIP on 19.08.2016.
// */
//@Entity
//public class ProductProperty {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @OneToMany(mappedBy = "productProperty")
//    private List<Product> productList = new ArrayList<>();
//
//    @ManyToMany
//    @JoinTable(name = "ProductProperty_ListOfPropertyAndValueInteger", joinColumns =
//    @JoinColumn(name = "fk_ProductProperty"), inverseJoinColumns =
//    @JoinColumn(name = "fk_ListOfPropertyAndValueInteger"))
//    private List<PropertyAndValueInteger> listOfPropertyAndValueIntegers = new ArrayList<>();
//
//    @ManyToMany
//    @JoinTable(name = "ProductProperty_ListOfPropertyAndValueString", joinColumns =
//    @JoinColumn(name = "fk_ProductProperty"), inverseJoinColumns =
//    @JoinColumn(name = "fk_ListOfPropertyAndValueString"))
//    private List<PropertyAndValueString> listOfPropertyAndValueStrings = new ArrayList<>();
//
//    public ProductProperty() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
//
//    public List<PropertyAndValueInteger> getListOfPropertyAndValueIntegers() {
//        return listOfPropertyAndValueIntegers;
//    }
//
//    public void setListOfPropertyAndValueIntegers(List<PropertyAndValueInteger> listOfPropertyAndValueIntegers) {
//        this.listOfPropertyAndValueIntegers = listOfPropertyAndValueIntegers;
//    }
//
//    public List<PropertyAndValueString> getPropertyAndValueStrings() {
//        return listOfPropertyAndValueStrings;
//    }
//
//    public void setPropertyAndValueStrings(List<PropertyAndValueString> listOfPropertyAndValueStrings) {
//        this.listOfPropertyAndValueStrings = listOfPropertyAndValueStrings;
//    }
//
//
//}
