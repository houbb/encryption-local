package com.github.houbb.encryption.local.api.dto.req;

/**
 * 解密入参
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class CommonDecryptRequest extends CommonRequest {

    /**
     * 密文
     */
    private String cipher;

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

}
