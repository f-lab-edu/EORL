package com.eorl.domain.common;

import com.eorl.domain.store.StoreStatus;
import java.util.Arrays;
import java.util.NoSuchElementException;

public interface EnumData<T> {

    String getCode();
    String getTitle();

    /*static EnumData getInstance(String code) {
        return Arrays.stream(StoreStatus.values())
                .filter(s -> s.getCode().equals(code))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    };*/
}
