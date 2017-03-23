package com.shijianan.passkeeper.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.master.check.MasterCheckActivity;
import com.shijianan.passkeeper.master.create.MasterCreateActivity;
import com.shijianan.passkeeper.utils.ToastUtils;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        presenter = new SplashPresenterImpl(this);
        presenter.startRoute();
    }

    @Override
    public void onRoute2MasterCheck() {
        startActivity(new Intent(this, MasterCheckActivity.class));
        finish();
    }

    @Override
    public void onRoute2FingerCheck() {

    }

    @Override
    public void onRoute2Create() {
        startActivity(new Intent(this, MasterCreateActivity.class));
        finish();
    }

    @Override
    public void onRouteError(String msg) {
        ToastUtils.showShort(msg);
    }
}
