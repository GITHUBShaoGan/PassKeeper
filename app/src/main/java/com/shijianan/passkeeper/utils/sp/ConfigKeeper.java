package com.shijianan.passkeeper.utils.sp;

/**
 * Created by shijianan on 2017/3/23.
 */

public class ConfigKeeper {

    /**
     * 写入用户第一次创建数据库的时间戳
     *
     * @param stamp 时间戳
     */
    public static void putRegStamp(long stamp) {
        SPUtils.put(SPConst.SP_CONFIG_FILE_NAME, SPConst.SP_ITEM_REG_STAMP, stamp);
    }

    /**
     * 读取用户注册时间
     *
     * @return
     */
    public static long getRegTime() throws Exception {
        long regStamp = (long) SPUtils.get(SPConst.SP_CONFIG_FILE_NAME, SPConst.SP_ITEM_REG_STAMP, 0L);
        return regStamp;
    }
}
