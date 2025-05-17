package com.github.houbb.encryption.local.core.support.mask;

import com.github.houbb.encryption.local.api.core.EncryptMaskContext;
import com.github.houbb.encryption.local.core.util.InnerMaskUtil;

/**
 * @since 1.2.0
 */
public class EncryptMaskPassword extends AbstractEncryptMask {

    @Override
    protected String doMask(EncryptMaskContext context) {
        return InnerMaskUtil.password(context.getPlainText());
    }

}
