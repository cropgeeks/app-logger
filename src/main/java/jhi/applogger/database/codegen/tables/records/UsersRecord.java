/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import jhi.applogger.database.codegen.tables.Users;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record10<Integer, Integer, String, String, String, String, Timestamp, String, UInteger, UInteger> {

    private static final long serialVersionUID = -470415660;

    /**
     * Setter for <code>apptracker_db.users.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>apptracker_db.users.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>apptracker_db.users.application_id</code>.
     */
    public void setApplicationId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>apptracker_db.users.application_id</code>.
     */
    public Integer getApplicationId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>apptracker_db.users.userid</code>.
     */
    public void setUserid(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>apptracker_db.users.userid</code>.
     */
    public String getUserid() {
        return (String) get(2);
    }

    /**
     * Setter for <code>apptracker_db.users.user_name</code>.
     */
    public void setUserName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>apptracker_db.users.user_name</code>.
     */
    public String getUserName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>apptracker_db.users.version</code>.
     */
    public void setVersion(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>apptracker_db.users.version</code>.
     */
    public String getVersion() {
        return (String) get(4);
    }

    /**
     * Setter for <code>apptracker_db.users.locale</code>.
     */
    public void setLocale(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>apptracker_db.users.locale</code>.
     */
    public String getLocale() {
        return (String) get(5);
    }

    /**
     * Setter for <code>apptracker_db.users.date</code>.
     */
    public void setDate(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>apptracker_db.users.date</code>.
     */
    public Timestamp getDate() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>apptracker_db.users.os</code>.
     */
    public void setOs(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>apptracker_db.users.os</code>.
     */
    public String getOs() {
        return (String) get(7);
    }

    /**
     * Setter for <code>apptracker_db.users.run_count</code>.
     */
    public void setRunCount(UInteger value) {
        set(8, value);
    }

    /**
     * Getter for <code>apptracker_db.users.run_count</code>.
     */
    public UInteger getRunCount() {
        return (UInteger) get(8);
    }

    /**
     * Setter for <code>apptracker_db.users.rating</code>.
     */
    public void setRating(UInteger value) {
        set(9, value);
    }

    /**
     * Getter for <code>apptracker_db.users.rating</code>.
     */
    public UInteger getRating() {
        return (UInteger) get(9);
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
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, Integer, String, String, String, String, Timestamp, String, UInteger, UInteger> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, Integer, String, String, String, String, Timestamp, String, UInteger, UInteger> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Users.USERS.APPLICATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Users.USERS.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Users.USERS.USER_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Users.USERS.VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Users.USERS.LOCALE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return Users.USERS.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Users.USERS.OS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field9() {
        return Users.USERS.RUN_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field10() {
        return Users.USERS.RATING;
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
        return getApplicationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getLocale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component7() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getOs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component9() {
        return getRunCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component10() {
        return getRating();
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
        return getApplicationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getLocale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getOs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value9() {
        return getRunCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value10() {
        return getRating();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value2(Integer value) {
        setApplicationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value3(String value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value4(String value) {
        setUserName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value5(String value) {
        setVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value6(String value) {
        setLocale(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value7(Timestamp value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value8(String value) {
        setOs(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value9(UInteger value) {
        setRunCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value10(UInteger value) {
        setRating(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(Integer value1, Integer value2, String value3, String value4, String value5, String value6, Timestamp value7, String value8, UInteger value9, UInteger value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Integer id, Integer applicationId, String userid, String userName, String version, String locale, Timestamp date, String os, UInteger runCount, UInteger rating) {
        super(Users.USERS);

        set(0, id);
        set(1, applicationId);
        set(2, userid);
        set(3, userName);
        set(4, version);
        set(5, locale);
        set(6, date);
        set(7, os);
        set(8, runCount);
        set(9, rating);
    }
// @formatter:on
}
