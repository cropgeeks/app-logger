/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables.records;


import javax.annotation.Generated;

import jhi.applogger.database.codegen.tables.UsersIps;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class UsersIpsRecord extends UpdatableRecordImpl<UsersIpsRecord> implements Record4<Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = -422640902;

    /**
     * Setter for <code>apptracker_db.users_ips.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apptracker_db.users_ips.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apptracker_db.users_ips.users_id</code>.
     */
    public void setUsersId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>apptracker_db.users_ips.users_id</code>.
     */
    public Integer getUsersId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>apptracker_db.users_ips.ips_id</code>.
     */
    public void setIpsId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>apptracker_db.users_ips.ips_id</code>.
     */
    public Integer getIpsId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>apptracker_db.users_ips.applications_id</code>.
     */
    public void setApplicationsId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>apptracker_db.users_ips.applications_id</code>.
     */
    public Integer getApplicationsId() {
        return (Integer) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return UsersIps.USERS_IPS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UsersIps.USERS_IPS.USERS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return UsersIps.USERS_IPS.IPS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return UsersIps.USERS_IPS.APPLICATIONS_ID;
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
    public Integer component2() {
        return getUsersId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getIpsId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getApplicationsId();
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
    public Integer value2() {
        return getUsersId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getIpsId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getApplicationsId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersIpsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersIpsRecord value2(Integer value) {
        setUsersId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersIpsRecord value3(Integer value) {
        setIpsId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersIpsRecord value4(Integer value) {
        setApplicationsId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersIpsRecord values(Integer value1, Integer value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersIpsRecord
     */
    public UsersIpsRecord() {
        super(UsersIps.USERS_IPS);
    }

    /**
     * Create a detached, initialised UsersIpsRecord
     */
    public UsersIpsRecord(Integer id, Integer usersId, Integer ipsId, Integer applicationsId) {
        super(UsersIps.USERS_IPS);

        set(0, id);
        set(1, usersId);
        set(2, ipsId);
        set(3, applicationsId);
    }
// @formatter:on
}
