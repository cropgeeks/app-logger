/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jhi.applogger.database.codegen.ApptrackerDb;
import jhi.applogger.database.codegen.tables.records.UsersRecord;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
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
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = -1747119665;

    /**
     * The reference instance of <code>apptracker_db.users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    /**
     * The column <code>apptracker_db.users.id</code>.
     */
    public final TableField<UsersRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apptracker_db.users.application_id</code>.
     */
    public final TableField<UsersRecord, Integer> APPLICATION_ID = createField("application_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>apptracker_db.users.userid</code>.
     */
    public final TableField<UsersRecord, String> USERID = createField("userid", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>apptracker_db.users.user_name</code>.
     */
    public final TableField<UsersRecord, String> USER_NAME = createField("user_name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.users.version</code>.
     */
    public final TableField<UsersRecord, String> VERSION = createField("version", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.users.locale</code>.
     */
    public final TableField<UsersRecord, String> LOCALE = createField("locale", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.users.date</code>.
     */
    public final TableField<UsersRecord, Timestamp> DATE = createField("date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>apptracker_db.users.os</code>.
     */
    public final TableField<UsersRecord, String> OS = createField("os", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.users.run_count</code>.
     */
    public final TableField<UsersRecord, UInteger> RUN_COUNT = createField("run_count", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>apptracker_db.users.rating</code>.
     */
    public final TableField<UsersRecord, UInteger> RATING = createField("rating", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * Create a <code>apptracker_db.users</code> table reference
     */
    public Users() {
        this(DSL.name("users"), null);
    }

    /**
     * Create an aliased <code>apptracker_db.users</code> table reference
     */
    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>apptracker_db.users</code> table reference
     */
    public Users(Name alias) {
        this(alias, USERS);
    }

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return ApptrackerDb.APPTRACKER_DB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UsersRecord, Integer> getIdentity() {
        return Internal.createIdentity(jhi.applogger.database.codegen.tables.Users.USERS, jhi.applogger.database.codegen.tables.Users.USERS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Internal.createUniqueKey(jhi.applogger.database.codegen.tables.Users.USERS, "KEY_users_PRIMARY", jhi.applogger.database.codegen.tables.Users.USERS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersRecord>>asList(
              Internal.createUniqueKey(jhi.applogger.database.codegen.tables.Users.USERS, "KEY_users_PRIMARY", jhi.applogger.database.codegen.tables.Users.USERS.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(Name name) {
        return new Users(name, null);
    }
// @formatter:on
}
