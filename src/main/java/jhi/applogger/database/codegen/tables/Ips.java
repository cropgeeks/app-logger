/*
 * This file is generated by jOOQ.
 */
package jhi.applogger.database.codegen.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jhi.applogger.database.codegen.ApptrackerDb;
import jhi.applogger.database.codegen.tables.records.IpsRecord;

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
public class Ips extends TableImpl<IpsRecord> {

    private static final long serialVersionUID = 1468915984;

    /**
     * The reference instance of <code>apptracker_db.ips</code>
     */
    public static final Ips IPS = new Ips();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<IpsRecord> getRecordType() {
        return IpsRecord.class;
    }

    /**
     * The column <code>apptracker_db.ips.id</code>.
     */
    public final TableField<IpsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>apptracker_db.ips.ip_address</code>.
     */
    public final TableField<IpsRecord, String> IP_ADDRESS = createField("ip_address", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>apptracker_db.ips.country</code>.
     */
    public final TableField<IpsRecord, String> COUNTRY = createField("country", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.ips.country_code</code>.
     */
    public final TableField<IpsRecord, String> COUNTRY_CODE = createField("country_code", org.jooq.impl.SQLDataType.VARCHAR(2), this, "");

    /**
     * The column <code>apptracker_db.ips.city</code>.
     */
    public final TableField<IpsRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.ips.latitude</code>.
     */
    public final TableField<IpsRecord, String> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.ips.longitude</code>.
     */
    public final TableField<IpsRecord, String> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.ips.hostname</code>.
     */
    public final TableField<IpsRecord, String> HOSTNAME = createField("hostname", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.ips.provider</code>.
     */
    public final TableField<IpsRecord, String> PROVIDER = createField("provider", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>apptracker_db.ips.state</code>.
     */
    public final TableField<IpsRecord, String> STATE = createField("state", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>apptracker_db.ips</code> table reference
     */
    public Ips() {
        this(DSL.name("ips"), null);
    }

    /**
     * Create an aliased <code>apptracker_db.ips</code> table reference
     */
    public Ips(String alias) {
        this(DSL.name(alias), IPS);
    }

    /**
     * Create an aliased <code>apptracker_db.ips</code> table reference
     */
    public Ips(Name alias) {
        this(alias, IPS);
    }

    private Ips(Name alias, Table<IpsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ips(Name alias, Table<IpsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<IpsRecord, Integer> getIdentity() {
        return Internal.createIdentity(jhi.applogger.database.codegen.tables.Ips.IPS, jhi.applogger.database.codegen.tables.Ips.IPS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<IpsRecord> getPrimaryKey() {
        return Internal.createUniqueKey(jhi.applogger.database.codegen.tables.Ips.IPS, "KEY_ips_PRIMARY", jhi.applogger.database.codegen.tables.Ips.IPS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<IpsRecord>> getKeys() {
        return Arrays.<UniqueKey<IpsRecord>>asList(
              Internal.createUniqueKey(jhi.applogger.database.codegen.tables.Ips.IPS, "KEY_ips_PRIMARY", jhi.applogger.database.codegen.tables.Ips.IPS.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ips as(String alias) {
        return new Ips(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ips as(Name alias) {
        return new Ips(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ips rename(String name) {
        return new Ips(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ips rename(Name name) {
        return new Ips(name, null);
    }
// @formatter:on
}
