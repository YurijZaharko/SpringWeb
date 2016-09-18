package proj.form.Filter;


import proj.entity.Brand;
import proj.entity.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by SCIP on 17.09.2016.
 */
public class ProductFilterForm {

    private String maxString = "";

    private String minString = "";

    private int maxInt = 0;

    private int minInt = 0;

    private static final Pattern pattern = Pattern.compile("^[0-9]{1,9}$");

    private List<Brand> brandId = new ArrayList<>();

    private List<Country> countryId = new ArrayList<>();

    private List<Integer> categoryId = new ArrayList<>();

    public String getMaxString() {
        return maxString;
    }

    public void setMaxString(String maxString) {
        if(pattern.matcher(maxString).matches()){
            maxInt = Integer.valueOf(maxString);
        }
        this.maxString = maxString;
    }

    public String getMinString() {
        return minString;
    }

    public void setMinString(String minString) {
        if(pattern.matcher(minString).matches()){
            minInt = Integer.valueOf(minString);
        }
        this.minString = minString;
    }

    public int getMaxInt() {
        return maxInt;
    }

    public void setMaxInt(int maxInt) {
        this.maxInt = maxInt;
    }

    public int getMinInt() {
        return minInt;
    }

    public void setMinInt(int minInt) {
        this.minInt = minInt;
    }

    public List<Integer> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<Integer> categoryId) {
        this.categoryId = categoryId;
    }

    public List<Brand> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<Brand> brandId) {
        this.brandId = brandId;
    }

    public List<Country> getCountryId() {
        return countryId;
    }

    public void setCountryId(List<Country> countryId) {
        this.countryId = countryId;
    }
}
