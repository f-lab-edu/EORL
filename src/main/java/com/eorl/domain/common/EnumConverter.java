package com.eorl.domain.common;

import com.eorl.domain.store.StoreStatus;
import jakarta.persistence.AttributeConverter;

public class EnumConverter implements AttributeConverter<EnumData, String> {

    @Override
    public String convertToDatabaseColumn(EnumData attribute) {
        if( attribute == null ){
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public EnumData convertToEntityAttribute(String dbData) {
        EnumData result = null;

        if (dbData != null && !dbData.isEmpty()) {
            result = getEnumData(this, dbData);
        }
        return result;
    }

    private EnumData getEnumData(Object enumData, String dbData) {

        if( enumData instanceof StoreStatus )
            return StoreStatus.getInstance(dbData);

        return null;
    }

}
