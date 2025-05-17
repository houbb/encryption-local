package com.github.houbb.encryption.local.core.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InnerMaskUtilTest {

    // region phone()
    @Test
    public void phone_withNull_shouldReturnNull() {
        assertNull(InnerMaskUtil.phone(null));
    }

    @Test
    public void phone_withEmpty_shouldReturnEmpty() {
        assertEquals("", InnerMaskUtil.phone(""));
    }

    @Test
    public void phone_withShortNumber_shouldNotMask() {
        assertEquals("123", InnerMaskUtil.phone("123"));
    }

    @Test
    public void phone_withNormalPhone_shouldMaskMiddle() {
        assertEquals("138****8000", InnerMaskUtil.phone("13800138000"));
    }
    // endregion

    // region email()
    @Test
    public void email_withNull_shouldReturnNull() {
        assertNull(InnerMaskUtil.email(null));
    }

    @Test
    public void email_withEmpty_shouldReturnEmpty() {
        assertEquals("", InnerMaskUtil.email(""));
    }

    @Test
    public void email_withSimpleEmail_shouldMaskMiddle() {
        assertEquals("abc@test.com", InnerMaskUtil.email("abc@test.com"));
    }

    @Test
    public void email_withShortLocalPart_shouldMaskCorrectly() {
        assertEquals("a@b.com", InnerMaskUtil.email("a@b.com"));
    }
    // endregion

    // region chineseName()
    @Test
    public void chineseName_withNull_shouldReturnNull() {
        assertNull(InnerMaskUtil.chineseName(null));
    }

    @Test
    public void chineseName_withEmpty_shouldReturnEmpty() {
        assertEquals("", InnerMaskUtil.chineseName(""));
    }

    @Test
    public void chineseName_withSingleChar_shouldNotMask() {
        assertEquals("张", InnerMaskUtil.chineseName("张"));
    }

    @Test
    public void chineseName_withTwoChars_shouldMaskFirst() {
        assertEquals("*四", InnerMaskUtil.chineseName("李四"));
    }

    @Test
    public void chineseName_withThreeChars_shouldMaskMiddle() {
        assertEquals("王*中", InnerMaskUtil.chineseName("王五中"));
    }

    @Test
    public void chineseName_withLongName_shouldMaskMiddle() {
        assertEquals("欧**文", InnerMaskUtil.chineseName("欧阳修文"));
    }
    // endregion

    // region bankCardNum()
    @Test
    public void bankCardNum_withShortCardId_shouldReturnOriginal() {
        assertEquals("1234567890", InnerMaskUtil.bankCardNum("1234567890"));
    }

    @Test
    public void bankCardNum_withNormalCardId_shouldMaskMiddle() {
        assertEquals("622848*********0018",
                InnerMaskUtil.bankCardNum("6228480402564890018"));
    }
    // endregion

    // region idCard()
    @Test
    public void idCard_with15Digits_shouldMaskMiddle() {
        assertEquals("110101*********316",
                InnerMaskUtil.idCard("110101199003072316"));
    }

    @Test
    public void idCard_with18Digits_shouldMaskMiddle() {
        assertEquals("110101*********396",
                InnerMaskUtil.idCard("110101199003072396"));
    }
    // endregion

    // region address()
    @Test
    public void address_withShortAddress_shouldReturnOriginal() {
        assertEquals("北京", InnerMaskUtil.address("北京"));
    }

    @Test
    public void address_withLongAddress_shouldMaskMiddle() {
        assertEquals("北京市朝阳区**路87号",
                InnerMaskUtil.address("北京市朝阳区解放路87号"));
    }
    // endregion

    // region password()
    @Test
    public void password_withNull_shouldReturnEmpty() {
        assertEquals(null, InnerMaskUtil.password(null));
    }

    @Test
    public void password_withEmpty_shouldReturnEmpty() {
        assertEquals("", InnerMaskUtil.password(""));
    }

    @Test
    public void password_withNonEmptyPassword_shouldReturnStars() {
        assertEquals("******", InnerMaskUtil.password("123456"));
        assertEquals("*******", InnerMaskUtil.password("abcdefg"));
    }
    // endregion
}
