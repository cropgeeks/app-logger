/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jhi.applogger.database.codegen.ApptrackerDb;
import jhi.applogger.database.codegen.tables.records.UsersIpsRecord;

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
public class UsersIps extends TableImpl<UsersIpsRecord> {

    private static final long serialVersionUID = -1923570413;

    /**
     * The reference instance of <code>apptracker_db.users_ips</code>
     */
    public static final UsersIps USERS_IPS = new UsersIps();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersIpsRecord> getRecordType() {
        return UsersIpsRecord.class;
    }

    /**
     * The column <code>apptracker_db.users_ips.id</code>.
     */
    public final TableField<UsersIpsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apptracker_db.users_ips.users_id</code>.
     */
    public final TableField<UsersIpsRecord, Integer> USERS_ID = createField("users_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apptracker_db.users_ips.ips_id</code>.
     */
    public final TableField<UsersIpsRecord, Integer> IPS_ID = createField("ips_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>apptracker_db.users_ips.applications_id</code>.
     */
    public final TableField<UsersIpsRecord, Integer> APPLICATIONS_ID = createField("applications_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>apptracker_db.users_ips</code> table reference
     */
    public UsersIps() {
        this(DSL.name("users_ips"), null);
    }

    /**
     * Create an aliased <code>apptracker_db.users_ips</code> table reference
     */
    public UsersIps(String alias) {
        this(DSL.name(alias), USERS_IPS);
    }

    /**
     * Create an aliased <code>apptracker_db.users_ips</code> table reference
     */
    public UsersIps(Name alias) {
        this(alias, USERS_IPS);
    }

    private UsersIps(Name alias, Table<UsersIpsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsersIps(Name alias, Table<UsersIpsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<UsersIpsRecord, Integer> getIdentity() {
        return Internal.createIdentity(jhi.applogger.database.codegen.tables.UsersIps.USERS_IPS, jhi.applogger.database.codegen.tables.UsersIps.USERS_IPS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersIpsRecord> getPrimaryKey() {
        return Internal.createUniqueKey(jhi.applogger.database.codegen.tables.UsersIps.USERS_IPS, "KEY_users_ips_PRIMARY", jhi.applogger.database.codegen.tables.UsersIps.USERS_IPS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersIpsRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersIpsRecord>>asList(
              Internal.createUniqueKey(jhi.applogger.database.codegen.tables.UsersIps.USERS_IPS, "KEY_users_ips_PRIMARY", jhi.applogger.database.codegen.tables.UsersIps.USERS_IPS.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersIps as(String alias) {
        return new UsersIps(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersIps as(Name alias) {
        return new UsersIps(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersIps rename(String name) {
        return new UsersIps(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersIps rename(Name name) {
        return new UsersIps(name, null);
    }
// @formatter:on
}
