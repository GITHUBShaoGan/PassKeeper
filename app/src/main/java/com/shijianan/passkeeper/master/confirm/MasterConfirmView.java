package com.shijianan.passkeeper.master.confirm;

/**
 * Created by shijianan on 2017/3/22.
 */

public interface MasterConfirmView {

    void onSubmitError(String msg);

    void onSubmitSuccess();

    void onUIInitSuccess(String extraMaster);

    void onUIInitError(String msg);

}
