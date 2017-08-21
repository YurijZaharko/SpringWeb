package proj.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 26.07.2016.
 */
@Entity
@Table(indexes = {@Index(columnList = "price"), @Index(columnList = "productName"), @Index(columnList = "partNumber")})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal price;

    private BigDecimal sellPrice;

    private String productName;

    private String partNumber;

    private int version;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @OneToMany(mappedBy = "product")
    private List<PropertyAndValueString> propertyAndValueStringList;

    @OneToMany(mappedBy = "product")
    private List<OrderField> orderFields = new ArrayList<>();

    public Product(){}

    public Product(BigDecimal price, String productName, String partNumber) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<PropertyAndValueString> getPropertyAndValueStringList() {
        return propertyAndValueStringList;
    }

    public void setPropertyAndValueStringList(List<PropertyAndValueString> propertyAndValueStringList) {
        this.propertyAndValueStringList = propertyAndValueStringList;
    }

    public List<OrderField> getOrderFields() {
        return orderFields;
    }

    public void setOrderFields(List<OrderField> orderFields) {
        this.orderFields = orderFields;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
