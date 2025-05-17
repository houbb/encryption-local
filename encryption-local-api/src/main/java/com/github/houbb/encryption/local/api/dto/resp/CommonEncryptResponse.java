package com.github.houbb.encryption.local.api.dto.resp;

/**
 * 加密响应
 * @author binbin.hou
 * @since 1.0.0
 */
public class CommonEncryptResponse extends CommonResponse {

    /**
     * 密文
     */
    private String cipher;

    /**
     * 掩码
     */
    private String mask;

    /**
     * 摘要
     */
    private String hash;

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "CommonEncryptResponse{" +
                "cipher='" + cipher + '\'' +
                ", mask='" + mask + '\'' +
                ", hash='" + hash + '\'' +
                "}";
    }

}
