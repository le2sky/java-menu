package menu.domain;

public interface Menus {

    boolean contains(Menu menu);

    Menu getBy(String name);
}
