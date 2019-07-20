package com.wutong.mygreendao.green.dao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

/**
 * Created by HP on 2019/7/20.
 */

public class MyDaoMaster extends DaoMaster.OpenHelper {

        private  final String TAG = "trh"+this.getClass().getSimpleName();

        public MyDaoMaster(Context context, String name) {
            super(context, name);
        }

        public MyDaoMaster(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            super.onUpgrade(db, oldVersion, newVersion);
            MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
                @Override
                public void onCreateAllTables(Database db, boolean ifNotExists) {
                    DaoMaster.createAllTables(db, ifNotExists);
                }

                @Override
                public void onDropAllTables(Database db, boolean ifExists) {
                    DaoMaster.dropAllTables(db, ifExists);
                }
            }, StudentDao.class,PeopleDao.class);

            Log.e(TAG, "onUpgrade: " + oldVersion + " newVersion = " + newVersion);
        }
    }


