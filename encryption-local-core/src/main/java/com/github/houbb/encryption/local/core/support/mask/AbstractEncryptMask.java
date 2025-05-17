package com.github.houbb.encryption.local.core.support.mask;

import com.github.houbb.encryption.local.api.core.EncryptMaskContext;
import com.github.houbb.encryption.local.api.core.IEncryptMask;
import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * 基础类
 *
 * @since 1.2.0
 */
public abstract class AbstractEncryptMask implements IEncryptMask {

    protected abstract String doMask(EncryptMaskContext context);

    @Override
    public String mask(EncryptMaskContext context) {
        String plainText = context.getPlainText();
        if(StringUtil.isEmpty(plainText)) {
            return plainText;
        }

        return doMask(context);
    }

}
