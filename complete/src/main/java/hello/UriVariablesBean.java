package hello;

import java.util.HashMap;
import java.util.Map;

public class UriVariablesBean {
    static int no = 1;
    static int page = 285;
    public String filename = "";

    public Map<String, ?> populate(Object payload) {

        Map<String, Object> variables = new HashMap<String, Object>();

        variables.put("no", Integer.toString(no));
        variables.put("page", Integer.toString(page));
        filename = no + "_" + page + ".jpg";
        page++;
        if (page == 288) {
            page = 285;
            no++;
        }

        return variables;
    }
}
