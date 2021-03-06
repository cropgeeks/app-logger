/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables.records;


import javax.annotation.Generated;

import jhi.applogger.database.codegen.tables.Applications;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ApplicationsRecord extends UpdatableRecordImpl<ApplicationsRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = -1193092308;

    /**
     * Setter for <code>apptracker_db.applications.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apptracker_db.applications.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apptracker_db.applications.app_name</code>.
     */
    public void setAppName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>apptracker_db.applications.app_name</code>.
     */
    public String getAppName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Applications.APPLICATIONS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Applications.APPLICATIONS.APP_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAppName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAppName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApplicationsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApplicationsRecord value2(String value) {
        setAppName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApplicationsRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ApplicationsRecord
     */
    public ApplicationsRecord() {
        super(Applications.APPLICATIONS);
    }

    /**
     * Create a detached, initialised ApplicationsRecord
     */
    public ApplicationsRecord(Integer id, String appName) {
        super(Applications.APPLICATIONS);

        set(0, id);
        set(1, appName);
    }
// @formatter:on
}
