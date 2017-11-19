package org.smallfire.java.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/19.
 */
public class RequestBean implements Serializable {

    private Long timestamp ;
    private String id ;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
