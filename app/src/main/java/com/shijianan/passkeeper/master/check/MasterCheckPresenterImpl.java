package com.shijianan.passkeeper.master.check;

/**
 * Created by shijianan on 2017/3/23.
 */

public class MasterCheckPresenterImpl implements MasterCheckPresenter,MasterCheckModel.OnCheckMasterCallback {

    private MasterCheckModel masterCheckModel;
    private MasterCheckView masterCheckView;

    public MasterCheckPresenterImpl(MasterCheckView masterCheckView) {
        this.masterCheckView = masterCheckView;
        this.masterCheckModel = new MasterCheckModelImpl();
    }

    @Override
    public void checkMaster(String editMaster) {
        masterCheckModel.checkMaster(editMaster,this);
    }

    @Override
    public void onCheckSuccess() {
        masterCheckView.onCheckSuccess();
    }

    @Override
    public void onCheckFailed() {
        masterCheckView.onCheckFailed();
    }

    @Override
    public void onCheckError(String msg) {
        masterCheckView.onCheckError(msg);
    }
}
