package com.shijianan.passkeeper.master.confirm;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by shijianan on 2017/3/22.
 */

public interface MasterConfirmPresenter {

    void onSubmitClick(String extraMaster,String editMaster);

    void initUI(Intent intent, Bundle saveInstanceState);

}
