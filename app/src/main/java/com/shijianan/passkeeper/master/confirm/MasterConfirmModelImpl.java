package com.shijianan.passkeeper.master.confirm;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.config.AppConfig;
import com.shijianan.passkeeper.database.DBManager;
import com.shijianan.passkeeper.database.dao.UserConfigDao;
import com.shijianan.passkeeper.database.entity.UserConfig;
import com.shijianan.passkeeper.master.create.MasterCreateActivity;
import com.shijianan.passkeeper.utils.MD5Utils;
import com.shijianan.passkeeper.utils.StringUtils;
import com.shijianan.passkeeper.utils.sp.ConfigKeeper;

import java.util.UUID;

/**
 * Created by shijianan on 2017/3/22.
 */

public class MasterConfirmModelImpl implements MasterConfirmModel {

    @Override
    public void initUI(Intent intent, Bundle saveInstanceState, OnInitUIListener onInitUIListener) {
        if (saveInstanceState == null) {
            if (intent != null && intent.hasExtra(MasterCreateActivity.EXTRA_MASTER)) {
                String master = intent.getStringExtra(MasterCreateActivity.EXTRA_MASTER);
                if (master != null && master.length() >= AppConfig.MIN_MASTER_PASS_LENGTH && master.length() <= AppConfig.MAX_MASTER_PASS_LENGTH) {
                    onInitUIListener.onUIInitSuccess(master);
                } else {
                    onInitUIListener.onUIInitError(StringUtils.getStrFromRes(R.string.error_master));
                }
            } else {
                onInitUIListener.onUIInitError(StringUtils.getStrFromRes(R.string.error_empty_intent));
            }
        } else {
            //杀死后恢复
            if (saveInstanceState.containsKey(MasterCreateActivity.EXTRA_MASTER)) {
                String master = saveInstanceState.getString(MasterCreateActivity.EXTRA_MASTER);
                if (master != null && master.length() >= AppConfig.MIN_MASTER_PASS_LENGTH && master.length() <= AppConfig.MAX_MASTER_PASS_LENGTH) {
                    onInitUIListener.onUIInitSuccess(master);
                } else {
                    onInitUIListener.onUIInitError(StringUtils.getStrFromRes(R.string.error_master));
                }
            } else {
                onInitUIListener.onUIInitError(StringUtils.getStrFromRes(R.string.error_cannot_restore_instance));
            }
        }
    }

    @Override
    public void onSubmitClick(String extraMaster, String editMaster, OnSubmitClickCallback onSubmitClickCallback) {
        if (!TextUtils.isEmpty(extraMaster) && !TextUtils.isEmpty(editMaster) && TextUtils.equals(extraMaster, editMaster)) {
            long stamp = System.currentTimeMillis();
            DBManager.getInstance(MD5Utils.encode(stamp + ""));
            String uuid = UUID.randomUUID().toString();
            String master = MD5Utils.encode(editMaster);
            UserConfig userConfig = new UserConfig(uuid,master,false,System.currentTimeMillis());
            UserConfigDao.getInstance().insert(userConfig);
            ConfigKeeper.putRegStamp(stamp);
            onSubmitClickCallback.onSubmitSuccess();
        } else {
            onSubmitClickCallback.onSubmitError(StringUtils.getStrFromRes(R.string.error_master_confirm));
        }
    }

}
