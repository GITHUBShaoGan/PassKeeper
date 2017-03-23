package com.shijianan.passkeeper.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.shijianan.passkeeper.App;

/**
 * Created by shijianan on 2017/3/22.
 */

public class ToastUtils {

    public static void showShort(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(int id) {
        Toast.makeText(App.getContext(), id, Toast.LENGTH_SHORT).show();
    }

}
