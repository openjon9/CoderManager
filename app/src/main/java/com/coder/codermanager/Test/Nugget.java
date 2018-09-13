package com.coder.codermanager.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rey on 2018/9/13.
 */

public class Nugget {

    private String id =  "555";
    private List<String> Tags = new ArrayList<>();


    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> tags) {
        Tags = tags;
    }

    public Nugget(List<String> tags) {
        Tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
