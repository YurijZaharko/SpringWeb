package proj.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private int price;
    private String productName;
    private String partNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @ManyToMany
    @JoinTable(name = "valueOfStringProperties_product", joinColumns =
    @JoinColumn(name = "fk_product"), inverseJoinColumns =
    @JoinColumn(name = "fk_valueOfStringProperties"))
    private List<ValueOfStringProperties> valueOfStringPropertiesList = new ArrayList<ValueOfStringProperties>();

    @ManyToMany
    @JoinTable(name = "integerProperties_valueOfIntegerProperties", joinColumns =
    @JoinColumn(name = "integerProperties"), inverseJoinColumns =
    @JoinColumn(name = "valueOfIntegerProperties"))
    private List<ValueOfIntegerProperties> valueOfIntegerPropertiesList = new ArrayList<ValueOfIntegerProperties>();

    public Product() {
    }

    public Product(int price, String productName, String partNumber) {
        this.price = price;
        this.productName = productName;
        this.partNumber = partNumber;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<ValueOfStringProperties> getValueOfStringPropertiesList() {
        return valueOfStringPropertiesList;
    }

    public void setValueOfStringPropertiesList(List<ValueOfStringProperties> valueOfStringPropertiesList) {
        this.valueOfStringPropertiesList = valueOfStringPropertiesList;
    }

    public List<ValueOfIntegerProperties> getValueOfIntegerPropertiesList() {
        return valueOfIntegerPropertiesList;
    }

    public void setValueOfIntegerPropertiesList(List<ValueOfIntegerProperties> valueOfIntegerPropertiesList) {
        this.valueOfIntegerPropertiesList = valueOfIntegerPropertiesList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", brand=" + brand +
                ", country=" + country +
                '}';
    }
}
