package com.shijianan.passkeeper.master.check;

/**
 * Created by shijianan on 2017/3/23.
 */

public interface MasterCheckView {

    void onCheckSuccess();

    void onCheckFailed();

    void onCheckError(String msg);

}
