package com.github.houbb.encryption.local.core.core;


import com.github.houbb.encryption.local.core.util.InnerMaskUtil;

/**
 * 密码加解密
 * @author binbin.hou
 * @since 1.1.0
 */
public class PasswordEncryption extends AbstractEncryption {

    @Override
    protected String getMask(String plainText) {
        return InnerMaskUtil.password(plainText);
    }

}
