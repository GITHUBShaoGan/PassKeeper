package com.shijianan.passkeeper;

import android.app.Application;
import android.content.Context;

import com.shijianan.passkeeper.database.greendao.DaoMaster;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by shijianan on 2017/3/9.
 */

public class App extends Application {

    private static Context context;
    private boolean isDebugMode;

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(getApplicationContext());
        setDebugMode(true);
        initLeakCanary();
    }

    private void initLeakCanary() {
        if (!isDebugMode() || LeakCanary.isInAnalyzerProcess(getContext())) {
            return;
        }
        LeakCanary.install(this);
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        App.context = context;
    }

    public boolean isDebugMode() {
        return isDebugMode;
    }

    public void setDebugMode(boolean debugMode) {
        isDebugMode = debugMode;
    }

}
