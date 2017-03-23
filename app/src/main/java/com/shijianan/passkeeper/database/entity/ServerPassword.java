package com.shijianan.passkeeper.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by shijianan on 2017/3/23.
 */
@Entity
public class ServerPassword extends Password {

    @Id
    private String uuid;
    private String ip;
    private int port;
    private String userName;
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getPort() {
        return this.port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Generated(hash = 213384919)
    public ServerPassword(String uuid, String ip, int port, String userName) {
        this.uuid = uuid;
        this.ip = ip;
        this.port = port;
        this.userName = userName;
    }
    @Generated(hash = 1070027797)
    public ServerPassword() {
    }


}
