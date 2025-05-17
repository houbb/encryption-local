package com.github.houbb.encryption.local.core.support.mask;

import com.github.houbb.encryption.local.api.core.IEncryptMask;

/**
 * @since 1.2.0
 */
public class EncryptMasks {

    public static IEncryptMask address() {
        return new EncryptMaskAddress();
    }

    public static IEncryptMask chineseName() {
        return new EncryptMaskChineseName();
    }

    public static IEncryptMask bankCardNum() {
        return new EncryptMaskBankCardNum();
    }

    public static IEncryptMask email() {
        return new EncryptMaskEmail();
    }

    public static IEncryptMask phone() {
        return new EncryptMaskPhone();
    }

    public static IEncryptMask idCard() {
        return new EncryptMaskIdCard();
    }

    public static IEncryptMask password() {
        return new EncryptMaskPassword();
    }

}