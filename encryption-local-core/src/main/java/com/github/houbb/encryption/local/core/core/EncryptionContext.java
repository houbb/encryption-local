package com.github.houbb.encryption.local.core.core;

import com.github.houbb.encryption.local.api.core.IEncryptionContext;
import com.github.houbb.hash.core.bs.HashBs;
import com.github.houbb.secret.core.bs.SecretBs;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class EncryptionContext implements IEncryptionContext {

    /**
     * 摘要策略
     */
    private HashBs hashBs;

    /**
     * 加密策略
     */
    private SecretBs secretBs;

    public static EncryptionContext newInstance() {
        return new EncryptionContext();
    }

    @Override
    public HashBs hashBs() {
        return hashBs;
    }

    public EncryptionContext hashBs(HashBs hashBs) {
        this.hashBs = hashBs;
        return this;
    }

    @Override
    public SecretBs secretBs() {
        return secretBs;
    }

    public EncryptionContext secretBs(SecretBs secretBs) {
        this.secretBs = secretBs;
        return this;
    }
}
