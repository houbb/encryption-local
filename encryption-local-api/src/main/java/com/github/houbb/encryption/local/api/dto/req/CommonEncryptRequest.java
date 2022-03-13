package com.github.houbb.encryption.local.api.dto.req;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
