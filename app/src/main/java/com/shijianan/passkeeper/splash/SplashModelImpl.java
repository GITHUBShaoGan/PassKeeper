package com.shijianan.passkeeper.splash;


import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.database.DBManager;
import com.shijianan.passkeeper.database.dao.UserConfigDao;
import com.shijianan.passkeeper.database.entity.UserConfig;
import com.shijianan.passkeeper.utils.StringUtils;
import com.shijianan.passkeeper.utils.sp.ConfigKeeper;

/**
 * Created by shijianan on 2017/3/19.
 */

public class SplashModelImpl implements SplashModel {

    @Override
    public void startRoute(OnRouteCallback onRouteCallback) {
        long stamp = 0;
        try {
            stamp = ConfigKeeper.getRegTime();
        } catch (Exception e) {
            e.printStackTrace();
            onRouteCallback.onRouteError(e.getLocalizedMessage());
        }
        if (stamp != 0) {
            int status = UserConfigDao.getInstance().getDBStatus();
            switch (status) {
                case UserConfig.DBStatus.EMPTY:
                    onRouteCallback.onRoute2Create();
                    break;
                case UserConfig.DBStatus.CORRECT:
                    UserConfig userConfig = UserConfigDao.getInstance().query();
                    if (userConfig != null) {
                        if (userConfig.getUseFingerPrint()) {
                            onRouteCallback.onRoute2FingerCheck();
                        } else {
                            onRouteCallback.onRoute2MasterCheck();
                        }
                    } else {
                        onRouteCallback.onRouteError(StringUtils.getStrFromRes(R.string.error_unknown));
                    }
                    break;
                case UserConfig.DBStatus.ERROR:
                    onRouteCallback.onRouteError(StringUtils.getStrFromRes(R.string.error_data_tamper));
                    break;
                default:
                    break;
            }
        } else {
            onRouteCallback.onRoute2Create();
        }
    }

}
