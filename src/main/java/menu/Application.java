package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.infrastructure.AllMenusData;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new RecommendationService(simpleMenuCategories(List.of(
                MenuCategory.한식,
                MenuCategory.한식,
                MenuCategory.한식,
                MenuCategory.일식,
                MenuCategory.중식,
                MenuCategory.아시안
        )), new Menus() {
            
            @Override
            public Menu pickOne(MenuCategory recommendedCategory) {
                List<String> menusName = AllMenusData.getBy(recommendedCategory)
                        .stream()
                        .map(Menu::getName)
                        .toList();

                String menu = Randoms.shuffle(menusName).get(0);

                return AllMenusData.get(menu);
            }
        }));

        controller.run();
    }

    private static MenuCategories simpleMenuCategories(List<MenuCategory> categories) {

        return new MenuCategories() {

            private final Queue<MenuCategory> queue = new LinkedList<>(categories);

            @Override
            public MenuCategory pickOne() {
                return queue.poll();
            }
        };
    }
}
