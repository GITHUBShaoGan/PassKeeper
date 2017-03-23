package com.shijianan.passkeeper.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by shijianan on 2017/3/23.
 */
@Entity
public class BankCardPassword extends Password {

    @Id
    private String uuid;
    private String cardNo;
    public String getCardNo() {
        return this.cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Generated(hash = 1095688323)
    public BankCardPassword(String uuid, String cardNo) {
        this.uuid = uuid;
        this.cardNo = cardNo;
    }
    @Generated(hash = 814365110)
    public BankCardPassword() {
    }

}
