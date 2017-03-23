package com.shijianan.passkeeper.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.shijianan.passkeeper.database.entity.OtherPassword;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "OTHER_PASSWORD".
*/
public class OtherPasswordDao extends AbstractDao<OtherPassword, String> {

    public static final String TABLENAME = "OTHER_PASSWORD";

    /**
     * Properties of entity OtherPassword.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Uuid = new Property(0, String.class, "uuid", true, "UUID");
        public final static Property Account = new Property(1, String.class, "account", false, "ACCOUNT");
    };


    public OtherPasswordDao(DaoConfig config) {
        super(config);
    }
    
    public OtherPasswordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"OTHER_PASSWORD\" (" + //
                "\"UUID\" TEXT PRIMARY KEY NOT NULL ," + // 0: uuid
                "\"ACCOUNT\" TEXT);"); // 1: account
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"OTHER_PASSWORD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OtherPassword entity) {
        stmt.clearBindings();
 
        String uuid = entity.getUuid();
        if (uuid != null) {
            stmt.bindString(1, uuid);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(2, account);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OtherPassword entity) {
        stmt.clearBindings();
 
        String uuid = entity.getUuid();
        if (uuid != null) {
            stmt.bindString(1, uuid);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(2, account);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public OtherPassword readEntity(Cursor cursor, int offset) {
        OtherPassword entity = new OtherPassword( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // uuid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // account
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OtherPassword entity, int offset) {
        entity.setUuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setAccount(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(OtherPassword entity, long rowId) {
        return entity.getUuid();
    }
    
    @Override
    public String getKey(OtherPassword entity) {
        if(entity != null) {
            return entity.getUuid();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
