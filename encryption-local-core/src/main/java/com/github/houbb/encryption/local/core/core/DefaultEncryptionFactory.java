package com.github.houbb.encryption.local.core.core;

import com.github.houbb.encryption.local.api.core.IEncryption;
import com.github.houbb.encryption.local.api.core.IEncryptionFactory;

public class DefaultEncryptionFactory implements IEncryptionFactory {

    private static final IEncryption ENCRYPTION = new CommonEncryption();

    @Override
    public IEncryption get(String type) {
        return ENCRYPTION;
    }

}
