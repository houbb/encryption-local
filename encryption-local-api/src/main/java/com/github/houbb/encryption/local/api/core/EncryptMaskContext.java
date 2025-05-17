package com.github.houbb.encryption.local.api.core;

/**
 * 掩码上下文
 *
 * @since 1.2.0
 */
public class EncryptMaskContext {

    /**
     * 原始文本
     */
    private String plainText;

    /**
     * 类别
     */
    private String type;

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EncryptMaskContext{" +
                "plainText='" + plainText + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
