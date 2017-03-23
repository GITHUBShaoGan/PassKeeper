package com.shijianan.passkeeper.password.category;

import java.util.List;

/**
 * Created by shijianan on 2017/3/23.
 */

public class PassCatPresenterImpl implements PassCatPresenter,PassCatModel.OnItemClickListener,PassCatModel.OnInitUiListener {

    private PassCatModel passCatModel;
    private PassCatView passCatView;

    public PassCatPresenterImpl(PassCatView passCatView) {
        this.passCatView = passCatView;
        this.passCatModel = new PassCatModelImpl();
    }

    @Override
    public void initUI() {
        passCatModel.initUI(this);
    }

    @Override
    public void clickItem(int passCatType) {
        passCatModel.clickItem(passCatType,this);
    }

    @Override
    public void onInitSuccess(List<PassCat> passCatList) {
        passCatView.onInitSuccess(passCatList);
    }

    @Override
    public void onInitError(String msg) {
        passCatView.onInitError(msg);
    }

    @Override
    public void onClick2WebsiteEdit() {
        passCatView.onClick2WebsiteEdit();
    }

    @Override
    public void onClick2BankEdit() {
        passCatView.onClick2BankEdit();
    }

    @Override
    public void onClick2ServerEdit() {
        passCatView.onClick2ServerEdit();
    }

    @Override
    public void onClick2WifiEdit() {
        passCatView.onClick2WifiEdit();
    }

    @Override
    public void onClick2OtherEdit() {
        passCatView.onClick2OtherEdit();
    }
}
