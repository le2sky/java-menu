package menu;

import menu.domain.Category;
import menu.infrastructure.SimpleCategoryPicker;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        SimpleCategoryPicker categories = new SimpleCategoryPicker();
        categories.setData(List.of(
                Category.아시안,
                Category.아시안,
                Category.아시안,
                Category.양식,
                Category.일식,
                Category.중식
        ));
        MenusData menus = new MenusData();
        ObjectMapper.setData(menus);
        Controller controller = new Controller(menus, categories);
        controller.run();
    }
}
