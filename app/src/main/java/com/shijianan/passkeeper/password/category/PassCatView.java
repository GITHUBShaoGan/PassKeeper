package com.shijianan.passkeeper.password.category;

import java.util.List;

/**
 * Created by shijianan on 2017/3/23.
 */

public interface PassCatView {

    void onInitSuccess(List<PassCat> passCatList);

    void onInitError(String msg);

    void onClick2WebsiteEdit();

    void onClick2BankEdit();

    void onClick2ServerEdit();

    void onClick2WifiEdit();

    void onClick2OtherEdit();

}
