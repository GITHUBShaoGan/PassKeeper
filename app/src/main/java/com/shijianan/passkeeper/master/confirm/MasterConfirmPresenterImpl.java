package com.shijianan.passkeeper.master.confirm;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by shijianan on 2017/3/22.
 */

public class MasterConfirmPresenterImpl implements MasterConfirmPresenter, MasterConfirmModel.OnSubmitClickCallback, MasterConfirmModel.OnInitUIListener {

    private MasterConfirmModel masterConfirmModel;
    private MasterConfirmView masterConfirmView;

    public MasterConfirmPresenterImpl(MasterConfirmView masterConfirmView) {
        this.masterConfirmView = masterConfirmView;
        this.masterConfirmModel = new MasterConfirmModelImpl();
    }

    @Override
    public void onSubmitClick(String extraMaster, String editMaster) {
        this.masterConfirmModel.onSubmitClick(extraMaster, editMaster, this);
    }

    @Override
    public void initUI(Intent intent, Bundle saveInstanceState) {
        masterConfirmModel.initUI(intent, saveInstanceState,this);
    }

    @Override
    public void onSubmitError(String msg) {
        this.masterConfirmView.onSubmitError(msg);
    }

    @Override
    public void onSubmitSuccess() {
        this.masterConfirmView.onSubmitSuccess();
    }

    @Override
    public void onUIInitSuccess(String extraMaster) {
        this.masterConfirmView.onUIInitSuccess(extraMaster);
    }

    @Override
    public void onUIInitError(String msg) {
        this.masterConfirmView.onUIInitError(msg);
    }
}
