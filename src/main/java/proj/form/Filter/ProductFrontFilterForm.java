package proj.form.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Created by SC on 29.04.2017.
 */
public class ProductFrontFilterForm {

    private int categoryId;

    private String categoryName;

    private String maxString = "";

    private String minString = "";

    private int maxPriceInt = 0;

    private int minPriceInt = 0;

    private static final Pattern pattern = Pattern.compile("^[0-9]{1,9}$");

    private List<Integer> countryIdList = new ArrayList<>();

    private List<Integer> brandId = new ArrayList<>();

    private Map<Integer, List<Integer>> propertyMap = new TreeMap<>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMaxString() {
        return maxString;
    }

    public void setMaxString(String maxString) {
        if(pattern.matcher(maxString).matches()){
            maxPriceInt = Integer.valueOf(maxString);
        }
        this.maxString = maxString;
    }

    public String getMinString() {
        return minString;
    }

    public void setMinString(String minString) {
        if(pattern.matcher(minString).matches()){
            minPriceInt = Integer.valueOf(minString);
        }
        this.minString = minString;
    }

    public int getMaxPriceInt() {
        return maxPriceInt;
    }

    public void setMaxPriceInt(int maxPriceInt) {
        this.maxPriceInt = maxPriceInt;
    }

    public int getMinPriceInt() {
        return minPriceInt;
    }

    public void setMinPriceInt(int minPriceInt) {
        this.minPriceInt = minPriceInt;
    }

    public List<Integer> getCountryIdList() {
        return countryIdList;
    }

    public void setCountryIdList(List<Integer> countryIdList) {
        this.countryIdList = countryIdList;
    }

    public Map<Integer, List<Integer>> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<Integer, List<Integer>> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public List<Integer> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<Integer> brandId) {
        this.brandId = brandId;
    }
}
