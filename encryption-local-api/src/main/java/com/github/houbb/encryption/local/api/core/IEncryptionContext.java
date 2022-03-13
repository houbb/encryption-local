package com.github.houbb.encryption.local.api.core;


import com.github.houbb.hash.api.IHash;
import com.github.houbb.hash.core.bs.HashBs;
import com.github.houbb.secret.api.api.ISecret;
import com.github.houbb.secret.core.bs.SecretBs;

/**
 * 加解密上下文接口
 * @author binbin.hou
 * @since 1.0.0
 */
public interface IEncryptionContext {

    /**
     * 加密引导类
     * @return 加密
     */
    SecretBs secretBs();

    /**
     * 哈希引导类
     * @return 哈希
     */
    HashBs hashBs();

}
