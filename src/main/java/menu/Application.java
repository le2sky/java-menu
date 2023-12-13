package menu;

import menu.infrastructure.RandomCategoryPicker;

public class Application {

    public static void main(String[] args) {
        MenusData menus = new MenusData();
        ObjectMapper.setData(menus);
        Controller controller = new Controller(menus, new RandomCategoryPicker());

        controller.run();
    }
}
