package com.github.houbb.encryption.local.core.util;

import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;
import com.github.houbb.encryption.local.api.enums.EncryptTypeEnum;
import com.github.houbb.encryption.local.core.bs.EncryptionLocalBs;
import com.github.houbb.hash.api.IHash;
import com.github.houbb.hash.core.core.hash.Hashes;
import com.github.houbb.secret.api.api.ISecret;
import com.github.houbb.secret.core.support.secret.Secrets;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class EncryptionLocalUtil {

    private EncryptionLocalUtil(){}

    /**
     * 默认盐值
     * @since 1.1.0
     */
    private static final String DEFAULT_SALT = "99886622";

    /**
     * 地址加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse addressEncrypt(String plainText,
                                                String salt) {
        return encrypt(EncryptTypeEnum.ADDRESS, plainText, salt);
    }

    /**
     * 地址加密
     * @param plainText 明文
     * @return 结果
     * @since 1.1.0
     */
    public static CommonEncryptResponse addressEncrypt(String plainText) {
        return addressEncrypt(plainText, DEFAULT_SALT);
    }

    /**
     * 姓名加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse nameEncrypt(String plainText,
                                                       String salt) {
        return encrypt(EncryptTypeEnum.NAME, plainText, salt);
    }

    /**
     * 姓名加密
     * @param plainText 明文
     * @return 结果
     * @since 1.1.0
     */
    public static CommonEncryptResponse nameEncrypt(String plainText) {
        return nameEncrypt(plainText, DEFAULT_SALT);
    }

    /**
     * 邮箱加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse emailEncrypt(String plainText,
                                                    String salt) {
        return encrypt(EncryptTypeEnum.EMAIL, plainText, salt);
    }

    /**
     * 邮箱加密
     * @param plainText 明文
     * @return 结果
     * @since 1.1.0
     */
    public static CommonEncryptResponse emailEncrypt(String plainText) {
        return emailEncrypt(plainText, DEFAULT_SALT);
    }

    /**
     * 手机加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse phoneEncrypt(String plainText,
                                                     String salt) {
        return encrypt(EncryptTypeEnum.PHONE, plainText, salt);
    }

    /**
     * 手机加密
     * @param plainText 明文
     * @return 结果
     * @since 1.1.0
     */
    public static CommonEncryptResponse phoneEncrypt(String plainText) {
        return phoneEncrypt(plainText, DEFAULT_SALT);
    }

    /**
     * 身份证加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse idCardEncrypt(String plainText,
                                                     String salt) {
        return encrypt(EncryptTypeEnum.ID_CARD, plainText, salt);
    }

    /**
     * 身份证加密
     * @param plainText 明文
     * @return 结果
     * @since 1.1.0
     */
    public static CommonEncryptResponse idCardEncrypt(String plainText) {
        return idCardEncrypt(plainText, DEFAULT_SALT);
    }

    /**
     * 银行卡加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse bankCardNoEncrypt(String plainText,
                                                      String salt) {
        return encrypt(EncryptTypeEnum.BANK_CARD_NUM, plainText, salt);
    }

    /**
     * 银行卡加密
     * @param plainText 明文
     * @return 结果
     * @since 1.1.0
     */
    public static CommonEncryptResponse bankCardNoEncrypt(String plainText) {
        return bankCardNoEncrypt(plainText, DEFAULT_SALT);
    }

    /**
     * 密码加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse passwordEncrypt(String plainText,
                                                          String salt) {
        return encrypt(EncryptTypeEnum.PASSWORD, plainText, salt);
    }

    /**
     * 密码加密
     * @param plainText 明文
     * @return 结果
     * @since 1.1.0
     */
    public static CommonEncryptResponse passwordEncrypt(String plainText) {
        return passwordEncrypt(plainText, DEFAULT_SALT);
    }



    /**
     * 地址解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String addressDecrypt(String cipher,
                                 String salt) {
        return decrypt(EncryptTypeEnum.ADDRESS, cipher, salt);
    }

    /**
     * 邮箱解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String emailDecrypt(String cipher,
                                        String salt) {
        return decrypt(EncryptTypeEnum.EMAIL, cipher, salt);
    }

    /**
     * 手机号解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String phoneDecrypt(String cipher,
                                      String salt) {
        return decrypt(EncryptTypeEnum.PHONE, cipher, salt);
    }

    /**
     * 姓名解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String nameDecrypt(String cipher,
                                      String salt) {
        return decrypt(EncryptTypeEnum.NAME, cipher, salt);
    }

    /**
     * 银行卡号解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String bankCardNumDecrypt(String cipher,
                                     String salt) {
        return decrypt(EncryptTypeEnum.BANK_CARD_NUM, cipher, salt);
    }

    /**
     * 身份证解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String idCardDecrypt(String cipher,
                                           String salt) {
        return decrypt(EncryptTypeEnum.ID_CARD, cipher, salt);
    }

    /**
     * 地址解密（默认 salt）
     * @param cipher 密文
     * @return 明文
     * @since 1.1.0
     */
    public static String addressDecrypt(String cipher) {
        return addressDecrypt(cipher, DEFAULT_SALT);
    }

    /**
     * 邮箱解密（默认 salt）
     * @param cipher 密文
     * @return 明文
     * @since 1.1.0
     */
    public static String emailDecrypt(String cipher) {
        return emailDecrypt(cipher, DEFAULT_SALT);
    }

    /**
     * 手机号解密（默认 salt）
     * @param cipher 密文
     * @return 明文
     * @since 1.1.0
     */
    public static String phoneDecrypt(String cipher) {
        return phoneDecrypt(cipher, DEFAULT_SALT);
    }

    /**
     * 姓名解密（默认 salt）
     * @param cipher 密文
     * @return 明文
     * @since 1.1.0
     */
    public static String nameDecrypt(String cipher) {
        return nameDecrypt(cipher, DEFAULT_SALT);
    }

    /**
     * 银行卡号解密（默认 salt）
     * @param cipher 密文
     * @return 明文
     * @since 1.1.0
     */
    public static String bankCardNumDecrypt(String cipher) {
        return bankCardNumDecrypt(cipher, DEFAULT_SALT);
    }

    /**
     * 身份证解密（默认 salt）
     * @param cipher 密文
     * @return 明文
     * @since 1.1.0
     */
    public static String idCardDecrypt(String cipher) {
        return idCardDecrypt(cipher, DEFAULT_SALT);
    }

    /**
     * 密码解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 明文
     */
    public static String passwordDecrypt(String cipher,
                                         String salt) {
        return decrypt(EncryptTypeEnum.PASSWORD, cipher, salt);
    }

    /**
     * 密码解密（默认 salt）
     * @param cipher 密文
     * @return 明文
     * @since 1.1.0
     */
    public static String passwordDecrypt(String cipher) {
        return passwordDecrypt(cipher, DEFAULT_SALT);
    }


    /**
     * 加密
     * @param typeEnum 加密策略
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    private static CommonEncryptResponse encrypt(final EncryptTypeEnum typeEnum,
                                                String plainText,
                                                String salt) {
        return encrypt(typeEnum, plainText, salt, Hashes.md5(), Secrets.aes());
    }

    /**
     * 加密
     * @param typeEnum 加密策略
     * @param plainText 明文
     * @param salt 秘钥
     * @param hash 哈希策略
     * @param secret 加密策略
     * @return 结果
     */
    private static CommonEncryptResponse encrypt(final EncryptTypeEnum typeEnum,
                                                String plainText,
                                                String salt,
                                                IHash hash,
                                                ISecret secret) {
        EncryptionLocalBs encryptionLocalBs = EncryptionLocalBs.newInstance()
                .salt(salt)
                .hash(hash)
                .secret(secret);

        return encryptionLocalBs.encrypt(plainText, typeEnum.getCode());
    }

    /**
     * 解密
     * @param typeEnum 加密策略
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    private static String decrypt(final EncryptTypeEnum typeEnum,
                                 String cipher,
                                 String salt) {
        return decrypt(typeEnum, cipher, salt, Hashes.md5(), Secrets.aes());
    }

    /**
     * 解密
     * @param typeEnum 加密策略
     * @param cipher 密文
     * @param salt 秘钥
     * @param hash 哈希策略
     * @param secret 加密策略
     * @return 结果
     * @since 1.2.0
     */
    private static String decrypt(final EncryptTypeEnum typeEnum,
                                                String cipher,
                                                String salt,
                                                IHash hash,
                                                ISecret secret) {
        EncryptionLocalBs encryptionLocalBs = EncryptionLocalBs.newInstance()
                .salt(salt)
                .hash(hash)
                .secret(secret);

        return encryptionLocalBs.decrypt(cipher, typeEnum.getCode());
    }

    /**
     * 哈希
     *
     * @param plainText 加密策略
     * @param salt      秘钥
     * @param hash      哈希策略
     * @return 结果
     */
    public static String hash(String plainText,
                              String salt,
                              IHash hash) {
        EncryptionLocalBs encryptionLocalBs = EncryptionLocalBs.newInstance()
                .salt(salt)
                .hash(hash);

        return encryptionLocalBs.hash(plainText);
    }

    /**
     * 哈希
     *
     * @param plainText 加密策略
     * @param salt      秘钥
     * @return 结果
     */
    public static String hash(String plainText,
                              String salt) {
        return hash(plainText, salt, Hashes.md5());
    }

}
