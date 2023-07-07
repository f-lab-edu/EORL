package com.eorl.domain.common;

import com.eorl.domain.menu.MenuStatus;
import com.eorl.domain.store.StoreStatus;
import jakarta.persistence.AttributeConverter;

public class EnumConverter implements AttributeConverter<EnumData, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EnumData attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public EnumData convertToEntityAttribute(Integer dbData) {
        EnumData result = null;

        if (dbData != null) {
            result = getEnumData(this, dbData);
        }
        return result;
    }

    private EnumData getEnumData(Object enumData, Integer dbData) {

        if (enumData instanceof StoreStatus) {
            return StoreStatus.valueOf(dbData);
        } else if (enumData instanceof MenuStatus) {
            return MenuStatus.valueOf(dbData);
        }

        return null;
    }

}
