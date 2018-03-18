package com.youngfeng.androidclient.domain;

import java.io.Serializable;

/**
 * User
 *
 * @author Scott Smith 2018-03-18 11:37
 */
public class User implements Serializable {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
