package menu.domain;

import java.util.Arrays;

public enum Category {

    일식(1),
    한식(2),
    중식(3),
    아시안(4),
    양식(5);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public static Category get(int value) {
        return Arrays.stream(Category.values())
                .filter(category -> category.value == value)
                .findFirst()
                .orElseThrow();
    }
}
