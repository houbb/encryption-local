package com.github.houbb.encryption.local.core.bs;

import com.github.houbb.encryption.local.api.core.*;
import com.github.houbb.encryption.local.api.dto.req.CommonDecryptRequest;
import com.github.houbb.encryption.local.api.dto.req.CommonEncryptRequest;
import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;
import com.github.houbb.encryption.local.core.core.DefaultEncryptionFactory;
import com.github.houbb.encryption.local.core.core.EncryptionContext;
import com.github.houbb.encryption.local.core.support.mask.DefaultEncryptMaskFactory;
import com.github.houbb.hash.api.IHash;
import com.github.houbb.hash.core.bs.HashBs;
import com.github.houbb.hash.core.core.hash.Hashes;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.secret.api.api.ISecret;
import com.github.houbb.secret.core.bs.SecretBs;
import com.github.houbb.secret.core.support.secret.Secrets;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
     * 编码
     */
    private Charset charset = StandardCharsets.UTF_8;

    /**
     * 秘钥
     *
     * 建议用户自己指定
     */
    private String salt = "99886622";

    /**
     * 哈希策略
     */
    private IHash hash = Hashes.md5();

    /**
     * 加密策略
     */
    private ISecret secret = Secrets.aes();

    /**
     * 掩码工厂策略
     * @since 1.2.0
     */
    private IEncryptMaskFactory maskFactory = new DefaultEncryptMaskFactory();

    /**
     * 加密工厂策略
     * @since 1.2.0
     */
    private IEncryptionFactory encryptionFactory = new DefaultEncryptionFactory();

    /**
     * 上下文
     */
    private IEncryptionContext encryptionContext;


    public EncryptionLocalBs charset(Charset charset) {
        ArgUtil.notNull(charset, "charset");

        this.charset = charset;
        return this;
    }

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

    public EncryptionLocalBs maskFactory(IEncryptMaskFactory maskFactory) {
        ArgUtil.notNull(maskFactory, "maskFactory");

        this.maskFactory = maskFactory;
        return this;
    }

    public EncryptionLocalBs encryptionFactory(IEncryptionFactory encryptionFactory) {
        ArgUtil.notNull(encryptionFactory, "encryptionFactory");

        this.encryptionFactory = encryptionFactory;
        return this;
    }

    /**
     * 初始化
     * @return this
     */
    public synchronized EncryptionLocalBs init() {
        ArgUtil.notEmpty(salt, "salt");

        final byte[] salts = salt.getBytes(charset);
        HashBs hashBs = HashBs.newInstance()
                .charset(charset)
                .hash(hash)
                .salt(salts);

        SecretBs secretBs = SecretBs.newInstance()
                .charset(charset.name())
                .secret(secret)
                .key(salts);

        this.encryptionContext = EncryptionContext.newInstance()
            .hashBs(hashBs)
            .secretBs(secretBs);

        return this;
    }


    /**
     * 加密
     * @param plainText 文本
     * @param type 类别
     * @return 结果
     * @since 1.2.0
     */
    public CommonEncryptResponse encrypt(String plainText, String type) {
        checkStatus();

        final IEncryptMask encryptMask = maskFactory.get(type);
        final IEncryption encryption = encryptionFactory.get(type);

        CommonEncryptRequest request = new CommonEncryptRequest();
        request.setText(plainText);
        request.setEncryptMask(encryptMask);

        return encryption.encrypt(request, encryptionContext);
    }

    /**
     * 解密
     * @param cipher 文本
     * @param type 类别
     * @return 结果
     */
    public String decrypt(String cipher, String type) {
        checkStatus();

        final IEncryption encryption = encryptionFactory.get(type);

        CommonDecryptRequest request = new CommonDecryptRequest();
        request.setCipher(cipher);
        return encryption.decrypt(request, encryptionContext).getText();
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
