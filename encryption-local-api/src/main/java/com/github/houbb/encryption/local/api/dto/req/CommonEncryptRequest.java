package com.github.houbb.encryption.local.api.dto.req;

import com.github.houbb.encryption.local.api.core.IEncryptMask;

/**
 * 加密入参
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class CommonEncryptRequest extends CommonRequest {

    /**
     * 待加密内容
     */
    private String text;

    /**
     * 加密策略
     * @since 1.2.0
     */
    private IEncryptMask encryptMask;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public IEncryptMask getEncryptMask() {
        return encryptMask;
    }

    public void setEncryptMask(IEncryptMask encryptMask) {
        this.encryptMask = encryptMask;
    }
}
