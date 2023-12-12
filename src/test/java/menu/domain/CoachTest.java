package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

class CoachTest {

    @DisplayName("이름 생성 테스트")
    @Test
    void create() {
        Name pobi = new Name("pobi");
        Name other = new Name("pobi");

        assertThat(pobi).isEqualTo(other);
    }

    @DisplayName("코치의 이름은 최소 2글자, 최대 4글자이다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void checkNameLength(int source) {
        String repeated = "*".repeat(source);

        assertThatThrownBy(() -> new Name(repeated))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.")
    @Test
    void checkHateMenuSize() {
        Coach pobi = new Coach(new Name("pobi"));
        List<Menu> menus = List.of(
                new Menu("1", MenuCategory.일식),
                new Menu("2", MenuCategory.일식),
                new Menu("3", MenuCategory.일식));

        assertThatThrownBy(() -> pobi.setHateMenu(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 메뉴는 중복이 없어야 한다.")
    @Test
    void checkHateMenuDuplication() {
        Coach pobi = new Coach(new Name("pobi"));
        List<Menu> menus = List.of(
                new Menu("1", MenuCategory.일식),
                new Menu("1", MenuCategory.일식));

        assertThatThrownBy(() -> pobi.setHateMenu(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
