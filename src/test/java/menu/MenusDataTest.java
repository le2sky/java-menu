package menu;

import static org.assertj.core.api.Assertions.assertThat;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenusDataTest {

    @DisplayName("포함되어 있는 메뉴인지 확인한다.")
    @Test
    void contains() {
        Menus menus = new MenusData();

        boolean result1 = menus.contains(new Menu(Category.일식, "오니기리"));
        boolean result2 = menus.contains(new Menu(Category.일식, "오니"));

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @DisplayName("메뉴를 이름으로 가져온다.")
    @Test
    void getBy() {
        Menus menus = new MenusData();

        Menu result = menus.getBy("뇨끼");

        assertThat(result).isEqualTo(new Menu(Category.양식, "뇨끼"));
    }
}
