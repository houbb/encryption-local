package com.github.houbb.encryption.local.api.core;

/**
 * 掩码
 *
 * @since 1.2.0
 */
public interface IEncryptMaskFactory {

    /**
     * 实现
     * @param type 请求
     * @return 结果
     */
    IEncryptMask get(final String type);

}
