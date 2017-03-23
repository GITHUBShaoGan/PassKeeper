package com.shijianan.passkeeper.utils;

import android.support.annotation.StringRes;

import com.shijianan.passkeeper.App;

/**
 * Created by shijianan on 2017/3/22.
 */

public class StringUtils {

    /**
     * 从资源中获取字符串
     *
     * @param id 字符资源id
     * @return 字符串
     */
    public static String getStrFromRes(@StringRes int id) {
        return App.getContext().getString(id);
    }

}
