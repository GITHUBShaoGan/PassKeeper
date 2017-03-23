package com.shijianan.passkeeper.splash;

/**
 * Created by shijianan on 2017/3/19.
 */

public class SplashPresenterImpl implements SplashPresenter, SplashModel.OnRouteCallback {

    private SplashModel splashModel;
    private SplashView splashView;

    public SplashPresenterImpl(SplashView splashView) {
        this.splashView = splashView;
        this.splashModel = new SplashModelImpl();
    }

    @Override
    public void startRoute() {
        splashModel.startRoute(this);
    }

    @Override
    public void onRoute2MasterCheck() {
        splashView.onRoute2MasterCheck();
    }

    @Override
    public void onRoute2FingerCheck() {
        splashView.onRoute2FingerCheck();
    }

    @Override
    public void onRoute2Create() {
        splashView.onRoute2Create();
    }

    @Override
    public void onRouteError(String msg) {
        splashView.onRouteError(msg);
    }
}
