package com.theaty.xiaoyuan.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.theaty.xiaoyuan.model.xiaoyuan.Member;

import com.theaty.xiaoyuan.model.xiaoyuan.Message;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MESSAGE".
*/
public class MessageDao extends AbstractDao<Message, Long> {

    public static final String TABLENAME = "MESSAGE";

    /**
     * Properties of entity Message.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property MessageId = new Property(0, Long.class, "messageId", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property Enabled = new Property(3, int.class, "enabled", false, "ENABLED");
        public final static Property System = new Property(4, int.class, "system", false, "SYSTEM");
        public final static Property MemberId = new Property(5, Long.class, "memberId", false, "MEMBER_ID");
    }

    private DaoSession daoSession;

    private Query<Message> member_MessagesQuery;

    public MessageDao(DaoConfig config) {
        super(config);
    }
    
    public MessageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MESSAGE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: messageId
                "\"NAME\" TEXT," + // 1: name
                "\"CONTENT\" TEXT," + // 2: content
                "\"ENABLED\" INTEGER NOT NULL ," + // 3: enabled
                "\"SYSTEM\" INTEGER NOT NULL ," + // 4: system
                "\"MEMBER_ID\" INTEGER);"); // 5: memberId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MESSAGE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Message entity) {
        stmt.clearBindings();
 
        Long messageId = entity.getMessageId();
        if (messageId != null) {
            stmt.bindLong(1, messageId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        stmt.bindLong(4, entity.getEnabled());
        stmt.bindLong(5, entity.getSystem());
 
        Long memberId = entity.getMemberId();
        if (memberId != null) {
            stmt.bindLong(6, memberId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Message entity) {
        stmt.clearBindings();
 
        Long messageId = entity.getMessageId();
        if (messageId != null) {
            stmt.bindLong(1, messageId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        stmt.bindLong(4, entity.getEnabled());
        stmt.bindLong(5, entity.getSystem());
 
        Long memberId = entity.getMemberId();
        if (memberId != null) {
            stmt.bindLong(6, memberId);
        }
    }

    @Override
    protected final void attachEntity(Message entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Message readEntity(Cursor cursor, int offset) {
        Message entity = new Message( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // messageId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.getInt(offset + 3), // enabled
            cursor.getInt(offset + 4), // system
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // memberId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Message entity, int offset) {
        entity.setMessageId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setEnabled(cursor.getInt(offset + 3));
        entity.setSystem(cursor.getInt(offset + 4));
        entity.setMemberId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Message entity, long rowId) {
        entity.setMessageId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Message entity) {
        if(entity != null) {
            return entity.getMessageId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Message entity) {
        return entity.getMessageId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "messages" to-many relationship of Member. */
    public List<Message> _queryMember_Messages(Long messageId) {
        synchronized (this) {
            if (member_MessagesQuery == null) {
                QueryBuilder<Message> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.MessageId.eq(null));
                member_MessagesQuery = queryBuilder.build();
            }
        }
        Query<Message> query = member_MessagesQuery.forCurrentThread();
        query.setParameter(0, messageId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getMemberDao().getAllColumns());
            builder.append(" FROM MESSAGE T");
            builder.append(" LEFT JOIN MEMBER T0 ON T.\"MEMBER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Message loadCurrentDeep(Cursor cursor, boolean lock) {
        Message entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Member member = loadCurrentOther(daoSession.getMemberDao(), cursor, offset);
        entity.setMember(member);

        return entity;    
    }

    public Message loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Message> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Message> list = new ArrayList<Message>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Message> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Message> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}