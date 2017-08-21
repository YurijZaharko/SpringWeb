package proj.form.Filter;

import proj.form.FilterForm;

/**
 * Created by SC on 12.09.2016.
 */
public class CountryFilterForm implements FilterForm {

    private String search = "";

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
