package com.github.houbb.encryption.local.core.core;


import com.github.houbb.encryption.local.core.util.InnerMaskUtil;

/**
 * 地址加解密
 * @author binbin.hou
 * @since 1.0.0
 */
public class AddressEncryption extends AbstractEncryption {

    @Override
    protected String getMask(String plainText) {
        return InnerMaskUtil.address(plainText);
    }

}
