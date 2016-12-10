package proj.form.Filter;

import proj.form.FilterForm;

/**
 * Created by SCIP on 10.12.2016.
 */
public class StringPropertiesFilterForm implements FilterForm {

    private String search = "";
    @Override
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
