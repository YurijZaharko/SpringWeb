package proj.controller.staticMethod;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import proj.form.FilterForm;

/**
 * Created by SCIP on 16.09.2016.
 */
public class CommonMethod {
    public static String getParams(Pageable pageable, FilterForm form){
        StringBuilder buffer = new StringBuilder();
        buffer.append("?page=");
        buffer.append(String.valueOf(pageable.getPageNumber()+1));
        buffer.append("&size=");
        buffer.append(String.valueOf(pageable.getPageSize()));
        if(pageable.getSort()!=null){
            buffer.append("&sort=");
            Sort sort = pageable.getSort();
            sort.forEach((order)->{
                buffer.append(order.getProperty());
                if(order.getDirection()!= Sort.Direction.ASC)
                    buffer.append(",desc");
            });
        }
        buffer.append("&search=");
        buffer.append(form.getSearch());
        return buffer.toString();
    }
}
