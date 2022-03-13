package com.github.houbb.encryption.local.core.util;

import com.github.houbb.encryption.local.api.core.IEncryption;
import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;
import com.github.houbb.encryption.local.core.bs.EncryptionLocalBs;
import com.github.houbb.encryption.local.core.core.Encryptions;
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
     * 地址加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse addressEncrypt(String plainText,
                                                String salt) {
        return encrypt(Encryptions.address(), plainText, salt);
    }

    /**
     * 姓名加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse nameEncrypt(String plainText,
                                                       String salt) {
        return encrypt(Encryptions.name(), plainText, salt);
    }

    /**
     * 邮箱加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse emailEncrypt(String plainText,
                                                    String salt) {
        return encrypt(Encryptions.email(), plainText, salt);
    }

    /**
     * 手机加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse phoneEncrypt(String plainText,
                                                     String salt) {
        return encrypt(Encryptions.phone(), plainText, salt);
    }

    /**
     * 身份证加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse idCardEncrypt(String plainText,
                                                     String salt) {
        return encrypt(Encryptions.idCard(), plainText, salt);
    }

    /**
     * 银行卡加密
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse bankCardNoEncrypt(String plainText,
                                                      String salt) {
        return encrypt(Encryptions.bankCardNo(), plainText, salt);
    }

    /**
     * 加密
     * @param encryption 加密策略
     * @param plainText 明文
     * @param salt 秘钥
     * @return 结果
     */
    public static CommonEncryptResponse encrypt(IEncryption encryption,
                                                String plainText,
                                                String salt) {
        return encrypt(encryption, plainText, salt, Hashes.md5(), Secrets.aes());
    }

    /**
     * 加密
     * @param encryption 加密策略
     * @param plainText 明文
     * @param salt 秘钥
     * @param hash 哈希策略
     * @param secret 加密策略
     * @return 结果
     */
    public static CommonEncryptResponse encrypt(IEncryption encryption,
                                                String plainText,
                                                String salt,
                                                IHash hash,
                                                ISecret secret) {
        EncryptionLocalBs encryptionLocalBs = EncryptionLocalBs.newInstance()
                .salt(salt)
                .hash(hash)
                .secret(secret);

        return encryptionLocalBs.encrypt(encryption, plainText);
    }

    /**
     * 解密
     * @param encryption 加密策略
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String decrypt(IEncryption encryption,
                                                String cipher,
                                                String salt) {
        return decrypt(encryption, cipher, salt, Hashes.md5(), Secrets.aes());
    }

    /**
     * 地址解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String addressDecrypt(String cipher,
                                 String salt) {
        return decrypt(Encryptions.address(), cipher, salt);
    }

    /**
     * 邮箱解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String emailDecrypt(String cipher,
                                        String salt) {
        return decrypt(Encryptions.email(), cipher, salt);
    }

    /**
     * 手机号解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String phoneDecrypt(String cipher,
                                      String salt) {
        return decrypt(Encryptions.phone(), cipher, salt);
    }

    /**
     * 姓名解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String nameDecrypt(String cipher,
                                      String salt) {
        return decrypt(Encryptions.name(), cipher, salt);
    }

    /**
     * 银行卡号解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String bankCardNoDecrypt(String cipher,
                                     String salt) {
        return decrypt(Encryptions.bankCardNo(), cipher, salt);
    }

    /**
     * 身份证解密
     * @param cipher 密文
     * @param salt 秘钥
     * @return 结果
     */
    public static String idCardDecrypt(String cipher,
                                           String salt) {
        return decrypt(Encryptions.idCard(), cipher, salt);
    }

    /**
     * 解密
     * @param encryption 加密策略
     * @param cipher 密文
     * @param salt 秘钥
     * @param hash 哈希策略
     * @param secret 加密策略
     * @return 结果
     */
    public static String decrypt(IEncryption encryption,
                                                String cipher,
                                                String salt,
                                                IHash hash,
                                                ISecret secret) {
        EncryptionLocalBs encryptionLocalBs = EncryptionLocalBs.newInstance()
                .salt(salt)
                .hash(hash)
                .secret(secret);

        return encryptionLocalBs.decrypt(encryption, cipher);
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
