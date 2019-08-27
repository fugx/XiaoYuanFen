package com.theaty.xiaoyuan.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.theaty.xiaoyuan.model.xiaoyuan.Sign;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SIGN".
*/
public class SignDao extends AbstractDao<Sign, Long> {

    public static final String TABLENAME = "SIGN";

    /**
     * Properties of entity Sign.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property SignId = new Property(0, Long.class, "signId", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Enabled = new Property(2, int.class, "enabled", false, "ENABLED");
        public final static Property Custom = new Property(3, int.class, "custom", false, "CUSTOM");
    }

    private Query<Sign> member_SignsQuery;
    private Query<Sign> play_SignsQuery;

    public SignDao(DaoConfig config) {
        super(config);
    }
    
    public SignDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SIGN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: signId
                "\"NAME\" TEXT," + // 1: name
                "\"ENABLED\" INTEGER NOT NULL ," + // 2: enabled
                "\"CUSTOM\" INTEGER NOT NULL );"); // 3: custom
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SIGN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Sign entity) {
        stmt.clearBindings();
 
        Long signId = entity.getSignId();
        if (signId != null) {
            stmt.bindLong(1, signId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getEnabled());
        stmt.bindLong(4, entity.getCustom());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Sign entity) {
        stmt.clearBindings();
 
        Long signId = entity.getSignId();
        if (signId != null) {
            stmt.bindLong(1, signId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getEnabled());
        stmt.bindLong(4, entity.getCustom());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Sign readEntity(Cursor cursor, int offset) {
        Sign entity = new Sign( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // signId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // enabled
            cursor.getInt(offset + 3) // custom
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Sign entity, int offset) {
        entity.setSignId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setEnabled(cursor.getInt(offset + 2));
        entity.setCustom(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Sign entity, long rowId) {
        entity.setSignId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Sign entity) {
        if(entity != null) {
            return entity.getSignId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Sign entity) {
        return entity.getSignId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "signs" to-many relationship of Member. */
    public List<Sign> _queryMember_Signs(Long signId) {
        synchronized (this) {
            if (member_SignsQuery == null) {
                QueryBuilder<Sign> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SignId.eq(null));
                member_SignsQuery = queryBuilder.build();
            }
        }
        Query<Sign> query = member_SignsQuery.forCurrentThread();
        query.setParameter(0, signId);
        return query.list();
    }

    /** Internal query to resolve the "signs" to-many relationship of Play. */
    public List<Sign> _queryPlay_Signs(Long signId) {
        synchronized (this) {
            if (play_SignsQuery == null) {
                QueryBuilder<Sign> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SignId.eq(null));
                play_SignsQuery = queryBuilder.build();
            }
        }
        Query<Sign> query = play_SignsQuery.forCurrentThread();
        query.setParameter(0, signId);
        return query.list();
    }

}