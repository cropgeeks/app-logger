/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen;


import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.impl.SchemaImpl;


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
public class ApptrackerDb extends SchemaImpl {

    private static final long serialVersionUID = -1462501144;

    /**
     * The reference instance of <code>apptracker_db</code>
     */
    public static final ApptrackerDb APPTRACKER_DB = new ApptrackerDb();

    /**
     * No further instances allowed
     */
    private ApptrackerDb() {
        super("apptracker_db", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }
// @formatter:on
}