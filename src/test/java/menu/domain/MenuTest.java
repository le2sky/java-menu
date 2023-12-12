package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("주어진 카테고리에 해당하는지 판단한다.")
    @Test
    void isCategorizedBy() {
        Menu japan = new Menu("일식", MenuCategory.일식);

        assertThat(japan.isCategorizedBy(MenuCategory.양식)).isFalse();
        assertThat(japan.isCategorizedBy(MenuCategory.일식)).isTrue();
    }
}
