package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final String INVALID_NAME_LENGTH_RANGE =
            "이름의 길이는 최소 " + MIN_NAME_LENGTH + "글자에서 " + MAX_NAME_LENGTH + "글자입니다.";
    private static final int MAX_HATE_MENU_SIZE = 2;
    private static final String INVALID_HATE_MENU_SIZE_MESSAGE =
            "코치가 먹지 못하는 음식은 " + MAX_HATE_MENU_SIZE + "개 이하만 설정해주세요.";
    private static final String HATE_MENUS_DUPLICATION_MESSAGE = "중복된 메뉴를 포함하고 있습니다.";

    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();

    public Coach(String name) {
        checkNameLength(name);

        this.name = name;
    }

    private static void checkNameLength(String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_RANGE);
        }
    }

    private static boolean isInvalidNameLength(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    public void setHateMenus(List<Menu> menus) {
        checkHateMenusSize(menus);
        checkHateMenusDuplication(menus);

        hateMenus.clear();
        hateMenus.addAll(menus);
    }

    private void checkHateMenusSize(List<Menu> menus) {
        if (isInvalidMenusSize(menus)) {
            throw new IllegalArgumentException(INVALID_HATE_MENU_SIZE_MESSAGE);
        }
    }

    private boolean isInvalidMenusSize(List<Menu> menus) {
        return menus.size() > MAX_HATE_MENU_SIZE;
    }

    private void checkHateMenusDuplication(List<Menu> menus) {
        if (hasDuplication(menus)) {
            throw new IllegalArgumentException(HATE_MENUS_DUPLICATION_MESSAGE);
        }
    }

    private boolean hasDuplication(List<Menu> menus) {
        return calculateUniqueSize(menus) != menus.size();
    }

    private int calculateUniqueSize(List<Menu> menus) {
        return menus.stream().distinct().toList().size();
    }

    public boolean isHate(Menu menu) {
        return hateMenus.contains(menu);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
