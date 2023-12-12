package menu.domain;

import java.util.Arrays;

public enum MenuCategory {

    일식(1),
    한식(2),
    중식(3),
    아시안(4),
    양식(5);

    private final int value;

    MenuCategory(int value) {
        this.value = value;
    }

    public static MenuCategory get(int value) {
        return Arrays.stream(values())
                .filter(v -> v.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }
}
