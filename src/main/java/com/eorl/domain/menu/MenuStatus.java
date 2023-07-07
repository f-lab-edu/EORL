package com.eorl.domain.menu;

import com.eorl.domain.common.EnumData;
import java.util.Arrays;
import java.util.NoSuchElementException;
import lombok.ToString;

@ToString
public enum MenuStatus implements EnumData {

    ACTIVE(1, "제공"),
    UN_ACTIVE(2, "미제공"),
    DELETE(3, "삭제");

    final int code;
    final String title;

    MenuStatus(int code, String title) {
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

    public static MenuStatus valueOf(int code) {
        return Arrays.stream(MenuStatus.values())
                .filter(s -> s.getCode() == code)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
