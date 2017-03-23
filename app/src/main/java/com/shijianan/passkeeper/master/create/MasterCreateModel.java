package com.shijianan.passkeeper.master.create;

import android.text.Editable;

/**
 * Created by shijianan on 2017/3/22.
 */

public interface MasterCreateModel {


    interface OnMasterTextChangedCallback{

        void onMasterTextChangeLegal();

        void onMasterTextChangeIllegal(String msg);

    }

    void changeMasterText(Editable s,OnMasterTextChangedCallback onMasterTextChangedCallback);

}
