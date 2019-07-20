package com.wutong.mygreendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.wutong.mygreendao.green.dao.db.DaoMaster;
import com.wutong.mygreendao.green.dao.db.DaoSession;
import com.wutong.mygreendao.green.dao.db.MyDaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by HP on 2019/7/20.
 */

public class MyApplication extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
                                                                                        //数据库的名字
        MyDaoMaster helper = new MyDaoMaster (this, "trh-db");
       Database db = helper.getWritableDb();
//        Database db = helper.getEncryptedWritableDb("wutong"); //加密
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
