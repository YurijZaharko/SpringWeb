package proj.entity;

import javax.persistence.*;
import java.math.BigDecimal;

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

    private BigDecimal enterPrice;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private PropertyAndValueInteger propertyAndValueInteger;

    @ManyToOne(fetch = FetchType.LAZY)
    private PropertyAndValueString propertyAndValueString;

    public Product() {}

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

    public PropertyAndValueInteger getPropertyAndValueInteger() {
        return propertyAndValueInteger;
    }

    public void setPropertyAndValueInteger(PropertyAndValueInteger propertyAndValueInteger) {
        this.propertyAndValueInteger = propertyAndValueInteger;
    }

    public PropertyAndValueString getPropertyAndValueString() {
        return propertyAndValueString;
    }

    public void setPropertyAndValueString(PropertyAndValueString propertyAndValueString) {
        this.propertyAndValueString = propertyAndValueString;
    }
}
