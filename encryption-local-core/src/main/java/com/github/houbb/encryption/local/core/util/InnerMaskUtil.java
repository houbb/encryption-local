package com.github.houbb.encryption.local.core.util;

import com.github.houbb.heaven.constant.PunctuationConst;
import com.github.houbb.heaven.util.lang.StringUtil;

/**
 * https://www.cnblogs.com/cailijuan/p/11505217.html
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public final class InnerMaskUtil {

    private InnerMaskUtil(){}

    /**
     * 脱敏电话号码
     * @param phone 电话号码
     * @return 结果
     */
    public static String phone(final String phone) {
        if(StringUtil.isEmpty(phone)) {
            return phone;
        }
        if(phone.length() <= 3) {
            return phone;
        }

        final int prefixLength = 3;
        final String middle = "****";
        return StringUtil.buildString(phone, middle, prefixLength);
    }

    /**
     * 脱敏邮箱
     * @param email 邮箱
     * @return 结果
     */
    public static String email(final String email) {
        if(StringUtil.isEmpty(email)) {
            return email;
        }

        final int prefixLength = 3;

        final int atIndex = email.indexOf(PunctuationConst.AT);
        String middle = "****";

        if(atIndex > 0) {
            int middleLength = atIndex - prefixLength;
            middle = StringUtil.repeat(PunctuationConst.STAR, middleLength);
        }
        return StringUtil.buildString(email, middle, prefixLength);
    }

    /**
     * 脱敏中文名称
     * @param chineseName 中文名称
     * @return 脱敏后的结果
     */
    public static String chineseName(final String chineseName) {
        if(StringUtil.isEmpty(chineseName)) {
            return chineseName;
        }

        final int nameLength = chineseName.length();
        if(1 == nameLength) {
            return chineseName;
        }

        if(2 == nameLength) {
            return PunctuationConst.STAR + chineseName.charAt(1);
        }

        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(chineseName.charAt(0));
        for(int i = 0; i < nameLength-2; i++) {
            stringBuffer.append(PunctuationConst.STAR);
        }
        stringBuffer.append(chineseName.charAt(nameLength -1));
        return stringBuffer.toString();
    }

    /**
     * 脱敏银行卡号（前6后4）
     * @param cardId 卡号
     * @return 脱敏结果
     */
    public static String bankCardNum(final String cardId) {
        if(StringUtil.isEmpty(cardId)) {
            return cardId;
        }

        final int prefixLength = 6;
        int times = cardId.length() - 10;
        final String middle = StringUtil.repeat("*", times);
        return StringUtil.buildString(cardId, middle, prefixLength);
    }

    /**
     * 脱敏身份证号
     * 保留前六后三, 适用于15位和18位身份证
     * @param cardId 卡号
     * @return 脱敏结果
     */
    public static String idCard(final String cardId) {
        if(StringUtil.isEmpty(cardId)) {
            return cardId;
        }

        final int prefixLength = 6;
        int times = cardId.length() - 9;
        final String middle = StringUtil.repeat("*", times);
        return StringUtil.buildString(cardId, middle, prefixLength);
    }

    /**
     * 地址信息脱敏
     * 保留前6后4
     * @param address 地址
     * @return 脱敏结果
     */
    public static String address(final String address) {
        if(StringUtil.isEmpty(address)) {
            return address;
        }

        final int prefixLength = 6;
        int times = address.length() - 10;
        final String middle = StringUtil.repeat("*", times);
        return StringUtil.buildString(address, middle, prefixLength);
    }

    /**
     * 密码信息脱敏
     * @param password 地址
     * @return 脱敏结果
     * @since 1.1.0
     */
    public static String password(final String password) {
        if(StringUtil.isEmpty(password)) {
            return password;
        }

        return StringUtil.repeat("*", password.length());
    }

}
