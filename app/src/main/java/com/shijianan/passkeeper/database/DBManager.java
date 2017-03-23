package com.shijianan.passkeeper.database;

import android.text.TextUtils;

import com.shijianan.passkeeper.App;
import com.shijianan.passkeeper.database.greendao.DaoMaster;
import com.shijianan.passkeeper.database.greendao.DaoSession;
import com.shijianan.passkeeper.utils.MD5Utils;
import com.shijianan.passkeeper.utils.sp.ConfigKeeper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by shijianan on 2017/3/23.
 */

public class DBManager {

    private static volatile DBManager instance;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private Database sqLiteDatabase;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public static DBManager getInstance(String password) {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager(password);
                }
            }
        }
        return instance;
    }

    public static DBManager getInstance() {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    try {
                        instance = new DBManager(MD5Utils.encode(ConfigKeeper.getRegTime() + ""));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    private DBManager(String password) {
        if (!TextUtils.isEmpty(password)) {
            this.devOpenHelper = new DaoMaster.DevOpenHelper(App.getContext(), DBConfig.DB_NAME);
            this.sqLiteDatabase = devOpenHelper.getEncryptedWritableDb(password);
            this.daoMaster = new DaoMaster(this.sqLiteDatabase);
            this.daoSession = daoMaster.newSession();
        } else {
            throw new NullPointerException("Password of database cannot be null");
        }
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    /**
     * 关闭数据库，释放资源
     */
    public void close() {
        if (this.daoSession != null) {
            this.daoSession.clear();
            this.daoSession = null;
        }
        if (this.devOpenHelper != null) {
            this.devOpenHelper.close();
            this.devOpenHelper = null;
        }
    }
}
