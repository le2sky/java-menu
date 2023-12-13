package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

class CoachTest {

    @DisplayName("이름의 길이는 최소 2글자에서 4글자이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void checkNameLength(int source) {
        assertThatThrownBy(() -> new Coach("*".repeat(source)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치는 못먹는 음식을 설정할 수 있다.")
    @Test
    void setHateMenus() {
        Coach coach = new Coach("pobi");
        Menu menu1 = new Menu(Category.한식, "떡볶이");
        Menu menu2 = new Menu(Category.한식, "김밥");
        List<Menu> menus = List.of(menu1, menu2);

        coach.setHateMenus(menus);

        assertThat(coach.isHate(menu1)).isTrue();
        assertThat(coach.isHate(menu2)).isTrue();
    }

    @DisplayName("코치가 먹지 못하는 음식은 0개에서 2개 사이이다.")
    @Test
    void checkHateMenusSize() {
        Coach coach = new Coach("pobi");
        Menu menu1 = new Menu(Category.한식, "떡볶이");
        Menu menu2 = new Menu(Category.한식, "김밥");
        Menu menu3 = new Menu(Category.한식, "김치");
        List<Menu> menus = List.of(menu1, menu2, menu3);

        assertThatThrownBy(() -> coach.setHateMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치가 먹지 못하는 음식은 중복을 허용하지 않는다.")
    @Test
    void checkHateMenusDuplication() {
        Coach coach = new Coach("pobi");
        Menu menu = new Menu(Category.한식, "떡볶이");
        List<Menu> menus = List.of(menu, menu);

        assertThatThrownBy(() -> coach.setHateMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
