package proj.form;

import java.util.*;

/**
 * Created by SCIP on 30.10.2016.
 */
public class PropertyAndValueStringsForm {
    private int id;

    private List<Integer> stringPropertiesId = new LinkedList<>();

    private List<Integer> stringValueId = new LinkedList<>();

    public PropertyAndValueStringsForm() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getStringPropertiesId() {
        return stringPropertiesId;
    }

    public void setStringPropertiesId(List<Integer> stringPropertiesId) {
        this.stringPropertiesId = stringPropertiesId;
    }

    public List<Integer> getStringValueId() {
        return stringValueId;
    }

    public void setStringValueId(List<Integer> stringValueId) {
        this.stringValueId = stringValueId;
    }

}
