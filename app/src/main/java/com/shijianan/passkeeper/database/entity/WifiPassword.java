package com.shijianan.passkeeper.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by shijianan on 2017/3/23.
 */
@Entity
public class WifiPassword extends Password {

    @Id
    private String uuid;
    private String wifiName;
    private String routerAccount;
    private String routerPassword;
    private String operatorAccount;
    private String operatorPassword;
    public String getOperatorPassword() {
        return this.operatorPassword;
    }
    public void setOperatorPassword(String operatorPassword) {
        this.operatorPassword = operatorPassword;
    }
    public String getOperatorAccount() {
        return this.operatorAccount;
    }
    public void setOperatorAccount(String operatorAccount) {
        this.operatorAccount = operatorAccount;
    }
    public String getRouterPassword() {
        return this.routerPassword;
    }
    public void setRouterPassword(String routerPassword) {
        this.routerPassword = routerPassword;
    }
    public String getRouterAccount() {
        return this.routerAccount;
    }
    public void setRouterAccount(String routerAccount) {
        this.routerAccount = routerAccount;
    }
    public String getWifiName() {
        return this.wifiName;
    }
    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Generated(hash = 456322151)
    public WifiPassword(String uuid, String wifiName, String routerAccount,
            String routerPassword, String operatorAccount, String operatorPassword) {
        this.uuid = uuid;
        this.wifiName = wifiName;
        this.routerAccount = routerAccount;
        this.routerPassword = routerPassword;
        this.operatorAccount = operatorAccount;
        this.operatorPassword = operatorPassword;
    }
    @Generated(hash = 2093824090)
    public WifiPassword() {
    }

}
