package com.shijianan.passkeeper.master.check;

import android.text.TextUtils;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.database.dao.UserConfigDao;
import com.shijianan.passkeeper.database.entity.UserConfig;
import com.shijianan.passkeeper.utils.MD5Utils;
import com.shijianan.passkeeper.utils.StringUtils;

/**
 * Created by shijianan on 2017/3/23.
 */

public class MasterCheckModelImpl implements MasterCheckModel {

    @Override
    public void checkMaster(String editMaster, OnCheckMasterCallback onCheckMasterCallback) {
        if (TextUtils.isEmpty(editMaster)) {
            onCheckMasterCallback.onCheckFailed();
            return;
        }
        UserConfig userConfig = UserConfigDao.getInstance().query();
        if (userConfig == null) {
            onCheckMasterCallback.onCheckError(StringUtils.getStrFromRes(R.string.error_no_userconfig));
        } else {
            String masterAfterMD5 = userConfig.getMasterPassword();
            String editMasterAfterMD5 = MD5Utils.encode(editMaster);
            if (TextUtils.equals(masterAfterMD5, editMasterAfterMD5)) {
                onCheckMasterCallback.onCheckSuccess();
            } else {
                onCheckMasterCallback.onCheckFailed();
            }
        }
    }

}
