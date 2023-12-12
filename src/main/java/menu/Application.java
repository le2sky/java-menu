package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.infrastructure.AllMenusData;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new RecommendationService(getMenuCategories(), getMenus()));

        controller.run();
    }

    private static MenuCategories getMenuCategories() {

        return new MenuCategories() {

            @Override
            public MenuCategory pickOne() {
                return MenuCategory.get(Randoms.pickNumberInRange(1, 5));
            }
        };
    }

    private static Menus getMenus() {

        return new Menus() {

            @Override
            public Menu pickOne(MenuCategory recommendedCategory) {
                List<String> menusName = AllMenusData.getBy(recommendedCategory)
                        .stream()
                        .map(Menu::getName)
                        .toList();

                String menu = Randoms.shuffle(menusName).get(0);

                return AllMenusData.get(menu);
            }
        };
    }
}
