package com.eorl.domain.store;

import com.eorl.domain.common.EnumData;
import java.util.Arrays;
import java.util.NoSuchElementException;
import lombok.ToString;

@ToString
public enum StoreStatus implements EnumData {

    ACTIVE("1", "정상"),
    UN_ACTIVE("2", "폐업"),
    CLOSED("3", "휴업");

    String code;
    String title;

    StoreStatus(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public static StoreStatus getInstance(String code) {
        return Arrays.stream(StoreStatus.values())
                .filter(s -> s.getCode().equals(code))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }

}
