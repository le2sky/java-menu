package menu.domain;

import java.util.List;

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
        hateMenus = menus;
    }
}
