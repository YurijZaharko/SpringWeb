package proj.form;

import org.springframework.web.multipart.MultipartFile;
import proj.entity.*;


/**
 * Created by SCIP on 03.09.2016.
 */
public class ProductForm{
    private int id;

    private String price;

    private String productName;

    private String partNumber;

    private int version;

    private String path;

    private Category category;

    private Country country;

    private Brand brand;

    private PropertyAndValueInteger propertyAndValueInteger;

    private PropertyAndValueString propertyAndValueString;

    private MultipartFile file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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
