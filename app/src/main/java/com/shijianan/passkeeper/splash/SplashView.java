package com.shijianan.passkeeper.splash;

/**
 * Created by shijianan on 2017/3/19.
 */

public interface SplashView {

    void onRoute2MasterCheck();

    void onRoute2FingerCheck();

    void onRoute2Create();

    void onRouteError(String msg);

}
