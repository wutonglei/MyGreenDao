package com.wutong.mygreendao.green.dao.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PEOPLE".
*/
public class PeopleDao extends AbstractDao<People, Long> {

    public static final String TABLENAME = "PEOPLE";

    /**
     * Properties of entity People.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StudentNo = new Property(1, int.class, "studentNo", false, "STUDENT_NO");
        public final static Property Age = new Property(2, int.class, "age", false, "AGE");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property School = new Property(4, String.class, "school", false, "SCHOOL");
        public final static Property Wife = new Property(5, String.class, "wife", false, "WIFE");
        public final static Property Farther = new Property(6, String.class, "farther", false, "FARTHER");
    }


    public PeopleDao(DaoConfig config) {
        super(config);
    }
    
    public PeopleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PEOPLE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"STUDENT_NO\" INTEGER NOT NULL UNIQUE ," + // 1: studentNo
                "\"AGE\" INTEGER NOT NULL ," + // 2: age
                "\"NAME\" TEXT," + // 3: name
                "\"SCHOOL\" TEXT," + // 4: school
                "\"WIFE\" TEXT," + // 5: wife
                "\"FARTHER\" TEXT);"); // 6: farther
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PEOPLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, People entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getStudentNo());
        stmt.bindLong(3, entity.getAge());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String school = entity.getSchool();
        if (school != null) {
            stmt.bindString(5, school);
        }
 
        String wife = entity.getWife();
        if (wife != null) {
            stmt.bindString(6, wife);
        }
 
        String farther = entity.getFarther();
        if (farther != null) {
            stmt.bindString(7, farther);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, People entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getStudentNo());
        stmt.bindLong(3, entity.getAge());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String school = entity.getSchool();
        if (school != null) {
            stmt.bindString(5, school);
        }
 
        String wife = entity.getWife();
        if (wife != null) {
            stmt.bindString(6, wife);
        }
 
        String farther = entity.getFarther();
        if (farther != null) {
            stmt.bindString(7, farther);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public People readEntity(Cursor cursor, int offset) {
        People entity = new People( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // studentNo
            cursor.getInt(offset + 2), // age
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // school
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // wife
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // farther
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, People entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStudentNo(cursor.getInt(offset + 1));
        entity.setAge(cursor.getInt(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSchool(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWife(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFarther(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(People entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(People entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(People entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
