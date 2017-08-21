package proj.form.Filter;

import proj.form.FilterForm;

/**
 * Created by SC on 05.01.2017.
 */
public class UserFilterForm implements FilterForm {

    private String search = "";

    @Override
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
