package com.shijianan.passkeeper.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.shijianan.passkeeper.database.entity.UserConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_CONFIG".
*/
public class UserConfigDao extends AbstractDao<UserConfig, String> {

    public static final String TABLENAME = "USER_CONFIG";

    /**
     * Properties of entity UserConfig.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Uuid = new Property(0, String.class, "uuid", true, "UUID");
        public final static Property MasterPassword = new Property(1, String.class, "masterPassword", false, "MASTER_PASSWORD");
        public final static Property UseFingerPrint = new Property(2, boolean.class, "useFingerPrint", false, "USE_FINGER_PRINT");
        public final static Property CreateStamp = new Property(3, long.class, "createStamp", false, "CREATE_STAMP");
    };


    public UserConfigDao(DaoConfig config) {
        super(config);
    }
    
    public UserConfigDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_CONFIG\" (" + //
                "\"UUID\" TEXT PRIMARY KEY NOT NULL ," + // 0: uuid
                "\"MASTER_PASSWORD\" TEXT," + // 1: masterPassword
                "\"USE_FINGER_PRINT\" INTEGER NOT NULL ," + // 2: useFingerPrint
                "\"CREATE_STAMP\" INTEGER NOT NULL );"); // 3: createStamp
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_CONFIG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserConfig entity) {
        stmt.clearBindings();
 
        String uuid = entity.getUuid();
        if (uuid != null) {
            stmt.bindString(1, uuid);
        }
 
        String masterPassword = entity.getMasterPassword();
        if (masterPassword != null) {
            stmt.bindString(2, masterPassword);
        }
        stmt.bindLong(3, entity.getUseFingerPrint() ? 1L: 0L);
        stmt.bindLong(4, entity.getCreateStamp());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserConfig entity) {
        stmt.clearBindings();
 
        String uuid = entity.getUuid();
        if (uuid != null) {
            stmt.bindString(1, uuid);
        }
 
        String masterPassword = entity.getMasterPassword();
        if (masterPassword != null) {
            stmt.bindString(2, masterPassword);
        }
        stmt.bindLong(3, entity.getUseFingerPrint() ? 1L: 0L);
        stmt.bindLong(4, entity.getCreateStamp());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public UserConfig readEntity(Cursor cursor, int offset) {
        UserConfig entity = new UserConfig( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // uuid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // masterPassword
            cursor.getShort(offset + 2) != 0, // useFingerPrint
            cursor.getLong(offset + 3) // createStamp
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserConfig entity, int offset) {
        entity.setUuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setMasterPassword(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUseFingerPrint(cursor.getShort(offset + 2) != 0);
        entity.setCreateStamp(cursor.getLong(offset + 3));
     }
    
    @Override
    protected final String updateKeyAfterInsert(UserConfig entity, long rowId) {
        return entity.getUuid();
    }
    
    @Override
    public String getKey(UserConfig entity) {
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