package com.github.houbb.encryption.local.test;

import com.github.houbb.encryption.local.api.dto.resp.CommonEncryptResponse;
import com.github.houbb.encryption.local.core.bs.EncryptionLocalBs;
import com.github.houbb.encryption.local.core.util.EncryptionLocalUtil;
import com.github.houbb.hash.core.core.hash.Hashes;
import com.github.houbb.secret.core.support.secret.Secrets;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class EncryptionLocalBsTest {

    private EncryptionLocalBs getLocalBs() {
        return EncryptionLocalBs.newInstance()
                .hash(Hashes.md5())
                .secret(Secrets.aes())
                .salt("99886622");
    }

    @Test
    public void addressTest() {
        final String address = "太平洋比基尼海滩比奇堡镇贝壳街124号的波萝屋";

        EncryptionLocalBs localBs = getLocalBs();
        CommonEncryptResponse response = localBs.addressEncrypt(address);
        String cipher = response.getCipher();
        String mask = response.getMask();
        String hash = response.getHash();
        Assert.assertEquals("D8D9E99FB8286107C2F75325C0B9046CF335EE4AC4FCD3F27E0D6BFD8B3DBF39440A3D69422A3AF933576798CF3860F330F288E196CEACB22CCCDA0623B94355", cipher);
        Assert.assertEquals("太平洋比基尼*************的波萝屋", mask);
        Assert.assertEquals("31912515337902B8A3CC1CBDB5772358", hash);

        // 解密
        String plain = localBs.addressDecrypt(cipher);
        Assert.assertEquals(address, plain);
    }

    @Test
    public void nameTest() {
        final String name = "海绵宝宝";
        EncryptionLocalBs localBs = getLocalBs();

        CommonEncryptResponse response = localBs.nameEncrypt(name);
        String cipher = response.getCipher();
        String mask = response.getMask();
        String hash = response.getHash();
        Assert.assertEquals("91AF56071FA8830391144DBEAE3967DA", cipher);
        Assert.assertEquals("海**宝", mask);
        Assert.assertEquals("94B221D98E0EF588B5304A88752DC6C7", hash);

        // 解密
        String plain = localBs.nameDecrypt(cipher);
        Assert.assertEquals(name, plain);
    }

    @Test
    public void emailTest() {
        final String email = "haimian@baobao.com";
        EncryptionLocalBs localBs = getLocalBs();

        CommonEncryptResponse response = localBs.emailEncrypt(email);
        String cipher = response.getCipher();
        String mask = response.getMask();
        String hash = response.getHash();
        Assert.assertEquals("15768CD9C0E70E2C798451E7982C8877DF991568ECD7BC3E1A9E9AD72455B085", cipher);
        Assert.assertEquals("hai****@baobao.com", mask);
        Assert.assertEquals("4C651B4CDACA3CFA4876277B678282A9", hash);

        // 解密
        String plain = localBs.emailDecrypt(cipher);
        Assert.assertEquals(email, plain);
    }

    @Test
    public void phoneTest() {
        final String email = "18888888888";
        EncryptionLocalBs localBs = getLocalBs();

        CommonEncryptResponse response = localBs.phoneEncrypt(email);
        String cipher = response.getCipher();
        String mask = response.getMask();
        String hash = response.getHash();
        Assert.assertEquals("08276740AEC8AAC11C6D0F84184DE2B5", cipher);
        Assert.assertEquals("188****8888", mask);
        Assert.assertEquals("381FA900C0626D7D7E2DB185B3558166", hash);

        // 解密
        String plain = localBs.phoneDecrypt(cipher);
        Assert.assertEquals(email, plain);
    }

    @Test
    public void idCardTest() {
        final String idCard = "330781198509079479";
        EncryptionLocalBs localBs = getLocalBs();

        CommonEncryptResponse response = localBs.idCardEncrypt(idCard);
        String cipher = response.getCipher();
        String mask = response.getMask();
        String hash = response.getHash();
        Assert.assertEquals("74101E0AAF25796680E40F3198D1AEFBC00E25FD8316F40CE90B425338894A42", cipher);
        Assert.assertEquals("330781*********479", mask);
        Assert.assertEquals("2C7E7A814C36DE11EF01F39C35CECF12", hash);

        // 解密
        String plain = localBs.idCardDecrypt(cipher);
        Assert.assertEquals(idCard, plain);
    }

    //https://ddu1222.github.io/bankcard-validator/bcBuilder.html
    // 测试数据
    @Test
    public void bankCardNoTest() {
        final String bankCardNoTest = "4427290920309717";
        EncryptionLocalBs localBs = getLocalBs();

        CommonEncryptResponse response = localBs.bankCardNoEncrypt(bankCardNoTest);
        String cipher = response.getCipher();
        String mask = response.getMask();
        String hash = response.getHash();
        Assert.assertEquals("288D5EC5432203677D3714E9A270F9998AC04BF65E5A36C6773187A4239D05EE", cipher);
        Assert.assertEquals("442729******9717", mask);
        Assert.assertEquals("DE550BAF362B3EF640FF5AEC7D6E2F38", hash);

        // 解密
        String plain = localBs.idCardDecrypt(cipher);
        Assert.assertEquals(bankCardNoTest, plain);
    }

}
