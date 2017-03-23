package com.shijianan.passkeeper.password.category;

import java.util.List;

/**
 * Created by shijianan on 2017/3/23.
 */

public interface PassCatModel {

    interface OnInitUiListener {

        void onInitSuccess(List<PassCat> passCatList);

        void onInitError(String msg);

    }

    void initUI(OnInitUiListener onInitUiListener);

    interface OnItemClickListener {

        void onClick2WebsiteEdit();

        void onClick2BankEdit();

        void onClick2ServerEdit();

        void onClick2WifiEdit();

        void onClick2OtherEdit();

    }

    void clickItem(int passCatType,OnItemClickListener onItemClickListener);

}
