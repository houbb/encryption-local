package com.github.houbb.encryption.local.api.dto.resp;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class CommonDecryptResponse extends CommonResponse {

    /**
     * 解密之后的文本
     */
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
