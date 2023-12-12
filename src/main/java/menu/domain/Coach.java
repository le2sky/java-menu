package menu.domain;

import java.util.List;
import java.util.Objects;

public class Coach {

    private final Name name;
    private List<Menu> hateMenus;

    public Coach(Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getValue();
    }

    public void setHateMenu(List<Menu> menus) {
        checkMenusSize(menus);
        checkMenusDuplication(menus);

        hateMenus = menus;
    }

    private void checkMenusSize(List<Menu> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException("각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴를 설정해야 합니다.");
        }
    }

    private void checkMenusDuplication(List<Menu> menus) {
        if (calculateUniqueMenusSize(menus) != menus.size()) {
            throw new IllegalArgumentException("중복 메뉴가 포함되어 있습니다.");
        }
    }

    private int calculateUniqueMenusSize(List<Menu> menus) {
        return menus.stream()
                .distinct()
                .toList()
                .size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name) && Objects.equals(hateMenus, coach.hateMenus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hateMenus);
    }
}
