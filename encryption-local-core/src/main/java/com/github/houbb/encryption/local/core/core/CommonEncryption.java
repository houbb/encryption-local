package com.github.houbb.encryption.local.core.core;

import com.github.houbb.encryption.local.api.core.EncryptMaskContext;
import com.github.houbb.encryption.local.api.core.IEncryptMask;
import com.github.houbb.encryption.local.api.core.IEncryption;
import com.github.houbb.encryption.local.api.core.IEncryptionContext;
import com.github.houbb.encryption.local.api.dto.req.CommonDecryptRequest;
import com.github.houbb.encryption.local.api.dto.req.CommonEncryptRequest;
import com.github.houbb.encryption.local.api.dto.resp.CommonDecryptResponse;
import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;
import com.github.houbb.secret.core.bs.SecretBs;
import com.github.houbb.secret.core.util.HexUtil;

/**
 * 通用策略
 *
 * @author binbin.hou
 * @since 1.2.0
 */
public class CommonEncryption implements IEncryption {

    protected String getMask(CommonEncryptRequest request) {
        EncryptMaskContext context = new EncryptMaskContext();
        context.setPlainText(request.getText());

        final IEncryptMask encryptMask = request.getEncryptMask();
        return encryptMask.mask(context);
    }

    @Override
    public CommonEncryptResponse encrypt(CommonEncryptRequest request, IEncryptionContext context) {
        String plain = request.getText();

        //1. 加密
        String cipher = context.secretBs().encryptToHexString(plain);

        //2. 摘要
        String hash = context.hashBs().execute(plain);

        //3. 掩码
        String mask = getMask(request);

        CommonEncryptResponse response = new CommonEncryptResponse();
        response.setMask(mask);
        response.setCipher(cipher);
        response.setHash(hash);

        return response;
    }

    @Override
    public CommonDecryptResponse decrypt(CommonDecryptRequest request, IEncryptionContext context) {
        // 初始化一次
        SecretBs secretBs = context.secretBs();

        // https://www.jianshu.com/p/0d6b661b84dd
        byte[] bytes = HexUtil.hexStringToByte(request.getCipher());
        String plain = secretBs.decryptToString(bytes);

        CommonDecryptResponse response = new CommonDecryptResponse();
        response.setText(plain);
        return response;
    }

}
