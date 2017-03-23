package com.shijianan.passkeeper.master.confirm;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by shijianan on 2017/3/22.
 */

public interface MasterConfirmModel {

    interface OnInitUIListener {

        void onUIInitSuccess(String extraMaster);

        void onUIInitError(String msg);

    }

    void initUI(Intent intent, Bundle saveInstanceState, OnInitUIListener onInitUIListener);

    interface OnSubmitClickCallback {

        void onSubmitError(String msg);

        void onSubmitSuccess();

    }

    void onSubmitClick(String extraMaster, String editMaster, OnSubmitClickCallback onSubmitClickCallback);

}
