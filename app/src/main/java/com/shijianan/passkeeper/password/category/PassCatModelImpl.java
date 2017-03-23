package com.shijianan.passkeeper.password.category;

import com.shijianan.passkeeper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shijianan on 2017/3/23.
 */

public class PassCatModelImpl implements PassCatModel {

    @Override
    public void initUI(OnInitUiListener onInitUiListener) {
        PassCat website = new PassCat(R.drawable.ic_website_blue_48, R.string.title_cat_website, R.string.desc_cat_website, PassCatType.WEBSITE);
        PassCat bankCard = new PassCat(R.drawable.ic_bank_golden_48, R.string.title_cat_bankcard, R.string.desc_cat_bankcard, PassCatType.BANK);
        PassCat server = new PassCat(R.drawable.ic_server_black_48, R.string.title_cat_server, R.string.desc_cat_server, PassCatType.SERVER);
        PassCat wifi = new PassCat(R.drawable.ic_wifi_green_24, R.string.title_cat_wifi, R.string.desc_cat_wifi, PassCatType.WIFI);
        PassCat other = new PassCat(R.drawable.ic_other_48, R.string.title_cat_other, R.string.desc_cat_other, PassCatType.OTHER);
        List<PassCat> passCatList = new ArrayList<>();
        passCatList.add(website);
        passCatList.add(bankCard);
        passCatList.add(server);
        passCatList.add(wifi);
        passCatList.add(other);
        onInitUiListener.onInitSuccess(passCatList);
    }

    @Override
    public void clickItem(int passCatType, OnItemClickListener onItemClickListener) {
        switch (passCatType) {
            case PassCatType.WEBSITE:
                onItemClickListener.onClick2WebsiteEdit();
                break;
            case PassCatType.BANK:
                onItemClickListener.onClick2BankEdit();
                break;
            case PassCatType.SERVER:
                onItemClickListener.onClick2ServerEdit();
                break;
            case PassCatType.WIFI:
                onItemClickListener.onClick2WifiEdit();
                break;
            case PassCatType.OTHER:
                onItemClickListener.onClick2OtherEdit();
                break;
            default:
                onItemClickListener.onClick2OtherEdit();
                break;
        }
    }

}
