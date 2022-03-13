package com.github.houbb.encryption.local.api.core;


import com.github.houbb.encryption.local.api.dto.req.CommonDecryptRequest;
import com.github.houbb.encryption.local.api.dto.req.CommonEncryptRequest;
import com.github.houbb.encryption.local.api.dto.resp.CommonDecryptResponse;
import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;

/**
 * 加解密接口
 * @author binbin.hou
 * @since 1.0.0
 */
public interface IEncryption {

    /**
     * 加密
     * @param request 请求
     * @param context 上下文
     * @return 结果
     */
    CommonEncryptResponse encrypt(final CommonEncryptRequest request,
                                  final IEncryptionContext context);

    /**
     * 解密
     * @param request 请求
     * @param context 上下文
     * @return 结果
     */
    CommonDecryptResponse decrypt(final CommonDecryptRequest request,
                                  final IEncryptionContext context);

}
