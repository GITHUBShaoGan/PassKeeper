package com.shijianan.passkeeper.splash;

/**
 * Created by shijianan on 2017/3/19.
 */

public interface SplashModel {

    interface OnRouteCallback{

        void onRoute2MasterCheck();

        void onRoute2FingerCheck();

        void onRoute2Create();

        void onRouteError(String msg);

    }

    void startRoute(OnRouteCallback onRouteCallback);

}
