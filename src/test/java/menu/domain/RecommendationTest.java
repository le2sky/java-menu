package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import menu.MenusData;
import menu.infrastructure.SimpleCategoryPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class RecommendationTest {

    @DisplayName("카테고리를 추천할때, 2개 이상의 중복이 존재해서는 안된다.")
    @Test
    void recommendCategory() {
        SimpleCategoryPicker simpleCategoryPicker = new SimpleCategoryPicker();
        simpleCategoryPicker.setData(List.of(
                Category.아시안,
                Category.아시안,
                Category.아시안,
                Category.양식,
                Category.일식,
                Category.중식
        ));

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
}
