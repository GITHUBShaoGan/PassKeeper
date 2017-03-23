package com.shijianan.passkeeper.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by shijianan on 2017/3/23.
 */
@Entity
public class UserConfig {

    public class DBStatus{
        public static final int CORRECT = 0;
        public static final int EMPTY = 1;
        public static final int ERROR = 2;
    }

    @Id
    private String uuid;
    private String masterPassword;
    private boolean useFingerPrint;
    private long createStamp;
    public long getCreateStamp() {
        return this.createStamp;
    }
    public void setCreateStamp(long createStamp) {
        this.createStamp = createStamp;
    }
    public boolean getUseFingerPrint() {
        return this.useFingerPrint;
    }
    public void setUseFingerPrint(boolean useFingerPrint) {
        this.useFingerPrint = useFingerPrint;
    }
    public String getMasterPassword() {
        return this.masterPassword;
    }
    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Generated(hash = 1896439230)
    public UserConfig(String uuid, String masterPassword, boolean useFingerPrint,
            long createStamp) {
        this.uuid = uuid;
        this.masterPassword = masterPassword;
        this.useFingerPrint = useFingerPrint;
        this.createStamp = createStamp;
    }
    @Generated(hash = 523434660)
    public UserConfig() {
    }

    @Override
    public String toString() {
        return "UserConfig{" +
                "uuid='" + uuid + '\'' +
                ", masterPassword='" + masterPassword + '\'' +
                ", useFingerPrint=" + useFingerPrint +
                ", createStamp=" + createStamp +
                '}';
    }
}
