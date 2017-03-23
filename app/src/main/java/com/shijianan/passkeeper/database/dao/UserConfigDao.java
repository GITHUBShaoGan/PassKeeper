package com.shijianan.passkeeper.database.dao;

import com.shijianan.passkeeper.database.entity.UserConfig;

import java.util.List;

/**
 * Created by shijianan on 2017/3/23.
 */

public class UserConfigDao extends BaseDao<UserConfig> {


    public static UserConfigDao getInstance() {
        return UserConfigDaoHolder.INSTANCE;
    }

    private static class UserConfigDaoHolder {
        private static final UserConfigDao INSTANCE = new UserConfigDao();
    }

    /**
     * 插入新的用户信息时先清空数据库所有数据，保证数据库只有一条记录
     *
     * @param object
     * @return
     */
    @Override
    public boolean insert(UserConfig object) {
        deleteAll(UserConfig.class);
        return super.insert(object);
    }

    public UserConfig query() {
        List<UserConfig> list = queryAll(UserConfig.class);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 校验是否有用户数据
     *
     * @return
     */
    public int getDBStatus() {
        int status;
        List<UserConfig> list = queryAll(UserConfig.class);
        if (list == null) {
            //表明数据是正常的
            status = UserConfig.DBStatus.EMPTY;
        } else {
            if (list.isEmpty()) {
                status = UserConfig.DBStatus.EMPTY;
            } else if (list.size() == 1) {
                status = UserConfig.DBStatus.CORRECT;
            } else {
                status = UserConfig.DBStatus.ERROR;
            }
        }
        return status;
    }
}
