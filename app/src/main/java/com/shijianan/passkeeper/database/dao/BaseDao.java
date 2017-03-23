package com.shijianan.passkeeper.database.dao;

import com.shijianan.passkeeper.database.DBManager;

import java.util.List;

/**
 * Created by shijianan on 2017/3/23.
 */

public class BaseDao<T> {

    public BaseDao() {
    }

    public boolean insert(T object) {
        boolean flag = DBManager.getInstance().getDaoSession().insert(object) == -1 ? true : false;
        return flag;
    }

    public List<T> queryAll(Class<T> cls) {
        List<T> list = DBManager.getInstance().getDaoSession().loadAll(cls);
        return list;
    }

    public void deleteAll(Class<T> cls) {
        DBManager.getInstance().getDaoSession().deleteAll(cls);
    }

}
