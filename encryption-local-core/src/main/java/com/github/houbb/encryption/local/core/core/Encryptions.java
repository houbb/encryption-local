package com.github.houbb.encryption.local.core.core;

import com.github.houbb.encryption.local.api.core.IEncryption;
import com.github.houbb.heaven.support.instance.impl.Instances;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public final class Encryptions {

    private Encryptions(){}

    public static IEncryption address() {
        return Instances.singleton(AddressEncryption.class);
    }

    public static IEncryption name() {
        return Instances.singleton(NameEncryption.class);
    }

    public static IEncryption email() {
        return Instances.singleton(EmailEncryption.class);
    }

    public static IEncryption phone() {
        return Instances.singleton(PhoneEncryption.class);
    }

    public static IEncryption idCard() {
        return Instances.singleton(IdCardEncryption.class);
    }

    public static IEncryption bankCardNo() {
        return Instances.singleton(BankCardNoEncryption.class);
    }

    /**
     * 密码
     * @return 实现
     * @since 1.1.0
     */
    public static IEncryption password() {
        return new PasswordEncryption();
    }

}
