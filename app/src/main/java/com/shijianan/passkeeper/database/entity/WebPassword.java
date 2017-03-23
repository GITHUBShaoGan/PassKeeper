package com.shijianan.passkeeper.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by shijianan on 2017/3/23.
 */
@Entity
public class WebPassword extends Password{

    @Id
    private String uuid;
    private String account;
    private String url;
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Generated(hash = 1627809754)
    public WebPassword(String uuid, String account, String url) {
        this.uuid = uuid;
        this.account = account;
        this.url = url;
    }
    @Generated(hash = 693429965)
    public WebPassword() {
    }

}
