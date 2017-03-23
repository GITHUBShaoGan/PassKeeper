package com.shijianan.passkeeper.config;

/**
 * Created by shijianan on 2017/3/22.
 */

public class AppConfig {

    public static final String DEFAULT_KEY = "";//默认主密码
    public static final int DEFAULT_REG_STAMP = 0;//默认主密码循环加密次数

    public static final int MIN_MASTER_PASS_LENGTH = 4;//主密码最小长度
    public static final int MAX_MASTER_PASS_LENGTH = 16;//主密码最大长度

    public static final int MIN_MASTER_ENCRYPT_LOOP = 1;//最小加密次数
    public static final int MAX_MASTER_ENCRYPT_LOOP = 5;//最大加密次数

}
