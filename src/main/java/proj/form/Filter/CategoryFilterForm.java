package proj.form.Filter;

import proj.form.FilterForm;

/**
 * Created by SC on 02.10.2016.
 */
public class CategoryFilterForm implements FilterForm {

    private String search = "";

    @Override
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
