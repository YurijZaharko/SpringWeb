package proj.form;

import org.springframework.web.multipart.MultipartFile;
import proj.entity.Brand;
import proj.entity.Category;
import proj.entity.Country;
import proj.entity.PropertyAndValueString;

import java.util.List;


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

    private List<PropertyAndValueString> propertyAndValueStringList;

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

    public List<PropertyAndValueString> getPropertyAndValueStringList() {
        return propertyAndValueStringList;
    }

    public void setPropertyAndValueStringList(List<PropertyAndValueString> propertyAndValueStringList) {
        this.propertyAndValueStringList = propertyAndValueStringList;
    }
}
