package com.shijianan.passkeeper.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.shijianan.passkeeper.database.entity.BankCardPassword;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BANK_CARD_PASSWORD".
*/
public class BankCardPasswordDao extends AbstractDao<BankCardPassword, String> {

    public static final String TABLENAME = "BANK_CARD_PASSWORD";

    /**
     * Properties of entity BankCardPassword.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Uuid = new Property(0, String.class, "uuid", true, "UUID");
        public final static Property CardNo = new Property(1, String.class, "cardNo", false, "CARD_NO");
    };


    public BankCardPasswordDao(DaoConfig config) {
        super(config);
    }
    
    public BankCardPasswordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BANK_CARD_PASSWORD\" (" + //
                "\"UUID\" TEXT PRIMARY KEY NOT NULL ," + // 0: uuid
                "\"CARD_NO\" TEXT);"); // 1: cardNo
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BANK_CARD_PASSWORD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BankCardPassword entity) {
        stmt.clearBindings();
 
        String uuid = entity.getUuid();
        if (uuid != null) {
            stmt.bindString(1, uuid);
        }
 
        String cardNo = entity.getCardNo();
        if (cardNo != null) {
            stmt.bindString(2, cardNo);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BankCardPassword entity) {
        stmt.clearBindings();
 
        String uuid = entity.getUuid();
        if (uuid != null) {
            stmt.bindString(1, uuid);
        }
 
        String cardNo = entity.getCardNo();
        if (cardNo != null) {
            stmt.bindString(2, cardNo);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public BankCardPassword readEntity(Cursor cursor, int offset) {
        BankCardPassword entity = new BankCardPassword( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // uuid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // cardNo
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BankCardPassword entity, int offset) {
        entity.setUuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCardNo(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(BankCardPassword entity, long rowId) {
        return entity.getUuid();
    }
    
    @Override
    public String getKey(BankCardPassword entity) {
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