package com.github.houbb.encryption.local.api.enums;

/**
 * 加解密类型
 *
 * @since 1.4.0
 */
public enum EncryptTypeEnum {
    ADDRESS("ADDRESS", "地址"),
    BANK_CARD_NUM("BANK_CARD_NUM", "银行卡号"),
    EMAIL("EMAIL", "邮箱"),
    ID_CARD("ID_CARD", "身份证"),
    NAME("NAME", "姓名"),
    PASSWORD("PASSWORD", "密码"),
    PHONE("PHONE", "姓名"),
    ;

    private final String code;
    private final String desc;

    EncryptTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
