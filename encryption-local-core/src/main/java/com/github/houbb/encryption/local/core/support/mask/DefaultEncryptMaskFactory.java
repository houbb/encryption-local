package com.github.houbb.encryption.local.core.support.mask;


import com.github.houbb.encryption.local.api.core.IEncryptMask;
import com.github.houbb.encryption.local.api.core.IEncryptMaskFactory;
import com.github.houbb.encryption.local.api.enums.EncryptTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class DefaultEncryptMaskFactory implements IEncryptMaskFactory {

    private final Map<String, IEncryptMask> map = new HashMap<>();

    public DefaultEncryptMaskFactory() {
        map.put(EncryptTypeEnum.ADDRESS.getCode(), EncryptMasks.address());
        map.put(EncryptTypeEnum.BANK_CARD_NUM.getCode(), EncryptMasks.bankCardNum());
        map.put(EncryptTypeEnum.EMAIL.getCode(), EncryptMasks.email());
        map.put(EncryptTypeEnum.ID_CARD.getCode(), EncryptMasks.idCard());
        map.put(EncryptTypeEnum.NAME.getCode(), EncryptMasks.chineseName());
        map.put(EncryptTypeEnum.PASSWORD.getCode(), EncryptMasks.password());
        map.put(EncryptTypeEnum.PHONE.getCode(), EncryptMasks.phone());
    }

    @Override
    public IEncryptMask get(String type) {
        return map.get(type);
    }

}
