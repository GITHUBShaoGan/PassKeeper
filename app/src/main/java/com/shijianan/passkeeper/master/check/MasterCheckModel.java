package com.shijianan.passkeeper.master.check;

/**
 * Created by shijianan on 2017/3/23.
 */

public interface MasterCheckModel {

    interface OnCheckMasterCallback{

        void onCheckSuccess();

        void onCheckFailed();

        void onCheckError(String msg);

    }

    void checkMaster(String editMaster,OnCheckMasterCallback onCheckMasterCallback);

}
