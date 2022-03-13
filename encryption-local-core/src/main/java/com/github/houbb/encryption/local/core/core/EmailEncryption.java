package com.github.houbb.encryption.local.core.core;


import com.github.houbb.encryption.local.core.util.InnerMaskUtil;

/**
 * 邮箱加解密
 * @author binbin.hou
 * @since 1.0.0
 */
public class EmailEncryption extends AbstractEncryption {

    @Override
    protected String getMask(String plainText) {
        return InnerMaskUtil.email(plainText);
    }

}
