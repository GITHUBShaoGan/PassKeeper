package com.shijianan.passkeeper.master.create;

import android.text.Editable;
import android.text.TextUtils;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.config.AppConfig;
import com.shijianan.passkeeper.utils.StringUtils;

/**
 * Created by shijianan on 2017/3/22.
 */

public class MasterCreateModelImpl implements MasterCreateModel {
    @Override
    public void changeMasterText(Editable s, OnMasterTextChangedCallback onMasterTextChangedCallback) {
        String str = s.toString().trim();
        if (TextUtils.isEmpty(str)) {
            onMasterTextChangedCallback.onMasterTextChangeIllegal(StringUtils.getStrFromRes(R.string.error_empty_master));
            return;
        }
        if (str.length() <= AppConfig.MAX_MASTER_PASS_LENGTH && str.length() >= AppConfig.MIN_MASTER_PASS_LENGTH) {
            onMasterTextChangedCallback.onMasterTextChangeLegal();
        } else {
            onMasterTextChangedCallback.onMasterTextChangeIllegal(StringUtils.getStrFromRes(R.string.error_illegal_lenofmaster));
        }
    }
}
