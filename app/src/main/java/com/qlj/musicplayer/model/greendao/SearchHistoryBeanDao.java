package com.qlj.musicplayer.model.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.qlj.musicplayer.model.SearchHistoryBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SEARCH_HISTORY_BEAN".
*/
public class SearchHistoryBeanDao extends AbstractDao<SearchHistoryBean, Long> {

    public static final String TABLENAME = "SEARCH_HISTORY_BEAN";

    /**
     * Properties of entity SearchHistoryBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property SearchContent = new Property(1, String.class, "searchContent", false, "SEARCH_CONTENT");
        public final static Property SearchTime = new Property(2, String.class, "searchTime", false, "SEARCH_TIME");
        public final static Property IsSelected = new Property(3, boolean.class, "isSelected", false, "IS_SELECTED");
    }


    public SearchHistoryBeanDao(DaoConfig config) {
        super(config);
    }
    
    public SearchHistoryBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SEARCH_HISTORY_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"SEARCH_CONTENT\" TEXT," + // 1: searchContent
                "\"SEARCH_TIME\" TEXT," + // 2: searchTime
                "\"IS_SELECTED\" INTEGER NOT NULL );"); // 3: isSelected
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SEARCH_HISTORY_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SearchHistoryBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String searchContent = entity.getSearchContent();
        if (searchContent != null) {
            stmt.bindString(2, searchContent);
        }
 
        String searchTime = entity.getSearchTime();
        if (searchTime != null) {
            stmt.bindString(3, searchTime);
        }
        stmt.bindLong(4, entity.getIsSelected() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SearchHistoryBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String searchContent = entity.getSearchContent();
        if (searchContent != null) {
            stmt.bindString(2, searchContent);
        }
 
        String searchTime = entity.getSearchTime();
        if (searchTime != null) {
            stmt.bindString(3, searchTime);
        }
        stmt.bindLong(4, entity.getIsSelected() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SearchHistoryBean readEntity(Cursor cursor, int offset) {
        SearchHistoryBean entity = new SearchHistoryBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // searchContent
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // searchTime
            cursor.getShort(offset + 3) != 0 // isSelected
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SearchHistoryBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSearchContent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSearchTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIsSelected(cursor.getShort(offset + 3) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SearchHistoryBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SearchHistoryBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SearchHistoryBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
