package menu.domain;

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
}
