package com.shijianan.passkeeper.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by shijianan on 2017/3/23.
 */
@Entity
public class OtherPassword extends Password{

    @Id
    private String uuid;
    private String account;
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
    @Generated(hash = 6533906)
    public OtherPassword(String uuid, String account) {
        this.uuid = uuid;
        this.account = account;
    }
    @Generated(hash = 706239171)
    public OtherPassword() {
    }

}
