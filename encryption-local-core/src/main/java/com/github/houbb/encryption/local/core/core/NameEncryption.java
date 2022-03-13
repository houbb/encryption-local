package com.github.houbb.encryption.local.core.core;


import com.github.houbb.encryption.local.core.util.InnerMaskUtil;

/**
 * 姓名加解密
 * @author binbin.hou
 * @since 1.0.0
 */
public class NameEncryption extends AbstractEncryption {

    @Override
    protected String getMask(String plainText) {
        return InnerMaskUtil.chineseName(plainText);
    }

}
