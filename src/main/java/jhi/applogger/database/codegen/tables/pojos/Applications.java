/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


// @formatter:off
/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Applications implements Serializable {

    private static final long serialVersionUID = -1175841454;

    private Integer id;
    private String  appName;

    public Applications() {}

    public Applications(Applications value) {
        this.id = value.id;
        this.appName = value.appName;
    }

    public Applications(
        Integer id,
        String  appName
    ) {
        this.id = id;
        this.appName = appName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Applications (");

        sb.append(id);
        sb.append(", ").append(appName);

        sb.append(")");
        return sb.toString();
    }
// @formatter:on
}
