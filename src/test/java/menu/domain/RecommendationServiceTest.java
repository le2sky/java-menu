package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        )));
    }

    @DisplayName("한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.")
    @Test
    void checkCategoryCount() {
        RecommendationService recommendationService = new RecommendationService(simpleMenuCategories(List.of(
                MenuCategory.아시안,
                MenuCategory.일식,
                MenuCategory.아시안,
                MenuCategory.아시안,
                MenuCategory.아시안,
                MenuCategory.일식,
                MenuCategory.한식
        )));

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

    private MenuCategories simpleMenuCategories(List<MenuCategory> categories) {

        return new MenuCategories() {

            private final Queue<MenuCategory> queue = new LinkedList<>(categories);

            @Override
            public MenuCategory pickOne() {
                return queue.poll();
            }
        };
    }
}
