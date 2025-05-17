package com.github.houbb.encryption.local.api.core;


/**
 * 工厂
 *
 * @author binbin.hou
 * @since 1.2.0
 */
public interface IEncryptionFactory {

    /**
     * 实现
     * @param type 请求
     * @return 结果
     */
    IEncryption get(final String type);

}
