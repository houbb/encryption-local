package com.github.houbb.encryption.local.core.bs;

import com.github.houbb.encryption.local.api.core.IEncryption;
import com.github.houbb.encryption.local.api.core.IEncryptionContext;
import com.github.houbb.encryption.local.api.dto.req.CommonDecryptRequest;
import com.github.houbb.encryption.local.api.dto.req.CommonEncryptRequest;
import com.github.houbb.encryption.local.api.dto.resp.CommonDecryptResponse;
import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;
import com.github.houbb.encryption.local.core.core.EncryptionContext;
import com.github.houbb.encryption.local.core.core.Encryptions;
import com.github.houbb.hash.api.IHash;
import com.github.houbb.hash.core.bs.HashBs;
import com.github.houbb.hash.core.core.hash.Hashes;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.secret.api.api.ISecret;
import com.github.houbb.secret.core.bs.SecretBs;
import com.github.houbb.secret.core.support.secret.Secrets;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public final class EncryptionLocalBs {

    private EncryptionLocalBs(){}

    public static EncryptionLocalBs newInstance() {
        return new EncryptionLocalBs();
    }

    /**
     * 秘钥
     */
    private String salt = null;

    /**
     * 哈希策略
     */
    private IHash hash = Hashes.md5();

    /**
     * 加密策略
     */
    private ISecret secret = Secrets.aes();

    /**
     * 上下文
     */
    private IEncryptionContext encryptionContext;

    public EncryptionLocalBs salt(String salt) {
        ArgUtil.notEmpty(salt, "salt");

        this.salt = salt;
        return this;
    }

    public EncryptionLocalBs hash(IHash hash) {
        ArgUtil.notNull(hash, "hash");

        this.hash = hash;
        return this;
    }

    public EncryptionLocalBs secret(ISecret secret) {
        ArgUtil.notNull(secret, "secret");

        this.secret = secret;
        return this;
    }

    /**
     * 初始化
     * @return this
     */
    public synchronized EncryptionLocalBs init() {
        ArgUtil.notEmpty(salt, "salt");

        HashBs hashBs = HashBs.newInstance()
                .hash(hash)
                .salt(salt.getBytes());

        SecretBs secretBs = SecretBs.newInstance()
                .secret(secret)
                .key(salt.getBytes());

        this.encryptionContext = EncryptionContext.newInstance()
            .hashBs(hashBs)
            .secretBs(secretBs);

        return this;
    }


    /**
     * 加密
     * @param encryption 策略
     * @param plainText 文本
     * @return 结果
     */
    public CommonEncryptResponse encrypt(final IEncryption encryption, String plainText) {
        checkStatus();

        CommonEncryptRequest request = new CommonEncryptRequest();
        request.setText(plainText);

        return encryption.encrypt(request, encryptionContext);
    }

    /**
     * 地址加密
     * @param plainText 文本
     * @return 结果
     */
    public CommonEncryptResponse addressEncrypt(String plainText) {
        return encrypt(Encryptions.address(), plainText);
    }

    /**
     * 姓名加密
     * @param plainText 文本
     * @return 结果
     */
    public CommonEncryptResponse nameEncrypt(String plainText) {
        return encrypt(Encryptions.name(), plainText);
    }

    /**
     * 邮箱加密
     * @param plainText 文本
     * @return 结果
     */
    public CommonEncryptResponse emailEncrypt(String plainText) {
        return encrypt(Encryptions.email(), plainText);
    }

    /**
     * 手机号加密
     * @param plainText 文本
     * @return 结果
     */
    public CommonEncryptResponse phoneEncrypt(String plainText) {
        return encrypt(Encryptions.phone(), plainText);
    }

    /**
     * 银行卡加密
     * @param plainText 文本
     * @return 结果
     */
    public CommonEncryptResponse bankCardNoEncrypt(String plainText) {
        return encrypt(Encryptions.bankCardNo(), plainText);
    }

    /**
     * 身份证加密
     * @param plainText 文本
     * @return 结果
     */
    public CommonEncryptResponse idCardEncrypt(String plainText) {
        return encrypt(Encryptions.idCard(), plainText);
    }

    /**
     * 解密
     * @param encryption 策略
     * @param cipher 文本
     * @return 结果
     */
    public String decrypt(final IEncryption encryption, String cipher) {
        checkStatus();

        CommonDecryptRequest request = new CommonDecryptRequest();
        request.setCipher(cipher);

        return encryption.decrypt(request, encryptionContext).getText();
    }

    /**
     * 地址解密
     * @param cipher 文本
     * @return 结果
     */
    public String addressDecrypt(String cipher) {
        return decrypt(Encryptions.address(), cipher);
    }

    /**
     * 姓名解密
     * @param cipher 文本
     * @return 结果
     */
    public String nameDecrypt(String cipher) {
        return decrypt(Encryptions.name(), cipher);
    }

    /**
     * 手机号解密
     * @param cipher 文本
     * @return 结果
     */
    public String phoneDecrypt(String cipher) {
        return decrypt(Encryptions.phone(), cipher);
    }

    /**
     * 邮箱解密
     * @param cipher 文本
     * @return 结果
     */
    public String emailDecrypt(String cipher) {
        return decrypt(Encryptions.email(), cipher);
    }

    /**
     * 银行卡号解密
     * @param cipher 文本
     * @return 结果
     */
    public String bankCardNoDecrypt(String cipher) {
        return decrypt(Encryptions.bankCardNo(), cipher);
    }

    /**
     * 银行卡号解密
     * @param cipher 文本
     * @return 结果
     */
    public String idCardDecrypt(String cipher) {
        return decrypt(Encryptions.idCard(), cipher);
    }

    /**
     * 生成摘要
     * @param plainText 文本
     * @return 结果
     */
    public String hash(String plainText) {
        checkStatus();

        //2. 摘要
        return this.encryptionContext.hashBs().execute(plainText);
    }

    private void checkStatus() {
        if(this.encryptionContext == null) {
            this.init();
        }
    }


}
