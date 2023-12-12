package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RecommendationServiceTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        new RecommendationService(simpleMenuCategories(List.of(
                MenuCategory.아시안,
                MenuCategory.일식
        )), simpleMenus(Collections.emptyList()));
    }

    @DisplayName("한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.")
    @Test
    void checkCategoryCount() {
        RecommendationService recommendationService = new RecommendationService(
                simpleMenuCategories(List.of(
                        MenuCategory.아시안,
                        MenuCategory.일식,
                        MenuCategory.아시안,
                        MenuCategory.아시안,
                        MenuCategory.아시안,
                        MenuCategory.일식,
                        MenuCategory.한식
                )), simpleMenus(Collections.emptyList()));

        List<MenuCategory> result = recommendationService.recommendCategories();

        assertThat(result)
                .hasSize(5)
                .containsExactly(
                        MenuCategory.아시안,
                        MenuCategory.일식,
                        MenuCategory.아시안,
                        MenuCategory.일식,
                        MenuCategory.한식
                );
    }

    @DisplayName("코치가 먹을 수 있는지 체크한다.")
    @Test
    void checkEatable() {
        Coach pobi = new Coach(new Name("pobi"));
        Coaches coaches = new Coaches(List.of(
                pobi,
                new Coach(new Name("lee"))
        ));
        pobi.setHateMenu(List.of(new Menu("뇨끼", MenuCategory.아시안)));

        RecommendationService recommendationService = new RecommendationService(
                simpleMenuCategories(List.of(MenuCategory.아시안)),
                simpleMenus(List.of(
                        new Menu("뇨끼", MenuCategory.아시안),
                        new Menu("초밥", MenuCategory.아시안)
                )));

        List<RecommendResult> result = recommendationService.recommendMenus(coaches, List.of(MenuCategory.아시안));

        assertThat(result)
                .containsExactly(
                        new RecommendResult("pobi", List.of(new Menu("초밥", MenuCategory.아시안))),
                        new RecommendResult("lee", List.of(new Menu("뇨끼", MenuCategory.아시안)))
                );
    }

    @DisplayName("중복 메뉴가 없어야 한다.")
    @Test
    void checkDuplication() {
        Coaches coaches = new Coaches(List.of(
                new Coach(new Name("pobi")),
                new Coach(new Name("lee"))
        ));
        RecommendationService recommendationService = new RecommendationService(
                simpleMenuCategories(List.of(MenuCategory.아시안)),
                simpleMenus(List.of(
                        new Menu("뇨끼", MenuCategory.아시안),
                        new Menu("뇨끼", MenuCategory.아시안),
                        new Menu("뇨끼", MenuCategory.아시안),
                        new Menu("뇨끼", MenuCategory.아시안),
                        new Menu("초밥", MenuCategory.아시안)
                )));

        List<RecommendResult> result = recommendationService.recommendMenus(coaches,
                List.of(MenuCategory.아시안, MenuCategory.아시안));

        assertThat(result.get(0))
                .isEqualTo(
                        new RecommendResult("pobi", List.of(
                                new Menu("뇨끼", MenuCategory.아시안),
                                new Menu("초밥", MenuCategory.아시안)))
                );
    }

    private MenuCategories simpleMenuCategories(List<MenuCategory> categories) {

        return new MenuCategories() {

            private final Queue<MenuCategory> queue = new LinkedList<>(categories);

            @Override
            public MenuCategory pickOne() {
                return queue.poll();
            }
        };
    }

    private Menus simpleMenus(List<Menu> menus) {

        return new Menus() {

            private final Queue<Menu> queue = new LinkedList<>(menus);

            @Override
            public Menu pickOne(MenuCategory recommendedCategory) {
                Menu returning = queue.poll();
                queue.offer(returning);

                return returning;
            }
        };
    }
}
