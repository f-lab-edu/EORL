package com.eorl.domain.store;

import com.eorl.domain.common.EnumData;
import java.util.Arrays;
import java.util.NoSuchElementException;
import lombok.ToString;

@ToString
public enum StoreStatus implements EnumData {

    ACTIVE(1, "정상"),
    UN_ACTIVE(2, "폐업"),
    CLOSED(3, "휴업");

    final int code;
    final String title;

    StoreStatus(int code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public static StoreStatus valueOf(int code) {
        return Arrays.stream(StoreStatus.values())
                .filter(s -> s.getCode() == code)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
