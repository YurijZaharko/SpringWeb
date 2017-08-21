package proj.form.Filter;

import proj.form.FilterForm;

/**
 * Created by SCIP on 15.09.2016.
 */
public class BrandFilterForm implements FilterForm {
    private String search = "";

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
