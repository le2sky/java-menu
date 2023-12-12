package menu.domain;

import java.util.Objects;

public class Menu {

    private String name;
    private MenuCategory category;

    public Menu(String name, MenuCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public boolean isCategorizedBy(MenuCategory targetCategory) {
        return category.equals(targetCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) && category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
