package com.github.houbb.encryption.local.core.core;


import com.github.houbb.encryption.local.core.util.InnerMaskUtil;

/**
 * 身份证加解密
 * @author binbin.hou
 * @since 1.0.0
 */
public class IdCardEncryption extends AbstractEncryption {

    @Override
    protected String getMask(String plainText) {
        return InnerMaskUtil.idCard(plainText);
    }

}
