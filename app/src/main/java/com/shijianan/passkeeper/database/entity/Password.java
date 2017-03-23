package com.shijianan.passkeeper.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by shijianan on 2017/3/23.
 */
@Entity
public class Password {

    @Id
    private String uuid;
    private String title;
    private String password;
    private String remark;
    private long createStamp;
    public long getCreateStamp() {
        return this.createStamp;
    }
    public void setCreateStamp(long createStamp) {
        this.createStamp = createStamp;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Generated(hash = 1700138811)
    public Password(String uuid, String title, String password, String remark,
            long createStamp) {
        this.uuid = uuid;
        this.title = title;
        this.password = password;
        this.remark = remark;
        this.createStamp = createStamp;
    }
    @Generated(hash = 565943725)
    public Password() {
    }

}
