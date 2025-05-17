package com.github.houbb.encryption.local.core.bs;

import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;
import com.github.houbb.encryption.local.api.enums.EncryptTypeEnum;
import org.junit.Assert;
import org.junit.Test;

public class EncryptionLocalBsTest {

    @Test
    public void passwordTest() {
        EncryptionLocalBs localBs = EncryptionLocalBs.newInstance();

        // 加密
        CommonEncryptResponse encryptResponse = localBs.encrypt("123456", EncryptTypeEnum.PASSWORD.getCode());
        Assert.assertEquals("CommonEncryptResponse{cipher='8B208237BEB2E6A4390E7128E5E000D7', mask='******', hash='FEB408A10822A55A939E8E38A6612515'}", encryptResponse.toString());

        // 解密
        String plainText = localBs.decrypt(encryptResponse.getCipher(), EncryptTypeEnum.PASSWORD.getCode());
        Assert.assertEquals("123456", plainText);
    }

}
