package com.shijianan.passkeeper.master.create;

import android.text.Editable;

/**
 * Created by shijianan on 2017/3/22.
 */

public class MasterCreatePresenterImpl implements MasterCreatePresenter, MasterCreateModel.OnMasterTextChangedCallback {

    private MasterCreateModel masterCreateModel;
    private MasterCreateView masterCreateView;

    public MasterCreatePresenterImpl(MasterCreateView masterCreateView) {
        this.masterCreateView = masterCreateView;
        this.masterCreateModel = new MasterCreateModelImpl();
    }

    @Override
    public void changeMasterText(Editable s) {
        masterCreateModel.changeMasterText(s, this);
    }

    @Override
    public void onMasterTextChangeLegal() {
        masterCreateView.onMasterTextChangeLegal();
    }

    @Override
    public void onMasterTextChangeIllegal(String msg) {
        masterCreateView.onMasterTextChangeIllegal(msg);
    }
}
