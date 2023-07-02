package com.eorl.domain.menu;

import com.eorl.domain.common.EnumData;
import java.util.Arrays;
import java.util.NoSuchElementException;
import lombok.ToString;

@ToString
public enum MenuStatus implements EnumData {


    ACTiVE("1", "제공"),
    UN_ACTIVE("2", "미제공"),
    DELETE("3", "삭제");

    String code;
    String title;

    MenuStatus(String code, String title) {
        this.code = code;
        this.title = title;
    }


    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    public static MenuStatus getInstance(String code) {
        return Arrays.stream(MenuStatus.values())
                .filter(s -> s.getCode().equals(code))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }
}
