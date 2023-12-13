package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import menu.infrastructure.MenusData;
import menu.infrastructure.SimpleCategoryPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RecommendationTest {

    @DisplayName("카테고리를 추천할때, 2개 이상의 중복이 존재해서는 안된다.")
    @Test
    void recommendCategory() {
        SimpleCategoryPicker simpleCategoryPicker = createCategoryPicker();
        Recommendation recommendation = new Recommendation(simpleCategoryPicker, new MenusData());

        List<Category> result = recommendation.recommendCategory();

        assertThat(result).hasSize(5);
        assertThat(result).containsExactly(
                Category.아시안,
                Category.아시안,
                Category.양식,
                Category.일식,
                Category.중식
        );
    }

    @DisplayName("메뉴를 추천할때, 각 코치별로 중복이 없다.")
    @Test
    void recommendMenu() {
        SimpleCategoryPicker simpleCategoryPicker = createCategoryPicker();
        Menus menus = createMenuPicker();
        Recommendation recommendation = new Recommendation(simpleCategoryPicker, menus);
        Coach pobi = new Coach("pobi");
        Coach lee = new Coach("lee");
        Coaches coaches = new Coaches(List.of(
                pobi,
                lee
        ));

        pobi.setHateMenus(List.of(
                new Menu(Category.중식, "볶음밥"),
                new Menu(Category.일식, "초밥")
        ));
        lee.setHateMenus(List.of(
                new Menu(Category.한식, "김치"),
                new Menu(Category.양식, "뇨끼")
        ));

        List<Category> categories = recommendation.recommendCategory();

        List<RecommendMenuResult> result = recommendation.recommendMenu(categories, coaches);

        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo(
                new RecommendMenuResult("pobi", List.of(
                        new Menu(Category.아시안, "쌀국수"),
                        new Menu(Category.아시안, "분짜"),
                        new Menu(Category.양식, "뇨끼"),
                        new Menu(Category.일식, "pobi"),
                        new Menu(Category.중식, "pobi"))
                ));
    }

    private static SimpleCategoryPicker createCategoryPicker() {
        SimpleCategoryPicker simpleCategoryPicker = new SimpleCategoryPicker();
        simpleCategoryPicker.setData(List.of(
                Category.아시안,
                Category.아시안,
                Category.아시안,
                Category.양식,
                Category.일식,
                Category.중식
        ));

        return simpleCategoryPicker;
    }

    private static Menus createMenuPicker() {
        return new Menus() {

            private static final EnumMap<Category, Queue<Menu>> menus = new EnumMap<>(Category.class);

            static {
                menus.put(Category.아시안, new LinkedList<>(List.of(
                        new Menu(Category.아시안, "쌀국수"),
                        new Menu(Category.아시안, "분짜"))));

                menus.put(Category.양식, new LinkedList<>(List.of(
                        new Menu(Category.양식, "뇨끼"),
                        new Menu(Category.양식, "lee"))));

                menus.put(Category.중식, new LinkedList<>(List.of(
                        new Menu(Category.중식, "볶음밥"),
                        new Menu(Category.중식, "pobi"))));

                menus.put(Category.일식, new LinkedList<>(List.of(
                        new Menu(Category.일식, "초밥"),
                        new Menu(Category.일식, "pobi"))));
            }

            @Override
            public boolean contains(Menu menu) {
                return false;
            }

            @Override
            public Menu getBy(String name) {
                return null;
            }

            @Override
            public Menu pickOne(Category category) {
                Menu picked = menus.get(category).poll();
                menus.get(category).offer(picked);

                return picked;
            }
        };
    }
}
